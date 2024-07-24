package parteGrafica;

import java.io.IOException;

public interface IFileOrganizer {
	
	public boolean addReg(Aluno a) throws Exception;
	public Aluno   delReg(int matric) throws Exception;
	public Aluno   getReg(int matric)throws Exception;
	public long    getPosition(int matric) throws Exception;
	public String  ExibirTodosAluno() throws IOException;
}
