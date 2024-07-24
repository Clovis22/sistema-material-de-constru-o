package br.material.construcao.p2;

public class Secao_Hidraulica extends Produto implements Codigo {
	
	private int    idHidraulica;
    private String tipo;
    private float  comprimento;
    private int    quantidade;
    
    public Secao_Hidraulica(int idHidraulica,String produto,int quantidade,String dataEntrada,float precoVenda,float precoCompra,
    		                String tipo,float comprimento){
    	
    	super(produto,dataEntrada,precoVenda,precoCompra);
    	this.idHidraulica = idHidraulica;
    	this.quantidade   = quantidade;
    	this.tipo         = tipo;
    	this.comprimento  = comprimento;
    }
    
    public Secao_Hidraulica(int quantidade){
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
  	//m�todo de acesso getProduto
  	public String getProduto() {
  		return super.produto;
  	}
      //m�todo de acesseo getQuantidade
  	public int getQuantidade() {
		return quantidade;
	}
      //m�todo de acesso getdataEntrada
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
		return idHidraulica;
		//metodo referenciando para a interface Codigo
	}
  	
  	public String getTipo(){
  		return tipo;
  	}
  	
  	public float getComprimento(){
  		return comprimento;
  	}
}