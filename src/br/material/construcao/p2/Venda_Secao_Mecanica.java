package br.material.construcao.p2;
import java.io.Serializable;


public class Venda_Secao_Mecanica implements Serializable,Codigo{
    //atributos de objeto dos tipos String e do tipo byte 
	private int    idMecanica;
	private String nomeCliente;
	private String produto;
	private int    quantidade;
	private String dataSaida;
	private String CPF_Cliente;
	private int    quantProduto;
	
	//método construtor Venda, contendo uma lista de parâmetros dos tipos String e do tipo byte
	public Venda_Secao_Mecanica(int idMecanica,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){
		this.idMecanica  = idMecanica;
		this.nomeCliente = nomeCliente; 
		this.produto     = produto;
		this.quantidade  = quantidade;
		this.dataSaida   = dataSaida;
		this.CPF_Cliente = CPF_Cliente;
	}
	
	public int getID(){
		return idMecanica;
		//metodo referenciando para a interface Codigo
	}
	
	public Venda_Secao_Mecanica(Produto quant){
		this.quantidade = quant.getQuantidade();
	}
	
	public void setquantProdutos(int quantProduto){
		this.quantProduto += quantProduto;
	}
	
	public int getquantProdutos(){
		return quantProduto;
	}
	
	//método de acesso getnomeCliente
	public String getnomeCliente(){
		return nomeCliente;
	}
	//método de acesso getProduto
	public String getProduto() {
		return produto;
	}
    //método de acesso getQuantidade
	public int getQuantidade() {
		return quantidade;
	}
	//método de acesso getdataSaida
	public String getdataSaida() {
		return dataSaida;
	}
	
	public String getcpfCliente() {
		return CPF_Cliente;
	}
}