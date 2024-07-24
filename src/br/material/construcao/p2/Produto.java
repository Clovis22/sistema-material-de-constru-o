package br.material.construcao.p2;
import java.io.Serializable;


public abstract class Produto implements Serializable{
	//atributos de objeto dos tipos String, do tipo byte e dos tipos float
	protected String produto;
	protected String dataEntrada;
	protected float  precoCompra;
	protected float  precoVenda;
	//método construtor Produto, contendo uma lista de parâmetros dos tipos, String, do tipo byte e dos tipos float
	public Produto(String produto,String dataEntrada,float precoCompra,float precoVenda){
		this.produto     = produto;
		this.dataEntrada = dataEntrada;
		this.precoCompra = precoCompra;
		this.precoVenda  = precoVenda;
	}
	
	public Produto(int quantidade){}
	
	public abstract void aumentarQuantidade(int quantidade);
	//metodo referenciando a classe abstrata Produto
	
	public abstract void diminuirQuantidade(int quantidade);
	//metodo referenciando a classe abstrata Produto
	
	public abstract String getProduto();
	//metodo referenciando a classe abstrata Produto
	
	public abstract int getQuantidade();
	//metodo referenciando a classe abstrata Produto
	
	public abstract String getdataEntrada();
	
	public abstract float getprecoCompra();
	
	public abstract float getprecoVenda();
}