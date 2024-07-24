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
  
	//m�todo de altera��o aumentarQuantidade contendo um par�metro do tipo Produto
	public void aumentarQuantidade(int quantidade){
		this.quantidade += quantidade;
	}
	//m�todo de altera��o diminuirQuantidade contendo um par�metro do tipo Produto
	public void diminuirQuantidade(int quantidade){
		this.quantidade -= quantidade;
	}
	
	public String getProduto() {
		return super.produto;
	}
	//m�todo de acesseo getQuantidade
	public int getQuantidade() {
		return quantidade;
	}
	
	public String getdataEntrada() {
		return super.dataEntrada;
	}
	//m�todo de acesso getprecoVenda
	public float getprecoVenda(){
		return super.precoVenda;
	}
	//m�todo de acesso getprecoCompra
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