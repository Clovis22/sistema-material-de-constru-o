package br.material.construcao.p2;

public class Secao_Eletrica extends Produto implements Codigo {

	private int    idEletrica;
	private float  voltagem;
	private float  potencia;
	private String tipo;
	private float  comprimento;
	private int    quantidade;

	public Secao_Eletrica(int idEletrica,String produto,int quantidade,String dataEntrega,float precoCompra,float precoVenda,
			float voltagem,float potencia,String tipo,float comprimento){

		super(produto,dataEntrega,precoCompra,precoVenda);
		this.idEletrica  = idEletrica;
		this.quantidade  = quantidade;
		this.voltagem    = voltagem;
		this.potencia    = potencia;
		this.tipo        = tipo;
		this.comprimento = comprimento;

	}


	//comportamento polimorfico
	public Secao_Eletrica(int quantidade){
		super(quantidade);
		this.quantidade = quantidade;
	}

	public void aumentarQuantidade(int quantidade){
		this.quantidade += quantidade;
	}
	//método de alteração diminuirQuantidade contendo um parâmetro do tipo Produto
	public void diminuirQuantidade(int quantidade){
		this.quantidade -= quantidade;
	}

	public String getProduto() {
		return super.produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
	//método de acesso getdataEntrada
	public String getdataEntrada() {
		return super.dataEntrada;
	}
	//método de acesso getprecoCompra
	public float getprecoCompra() {
		return super.precoCompra;
	}
	//método de acesso getprecoVenda
	public float getprecoVenda(){
		return super.precoVenda;
	}

	public int getID(){
		return idEletrica;
		//metodo referenciando para a interface Codigo
	}

	public float getVoltagem(){
		return voltagem;
	}

	public float getPotencia(){
		return potencia;
	}

	public String getTipo(){
		return tipo;
	}

	public float getComprimento(){
		return comprimento;
	}
}