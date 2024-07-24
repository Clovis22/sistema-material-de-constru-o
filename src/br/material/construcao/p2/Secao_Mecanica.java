package br.material.construcao.p2;
import java.io.Serializable;



public class Secao_Mecanica extends Produto implements Codigo {
	
	private int    idMecanica;
	private String tipo;
	private int    quantidade;

	public Secao_Mecanica(int idMecanica,String produto,int quantidade,String dataEntrega,float precoVenda,float precoCompra,String tipo){
		super(produto,dataEntrega,precoVenda,precoCompra);
		this.idMecanica = idMecanica;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public Secao_Mecanica(int quantidade){
	   super(quantidade);
	   this.quantidade = quantidade;
	}
	
	//método de alteração aumentarQuantidade contendo um parâmetro do tipo Produto
	public void aumentarQuantidade(int quantidade){
		this.quantidade += quantidade;
	}
	//método de alteração diminuirQuantidade contendo um parâmetro do tipo Produto
	public void diminuirQuantidade(int quantidade){
		this.quantidade -= quantidade;
	}
	//método de acesso getProduto
	public String getProduto() {
		return super.produto;
	}
	//método de acesseo getQuantidade
	public int getQuantidade() {
		return quantidade;
	}
	//método de acesso getdataEntrada
	public String getdataEntrada() {
		return super.dataEntrada;
	}
	//método de acesso getprecoVenda
	public float getprecoVenda(){
		return super.precoVenda;
	}
	//método de acesso getprecoCompra
	public float getprecoCompra() {
		return super.precoCompra;
	}
	
	public int getID(){
		return idMecanica;
		//metodo referenciando para a interface Codigo
	}

	public String getTipo(){
		return tipo;
	}
}