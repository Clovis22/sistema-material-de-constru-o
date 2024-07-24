package parteGrafica;



import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OrganizadorSimples implements IFileOrganizer{
	public FileChannel canal;


	public OrganizadorSimples(String nomeArq) throws IOException{
		File file = new File(nomeArq);
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		this.canal = raf.getChannel();
	}

	@Override
	public boolean addReg(Aluno a) throws Exception{
		ByteBuffer buffArquivoAluno = a.getBuffer();
		buffArquivoAluno.position(0);
		long tamanho = canal.size();
		canal.write(buffArquivoAluno,tamanho);
		return true;
	}

	@Override
	public Aluno delReg(int matric) throws Exception {
		long posicaoEncontrada = getPosition(matric);
		ByteBuffer bufBlocoAluno = ByteBuffer.allocate(157);

		System.out.println("aqui1 "+ canal.size());	
		long tamanhoArquivo = canal.size();

		while(posicaoEncontrada < tamanhoArquivo-157){
			this.canal.read(bufBlocoAluno, posicaoEncontrada+157);
			bufBlocoAluno.flip();
			int valor = bufBlocoAluno.getInt();
			System.out.println("matricula:  "+valor);
			System.out.println("posição:    "+posicaoEncontrada);
			canal.write(bufBlocoAluno,posicaoEncontrada);

			bufBlocoAluno.clear();
			posicaoEncontrada = posicaoEncontrada+157;

		}	

		canal.truncate((canal.size()-Aluno.lenght));
		System.out.println(	canal.size());
		return null;
	}

	@Override
	public Aluno getReg(int matric) throws IOException {
		long pos = this.getPosition(matric);
		if(pos == -1) return null;
		ByteBuffer bufAluno = ByteBuffer.allocate(Aluno.lenght);
		this.canal.read(bufAluno,pos);
		bufAluno.flip();
		Aluno a = new Aluno(bufAluno);
		return a;  
	}

	public long getPosition(int matric) throws IOException{
		long size = this.canal.size();	
		for(long pos = 0 ; pos < size ; pos += Aluno.lenght){

			ByteBuffer bufinicio = ByteBuffer.allocate(4);
			this.canal.read(bufinicio,pos);
			bufinicio.flip();

			if(matric == bufinicio.getInt()){
				return pos;
			}
		}
		return -1;
	}

	public String ExibirTodosAluno() throws IOException{
		long tamanho_arquivo = this.canal.size();
		String dadosAlunos = "";
		if(tamanho_arquivo != -1){
			for (long posicao = 0; posicao < tamanho_arquivo; posicao+=Aluno.lenght){
				ByteBuffer bufAluno = ByteBuffer.allocate(Aluno.lenght);
				this.canal.read(bufAluno,posicao);
				bufAluno.flip();
				Aluno a = new Aluno(bufAluno);
				dadosAlunos += a.ExibirAluno()+"\n\n";
			}
			return dadosAlunos;
		}else
			return null;
	}

//	public long getLerArquivo() throws IOException{
//		long size = this.canal.size();	
//		for(long pos = 0 ; pos < size ; pos += Aluno.lenght){
//
//			ByteBuffer bufinicio = ByteBuffer.allocate(4);
//			this.canal.read(bufinicio,pos);
//			bufinicio.flip();
//
//			if(matric == bufinicio.getInt()){
//				return pos;
//			}
//		}
//		return -1;
//	}


	//	public Aluno getReg(int matric) throws IOException{
	//		long tamanhoCanal = canal.size();
	//		int tamanhoAluno = Aluno.lenght;
	//		ByteBuffer bufferLer = ByteBuffer.allocate(tamanhoAluno);
	//		canal.read(bufferLer,tamanhoAluno * 0);
	//
	//		int resultado = (int) getPosition(matric);
	//		bufferLer.position(resultado);
	//
	//		int matriculaAluno = bufferLer.getInt();
	//
	//		byte [] b_nomeAluno = new byte [50];
	//		bufferLer.get(b_nomeAluno);
	//		String nomeAluno = new String (b_nomeAluno);
	//
	//		byte [] b_enderecoAluno = new byte [60];
	//		bufferLer.get(b_enderecoAluno);
	//		String enderecoAluno = new String (b_enderecoAluno);
	//
	//		short idadeAluno = bufferLer.getShort();
	//
	//		byte [] b_sexoAluno = new byte [1];
	//		bufferLer.get(b_sexoAluno);
	//		String sexoAluno = new String (b_sexoAluno);
	//
	//		byte [] b_emailAluno = new byte [40];
	//		bufferLer.get(b_emailAluno);
	//		String emailAluno = new String (b_emailAluno);
	//		bufferLer.flip();
	//
	//		Aluno encontrado = new Aluno(matriculaAluno,nomeAluno,enderecoAluno,idadeAluno,sexoAluno,emailAluno);
	//		return encontrado;
	//	}

	//		
	//		for (int i = 0; i < tamanhoAluno; i++){
	//			
	//		}
	//		era uma vez um rapaz chamado alguém. ele gostava muito de ficar em casa, mas um dia
	//		ele conheceu uma coisa que mudou a sua vida. essa coisa, foi chegando de mansinho, de
	//		uma forma, que ao perceber, já era tarde demais...suas relações
	//		ficaram comprometidas à partir do dia que ela, a coisa, tocou-lhe com amassos de paixão
	//	}

}
