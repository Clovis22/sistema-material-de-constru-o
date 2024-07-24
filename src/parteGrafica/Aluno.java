package parteGrafica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Aluno {
	
	private int matric;      // 04 bytes
	private String nome;     // 50 bytes
	private String endereco; // 60 bytes
	private short idade;     // 02 bytes 
	private String sexo;     // 01 bytes  
	private String email;    // 40 bytes = total 157 bytes
	public static final int lenght = 157;
	
	public Aluno (int matric, String nome, String endereco, short idade, String sexo, String email) {
		this.matric   = matric;
		this.nome     = corrigirTamanho(nome, 50);     
		this.endereco = corrigirTamanho(endereco, 60);
		this.idade = idade;
		this.sexo  = corrigirTamanho(sexo, 1);
		this.email = corrigirTamanho(email, 40);
	}
	
	public Aluno (ByteBuffer bufferAluno) {
		this.matric = bufferAluno.getInt();
	    
		byte [] b_nome = new byte [50];
	    bufferAluno.get(b_nome);
	    this.nome = new String(b_nome);
	    
	    byte [] b_endereco = new byte [60];
	    bufferAluno.get(b_endereco);
		this.endereco = new String(b_endereco);
		
		this.idade = bufferAluno.getShort();
		
	    byte [] b_sexo = new byte [1];
	    bufferAluno.get(b_sexo);
	    this.sexo = new String(b_sexo);
	    
	    byte [] b_email = new byte [40];
	    bufferAluno.get(b_email);
		this.email = new String(b_email);

		//this.nome   = LerNome(bufferAluno); // retorna string Alcymar
		//this.nome   = LerNome(bufferAluno); // retorna string Alcymar
		//this.nome   = LerNome(bufferAluno); // retorna string Alcymar
		//this.nome   = LerNome(bufferAluno); // retorna string Alcymar
		
	}
	
	public Aluno(){}
	
//
	public int getMatric() {
		return matric;
	}

	public void setMatric(int matric) {
		this.matric = matric;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public short getIdade() {
		return idade;
	}

	public void setIdade(short idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
// 
//  metodos extras manipulacao Arquivo
	public String corrigirTamanho (String palavra,int tam) {
		int size = palavra.getBytes().length;
		if(size < tam ){
			for (int i = size; i < tam; i++) {
				palavra = palavra+" ";
			}
		}else{
			palavra = palavra.substring(0,tam);
		}
		return palavra;
	}
	
	public ByteBuffer getBuffer(){ // empacota todos os atributos globais em um ByteBuffer 
		ByteBuffer bufferPacoteAluno = ByteBuffer.allocate(157);
		bufferPacoteAluno.putInt(matric);
		
		byte[] v_nome = this.nome.getBytes();
		bufferPacoteAluno.put(v_nome);
		
		byte[] v_endereco = this.endereco.getBytes();
		bufferPacoteAluno.put(v_endereco);
		
		bufferPacoteAluno.putShort(idade);
		
		byte[] v_sexo = this.sexo.getBytes();
		bufferPacoteAluno.put(v_sexo);
		
		byte[] v_email = this.email.getBytes();
		bufferPacoteAluno.put(v_email);
		
//		bufferPacoteAluno.putInt(this.matric);
//		bufferPacoteAluno.put(this.nome.getBytes());
//		bufferPacoteAluno.put(this.endereco.getBytes());
//		bufferPacoteAluno.put(this.sexo.getBytes());
//		bufferPacoteAluno.put(this.sexo.getBytes());
//		bufferPacoteAluno.put(this.email.getBytes());
		return bufferPacoteAluno; // retorna o buffer com os dados empacotados
	}
	
	
	public String ExibirAluno(){
		String conteudo = null;
		conteudo = "Matricula : "+this.matric+"\n"
				 + "Nome      : "+this.nome+"\n"
				 + "Endereco  : "+this.endereco+"\n"
				 + "Idade     : "+this.idade+"\n"
				 + "Sexo      : "+this.sexo+"\n"
				 + "Email     : "+this.email;
		return conteudo;
	}
	
	public String LerNome(ByteBuffer buf){
	    byte [] b_nome = new byte [50];
	    buf.get(b_nome);
		String nomeConvertido = new String(b_nome);
		return nomeConvertido;
	}
	
	public String converteByteStringEnder(ByteBuffer buf){
	    byte [] b_endereco = new byte [60];
	    buf.get(b_endereco);
		String enderecoConvertido = new String(b_endereco);
		return enderecoConvertido;
	}
	
	//
	public void SalvarArquivoAluno() throws IOException{
		File objeto_arquivo = new File("alunoSimples.db"); 
		RandomAccessFile raf = new RandomAccessFile(objeto_arquivo, "rw");
		FileChannel channel = raf.getChannel();
		
		ByteBuffer buffArquivoAluno = getBuffer(); // recebe o Buffer empacotado com os dados em aluno
		buffArquivoAluno.position(0);
		long tamanho = channel.size();
		
		channel.write(buffArquivoAluno,tamanho);
	}
	
	
	
	
}