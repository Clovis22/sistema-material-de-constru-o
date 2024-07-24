package parteGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;

import br.material.construcao.p2.*;

public class Form_Mov_Estoque implements Gravacao{


	BancoDeDados BD = new BancoDeDados();

	private String secao[]={"----------","Elétrica","Hidráulica","Mecânica","Outros"};
	private JComboBox selecao;
	public  JFrame frame_Cadastro_Estoque;
	private JButton btn_gravar_Mercadoria;
	private JButton btn_listar_Mercadoria;
	private JButton btn_buscar_Mercadoria;
	private JButton btn_atualizar_Mercadoria;
	private JButton btn_remover_Mercadoria;

	private JLabel LB_ID_Produto,LB_nome_Produto,
	LB_Quantidade_Produto,
	LB_Dt_Entrada_Produto,
	LB_Preco_Compra,
	LB_Preco_Venda,
	LB_Secao,LB_Estoque_Voltagem,
	LB_Estoque_Potencia,LB_Estoque_Tipo,
	LB_Estoque_Comprimento;


	private JTextField TF_ID_Produto,TF_nome_Produto,
	TF_Quantidade_Produto,
	TF_Preco_Compra,
	TF_Preco_Venda,TF_Estoque_Voltagem,
	TF_Estoque_Potencia,TF_Estoque_Tipo,
	TF_Estoque_Comprimento;

	private MaskFormatter MF_Dt_Entrada_Produto;
	private JFormattedTextField Formato_Dt_Entrada;

	private byte valor;
	public Form_Mov_Estoque() {
		ler_arquivo();

		ImageIcon Mov_Estoque  = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Estoque.png"));
		frame_Cadastro_Estoque = new JFrame("Cadastro de Estoque");
		frame_Cadastro_Estoque.setLayout(null);

		selecao = new JComboBox(secao);
		selecao.setMaximumRowCount(5);

		btn_gravar_Mercadoria    = new JButton("Cadastrar");
		btn_listar_Mercadoria    = new JButton("Listar");
		btn_buscar_Mercadoria    = new JButton("Pesquisar");
		btn_atualizar_Mercadoria = new JButton("Atualizar");
		btn_remover_Mercadoria   = new JButton("Remover");

		LB_ID_Produto          = new JLabel("Código");
		LB_nome_Produto        = new JLabel("Nome do Produto");
		LB_Quantidade_Produto  = new JLabel("Quantidade");
		LB_Dt_Entrada_Produto  = new JLabel("Data de Entrada");
		LB_Preco_Compra        = new JLabel("Preço de Compra R$");
		LB_Preco_Venda         = new JLabel("Preço de Venda R$");
		LB_Secao               = new JLabel("Seção");
		LB_Estoque_Voltagem    = new JLabel("Voltagem V");
		LB_Estoque_Potencia    = new JLabel("Potência WATTS");
		LB_Estoque_Tipo        = new JLabel("Tipo");
		LB_Estoque_Comprimento = new JLabel("Comprimento");

		LB_Estoque_Voltagem.hide();
		LB_Estoque_Potencia.hide();
		LB_Estoque_Tipo.hide();
		LB_Estoque_Comprimento.hide();

		TF_ID_Produto         = new JTextField();
		TF_nome_Produto       = new JTextField();
		TF_Quantidade_Produto = new JTextField();
		try {
			MF_Dt_Entrada_Produto = new MaskFormatter("## / ## / ####");
		} catch (ParseException e1) {}
		Formato_Dt_Entrada     = new JFormattedTextField(MF_Dt_Entrada_Produto);
		TF_Preco_Compra        = new JTextField();
		TF_Preco_Venda         = new JTextField();
		TF_Estoque_Voltagem    = new JTextField();
		TF_Estoque_Potencia    = new JTextField();
		TF_Estoque_Tipo        = new JTextField();
		TF_Estoque_Comprimento = new JTextField();

		TF_Estoque_Voltagem.hide();
		TF_Estoque_Potencia.hide();
		TF_Estoque_Tipo.hide();
		TF_Estoque_Comprimento.hide();

		frame_Cadastro_Estoque.add(selecao);
		frame_Cadastro_Estoque.add(btn_gravar_Mercadoria);
		frame_Cadastro_Estoque.add(btn_listar_Mercadoria);
		frame_Cadastro_Estoque.add(btn_buscar_Mercadoria);
		frame_Cadastro_Estoque.add(btn_atualizar_Mercadoria);
		frame_Cadastro_Estoque.add(btn_remover_Mercadoria);

		frame_Cadastro_Estoque.add(LB_Secao);
		frame_Cadastro_Estoque.add(LB_ID_Produto);
		frame_Cadastro_Estoque.add(LB_nome_Produto);
		frame_Cadastro_Estoque.add(LB_Quantidade_Produto);
		frame_Cadastro_Estoque.add(LB_Dt_Entrada_Produto);
		frame_Cadastro_Estoque.add(LB_Preco_Compra);
		frame_Cadastro_Estoque.add(LB_Preco_Venda);
		frame_Cadastro_Estoque.add(LB_Estoque_Voltagem);
		frame_Cadastro_Estoque.add(LB_Estoque_Potencia);
		frame_Cadastro_Estoque.add(LB_Estoque_Tipo);
		frame_Cadastro_Estoque.add(LB_Estoque_Comprimento);

		frame_Cadastro_Estoque.add(TF_ID_Produto);
		frame_Cadastro_Estoque.add(TF_nome_Produto);
		frame_Cadastro_Estoque.add(TF_Quantidade_Produto);
		frame_Cadastro_Estoque.add(Formato_Dt_Entrada);
		frame_Cadastro_Estoque.add(TF_Preco_Compra);
		frame_Cadastro_Estoque.add(TF_Preco_Venda);
		frame_Cadastro_Estoque.add(TF_Estoque_Voltagem);
		frame_Cadastro_Estoque.add(TF_Estoque_Potencia);
		frame_Cadastro_Estoque.add(TF_Estoque_Tipo);
		frame_Cadastro_Estoque.add(TF_Estoque_Comprimento);


		selecao.setBounds(268,72,100,25);
		btn_gravar_Mercadoria.setBounds(430,30,100,20);
		btn_listar_Mercadoria.setBounds(430,60, 100,20);
		btn_buscar_Mercadoria.setBounds(430,90,100,20);
		btn_atualizar_Mercadoria.setBounds(430,120,100,20);
		btn_remover_Mercadoria.setBounds(430,150,100,20);

		LB_ID_Produto.setBounds(01,12,70,20);
		LB_nome_Produto.setBounds(73,12,100,20);
		LB_Quantidade_Produto.setBounds(217,5,100,36);
		LB_Dt_Entrada_Produto.setBounds(325,5,120,36);
		LB_Preco_Compra.setBounds(01,46,133,36);
		LB_Preco_Venda.setBounds(157,46,110,36);
		LB_Secao.setBounds(272,46,100,36);

		TF_ID_Produto.setBounds(01,30,70,25);
		TF_nome_Produto.setBounds(73,30,140,25);
		TF_Quantidade_Produto.setBounds(217,30,105,25);
		Formato_Dt_Entrada.setBounds(325,30,100,25);
		TF_Preco_Compra.setBounds(01,72,150,25);
		TF_Preco_Venda.setBounds(157,72,105,25);

		frame_Cadastro_Estoque.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Principal Principal = new Principal();
				Principal.frame_Menu_Principal.show();
			}});


		//responsável por tratar os eventos do JComboBox
		selecao.addItemListener(new ItemListener(){ 
			public void itemStateChanged(ItemEvent event){
				if(event.getStateChange() == ItemEvent.SELECTED){
					valor = (byte) selecao.getSelectedIndex();
					switch(valor){
					case 0:
						LB_Estoque_Voltagem.setVisible(false);
						LB_Estoque_Potencia.setVisible(false);
						LB_Estoque_Tipo.setVisible(false);
						LB_Estoque_Comprimento.setVisible(false);
						LB_Estoque_Voltagem.setBounds(01,88,78,36);
						LB_Estoque_Potencia.setBounds(110,88,115,36);
						LB_Estoque_Tipo.setBounds(235,88,30,36);
						LB_Estoque_Comprimento.setBounds(01,129,100,36);

						TF_Estoque_Voltagem.setVisible(false);
						TF_Estoque_Potencia.setVisible(false);
						TF_Estoque_Tipo.setVisible(false);
						TF_Estoque_Comprimento.setVisible(false);
						TF_Estoque_Voltagem.setBounds(01,114,100,25);
						TF_Estoque_Potencia.setBounds(110,114,115,25);
						TF_Estoque_Tipo.setBounds(235,114,100,25);
						TF_Estoque_Comprimento.setBounds(01,155,100,25);

						break;	
					case 1:
						LB_Estoque_Voltagem.setVisible(true);
						LB_Estoque_Potencia.setVisible(true);
						LB_Estoque_Tipo.setVisible(true);
						LB_Estoque_Comprimento.setVisible(true);
						LB_Estoque_Voltagem.setBounds(01,88,78,36);
						LB_Estoque_Potencia.setBounds(110,88,115,36);
						LB_Estoque_Tipo.setBounds(235,88,30,36);
						LB_Estoque_Comprimento.setBounds(01,129,100,36);

						TF_Estoque_Voltagem.setVisible(true);
						TF_Estoque_Potencia.setVisible(true);
						TF_Estoque_Tipo.setVisible(true);
						TF_Estoque_Comprimento.setVisible(true);
						TF_Estoque_Voltagem.setBounds(01,114,100,25);
						TF_Estoque_Potencia.setBounds(110,114,115,25);
						TF_Estoque_Tipo.setBounds(235,114,100,25);
						TF_Estoque_Comprimento.setBounds(01,155,100,25);
						break;
					case 2:
						LB_Estoque_Voltagem.setVisible(false);
						LB_Estoque_Potencia.setVisible(false);

						LB_Estoque_Tipo.setVisible(true);
						LB_Estoque_Comprimento.setVisible(true);

						LB_Estoque_Tipo.setBounds(01,88,78,36);
						LB_Estoque_Comprimento.setBounds(110,88,115,36);

						TF_Estoque_Voltagem.setVisible(false);
						TF_Estoque_Potencia.setVisible(false);

						TF_Estoque_Tipo.setBounds(01,114,100,25);
						TF_Estoque_Comprimento.setBounds(110,114,115,25);

						TF_Estoque_Tipo.setVisible(true);
						TF_Estoque_Comprimento.setVisible(true);
						break;
					case 3:
						LB_Estoque_Voltagem.setVisible(false);
						LB_Estoque_Potencia.setVisible(false);
						LB_Estoque_Comprimento.setVisible(false);

						LB_Estoque_Tipo.setVisible(true);
						LB_Estoque_Tipo.setBounds(01,88,78,36);
						TF_Estoque_Tipo.setVisible(true);
						TF_Estoque_Tipo.setBounds(01,114,100,25);

						TF_Estoque_Voltagem.setVisible(false);
						TF_Estoque_Potencia.setVisible(false);
						TF_Estoque_Comprimento.setVisible(false);
						break;
					case 4:
						LB_Estoque_Voltagem.setVisible(false);
						LB_Estoque_Potencia.setVisible(false);
						LB_Estoque_Comprimento.setVisible(false);

						LB_Estoque_Tipo.setVisible(true);
						LB_Estoque_Tipo.setBounds(01,88,78,36);
						TF_Estoque_Tipo.setVisible(true);
						TF_Estoque_Tipo.setBounds(01,114,100,25);

						TF_Estoque_Voltagem.setVisible(false);
						TF_Estoque_Potencia.setVisible(false);
						TF_Estoque_Comprimento.setVisible(false);
						break;
					}
				}
			}
		});

		btn_gravar_Mercadoria.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//Obtem o valor(posição) que foi selecionado
				valor = (byte) selecao.getSelectedIndex();
				switch(valor){
				case 0:
					JOptionPane.showMessageDialog(null, "Não é possível salvar"+"\n"+"sem uma seção definida","Aviso!",JOptionPane.WARNING_MESSAGE);
					break;	
				case 1:
					onClickSalvarEletrica();
					break;
				case 2:
					onClickSalvarHidraulica();
					break;
				case 3:
					onClickSalvarMecanica();
					break;
				case 4:	
					onClickSalvarOutros();
					break;	
				}

			}});

		btn_listar_Mercadoria.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onCLickListar();
			}});

		btn_buscar_Mercadoria.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onClickBuscar();
			}});

		btn_atualizar_Mercadoria.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				Form_Atualizar_Estoque Form_Atualizar_Estoque = new Form_Atualizar_Estoque();
				Form_Atualizar_Estoque.frame_Atualizar_Estoque.show();
				frame_Cadastro_Estoque.hide();
			}});

		btn_remover_Mercadoria.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				Form_Remover_Estoque Form_Remover_Estoque = new Form_Remover_Estoque();
				Form_Remover_Estoque.frame_Remover_Estoque.show();
				frame_Cadastro_Estoque.hide();
			}});


		frame_Cadastro_Estoque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Cadastro_Estoque.setSize(548,230);
		frame_Cadastro_Estoque.setLocationRelativeTo(null);
		frame_Cadastro_Estoque.setVisible(true);
		frame_Cadastro_Estoque.setResizable(false);
		frame_Cadastro_Estoque.setIconImage(Mov_Estoque.getImage());

	}

	public void onClickSalvarEletrica(){
		String produto     = TF_nome_Produto.getText().toUpperCase();
		String dataEntrada = Formato_Dt_Entrada.getText();
		String Tipo        = TF_Estoque_Tipo.getText();

		int idEletrica;
		try{
			idEletrica = Integer.parseInt(TF_ID_Produto.getText());
			if(idEletrica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para o estocamento\nValor : "+idEletrica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}

		if (produto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_Quantidade_Produto.getText());
				Secao_Eletrica SE = new Secao_Eletrica(quantidade);
				if (SE.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para o estocamento\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_Quantidade_Produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_Quantidade_Produto.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}
			}

			if (dataEntrada.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Entrada.setBackground(Color.RED);
				return;
			}else {

				float preco_Compra;
				try {
					preco_Compra = Float.parseFloat(TF_Preco_Compra.getText());
					if (preco_Compra <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+preco_Compra,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Compra.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+TF_Preco_Compra.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}

				float preco_Venda;
				try {
					preco_Venda = Float.parseFloat(TF_Preco_Venda.getText());
					if (preco_Venda <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+preco_Venda,
								"Aviso!",JOptionPane.WARNING_MESSAGE); 
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Venda.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}else { 
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+TF_Preco_Venda.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}

				float Voltagem;
				try {
					Voltagem = Float.parseFloat(TF_Estoque_Voltagem.getText());
					if (Voltagem <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nVoltagem : "+Voltagem,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Voltagem.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Estoque_Voltagem.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nVoltagem : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Voltagem.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nVoltagem : "+TF_Estoque_Voltagem.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Voltagem.setBackground(Color.RED);
						return;
					}
				}

				float Potencia;
				try {
					Potencia = Float.parseFloat(TF_Estoque_Potencia.getText());
					if (Potencia <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPotência : "+Potencia,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Potencia.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Estoque_Potencia.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPotência : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Potencia.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPotência : "+TF_Estoque_Potencia.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Estoque_Potencia.setBackground(Color.RED);
						return;
					}
				}

				if (Tipo.equals("")){
					JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Estoque_Tipo.setBackground(Color.RED);
					return;
				}else {

					float Comprimento;
					try {
						Comprimento = Float.parseFloat(TF_Estoque_Comprimento.getText());
						if (Comprimento <= 0){
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+Comprimento,
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}
					}catch(NumberFormatException nfe){
						if (TF_Estoque_Comprimento.getText().equals("")){
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+null,
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}else {
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+TF_Estoque_Comprimento.getText(),
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}
					}

					if (BD.inserirEletrica(idEletrica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Voltagem,Potencia,Tipo,Comprimento).equals("Produto estocado com sucesso!")){
						JOptionPane.showMessageDialog(null,"Produto estocado com sucesso!");
						gravar_arquivo();
						limparCampos();	

						TF_ID_Produto.setBackground(Color.WHITE);
						TF_nome_Produto.setBackground(Color.WHITE);
						Formato_Dt_Entrada.setBackground(Color.WHITE);
						TF_Estoque_Tipo.setBackground(Color.WHITE);
						TF_Quantidade_Produto.setBackground(Color.WHITE);
						TF_Preco_Compra.setBackground(Color.WHITE);
						TF_Preco_Venda.setBackground(Color.WHITE);
						TF_Estoque_Voltagem.setBackground(Color.WHITE);
						TF_Estoque_Potencia.setBackground(Color.WHITE);
						TF_Estoque_Comprimento.setBackground(Color.WHITE);

						return;
					}else if (BD.inserirEletrica(idEletrica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Voltagem,Potencia,Tipo,Comprimento).equals("Impossível estocar produto\n"+"Código existente!")){
						JOptionPane.showMessageDialog(null,"Impossível estocar produto\n"+"Código existente!","Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_ID_Produto.setBackground(Color.RED);	
						return;
					}
				}
			}
		}

	}

	public void onClickSalvarHidraulica(){
		String produto     = TF_nome_Produto.getText().toUpperCase();
		String dataEntrada = Formato_Dt_Entrada.getText();
		String Tipo        = TF_Estoque_Tipo.getText();

		int idHidraulica;
		try{
			idHidraulica = Integer.parseInt(TF_ID_Produto.getText());
			if(idHidraulica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para o estocamento\nValor : "+idHidraulica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}

		if (produto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_Quantidade_Produto.getText());
				Secao_Hidraulica SH = new Secao_Hidraulica(quantidade);
				if (SH.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para o estocamento\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_Quantidade_Produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_Quantidade_Produto.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}
			}

			if (dataEntrada.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Entrada.setBackground(Color.RED);
				return;
			}else {

				float preco_Compra;
				try {
					preco_Compra = Float.parseFloat(TF_Preco_Compra.getText());
					if (preco_Compra <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+preco_Compra,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Compra.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+TF_Preco_Compra.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}

				float preco_Venda;
				try {
					preco_Venda = Float.parseFloat(TF_Preco_Venda.getText());
					if (preco_Venda <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+preco_Venda,
								"Aviso!",JOptionPane.WARNING_MESSAGE); 
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Venda.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}else { 
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+TF_Preco_Venda.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}

				if (Tipo.equals("")){
					JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Estoque_Tipo.setBackground(Color.RED);
					return;
				}else {

					float Comprimento;
					try {
						Comprimento = Float.parseFloat(TF_Estoque_Comprimento.getText());
						if (Comprimento <= 0){
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+Comprimento,
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}
					}catch(NumberFormatException nfe){
						if (TF_Estoque_Comprimento.getText().equals("")){
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+null,
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}else {
							JOptionPane.showMessageDialog(null,"Valor digitado inválido\nComprimento : "+TF_Estoque_Comprimento.getText(),
									"Aviso!",JOptionPane.WARNING_MESSAGE);
							TF_Estoque_Comprimento.setBackground(Color.RED);
							return;
						}
					}

					if (BD.inserirHidraulica(idHidraulica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo,Comprimento).equals("Produto estocado com sucesso!")){
						JOptionPane.showMessageDialog(null,"Produto estocado com sucesso!");
						gravar_arquivo();
						limparCampos();

						TF_ID_Produto.setBackground(Color.WHITE);
						TF_nome_Produto.setBackground(Color.WHITE);
						Formato_Dt_Entrada.setBackground(Color.WHITE);
						TF_Estoque_Tipo.setBackground(Color.WHITE);
						TF_Quantidade_Produto.setBackground(Color.WHITE);
						TF_Preco_Compra.setBackground(Color.WHITE);
						TF_Preco_Venda.setBackground(Color.WHITE);
						TF_Estoque_Comprimento.setBackground(Color.WHITE);

						return;
					}else if (BD.inserirHidraulica(idHidraulica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo,Comprimento).equals("Impossível estocar produto\n"+"Código existente!")){
						JOptionPane.showMessageDialog(null,"Impossível estocar produto\n"+"Código existente!","Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_ID_Produto.setBackground(Color.RED);
						return;
					}
				}
			}
		}
	}

	public void onClickSalvarMecanica(){
		String produto     = TF_nome_Produto.getText().toUpperCase();
		String dataEntrada = Formato_Dt_Entrada.getText();
		String Tipo        = TF_Estoque_Tipo.getText();

		int idMecanica;
		try{
			idMecanica = Integer.parseInt(TF_ID_Produto.getText());
			if(idMecanica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para o estocamento\nValor : "+idMecanica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}

		if (produto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_Quantidade_Produto.getText());
				Secao_Mecanica SM = new Secao_Mecanica(quantidade);
				if (SM.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para o estocamento\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_ID_Produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_Quantidade_Produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_Quantidade_Produto.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}
			}

			if (dataEntrada.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Entrada.setBackground(Color.RED);
				return;
			}else {

				float preco_Compra;
				try {
					preco_Compra = Float.parseFloat(TF_Preco_Compra.getText());
					if (preco_Compra <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+preco_Compra,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Compra.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+TF_Preco_Compra.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}

				float preco_Venda;
				try {
					preco_Venda = Float.parseFloat(TF_Preco_Venda.getText());
					if (preco_Venda <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+preco_Venda,
								"Aviso!",JOptionPane.WARNING_MESSAGE); 
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Venda.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}else { 
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+TF_Preco_Venda.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}

				if (Tipo.equals("")){
					JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Estoque_Tipo.setBackground(Color.RED);
					return;
				}else {

					if (BD.inserirMecanica(idMecanica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo).equals("Produto estocado com sucesso!")){
						JOptionPane.showMessageDialog(null,"Produto estocado com sucesso!");
						gravar_arquivo();
						limparCampos();	

						TF_ID_Produto.setBackground(Color.WHITE);
						TF_nome_Produto.setBackground(Color.WHITE);
						Formato_Dt_Entrada.setBackground(Color.WHITE);
						TF_Estoque_Tipo.setBackground(Color.WHITE);
						TF_Quantidade_Produto.setBackground(Color.WHITE);
						TF_Preco_Compra.setBackground(Color.WHITE);
						TF_Preco_Venda.setBackground(Color.WHITE);

						return;
					}else if(BD.inserirMecanica(idMecanica,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo).equals("Impossível estocar produto\n"+"Código existente!")){
						JOptionPane.showMessageDialog(null,"Impossível estocar produto\n"+"Código existente!","Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_ID_Produto.setBackground(Color.RED);
						return;
					}
				}
			}
		}
	}

	public void onClickSalvarOutros(){
		String produto     = TF_nome_Produto.getText().toUpperCase();
		String dataEntrada = Formato_Dt_Entrada.getText();
		String Tipo        = TF_Estoque_Tipo.getText();

		int idOutros;
		try{
			idOutros = Integer.parseInt(TF_ID_Produto.getText());
			if(idOutros < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para o estocamento\nValor : "+idOutros,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(TF_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido\nValor : "+TF_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_ID_Produto.setBackground(Color.RED);
				return;
			}
		}

		if (produto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Produto.setBackground(Color.RED);
			return;
		}else {

			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_Quantidade_Produto.getText());
				Secao_Outros SO = new Secao_Outros(quantidade);
				if (SO.getQuantidade() <= 0){
					JOptionPane.showMessageDialog(null,"Quantidade inválida para o estocamento\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_Quantidade_Produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
							"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_Quantidade_Produto.getText(),
							"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_Quantidade_Produto.setBackground(Color.RED);
					return;
				}
			}

			if (dataEntrada.equals("   /    /     ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
				Formato_Dt_Entrada.setBackground(Color.RED);
				return;
			}else {

				float preco_Compra;
				try {
					preco_Compra = Float.parseFloat(TF_Preco_Compra.getText());
					if (preco_Compra <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+preco_Compra,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Compra.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}else {
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de compra : "+TF_Preco_Compra.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Compra.setBackground(Color.RED);
						return;
					}
				}

				float preco_Venda;
				try {
					preco_Venda = Float.parseFloat(TF_Preco_Venda.getText());
					if (preco_Venda <= 0){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+preco_Venda,
								"Aviso!",JOptionPane.WARNING_MESSAGE); 
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}catch(NumberFormatException nfe){
					if (TF_Preco_Venda.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+null,
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}else { 
						JOptionPane.showMessageDialog(null,"Valor digitado inválido\nPreço de venda : "+TF_Preco_Venda.getText(),
								"Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_Preco_Venda.setBackground(Color.RED);
						return;
					}
				}

				if (Tipo.equals("")){
					JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_Estoque_Tipo.setBackground(Color.RED);
					return;
				}else {

					if (BD.inserirOutros(idOutros,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo).equals("Produto estocado com sucesso!")){
						JOptionPane.showMessageDialog(null,"Produto estocado com sucesso!");
						gravar_arquivo();
						limparCampos();	

						TF_ID_Produto.setBackground(Color.WHITE);
						TF_nome_Produto.setBackground(Color.WHITE);
						Formato_Dt_Entrada.setBackground(Color.WHITE);
						TF_Estoque_Tipo.setBackground(Color.WHITE);
						TF_Quantidade_Produto.setBackground(Color.WHITE);
						TF_Preco_Compra.setBackground(Color.WHITE);
						TF_Preco_Venda.setBackground(Color.WHITE);

						return;
					}else if(BD.inserirOutros(idOutros,produto,quantidade,dataEntrada,preco_Compra,preco_Venda,Tipo).equals("Impossível estocar produto\n"+"Código existente!")){
						JOptionPane.showMessageDialog(null,"Impossível estocar produto\n"+"Código existente!","Aviso!",JOptionPane.WARNING_MESSAGE);
						TF_ID_Produto.setBackground(Color.RED);
						return;
					}
				}
			}
		}
	}

	public void onCLickListar(){
		Form_List_Estoque Form_List_Estoque = new Form_List_Estoque();
		Form_List_Estoque.Exibir_List_Estoque_Eletrica.setText(BD.ListarSecaoEletrica());
		Form_List_Estoque.Exibir_List_Estoque_Hidraulica.setText(BD.ListarSecaoHidraulica());
		Form_List_Estoque.Exibir_List_Estoque_Mecanica.setText(BD.ListarSecaoMecanica());
		Form_List_Estoque.Exibir_List_Estoque_Outros.setText(BD.ListarSecaoOutros());
		frame_Cadastro_Estoque.hide();
	}

	public void onClickBuscar(){
		Form_Busc_Estoque Form_Busc_Estoque = new Form_Busc_Estoque();
		Form_Busc_Estoque.frame_Busc_Estoque.show();
		frame_Cadastro_Estoque.hide();	
	}

	public void limparCampos(){
		TF_ID_Produto.setText("");
		TF_nome_Produto.setText("");
		TF_Quantidade_Produto.setText("");
		Formato_Dt_Entrada.setText("");
		TF_Preco_Venda.setText("");
		TF_Preco_Compra.setText("");
		TF_Estoque_Voltagem.setText("");
		TF_Estoque_Potencia.setText("");
		TF_Estoque_Tipo.setText("");
		TF_Estoque_Comprimento.setText("");
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
			JOptionPane.showMessageDialog(null,"Arquivo de dados não Carregado");
		}
	}
}