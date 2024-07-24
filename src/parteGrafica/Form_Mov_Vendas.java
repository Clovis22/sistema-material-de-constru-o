package parteGrafica;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.material.construcao.p2.*;

public class Form_Mov_Vendas implements Gravacao{
	protected  JFrame  frame_Mov_Vendas;
	private JPanel  Painel;
	private JTabbedPane JTP_Mov_Vendas,JTP_Frequencia;
	private JButton btn_Venda,btn_Relatorio;
	private JComboBox jcb_Sec;
	private JTextField TF_nome_Cliente,TF_nome_Produto,TF_quantidade,TF_ID_Produto,TF_Troco,TF_Desconto,TF_Parcelas,TF_Valor_AV;
	private JLabel lb_nome_Cliente,lb_nome_Produto,lb_quantidade,lb_data_Saida,lb_Cpf_Cliente,
	lb_Secao,lb_Desconto,lb_ID_Produto,lb_Troco,lb_Parcelas,lb_Valor_AV,lb_Texto;

	private ImageIcon Mov_Vendas = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Vendas.png"));
	private MaskFormatter MF_Dt_Saida_Produto,MF_Cpf_Cliente;
	private JFormattedTextField Formato_Dt_Saida,Formato_Cpf_Cliente;

	private JCheckBox JCB_A_Vista,JCB_Prazo;

	private String secao[] = {"----------","Elétrica","Hidráulica","Mecânica","Outros"};

	private byte valor; 

	BancoDeDados BD = new BancoDeDados();

	public Form_Mov_Vendas(){
		ler_arquivo();

		frame_Mov_Vendas = new JFrame("Balcão de Vendas");

		Painel = new JPanel();
		Painel.setLayout(null);
		Painel.setSize(370,280);

		JTP_Mov_Vendas = new JTabbedPane();
		JTP_Mov_Vendas.setSize(370,280); 
		JTP_Frequencia = new JTabbedPane();

		lb_nome_Cliente  = new JLabel("Nome do Cliente");
		lb_nome_Produto  = new JLabel("Nome do Produto");
		lb_data_Saida    = new JLabel("Saída do Produto");
		lb_Cpf_Cliente   = new JLabel("CPF de Cliente");
		lb_quantidade    = new JLabel("Quantidade");
		lb_ID_Produto    = new JLabel("Codigo do Produto");
		lb_Troco         = new JLabel("Troco");
		TF_Desconto      = new JTextField();
		lb_Parcelas      = new JLabel("Parcelas");
		lb_Valor_AV      = new JLabel("Valor A.V. $");
		lb_Secao         = new JLabel("Seção");
		lb_Desconto      = new JLabel("Desconto (%)");
		lb_Texto         = new JLabel("X de");
		jcb_Sec          = new JComboBox(secao);
		TF_nome_Cliente  = new JTextField();
		TF_nome_Produto  = new JTextField();
		TF_quantidade    = new JTextField();
		TF_ID_Produto = new JTextField();

		

		TF_Troco        = new JTextField();

		TF_Troco.setText("0.0");

		TF_Parcelas     = new JTextField();
		TF_Valor_AV     = new JTextField();

		TF_Parcelas.setEnabled(false);
		TF_Valor_AV.setEnabled(false); 

		TF_Desconto.setEnabled(false);

		
		TF_Troco.setEditable(false);

		try {
			MF_Dt_Saida_Produto = new MaskFormatter("## / ## / ####");
			MF_Cpf_Cliente      = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {}

		Formato_Dt_Saida    = new JFormattedTextField(MF_Dt_Saida_Produto);
		Formato_Cpf_Cliente = new JFormattedTextField(MF_Cpf_Cliente);
		btn_Venda           = new JButton("Vender");
		btn_Relatorio       = new JButton("Relatorio");

		JCB_A_Vista         = new JCheckBox("A vista"); 
		JCB_Prazo           = new JCheckBox("A prazo");

		jcb_Sec.setMaximumRowCount(5);

		Painel.add(lb_nome_Cliente);
		Painel.add(lb_nome_Produto);
		Painel.add(lb_quantidade);
		Painel.add(lb_data_Saida);
		Painel.add(lb_Cpf_Cliente);
		Painel.add(lb_ID_Produto);
		Painel.add(lb_Secao);
		Painel.add(btn_Venda);
		Painel.add(btn_Relatorio);
		Painel.add(TF_nome_Cliente);
		Painel.add(TF_nome_Produto);
		Painel.add(TF_quantidade);
		Painel.add(Formato_Dt_Saida);
		Painel.add(Formato_Cpf_Cliente);
		Painel.add(TF_ID_Produto);
		Painel.add(jcb_Sec);

		lb_nome_Produto.setBounds(01,01,110,20);
		lb_nome_Cliente.setBounds(130,01,120,20);
		lb_quantidade.setBounds(01,40,120,20);
		lb_data_Saida.setBounds(130,40,130,20);
		lb_Cpf_Cliente.setBounds(260,40,130,20);
		lb_Secao.setBounds(01,78,95,20);
		lb_ID_Produto.setBounds(260,01,120,20);
		lb_Desconto.setBounds(260, 78, 80, 20);
		TF_ID_Produto.setBounds(260,20,100,25);

		TF_Desconto.setBounds(260, 97, 100, 25);
		btn_Venda.setBounds(60,190,109,24);
		btn_Relatorio.setBounds(190,190,109,24);
		TF_nome_Produto.setBounds(01,20,120,25);
		TF_nome_Cliente.setBounds(130,20,120,25);
		TF_quantidade.setBounds(01,59,120,25);
		Formato_Dt_Saida.setBounds(130,59,120,25);
		Formato_Cpf_Cliente.setBounds(260,59,100,25);
		jcb_Sec.setBounds(01,97,120,25);
		TF_Troco.setBounds(130, 97, 120, 25);

		JTP_Mov_Vendas.addTab("Balcão de Vendas", Painel);


		frame_Mov_Vendas.add(JTP_Mov_Vendas);


		frame_Mov_Vendas.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Principal Principal = new Principal();
				Principal.frame_Menu_Principal.show();
			}});

		btn_Venda.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//Obtem o valor(posição) que foi selecionado
				valor = (byte) jcb_Sec.getSelectedIndex();
				switch(valor){
				case 0:
					JOptionPane.showMessageDialog(null, "Não é possível executar venda"+"\n"+"sem uma seção definida!","Aviso!",JOptionPane.WARNING_MESSAGE);
					break;	
				case 1:	
					onClickVendaEletrica();
					break;
				case 2:
					onClickVendaHidraulica();
					break;
				case 3:
					onClickVendaMecanica();
					break;
				case 4:
					onClickVendaOutros();
					break;	
				}
			}});

		JCB_A_Vista.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){

				if(JCB_A_Vista.isSelected() == true){
					TF_Desconto.setEnabled(true);
					lb_Valor_AV.setVisible(true);
					TF_Valor_AV.setVisible(true);
					TF_Valor_AV.setEnabled(true);

					lb_Parcelas.setVisible(false);
					lb_Texto.setVisible(false);
					TF_Parcelas.setVisible(false);
					lb_Valor_AV.setBounds(01, 115, 80, 20);
					TF_Valor_AV.setBounds(01, 135, 120, 20);
				}else {	
					TF_Desconto.setEnabled(false);
					lb_Valor_AV.setVisible(false);
					TF_Valor_AV.setVisible(false);

					if(JCB_A_Vista.isSelected() != JCB_Prazo.isSelected()){
						TF_Desconto.setEnabled(false);
						lb_Valor_AV.setVisible(true);
						TF_Valor_AV.setVisible(true);
					}
				}

			}});

		JCB_Prazo.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){

				if(JCB_Prazo.isSelected() == true){
					TF_Desconto.setEnabled(false);

					lb_Parcelas.setVisible(true);
					TF_Parcelas.setVisible(true);
					TF_Parcelas.setEnabled(true);

					lb_Texto.setVisible(true);

					lb_Valor_AV.setVisible(true);
					TF_Valor_AV.setVisible(true);
					TF_Valor_AV.setEnabled(true);

					lb_Parcelas.setBounds(01, 115, 80, 20);
					lb_Texto.setBounds(104, 133, 40, 20);
					lb_Valor_AV.setBounds(130, 115, 80, 20);
					TF_Parcelas.setBounds(01, 135, 100, 20);
					TF_Valor_AV.setBounds(130, 135, 120, 20);
				}else {	
					TF_Desconto.setEnabled(false);
					lb_Parcelas.setVisible(false);
					TF_Parcelas.setVisible(false);
					lb_Texto.setVisible(false);
					lb_Valor_AV.setVisible(false);
					TF_Valor_AV.setVisible(false);

					if(JCB_A_Vista.isSelected() != JCB_Prazo.isSelected()){
						lb_Valor_AV.setVisible(true);
						TF_Valor_AV.setVisible(true);
						lb_Valor_AV.setBounds(01, 115, 80, 20);
						TF_Valor_AV.setBounds(01, 135, 120, 20);
					}
				}

			}});

		btn_Relatorio.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onCLickRelatorio();
			}});

		frame_Mov_Vendas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Mov_Vendas.setSize(370,280);
		frame_Mov_Vendas.setLocationRelativeTo(null);
		frame_Mov_Vendas.setVisible(true);
		frame_Mov_Vendas.setResizable(false);
		frame_Mov_Vendas.setIconImage(Mov_Vendas.getImage());
	
	}

	public void onClickVendaEletrica(){
		String nomeCliente  = TF_nome_Cliente.getText().toUpperCase();
		String nomeProduto  = TF_nome_Produto.getText().toUpperCase();
		String saidaProduto = Formato_Dt_Saida.getText();
		String CPF_Cliente  = Formato_Cpf_Cliente.getText();

		int idEletrica;
		try{
			idEletrica = Integer.parseInt(TF_ID_Produto.getText());
			if(idEletrica < 0 ){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idEletrica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else if (BD.verificarCodigoEletrica(idEletrica).equals("id não retornado!")){
				JOptionPane.showMessageDialog(null,"Código do produto não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}


		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;  
			try {
				quantidade = Integer.parseInt(TF_quantidade.getText());
				Produto  p = new Secao_Eletrica(quantidade);
				Venda_Secao_Eletrica vse = new Venda_Secao_Eletrica(p);

				if (vse.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para a venda do produto!\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

			if (saidaProduto.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Saida.setBackground(Color.RED);
				return;
			}else if (CPF_Cliente.equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Cpf_Cliente.setBackground(Color.RED);
				return;
			}


			if (BD.inserirVendaSecaoEletrica(idEletrica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Venda realizada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
				gravar_arquivo();
				limparCampos();

				TF_ID_Produto.setBackground(Color.WHITE);
				TF_nome_Cliente.setBackground(Color.WHITE);
				TF_nome_Produto.setBackground(Color.WHITE);
				Formato_Dt_Saida.setBackground(Color.WHITE);
				Formato_Cpf_Cliente.setBackground(Color.WHITE);
				TF_quantidade.setBackground(Color.WHITE);

			}else {
				if (BD.inserirVendaSecaoEletrica(idEletrica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Impossível realizar a venda do produto")){
					JOptionPane.showMessageDialog(null,"Impossível realizar a venda do produto : "+nomeProduto+"\n"+"Produto não encontrado no estoque!","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_nome_Produto.setBackground(Color.RED);
					return;  
				}else if (BD.inserirVendaSecaoEletrica(idEletrica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Cliente não encontrado!")){
					      JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
					      TF_nome_Cliente.setBackground(Color.RED);      
					      return;
				}else if (BD.inserirVendaSecaoEletrica(idEletrica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("CPF não encontrado!")){
					JOptionPane.showMessageDialog(null,"CPF não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
					Formato_Cpf_Cliente.setBackground(Color.RED);
					return; 
				}else {
					JOptionPane.showMessageDialog(null,BD.inserirVendaSecaoEletrica(idEletrica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente),"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}
		}
	}

	public void onClickVendaHidraulica(){
		String nomeCliente  = TF_nome_Cliente.getText().toUpperCase();
		String nomeProduto  = TF_nome_Produto.getText().toUpperCase();
		String saidaProduto = Formato_Dt_Saida.getText();
		String CPF_Cliente  = Formato_Cpf_Cliente.getText();

		int idHidraulica;
		try{
			idHidraulica = Integer.parseInt(TF_ID_Produto.getText());
			if(idHidraulica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idHidraulica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else if (BD.verificarCodigoHidraulica(idHidraulica).equals("id não retornado!")){
				JOptionPane.showMessageDialog(null,"Código do produto não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}


		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;  
			try {
				quantidade = Integer.parseInt(TF_quantidade.getText());
				Produto  p = new Secao_Hidraulica(quantidade);
				Venda_Secao_Hidraulica vsh = new Venda_Secao_Hidraulica(p); 
				if (vsh.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para a venda do produto!\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

			if (saidaProduto.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Saida.setBackground(Color.RED);
				return;
			}else if (CPF_Cliente.equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Cpf_Cliente.setBackground(Color.RED);
				return;
			}

			if (BD.inserirVendaSecaoHidraulica(idHidraulica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Venda realizada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
				gravar_arquivo();
				limparCampos();

				TF_ID_Produto.setBackground(Color.WHITE);
				TF_nome_Cliente.setBackground(Color.WHITE);
				TF_nome_Produto.setBackground(Color.WHITE);
				Formato_Dt_Saida.setBackground(Color.WHITE);
				Formato_Cpf_Cliente.setBackground(Color.WHITE);
				TF_quantidade.setBackground(Color.WHITE);

			}else {
				if (BD.inserirVendaSecaoHidraulica(idHidraulica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Impossível realizar a venda do produto")){
					JOptionPane.showMessageDialog(null,"Impossível realizar a venda do produto : "+nomeProduto+"\n"+"Produto não encontrado no estoque!","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_nome_Produto.setBackground(Color.RED);
					return;  
				}else if (BD.inserirVendaSecaoHidraulica(idHidraulica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Cliente não encontrado!")){
				      JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				      TF_nome_Cliente.setBackground(Color.RED);      
				      return;
				}else if (BD.inserirVendaSecaoHidraulica(idHidraulica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("CPF não encontrado!")){
					JOptionPane.showMessageDialog(null,"CPF não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
					Formato_Cpf_Cliente.setBackground(Color.RED);
					return; 
				}else {
					JOptionPane.showMessageDialog(null,BD.inserirVendaSecaoHidraulica(idHidraulica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente),"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

		}
	}

	public void onClickVendaMecanica(){
		String nomeCliente  = TF_nome_Cliente.getText().toUpperCase();
		String nomeProduto  = TF_nome_Produto.getText().toUpperCase();
		String saidaProduto = Formato_Dt_Saida.getText();
		String CPF_Cliente  = Formato_Cpf_Cliente.getText();

		int idMecanica;
		try{
			idMecanica = Integer.parseInt(TF_ID_Produto.getText());
			if(idMecanica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idMecanica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else if (BD.verificarCodigoMecanica(idMecanica).equals("id não retornado!")){
				JOptionPane.showMessageDialog(null,"Código do produto não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}



		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;  
			try {
				quantidade = Integer.parseInt(TF_quantidade.getText());
				Produto  p = new Secao_Mecanica(quantidade);
				Venda_Secao_Mecanica vsm = new Venda_Secao_Mecanica(p); 
				if (vsm.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para a venda do produto!\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

			if (saidaProduto.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Saida.setBackground(Color.RED);
				return;
			}else if (CPF_Cliente.equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Cpf_Cliente.setBackground(Color.RED);
				return;
			}


			if (BD.inserirVendaSecaoMecanica(idMecanica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Venda realizada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
				gravar_arquivo();
				limparCampos();

				TF_ID_Produto.setBackground(Color.WHITE);
				TF_nome_Cliente.setBackground(Color.WHITE);
				TF_nome_Produto.setBackground(Color.WHITE);
				Formato_Dt_Saida.setBackground(Color.WHITE);
				Formato_Cpf_Cliente.setBackground(Color.WHITE);
				TF_quantidade.setBackground(Color.WHITE);

			}else {
				if (BD.inserirVendaSecaoMecanica(idMecanica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Impossível realizar a venda do produto")){
					JOptionPane.showMessageDialog(null,"Impossível realizar a venda do produto : "+nomeProduto+"\n"+"Produto não encontrado no estoque!","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_nome_Produto.setBackground(Color.RED);
					return;  
				}else if (BD.inserirVendaSecaoMecanica(idMecanica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Cliente não encontrado!")){
				      JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				      TF_nome_Cliente.setBackground(Color.RED);      
				      return; 
			    }else if (BD.inserirVendaSecaoMecanica(idMecanica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("CPF não encontrado!")){
				     	 JOptionPane.showMessageDialog(null,"CPF não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
					     Formato_Cpf_Cliente.setBackground(Color.RED);
					     return; 
				}else {
					JOptionPane.showMessageDialog(null,BD.inserirVendaSecaoMecanica(idMecanica,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente),"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}
		}
	}

	public void onClickVendaOutros(){
		String nomeCliente  = TF_nome_Cliente.getText().toUpperCase();
		String nomeProduto  = TF_nome_Produto.getText().toUpperCase();
		String saidaProduto = Formato_Dt_Saida.getText();
		String CPF_Cliente  = Formato_Cpf_Cliente.getText();

		int idOutros;
		try{
			idOutros = Integer.parseInt(TF_ID_Produto.getText());
			if(idOutros < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idOutros,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else if (BD.verificarCodigoOutros(idOutros).equals("id não retornado!")){
				JOptionPane.showMessageDialog(null,"Código do produto não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}



		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;  
			try {
				quantidade = Integer.parseInt(TF_quantidade.getText());
				Produto  p = new Secao_Outros(quantidade);
				Venda_Secao_Outros vso = new Venda_Secao_Outros(p);
				if (vso.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para a venda do produto!\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

			if (saidaProduto.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Saida.setBackground(Color.RED);
				return;
			}else if (CPF_Cliente.equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Cpf_Cliente.setBackground(Color.RED);
				return;
			}
			if (BD.inserirVendaSecaoOutros(idOutros,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Venda realizada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
				gravar_arquivo();
				limparCampos();

				TF_ID_Produto.setBackground(Color.WHITE);
				TF_nome_Cliente.setBackground(Color.WHITE);
				TF_nome_Produto.setBackground(Color.WHITE);
				Formato_Dt_Saida.setBackground(Color.WHITE);
				Formato_Cpf_Cliente.setBackground(Color.WHITE);
				TF_quantidade.setBackground(Color.WHITE);

			}else {
				if (BD.inserirVendaSecaoOutros(idOutros,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Impossível realizar a venda do produto")){
					JOptionPane.showMessageDialog(null,"Impossível realizar a venda do produto : "+nomeProduto+"\n"+"Produto não encontrado no estoque!","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_nome_Produto.setBackground(Color.RED);
					return;  
				}else if (BD.inserirVendaSecaoOutros(idOutros,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("Cliente não encontrado!")){
				      JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
				      TF_nome_Cliente.setBackground(Color.RED);      
				      return;
			    }else if (BD.inserirVendaSecaoOutros(idOutros,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente).equals("CPF não encontrado!")){
					JOptionPane.showMessageDialog(null,"CPF não encontrado!","Aviso!",JOptionPane.WARNING_MESSAGE);
					Formato_Cpf_Cliente.setBackground(Color.RED);
					return; 
				}else {
					JOptionPane.showMessageDialog(null,BD.inserirVendaSecaoOutros(idOutros,nomeCliente,nomeProduto,quantidade,saidaProduto,CPF_Cliente),"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade.setBackground(Color.RED);
					return;
				}
			}

		}


	}

	public void limparCampos(){
		TF_ID_Produto.setText("");
		TF_nome_Cliente.setText("");
		TF_nome_Produto.setText("");
		TF_quantidade.setText("");
		Formato_Dt_Saida.setText("");
		Formato_Cpf_Cliente.setText("");
	}

	public void onCLickRelatorio(){
		Form_Relatorio_Vendas Form_Relatorio_Vendas = new Form_Relatorio_Vendas();
		Form_Relatorio_Vendas.Exibir_Relatorio_Vendas_Eletrica.setText(BD.relatorioVendasSecaoEletrica());
		Form_Relatorio_Vendas.Exibir_Relatorio_Vendas_Hidraulica.setText(BD.relatorioVendasSecaoHidraulica());
		Form_Relatorio_Vendas.Exibir_Relatorio_Vendas_Mecanica.setText(BD.relatorioVendasSecaoMecanica());
		Form_Relatorio_Vendas.Exibir_Relatorio_Vendas_Outros.setText(BD.relatorioVendasSecaoOutros());
		frame_Mov_Vendas.hide();
	}



	public void gravar_arquivo(){
		try{
			FileOutputStream f = new FileOutputStream("c:/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo de dados não Encontrado");
		}
	}

	public void ler_arquivo(){
		try{
			FileInputStream f = new FileInputStream("c:\\Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectInputStream o = new ObjectInputStream(f);
			BD = (BancoDeDados) o.readObject();
			o.close();
			}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo de dados não Encontrado");
		}
	}

}