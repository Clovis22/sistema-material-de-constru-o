package br.material.construcao.p2;
import java.io.Serializable;
import java.util.ArrayList;

public class BancoDeDados implements Serializable {
   /// Criaçao de arrayList de cada uma das classes usadas no sistema
	private String Aparencia;
	private ArrayList<Cliente>                Cliente;
	private ArrayList<Venda_Secao_Eletrica>   venda_secao_eletrica;
	private ArrayList<Venda_Secao_Hidraulica> venda_secao_hidraulica;
	private ArrayList<Venda_Secao_Mecanica>   venda_secao_mecanica;
	private ArrayList<Venda_Secao_Outros>     venda_secao_outros;

	
	private ArrayList<Secao_Eletrica>          secao_eletrica;
	private ArrayList<Secao_Hidraulica>        secao_hidraulica;
	private ArrayList<Secao_Mecanica>          secao_mecanica;
	private ArrayList<Secao_Outros>            secao_outros;
	
	private ArrayList<Float> precoVendaEletrica;
	private ArrayList<Float> auxPrecoVenda;
	private ArrayList<Float> precoCompraEletrica;
	private ArrayList<Float> lucroProdutoEletrica;

	private ArrayList<Float> precoVendaHidraulica;
	private ArrayList<Float> precoCompraHidraulica;
	private ArrayList<Float> lucroProdutoHidraulica;

	private ArrayList<Float> precoVendaMecanica;
	private ArrayList<Float> precoCompraMecanica;
	private ArrayList<Float> lucroProdutoMecanica;

	private ArrayList<Float> precoVendaOutros;
	private ArrayList<Float> precoCompraOutros;
	private ArrayList<Float> lucroProdutoOutros;


	private int contVendas = 1;

	public BancoDeDados(){

		Cliente                 = new ArrayList<Cliente>();	

		venda_secao_eletrica    = new ArrayList<Venda_Secao_Eletrica>();
		venda_secao_hidraulica  = new ArrayList<Venda_Secao_Hidraulica>();
		venda_secao_mecanica    = new ArrayList<Venda_Secao_Mecanica>();
		venda_secao_outros      = new ArrayList<Venda_Secao_Outros>();

		secao_eletrica          = new ArrayList<Secao_Eletrica>();
		secao_hidraulica        = new ArrayList<Secao_Hidraulica>();
		secao_mecanica          = new ArrayList<Secao_Mecanica>();
		secao_outros            = new ArrayList<Secao_Outros>();

		precoVendaEletrica             = new ArrayList<Float>();
		precoCompraEletrica            = new ArrayList<Float>();
		lucroProdutoEletrica           = new ArrayList<Float>();

		precoVendaHidraulica             = new ArrayList<Float>();
		precoCompraHidraulica            = new ArrayList<Float>();
		lucroProdutoHidraulica           = new ArrayList<Float>();

		precoVendaMecanica             = new ArrayList<Float>();
		precoCompraMecanica            = new ArrayList<Float>();
		lucroProdutoMecanica           = new ArrayList<Float>();

		precoVendaOutros             = new ArrayList<Float>();
		precoCompraOutros            = new ArrayList<Float>();
		lucroProdutoOutros           = new ArrayList<Float>();

		auxPrecoVenda           = new ArrayList<Float>();

	}
	//Metodo salvar Aparencia
	 public String getAparencia(){
		 return Aparencia;
	 }
	 
	 public void setAparencia(String Aparencia){
		 this.Aparencia = Aparencia;
	 }

//Metodo que verifica se um determinado cpf ja existem nao permitindo o cadastro de 2 cpfs iguais
	public String verifica_CPF(String CPF){
		String res = "";
		boolean teste = true;
		for (int i = 0; i < Cliente.size(); i++) {
			if (CPF.equals(Cliente.get(i).getCpf())){
				teste = false;
				res = "O CPF informado já existe no Sistema!";
				return res;
			}
		}

		if (teste == true){
			res = "";
			return res;
		}

		return res;
	}

	//=====================================================================================================
	//método de acesso inserirCliente, contendo uma lista de parâmetros dos tipos String
	//armazena no arrayList Cliente passados pelo construtor os parametros da classe Cliente
	public void inserirCliente(String nomeCliente,String cpf,String rg,String dataNascimento,
			String endereco,int numero,String bairro,String cidade,String cep,String estado,
			String telefone,String celular,String email){
		Cliente AUX1 = new Cliente(nomeCliente,cpf,rg,dataNascimento,endereco,
				numero,bairro,cidade,cep,estado,telefone,celular,email);
		verifica_CPF(cpf);
		Cliente.add(AUX1);

	}

	//=====================================================================================================

	//=====================================================================================================
	//método de acesso inserirMercadoria, contendo uma lista de parâmetros dos tipos String, do tipo byte e dos tipos float
	//armazena no ArrayList da Secao eletrica pelo construtor os parametros da classe Secao Eletrica
	public String inserirEletrica(int idEletrica,String produto,int quantidade,String dataEntrada,float precoCompra,float precoVenda,float voltagem,float potencia,
			String tipo,float comprimento){

		Secao_Eletrica E = new Secao_Eletrica(idEletrica,produto,quantidade,dataEntrada,precoCompra,precoVenda,voltagem,potencia,tipo,comprimento);

		String res = "";
		boolean teste = true;
		for (int i = 0; i < secao_eletrica.size(); i++) {
			if (idEletrica == secao_eletrica.get(i).getID()){
				teste = false;
				res = "Impossível estocar produto\n"+"Código existente!";
				return res;
			}
		}

		if (teste == true){
			secao_eletrica.add(E);
			res = "Produto estocado com sucesso!";
			return res;
		}

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso inserirMercadoria, contendo uma lista de parâmetros dos tipos String, do tipo byte e dos tipos float
	//armazena no ArrayList da Secao Hidraulica pelo construtor os parametros da classe Secaohidraulica
	public String inserirHidraulica(int idHidraulica,String produto,int quantidade,String dataEntrada,float precoVenda,float precoCompra,
			String tipo,float comprimento){

		Secao_Hidraulica H = new Secao_Hidraulica(idHidraulica,produto,quantidade,dataEntrada,precoVenda,precoCompra,tipo,comprimento);

		String res = ""; 
		boolean teste = true;
		//verificaçao para nao permitir que 2 ids sejam armazenados
		for (int i = 0; i < secao_hidraulica.size(); i++) {
			if (idHidraulica == secao_hidraulica.get(i).getID()){
				teste = false;
				res = "Impossível estocar produto\n"+"Código existente!";
				return res;
			}
		}

		if (teste == true){
			secao_hidraulica.add(H);
			res = "Produto estocado com sucesso!";
			return res;
		}

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	
	//armazena no ArrayList da Secao Mecanica pelo construtor os parametros da classe Secao Mecanica
	public String inserirMecanica(int idMecanica,String produto,int quantidade,String dataEntrada,float precoVenda,float precoCompra,String tipo){

		Secao_Mecanica M = new Secao_Mecanica(idMecanica,produto,quantidade,dataEntrada,precoVenda,precoCompra,tipo);

		String res = "";
		boolean teste = true;
		for (int i = 0; i < secao_mecanica.size(); i++) {
			if (idMecanica == secao_mecanica.get(i).getID()){
				teste = false;
				res = "Impossível estocar produto\n"+"Código existente!";
				return res;
			}
		}

		if (teste == true){
			secao_mecanica.add(M);
			res = "Produto estocado com sucesso!";
			return res;
		}

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso inserirMercadoria, contendo uma lista de parâmetros dos tipos String, do tipo byte e dos tipos float
	
	//armazena no ArrayList da Secao Outros pelo construtor os parametros da classe Secao Outros
	public String inserirOutros(int idOutros,String produto,int quantidade,String dataEntrada,float precoVenda,float precoCompra,
			String tipo){

		Secao_Outros O = new Secao_Outros(idOutros,produto,quantidade,dataEntrada,precoVenda,precoCompra,tipo);

		String res = "";
		boolean teste = true;
		for (int i = 0; i < secao_outros.size(); i++) {
			if (idOutros == secao_outros.get(i).getID()){
				teste = false;
				res = "Impossível estocar produto\n"+"Código existente!";
				return res;
			}
		}

		if (teste == true){
			secao_outros.add(O);
			res = "Produto estocado com sucesso!";
			return res;
		}

		return res;
	}
	//=====================================================================================================


//Metodo Exibe todos os Clientes armazenados no ArrayList fazendo um varredura pelo ArrayList e contatenando na variavel local res 
	public String listar_Cliente(){
		String res = "";

		boolean teste = false;

		for(int i = 0; i < Cliente.size(); i++){
			res += "REGISTRO ENCONTRADO:\n\nNome : " + Cliente.get(i).getnomeCliente()+"\n"+
					"CPF : " + Cliente.get(i).getCpf()+"\n"+"Carteira De Identidade : "+Cliente.get(i).getRg()+"\n"+
					"Data de Nascimento : "+Cliente.get(i).getDataNascimento()+"\n"+
					"Endereço : "+Cliente.get(i).getEndereco()+"\n"+"Numero Da Residencia: "+Cliente.get(i).getNumero()+"\n"+
					"Bairro : "+Cliente.get(i).getBairro()+"\n"+"Cidade : "+Cliente.get(i).getCidade()+"\n"+
					"CEP : "+Cliente.get(i).getCep()+"\n"+"Estado : "+Cliente.get(i).getEstado()+"\n"+
					"Telefone : "+Cliente.get(i).getTelefone()+"\n"+"Celular : "+Cliente.get(i).getCelular()+"\n"+
					"E-mail : "+Cliente.get(i).getEmail()+"\n"+"Venda(s) Realizada(s) : "+Cliente.get(i).getquantVendas()+"\n"+
					"___________________________________________"+"\n\n";

			teste = true;
		}

		if (teste == false)
			res = "Nenhum cliente foi cadastrado ainda!";

		return res;
	}

	///metodo realiza uma pesquisa de um determinado cliente atraves de 2 parametros verificando no ArrayList e concatenando na variavel res
	public String buscarCliente(String nome,String cpf){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < Cliente.size(); i++){
			if (nome.equals(Cliente.get(i).getnomeCliente())) {
				if (cpf.equals(Cliente.get(i).getCpf())){
					res = "REGISTRO ENCONTRADO:\n\nNome : " + Cliente.get(i).getnomeCliente()+"\n"+
							"CPF : " + Cliente.get(i).getCpf()+"\n"+"Carteira De Identidade : "+Cliente.get(i).getRg()+"\n"+
							"Data de Nascimento : "+Cliente.get(i).getDataNascimento()+"\n"+
							"Endereço : "+Cliente.get(i).getEndereco()+"\n"+"Numero Da Residencia: "+Cliente.get(i).getNumero()+"\n"+
							"Bairro : "+Cliente.get(i).getBairro()+"\n"+"Cidade : "+Cliente.get(i).getCidade()+"\n"+
							"CEP : "+Cliente.get(i).getCep()+"\n"+"Estado : "+Cliente.get(i).getEstado()+"\n"+
							"Telefone : "+Cliente.get(i).getTelefone()+"\n"+"Celular : "+Cliente.get(i).getCelular()+"\n"+
							"E-mail : "+Cliente.get(i).getEmail()+"\n"+"Venda(s) Realizada(s) : "+Cliente.get(i).getquantVendas();

					teste = true;
				}	
			}	 
		}

		if (teste == false)
			res = "Nenhum registro foi encontrado!";

		return res;
	}
///metodo realiza a alteracao de um determinado cliente atraves de 3 parametros Strings e 1 parametro Objeto
	public String alterarCliente(String nomeAntigo,String cpf,Cliente cliente){
		String res = "";
		for (int i = 0; i < Cliente.size(); i++) {
			if (nomeAntigo.equals(Cliente.get(i).getnomeCliente())){	
				if (cpf.equals(Cliente.get(i).getCpf())){
					Cliente.set(i, cliente);
					res = "Registro alterado com sucesso!";
					return res;
				}else 
					res = "Impossível alterar cliente\n"+"CPF : "+cpf+"\nnão encontrado no registro!";
			}else 
				res = "Impossível alterar cliente\n"+"Nome : "+nomeAntigo+"\nnão encontrado no registro!";	
		}

		return res;
	}
//metodo remove do ArrayList o cliente determinado pelos 2 parametros passados 
	public String removerCliente(String nome,String cpf){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < Cliente.size(); i++) {
			if (nome.equals(Cliente.get(i).getnomeCliente())){
				if (cpf.equals(Cliente.get(i).getCpf())){
					Cliente.remove(i);
					res = "Registro removido com sucesso!";
					return res;
				}
			}
		}

		if (teste == false)
			res = "Registro não encontrado para remoção!";

		return res;
	}

	//=====================================================================================================
	//método de acesso ListarSessaoEletrica
	public String ListarSecaoEletrica(){
		String res = "";
		boolean teste = false;

		for(int i = 0; i < secao_eletrica.size(); i++){
			res += "Seção Elétrica\nProdutos em Estoque :\n\nCódigo: "+secao_eletrica.get(i).getID()+
					"\nNome Do Produto : "+secao_eletrica.get(i).getProduto()+"\n" + 
					"Quantidade : "+secao_eletrica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
					secao_eletrica.get(i).getdataEntrada()+"\n"+
					"Preço de Compra : "+secao_eletrica.get(i).getprecoCompra()+" reais\n"+
					"Preço De Venda : "+secao_eletrica.get(i).getprecoVenda()+" reais\n"+
					"Voltagem : "+secao_eletrica.get(i).getVoltagem()+"\n"+"Potencia : "+secao_eletrica.get(i).getPotencia()+"\n"+
					"Tipo : "+secao_eletrica.get(i).getTipo()+"\n"+"Comprimento : "+secao_eletrica.get(i).getComprimento()+"\n"+
					"____________________________________\n\n";

			teste = true;
		}

		if (teste == false)
			res = "Impossível listar estoque.\n"+
					"Não ha produto(os) estocado(os) no momento!";
		return res;
	}
	//=====================================================================================================
	public String ListarSecaoHidraulica(){
		String res = "";
		boolean teste = false;
		for(int i = 0; i < secao_hidraulica.size(); i++){
			res += "Seção Hidráulica\nProdutos em Estoque :\n\nCódigo: "+secao_hidraulica.get(i).getID()+
					"\nNome Do Produto : "+secao_hidraulica.get(i).getProduto()+"\n" + 
					"Quantidade : "+secao_hidraulica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
					secao_hidraulica.get(i).getdataEntrada()+"\n"+
					"Preço de Compra : "+secao_hidraulica.get(i).getprecoCompra()+" reais\n"+
					"Preço De Venda : "+secao_hidraulica.get(i).getprecoVenda()+" reais\n"+
					"Tipo : "+secao_hidraulica.get(i).getTipo()+"\n"+"Comprimento  : "+secao_hidraulica.get(i).getComprimento()+
					"\n____________________________________\n\n";

			teste = true;
		}

		if (teste == false)
			res = "Impossível listar estoque.\n"+
					"Não ha produto(os) estocado(os) no momento!";
		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	public String ListarSecaoMecanica(){
		String res = "";
		boolean teste = false;
		for(int i = 0; i < secao_mecanica.size(); i++){
			res += "Seção Mecânica\nProdutos em Estoque :\n\nCódigo: "+secao_mecanica.get(i).getID()+
					"\nNome Do Produto : "+secao_mecanica.get(i).getProduto()+"\n" + 
					"Quantidade : "+secao_mecanica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
					secao_mecanica.get(i).getdataEntrada()+"\n"+
					"Preço de Compra : "+secao_mecanica.get(i).getprecoCompra()+" reais\n"+
					"Preço De Venda : "+secao_mecanica.get(i).getprecoVenda()+" reais\n"+
					"Tipo : "+secao_mecanica.get(i).getTipo()+"\n____________________________________\n\n";

			teste = true;
		}

		if (teste == false)
			res = "Impossível listar estoque.\n"+
					"Não ha produto(os) estocado(os) no momento!";
		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	public String ListarSecaoOutros(){
		String res = "";
		boolean teste = false;
		for(int i = 0; i < secao_outros.size(); i++){
			res += "Seção Outros\nProdutos em Estoque :\n\nCódigo: "+secao_outros.get(i).getID()+
					"\nNome Do Produto : "+secao_outros.get(i).getProduto()+"\n" + 
					"Quantidade : "+secao_outros.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
					secao_outros.get(i).getdataEntrada()+"\n"+
					"Preço de Compra : "+secao_outros.get(i).getprecoCompra()+" reais\n"+
					"Preço De Venda : "+secao_outros.get(i).getprecoVenda()+" reais\n"+
					"Tipo : "+secao_outros.get(i).getTipo()+"\n____________________________________\n\n";

			teste = true;
		}

		if (teste == false)
			res = "Impossível listar estoque.\n"+
					"Não ha produto(os) estocado(os) no momento!";
		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso pesquisarSessãoElétrica, contendo um parâmetro do tipo String
	public String pesquisarSecaoEletrica(int idEletrica,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_eletrica.size(); i++){
			if ((nomeProduto.equals(secao_eletrica.get(i).getProduto())) & (idEletrica == secao_eletrica.get(i).getID())) {
				res = "Seção Elétrica\nProdutos em Estoque :\n\nCódigo: "+secao_eletrica.get(i).getID()+
						"\nNome Do Produto : "+secao_eletrica.get(i).getProduto()+"\n" + 
						"Quantidade : "+secao_eletrica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
						secao_eletrica.get(i).getdataEntrada()+"\n"+
						"Preço de Compra : "+secao_eletrica.get(i).getprecoCompra()+" reais\n"+
						"Preço De Venda : "+secao_eletrica.get(i).getprecoVenda()+" reais\n"+
						"Voltagem : "+secao_eletrica.get(i).getVoltagem()+"\n"+"Potencia : "+
						secao_eletrica.get(i).getPotencia()+"\n"+
						"Tipo : "+secao_eletrica.get(i).getTipo()+"\n"+"Comprimento : "+
						secao_eletrica.get(i).getComprimento();
				return res;
			}	 
		}

		if (teste == false)
			res = "Nenhum registro foi encontrado!";

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso pesquisarSessãoElétrica, contendo um parâmetro do tipo String
	public String pesquisarSecaoHidraulica(int idHidraulica,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_hidraulica.size(); i++){
			if ((nomeProduto.equals(secao_hidraulica.get(i).getProduto()) & (idHidraulica == secao_hidraulica.get(i).getID()))) {
				res = "Seção Hidráulica\nProdutos em Estoque :\n\nCódigo: "+secao_hidraulica.get(i).getID()+
						"\nNome Do Produto : "+secao_hidraulica.get(i).getProduto()+"\n" + 
						"Quantidade : "+secao_hidraulica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
						secao_hidraulica.get(i).getdataEntrada()+"\n"+
						"Preço de Compra : "+secao_hidraulica.get(i).getprecoCompra()+" reais\n"+
						"Preço De Venda : "+secao_hidraulica.get(i).getprecoVenda()+" reais\n"+
						"Tipo : "+secao_hidraulica.get(i).getTipo()+"\n"+"Comprimento : "+
						secao_hidraulica.get(i).getComprimento();
				return res;
			}	 
		}

		if (teste == false)
			res = "Nenhum registro foi encontrado!";

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso pesquisarSessãoElétrica, contendo um parâmetro do tipo String
	public String pesquisarSecaoMecanica(int idMecanica,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_mecanica.size(); i++){
			if  ((nomeProduto.equals(secao_mecanica.get(i).getProduto()) & (idMecanica == secao_mecanica.get(i).getID()))) {
				res = "Seção Mecânica\nProdutos em Estoque :\n\nCódigo: "+secao_mecanica.get(i).getID()+
						"\nNome Do Produto : "+secao_mecanica.get(i).getProduto()+"\n" + 
						"Quantidade : "+secao_mecanica.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
						secao_mecanica.get(i).getdataEntrada()+"\n"+
						"Preço de Compra : "+secao_mecanica.get(i).getprecoCompra()+" reais\n"+
						"Preço De Venda : "+secao_mecanica.get(i).getprecoVenda()+" reais\n"+
						"Tipo : "+secao_mecanica.get(i).getTipo();
				return res;
			}	 
		}

		if (teste == false)
			res = "Nenhum registro foi encontrado!";

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso pesquisarSessãoElétrica, contendo um parâmetro do tipo String
	public String pesquisarSecaoOutros(int idOutros,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_outros.size(); i++){
			if  ((nomeProduto.equals(secao_outros.get(i).getProduto()) & (idOutros == secao_outros.get(i).getID()))) {
				res = "Seção Outros\nProdutos em Estoque :\n\nCódigo: "+secao_outros.get(i).getID()+
						"\nNome Do Produto : "+secao_outros.get(i).getProduto()+"\n" + 
						"Quantidade : "+secao_outros.get(i).getQuantidade()+"\n"+"Data De Entrada : "+
						secao_outros.get(i).getdataEntrada()+"\n"+
						"Preço de Compra : "+secao_outros.get(i).getprecoCompra()+" reais\n"+
						"Preço De Venda : "+secao_outros.get(i).getprecoVenda()+" reais\n"+
						"Tipo : "+secao_outros.get(i).getTipo();
				return res;
			}	 
		}

		if (teste == false)
			res = "Nenhum registro foi encontrado!";

		return res;
	}
	//=====================================================================================================

	//=====================================================================================================
	//método de acesso aumentarMercadoria, contendo uma lista de parâmetros do tipo String e do tipo int
    //metodo acrescenta uma quantidade de acordo com os parametros de produtos passados
	public String aumentarQuantidadeSecaoEletrica(int idEletrica,String nomeProduto,int quantidade){
		String res = "";

		for (int i = 0; i < secao_eletrica.size(); i++) {

			if ((nomeProduto.equals(secao_eletrica.get(i).getProduto()) & (idEletrica == secao_eletrica.get(i).getID()))){
				if (quantidade > 0){
					secao_eletrica.get(i).aumentarQuantidade(quantidade);
					res = "Quantidade adicionada com sucesso!";
					return res;
				}else {
					res = "Quantidade inválida a ser adicionada\nQuantidade : "+quantidade;
					return res;
				}
			}else {
				res = "Código ou produto não correspondem!";		
			}
		}
		return res;
	}

	public String aumentarQuantidadeSecaoHidraulica(int idHidraulica,String nomeProduto,int quantidade){
		String res = "";

		for (int i = 0; i < secao_hidraulica.size(); i++) {

			if ((nomeProduto.equals(secao_hidraulica.get(i).getProduto()) & (idHidraulica == secao_hidraulica.get(i).getID()))){
				if (quantidade > 0){
					secao_hidraulica.get(i).aumentarQuantidade(quantidade);
					res = "Quantidade adicionada com sucesso!";
					return res;
				}else {
					res = "Quantidade inválida a ser adicionada\nQuantidade : "+quantidade;
					return res;
				}
			}else {
				res = "Código ou produto não correspondem!";		
			}
		}
		return res;
	}

	public String aumentarQuantidadeSecaoMecanica(int idMecanica,String nomeProduto,int quantidade){
		String res = "";

		for (int i = 0; i < secao_mecanica.size(); i++) {

			if ((nomeProduto.equals(secao_mecanica.get(i).getProduto()) & (idMecanica == secao_mecanica.get(i).getID()))){
				if (quantidade > 0){
					secao_mecanica.get(i).aumentarQuantidade(quantidade);
					res = "Quantidade adicionada com sucesso!";
					return res;
				}else {
					res = "Quantidade inválida a ser adicionada\nQuantidade : "+quantidade;
					return res;
				}
			}else {
				res = "Código ou produto não correspondem!";		
			}
		}
		return res;
	}

	public String aumentarQuantidadeSecaoOutros(int idOutros,String nomeProduto,int quantidade){
		String res = "";

		for (int i = 0; i < secao_outros.size(); i++) {

			if ((nomeProduto.equals(secao_outros.get(i).getProduto()) & (idOutros == secao_outros.get(i).getID()))){
				if (quantidade > 0){
					secao_outros.get(i).aumentarQuantidade(quantidade);
					res = "Quantidade adicionada com sucesso!";
					return res;
				}else {
					res = "Quantidade inválida a ser adicionada\nQuantidade : "+quantidade;
					return res;
				}
			}else {
				res = "Código ou produto não correspondem!";		
			}		
		}
		return res;
	}


	public String removerSecaoEletrica(int idEletrica,String nomeProduto){
		String res = "";
		boolean teste = false;

		for (int i = 0; i < secao_eletrica.size(); i++) {
			if ((nomeProduto.equals(secao_eletrica.get(i).getProduto())) & (idEletrica == secao_eletrica.get(i).getID())){
				secao_eletrica.remove(i);
				res = "Registro removido com sucesso!";
				return res;
			}
		}

		if (teste == false)
			res = "Registro não encontrado para remoção!";

		return res;
	}

	public String removerSecaoHidraulica(int idHidraulica,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_hidraulica.size(); i++) {
			if ((nomeProduto.equals(secao_hidraulica.get(i).getProduto())) & (idHidraulica == secao_hidraulica.get(i).getID())){
				secao_hidraulica.remove(i);
				res = "Registro removido com sucesso!";
				return res;
			}
		}

		if (teste == false)
			res = "Registro não encontrado para remoção!";

		return res;
	}

	public String removerSecaoMecanica(int idMecanica,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_mecanica.size(); i++) {
			if ((nomeProduto.equals(secao_mecanica.get(i).getProduto())) & (idMecanica == secao_mecanica.get(i).getID())){
				secao_mecanica.remove(i);
				res = "Registro removido com sucesso!";
				return res;
			}
		}

		if (teste == false)
			res = "Registro não encontrado para remoção!";

		return res;
	}

	public String removerSecaoOutros(int idOutro,String nomeProduto){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < secao_outros.size(); i++) {
			if ((nomeProduto.equals(secao_outros.get(i).getProduto())) & (idOutro == secao_outros.get(i).getID())){
				secao_outros.remove(i);
				res = "Registro removido com sucesso!";
				return res;
			}

		}

		if (teste == false)
			res = "Registro não encontrado para remoção!";

		return res;
	}
//metodos verificam se o id parametros existe ja cadastrado no sistema
	public String verificarCodigoEletrica(int id){
		String res = "";
		boolean teste = false;
		
		for (int i = 0; i < secao_eletrica.size(); i++) {
			if(id == secao_eletrica.get(i).getID()){
				teste = true;
				break;
			}
		}
		
		if(teste == false){
			res = "id não retornado!";
			return res;
		}
			
		return res;
	}
	
	public String verificarCodigoHidraulica(int id){
		String res = "";
		boolean teste = false;
		
		for (int i = 0; i < secao_hidraulica.size(); i++) {
			if(id == secao_hidraulica.get(i).getID()){
				teste = true;
				break;
			}
		}
		
		if(teste == false){
			res = "id não retornado!";
			return res;
		}
		
		return res;
	}
	
	public String verificarCodigoMecanica(int id){
		String res = "";
		boolean teste = false;
		
		for (int i = 0; i < secao_mecanica.size(); i++) {
			if(id == secao_mecanica.get(i).getID()){
				teste = true;
				break;
			}
		}
		
		if(teste == false){
			res = "id não retornado!";
			return res;
		}
		
		return res;
	}
	
	public String verificarCodigoOutros(int id){
		String res = "";
		boolean teste = false;
		
		for (int i = 0; i < secao_outros.size(); i++) {
			if(id == secao_outros.get(i).getID()){
				teste = true;
				break;
			}
		}
		
		if(teste == false){
			res = "id não retornado!";
			return res;
		}
		
		return res;
	}
	//=====================================================================================================
	//método de acesso inserirVenda, contendo uma lista de parâmetros dos tipos String e do tipo byte
	//armazena no ArrayList Venda Secao Eletrica os parametros atraves do construtor da classe Venda Secao eletrica
	public String inserirVendaSecaoEletrica(int idEletrica,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){

		Venda_Secao_Eletrica AUX3 = new Venda_Secao_Eletrica(idEletrica,nomeCliente,produto,quantidade,dataSaida,CPF_Cliente);

		String res = "";
		boolean teste1 = false;	
		boolean teste2 = false;
		boolean teste3 = false;

		for (int i = 0; i < Cliente.size(); i++) {
			if (CPF_Cliente.equals(Cliente.get(i).getCpf())){
				quantidadeVendas(CPF_Cliente);
				teste1 = true;
				break;
			} 
		}

		if (teste1 == false){
			res = "CPF não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_eletrica.size(); i++) {
			if (produto.equals(secao_eletrica.get(i).getProduto())) {
				teste2 = true;
				res = "Venda realizada com sucesso!";
				break;
			}
		}

		if (teste2 == false){
			res = "Impossível realizar a venda do produto";
			return res;
		}
		
		for (int i = 0; i < Cliente.size(); i++){
			if (nomeCliente.equals(Cliente.get(i).getnomeCliente())){
				teste3 = true;
				break;

			}
		}
		
		if (teste3 == false){
			res ="Cliente não encontrado!";
			return res;
		}
		
		for (int i = 0; i < secao_eletrica.size(); i++) {
			if (produto.equals(secao_eletrica.get(i).getProduto())){
				if (quantidade <= secao_eletrica.get(i).getQuantidade()){
					venda_secao_eletrica.add(AUX3);
					secao_eletrica.get(i).diminuirQuantidade(quantidade);
					venda_secao_eletrica.get(i).setquantProdutos(quantidade);
					calcularVendaSecaoEletrica();
					break;
				}else {
					res = "Impossível realizar a venda do produto: "+secao_eletrica.get(i).getProduto()+"\n"+
							"Quantidade pedida : "+quantidade+"\n"+"Quantidade em estoque do produto: "+
							secao_eletrica.get(i).getQuantidade();
					return res;
				}
			}
		}

		return res;
	}
	//=====================================================================================================
    //armazena ao cliente um contaador que identifica a quantidade de produtos comprados por um cliente determinado
	
	int a;
	public int quantidadeVendas(String Cpf){
		for (int i = 0; i < Cliente.size(); i++) {
			if (Cpf.equals(Cliente.get(i).getCpf())){
				Cliente.get(i).setquantVendas(contVendas);
				a = Cliente.get(i).getquantVendas();
			}
		}  
		return a;
	}


	//=====================================================================================================
	//método de acesso inserirVenda, contendo uma lista de parâmetros dos tipos String e do tipo byte
	public String inserirVendaSecaoHidraulica(int idHidraulica,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){

		Venda_Secao_Hidraulica   AUX3  = new Venda_Secao_Hidraulica(idHidraulica,nomeCliente,produto,quantidade,dataSaida,CPF_Cliente);

		String res = "";
		boolean teste1 = false;
		boolean teste2 = false;
        boolean teste3 = false;
		
		for (int i = 0; i < Cliente.size(); i++) {
			if (CPF_Cliente.equals(Cliente.get(i).getCpf())){
				quantidadeVendas(CPF_Cliente);
				teste1 = true;
				break;
			} 
		}

		if (teste1 == false){
			res = "CPF não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_hidraulica.size(); i++) {
			if (produto.equals(secao_hidraulica.get(i).getProduto())) {
				teste2 = true;
				res = "Venda realizada com sucesso!";
				break;
			}	
		}

		if (teste2 == false){
			res = "Impossível realizar a venda do produto";
			return res;
		}
		
		
		for (int i = 0; i < Cliente.size(); i++){
			if (nomeCliente.equals(Cliente.get(i).getnomeCliente())){
				teste3 = true;
				break;

			}
		}
		
		if (teste3 == false){
			res ="Cliente não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_hidraulica.size(); i++) {
			if (produto.equals(secao_hidraulica.get(i).getProduto())){
				if (quantidade <= secao_hidraulica.get(i).getQuantidade()){
					venda_secao_hidraulica.add(AUX3);
					secao_hidraulica.get(i).diminuirQuantidade(quantidade);
					venda_secao_hidraulica.get(i).setquantProdutos(quantidade);
					calcularVendaSecaoHidraulica();
					break;
				}else{
					res = "Impossível realizar a venda do produto: "+secao_hidraulica.get(i).getProduto()+"\n"+
							"Quantidade pedida : "+quantidade+"\n"+"Quantidade em estoque do produto: "+
							secao_hidraulica.get(i).getQuantidade();
					return res;
				}
			}
		} 
		return res;
	}
	//=====================================================================================================
	//método de acesso inserirVenda, contendo uma lista de parâmetros dos tipos String e do tipo byte
	public String inserirVendaSecaoMecanica(int idMecanica,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){

		Venda_Secao_Mecanica   AUX3  = new Venda_Secao_Mecanica(idMecanica,nomeCliente,produto,quantidade,dataSaida,CPF_Cliente);

		String res = "";
		boolean teste1 = false;
		boolean teste2 = false;
		boolean teste3 = false;

		for (int i = 0; i < Cliente.size(); i++) {
			if (CPF_Cliente.equals(Cliente.get(i).getCpf())){
				quantidadeVendas(CPF_Cliente);
				teste1 = true;
				break;
			}
		}

		if (teste1 == false){
			res = "CPF não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_mecanica.size(); i++) {
			if (produto.equals(secao_mecanica.get(i).getProduto())) {
				teste2 = true;
				res = "Venda realizada com sucesso!";
				break;
			}	
		}

		if (teste2 == false){
			res = "Impossível realizar a venda do produto";
			return res;
		}
		
		for (int i = 0; i < Cliente.size(); i++){
			if (nomeCliente.equals(Cliente.get(i).getnomeCliente())){
				teste3 = true;
				break;

			}
		}
		
		if (teste3 == false){
			res ="Cliente não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_mecanica.size(); i++) {
			if (produto.equals(secao_mecanica.get(i).getProduto())){
				if (quantidade <= secao_mecanica.get(i).getQuantidade()){
					venda_secao_mecanica.add(AUX3);
					secao_mecanica.get(i).diminuirQuantidade(quantidade);
					venda_secao_mecanica.get(i).setquantProdutos(quantidade);
					calcularVendaSecaoMecanica();
					break;
				}else{
					res = "Impossível realizar a venda do produto: "+secao_mecanica.get(i).getProduto()+"\n"+
							"Quantidade pedida : "+quantidade+"\n"+"Quantidade em estoque do produto: "+
							secao_mecanica.get(i).getQuantidade();
					return res;
				}
			}
		} 
		return res;
	}
	//=====================================================================================================
	//método de acesso inserirVenda, contendo uma lista de parâmetros dos tipos String e do tipo byte
	public String inserirVendaSecaoOutros(int idOutros,String nomeCliente,String produto,int quantidade,String dataSaida,String CPF_Cliente){

		Venda_Secao_Outros   AUX3  = new Venda_Secao_Outros(idOutros,nomeCliente,produto,quantidade,dataSaida,CPF_Cliente);

		String res = "";
		boolean teste1 = false;
		boolean teste2 = false;
		boolean teste3 = false;
		
		for (int i = 0; i < Cliente.size(); i++) {
			if (CPF_Cliente.equals(Cliente.get(i).getCpf())){
				quantidadeVendas(CPF_Cliente);
				teste1 = true;
				break;
			}
		}

		if (teste1 == false){
			res = "CPF não encontrado!";
			return res;
		}

		for (int i = 0; i < secao_outros.size(); i++) {
			if (produto.equals(secao_outros.get(i).getProduto())) {
				teste2 = true;
				res = "Venda realizada com sucesso!";
				break;
			}	
		}

		if (teste2 == false){
			res = "Impossível realizar a venda do produto";
			return res;
		}

		
		for (int i = 0; i < Cliente.size(); i++){
			if (nomeCliente.equals(Cliente.get(i).getnomeCliente())){
				teste3 = true;
				break;

			}
		}
		
		if (teste3 == false){
			res ="Cliente não encontrado!";
			return res;
		}
		
		for (int i = 0; i < secao_outros.size(); i++) {
			if (produto.equals(secao_outros.get(i).getProduto())){
				if (quantidade <= secao_outros.get(i).getQuantidade()){
					venda_secao_outros.add(AUX3);
					secao_outros.get(i).diminuirQuantidade(quantidade);
					venda_secao_outros.get(i).setquantProdutos(quantidade);
					calcularVendaSecaoOutros();
					break;
				}else{
					res = "Impossível realizar a venda do produto: "+secao_outros.get(i).getProduto()+"\n"+
							"Quantidade pedida : "+quantidade+"\n"+"Quantidade em estoque do Pproduto: "+
							secao_outros.get(i).getQuantidade();
					return res;
				}
			}
		} 
		return res;
	}

	//============================================= Metodo Listar Estatisticas de Vendas ==================//

	public String listarLucrosEletrica(){
		String res = "";
		float somaLucro = 0;
		int somaquantProdutos = 0;

		for (int i = 0; i < venda_secao_eletrica.size(); i++) {
			somaLucro += lucroProdutoEletrica.get(i);
			somaquantProdutos += venda_secao_eletrica.get(i).getquantProdutos();
		}

		res = "Lucro Total: "+somaLucro+" R$\n"+"Qnt de produtos Vendidos: "+somaquantProdutos;

		return res;
	}

	public String listarLucrosHidraulica(){
		String res = "";
		float somaLucro = 0;
		int somaquantProdutos = 0;

		for (int i = 0; i < venda_secao_hidraulica.size(); i++) {
			somaLucro += lucroProdutoHidraulica.get(i);
			somaquantProdutos += venda_secao_hidraulica.get(i).getquantProdutos();
		}

		res = "Lucro Total: "+somaLucro+" R$\n"+"Qnt de produtos Vendidos: "+somaquantProdutos;
		return res;
	}

	//exibe um pequeno relatorio sobre os lucros e produtos vendidos
	public String listarLucrosMecanica(){
		String res = "";
		float somaLucro = 0;
		int somaquantProdutos = 0;

		for (int i = 0; i < venda_secao_mecanica.size(); i++) {
			somaLucro += lucroProdutoMecanica.get(i);
			somaquantProdutos += venda_secao_mecanica.get(i).getquantProdutos();
		}

		res = "Lucro Total: "+somaLucro+" R$\n"+"Qnt de produtos Vendidos: "+somaquantProdutos;
		return res;
	}

	public String listarLucrosOutros(){
		String res = "";
		float somaLucro = 0;
		int somaquantProdutos = 0;

		for (int i = 0; i < venda_secao_outros.size(); i++) {
			somaLucro += lucroProdutoOutros.get(i);
			somaquantProdutos += venda_secao_outros.get(i).getquantProdutos();
		}

		res = "Lucro Total: "+somaLucro+" R$\n"+"Qnt de produtos Vendidos: "+somaquantProdutos;
		return res;
	}


	//=====================================================================================================
	//método de alteração calcularVendaSessaoEletrica
	public void calcularVendaSecaoEletrica(){
		for (int i = 0; i < venda_secao_eletrica.size(); i++){
			for (int j = 0; j < secao_eletrica.size(); j++){
				float A = (venda_secao_eletrica.get(i).getQuantidade() * secao_eletrica.get(j).getprecoVenda());
				float B = (venda_secao_eletrica.get(i).getQuantidade() * secao_eletrica.get(j).getprecoCompra());
				precoVendaEletrica.add(i, A);
				precoCompraEletrica.add(i, B);
				lucroProdutoEletrica.add(i, (A - B));
			}
		}
	}

	//=====================================================================================================

	//método de alteração calcularVendaSessaoHidraulica
	//
	public void calcularVendaSecaoHidraulica(){
		for (int i = 0; i < venda_secao_hidraulica.size(); i++){
			for (int j = 0; j < secao_hidraulica.size(); j++){
				float A = (venda_secao_hidraulica.get(i).getQuantidade() * secao_hidraulica.get(j).getprecoVenda());
				float B = (venda_secao_hidraulica.get(i).getQuantidade() * secao_hidraulica.get(j).getprecoCompra());
				precoVendaHidraulica.add(i, A);
				precoCompraHidraulica.add(i, B);
				lucroProdutoHidraulica.add(i, (A - B));
			}
		}
	}
	//=====================================================================================================
	//método de alteração calcularVendaSessaoMecanica
	public void calcularVendaSecaoMecanica(){
		for (int i = 0; i < venda_secao_mecanica.size(); i++){
			for (int j = 0; j < secao_mecanica.size(); j++){
				float A = (venda_secao_mecanica.get(i).getQuantidade() * secao_mecanica.get(j).getprecoVenda());
				float B = (venda_secao_mecanica.get(i).getQuantidade() * secao_mecanica.get(j).getprecoCompra());
				precoVendaMecanica.add(i, A);
				precoCompraMecanica.add(i, B);
				lucroProdutoMecanica.add(i, (A - B));
			}
		}
	}
	//=====================================================================================================
	//método de alteração calcularVendaSessaoOutros
	public void calcularVendaSecaoOutros(){
		for (int i = 0; i < venda_secao_outros.size(); i++){
			for (int j = 0; j < secao_outros.size(); j++){
				float A = (venda_secao_outros.get(i).getQuantidade() * secao_outros.get(j).getprecoVenda());
				float B = (venda_secao_outros.get(i).getQuantidade() * secao_outros.get(j).getprecoCompra());
				precoVendaOutros.add(i, A);
				precoCompraOutros.add(i, B);
				lucroProdutoOutros.add(i, (A - B));
			}
		}
	}

	public String relatorioVendasSecaoEletrica(){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < venda_secao_eletrica.size(); i++) {
			res += "Seção Elétrica\n\nCódigo  : "+venda_secao_eletrica.get(i).getID()+
					"\nCliente : "+venda_secao_eletrica.get(i).getnomeCliente()+"\n"+
					"Produto : "+venda_secao_eletrica.get(i).getProduto()+"\n"+
					"Data de Saida do Produto : "+venda_secao_eletrica.get(i).getdataSaida()+"\n"+
					"Quantidade : "+venda_secao_eletrica.get(i).getQuantidade()+"\n"+
					"Valor Total da Venda : "+precoVendaEletrica.get(i)+" reais"+"\n"+
					"Valor Parcial do Lucro : "+lucroProdutoEletrica.get(i)+" reais\n____________________________________\n\n";
			teste = true;
		}	

		if (teste == false)
			res = "Não ha produto(os) vendidos(os) no momento!";

		return res;
	}

	public String relatorioVendasSecaoHidraulica(){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < venda_secao_hidraulica.size(); i++) {
			res += "Seção Hidráulica\n\nCódigo : "+venda_secao_hidraulica.get(i).getID()+
					"\nCliente : "+venda_secao_hidraulica.get(i).getnomeCliente()+"\n"+
					"Produto : "+venda_secao_hidraulica.get(i).getProduto()+"\n"+
					"Data de Saida do Produto : "+venda_secao_hidraulica.get(i).getdataSaida()+"\n"+
					"Quantidade : "+venda_secao_hidraulica.get(i).getQuantidade()+"\n"+
					"Valor Total da Venda : "+precoVendaHidraulica.get(i)+" reais"+"\n"+
					"Valor Parcial do Lucro : "+lucroProdutoHidraulica.get(i)+" reais\n____________________________________\n\n";
			teste = true;
		}	

		if (teste == false)
			res = "Não ha produto(os) vendidos(os) no momento!";

		return res;
	}

	public String relatorioVendasSecaoMecanica(){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < venda_secao_mecanica.size(); i++) {
			res += "Seção Mecânica\n\nCódigo : "+venda_secao_mecanica.get(i).getID()+"\n" +
					"Cliente : "+venda_secao_mecanica.get(i).getnomeCliente()+"\n"+
					"Produto : "+venda_secao_mecanica.get(i).getProduto()+"\n"+
					"Data de Saida do Produto : "+venda_secao_mecanica.get(i).getdataSaida()+"\n"+
					"Quantidade : "+venda_secao_mecanica.get(i).getQuantidade()+"\n"+
					"Valor Total da Venda : "+precoVendaMecanica.get(i)+" reais"+"\n"+
					"Valor Parcial do Lucro : "+lucroProdutoMecanica.get(i)+" reais\n____________________________________\n\n";
			teste = true;
		}	

		if (teste == false)
			res = "Não ha produto(os) vendidos(os) no momento!";

		return res;
	}

	public String relatorioVendasSecaoOutros(){
		String res = "";
		boolean teste = false;
		for (int i = 0; i < venda_secao_outros.size(); i++) {
			res += "Seção Outros\n\nCódigo : "+venda_secao_outros.get(i).getID()+"\n" +
					"Cliente : "+venda_secao_outros.get(i).getnomeCliente()+"\n"+
					"Produto : "+venda_secao_outros.get(i).getProduto()+"\n"+
					"Data de Saida do Produto : "+venda_secao_outros.get(i).getdataSaida()+"\n"+
					"Quantidade : "+venda_secao_outros.get(i).getQuantidade()+"\n"+
					"Valor Total da Venda : "+precoVendaOutros.get(i)+" reais"+"\n"+
					"Valor Parcial do Lucro : "+lucroProdutoOutros.get(i)+" reais\n____________________________________\n\n";
			teste = true;
		}	

		if (teste == false)
			res = "Não ha produto(os) vendidos(os) no momento!";

		return res;
	}
}