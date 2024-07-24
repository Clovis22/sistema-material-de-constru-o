package br.material.construcao.p2;
import java.io.Serializable;


public class Venda_Secao_Eletrica implements Serializable,Codigo{
    //atributos de objeto dos tipos String e do tipo byte 
	private int     idEletrica;
	private String  nomeCliente;
	private String  produto;
	private int     quantidade;
	private String  dataSaida;
	private String  CPF_Cliente;
	private int     quantProduto;
	//public  Produto quant;
	//m�todo construtor Venda, contendo uma lista de par�metros dos tipos String e do tipo byte
	public Venda_Secao_Eletrica(int idEletrica,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){
		this.idEletrica  = idEletrica;
		this.nomeCliente = nomeCliente; 
		this.produto     = produto;
		this.quantidade  = quantidade;
		this.dataSaida   = dataSaida;
		this.CPF_Cliente = CPF_Cliente;
	}	
	
	public Venda_Secao_Eletrica(Produto quant){
		this.quantidade = quant.getQuantidade();
	}
	//comportamento polimorfico
	public void setquantProdutos(int quantProduto){
		this.quantProduto += quantProduto;
	}
	
	public int getquantProdutos(){
		return quantProduto;
	}
	
	public int getID(){
		return idEletrica;
		//metodo referenciando para a interface Codigo
	}
	
	//m�todo de acesso getnomeCliente
	public String getnomeCliente(){
		return nomeCliente;
	}
	//m�todo de acesso getProduto
	public String getProduto() {
		return produto;
	}
    //m�todo de acesso getQuantidade
	public int getQuantidade() {
		return quantidade;
	}
	//m�todo de acesso getdataSaida
	public String getdataSaida() {
		return dataSaida;
	}
	
	public String getcpfCliente() {
		return CPF_Cliente;
	}
}