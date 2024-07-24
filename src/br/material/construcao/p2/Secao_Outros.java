package br.material.construcao.p2;

public class Secao_Outros extends Produto implements Codigo {
	
	private int    idOutros;
	private String tipo;
    private int    quantidade;
	
	public Secao_Outros(int idOutros,String produto,int quantidade,String dataEntrada,float precoVenda,float precoCompra,
			String tipo){
		super(produto,dataEntrada,precoVenda,precoCompra);
		this.idOutros   = idOutros;
		this.quantidade = quantidade;
		this.tipo       = tipo;
	}
	
    public Secao_Outros(int quantidade){
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
	
	public String getProduto() {
		return super.produto;
	}
	//método de acesseo getQuantidade
	public int getQuantidade() {
		return quantidade;
	}
	
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
		return idOutros;
		//metodo referenciando para a interface Codigo
	}

	public String getTipo(){
		return tipo;
	}
}