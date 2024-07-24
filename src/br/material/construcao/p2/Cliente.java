package br.material.construcao.p2;
import java.io.Serializable;


public class Cliente implements Serializable{
	private String nomeCliente;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String endereco;
	private int    numero;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	private String telefone;
	private String celular;
	private String email;
	private int    quantProduto;
	
	
	public Cliente(String nomeCliente,String cpf,String rg,String dataNascimento,
			       String endereco,int numero,String bairro,String cidade,String cep,String estado,
			       String telefone,String celular,String email){
		
		this.nomeCliente    = nomeCliente;
		this.cpf            = cpf;
		this.rg             = rg;
		this.dataNascimento = dataNascimento;
		this.endereco       = endereco;
		this.numero         = numero;
		this.bairro         = bairro;
		this.cidade         = cidade;
		this.cep            = cep;
		this.estado         = estado;
		this.telefone       = telefone;
		this.celular        = celular;
		this.email          = email;
        
	}
	
	public Cliente(){}
	
	public void setquantVendas(int quantidade) {
	    quantProduto += quantidade;
	}
	
	public int getquantVendas(){
		return quantProduto;
	}
	
	
	public String getnomeCliente(){
		return nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}
}