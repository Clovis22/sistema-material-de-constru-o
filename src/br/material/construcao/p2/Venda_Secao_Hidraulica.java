package br.material.construcao.p2;
import java.io.Serializable;


public class Venda_Secao_Hidraulica implements Serializable,Codigo{
    //atributos de objeto dos tipos String e do tipo byte 
	private int idHidraulica;
	private String nomeCliente;
	private String  produto;
	private int     quantidade;
	private String  dataSaida;
	private String  CPF_Cliente;
	private int quantProduto;
	
	//m�todo construtor Venda, contendo uma lista de par�metros dos tipos String e do tipo byte
	public Venda_Secao_Hidraulica(int idHidraulica, String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){
		this.idHidraulica = idHidraulica;
		this.nomeCliente = nomeCliente; 
		this.produto     = produto;
		this.quantidade  = quantidade;
		this.dataSaida   = dataSaida;
		this.CPF_Cliente = CPF_Cliente;
	}
	
	public int getID(){
		return idHidraulica;
		//metodo referenciando para a interface Codigo
	}
	
	public Venda_Secao_Hidraulica(Produto quant){
		this.quantidade  = quant.getQuantidade();
	}
	
	public void setquantProdutos(int quantProduto){
		this.quantProduto += quantProduto;
	}
	
	public int getquantProdutos(){
		return quantProduto;
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