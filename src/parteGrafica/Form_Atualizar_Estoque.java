package parteGrafica;
import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import br.material.construcao.p2.*;


public class Form_Atualizar_Estoque implements Gravacao {
	private static final ImageIcon Atual_Estoque = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Atualizar_M_Estoque_S.png")); 
	protected JFrame frame_Atualizar_Estoque;
	private JTextField TF_ID_Produto,TF_nome_produto,TF_quantidade_produto;
	private JLabel LB_ID_Produto,LB_nome_produto,LB_quantidade_produto,LB_Secao;
	private JButton btn_Atualizar_produto;
	private JComboBox JCB_Secao;
	private String secao[]={"----------","Elétrica","Hidráulica","Mecânica","Outros"};
	private byte valor;

	BancoDeDados BD = new BancoDeDados();

	public Form_Atualizar_Estoque(){
		ler_arquivo();
		
		
		frame_Atualizar_Estoque = new JFrame("Atualizar Estoque");
		frame_Atualizar_Estoque.setLayout(null);
		
		LB_ID_Produto   = new JLabel("Código");
		TF_ID_Produto   = new JTextField();
		LB_nome_produto = new JLabel("Nome do Produto"); 
		TF_nome_produto = new JTextField();
		LB_quantidade_produto = new JLabel("Quant. do Produto");
		TF_quantidade_produto = new JTextField();
		LB_Secao = new JLabel("Seção");
		btn_Atualizar_produto = new JButton("Atualizar");
		JCB_Secao = new JComboBox(secao);

		JCB_Secao.setMaximumRowCount(5);

		frame_Atualizar_Estoque.add(LB_ID_Produto);
		frame_Atualizar_Estoque.add(TF_ID_Produto);
		frame_Atualizar_Estoque.add(LB_nome_produto);
		frame_Atualizar_Estoque.add(TF_nome_produto);
		frame_Atualizar_Estoque.add(LB_quantidade_produto);
		frame_Atualizar_Estoque.add(TF_quantidade_produto);
		frame_Atualizar_Estoque.add(LB_Secao);
		frame_Atualizar_Estoque.add(btn_Atualizar_produto);
		frame_Atualizar_Estoque.add(JCB_Secao);
		
        LB_ID_Produto.setBounds(01,05,50,36);
		LB_nome_produto.setBounds(110,05,130,36);
		LB_quantidade_produto.setBounds(01,45,120,36);

		TF_ID_Produto.setBounds(01,30,100,25);
		TF_nome_produto.setBounds(110,30,125,25);
		TF_quantidade_produto.setBounds(01,70,100,25);

		LB_Secao.setBounds(110,45,130,36);
		JCB_Secao.setBounds(110,70,100,20);

		btn_Atualizar_produto.setBounds(250,50,80,25);


		frame_Atualizar_Estoque.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Mov_Estoque form_mov_Estoque = new Form_Mov_Estoque();
				form_mov_Estoque.frame_Cadastro_Estoque.show();
			}});

		btn_Atualizar_produto.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//Obtem o valor(posição) que foi selecionado
				valor = (byte) JCB_Secao.getSelectedIndex();
				switch(valor){
				case 0:
					JOptionPane.showMessageDialog(null, "Não é possível adicionar quantidade "+
							"\n"+"sem uma seção definida","Aviso!",JOptionPane.WARNING_MESSAGE);
					break;	
				case 1:
					OnClickAtualizarEletrica();
					break;
				case 2:
					OnClickAtualizarHidraulica();
					break;
				case 3:
					OnClickAtualizarMecanica();
					break;
				case 4:
					OnClickAtualizarOutros();
				break;	
				}
			}});




		frame_Atualizar_Estoque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Atualizar_Estoque.setSize(352,150);
		frame_Atualizar_Estoque.setLocationRelativeTo(null);
		frame_Atualizar_Estoque.setVisible(true);
		frame_Atualizar_Estoque.setResizable(false);
		frame_Atualizar_Estoque.setIconImage(Atual_Estoque.getImage());

	}

	public void OnClickAtualizarEletrica(){
		String nomeProduto = TF_nome_produto.getText().toUpperCase();

		int idEletrica;
		try{
			idEletrica = Integer.parseInt(TF_ID_Produto.getText());
			if(idEletrica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idEletrica,"Aviso!",JOptionPane.WARNING_MESSAGE);
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

		if (nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_produto.setBackground(Color.RED);
			return;
		}else {
			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_quantidade_produto.getText());
				Secao_Eletrica SE = new Secao_Eletrica(quantidade);
				if (SE.getQuantidade() < 0){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+quantidade,
                            "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade_produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
		                                          "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}else {
				    JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade_produto.getText(),
						                          "Aviso!",JOptionPane.WARNING_MESSAGE); 
				    TF_quantidade_produto.setBackground(Color.RED);
				    return;
				}
			}
			
			///Produto quant = new Produto(quantidade);
			
			if (BD.aumentarQuantidadeSecaoEletrica(idEletrica,nomeProduto,quantidade).equals("Quantidade adicionada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Quantidade adicionada com sucesso!");
				gravar_arquivo();
				//SalvarDados();
				limparCampos();
				return;
		    } else if ((BD.aumentarQuantidadeSecaoEletrica(idEletrica,nomeProduto,quantidade).equals("Quantidade inválida a ser adicionada\nQuantidade : "+quantidade))){
				JOptionPane.showMessageDialog(null,"Quantidade inválida a ser adicionada\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_quantidade_produto.setBackground(Color.RED);
				return;
		    }else if(BD.aumentarQuantidadeSecaoEletrica(idEletrica,nomeProduto,quantidade).equals("Código ou produto não correspondem!")){
		    	JOptionPane.showMessageDialog(null,"Código ou produto não correspondem!","Aviso!",JOptionPane.WARNING_MESSAGE);
		    	TF_ID_Produto.setBackground(Color.RED);
		    }
		}
		
		TF_ID_Produto.setBackground(Color.WHITE);
		TF_nome_produto.setBackground(Color.WHITE);
		TF_quantidade_produto.setBackground(Color.WHITE);
	}
	
	public void OnClickAtualizarHidraulica(){
		String nomeProduto = TF_nome_produto.getText().toUpperCase();

		int idHidraulica;
		try{
			idHidraulica = Integer.parseInt(TF_ID_Produto.getText());
			if(idHidraulica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idHidraulica,"Aviso!",JOptionPane.WARNING_MESSAGE);
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

		if (nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_produto.setBackground(Color.RED);
			return;
		}else {
			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_quantidade_produto.getText());
				Secao_Hidraulica SH = new Secao_Hidraulica(quantidade);
				if (SH.getQuantidade() < 0){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+quantidade,
                            "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade_produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
		                                          "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}else {
				    JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade_produto.getText(),
						                          "Aviso!",JOptionPane.WARNING_MESSAGE); 
				    TF_quantidade_produto.setBackground(Color.RED);
				    return;
				}
			}
			
			///Produto quant = new Produto(quantidade);
			
			if (BD.aumentarQuantidadeSecaoHidraulica(idHidraulica,nomeProduto,quantidade).equals("Quantidade adicionada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Quantidade adicionada com sucesso!");
				gravar_arquivo();
				//SalvarDados();
				limparCampos();
				return;
		    } else if ((BD.aumentarQuantidadeSecaoHidraulica(idHidraulica,nomeProduto,quantidade).equals("Quantidade inválida a ser adicionada\nQuantidade : "+quantidade))){
				JOptionPane.showMessageDialog(null,"Quantidade inválida a ser adicionada\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_quantidade_produto.setBackground(Color.RED);
				return;
		    }else if(BD.aumentarQuantidadeSecaoHidraulica(idHidraulica,nomeProduto,quantidade).equals("Código ou produto não correspondem!")){
		    	JOptionPane.showMessageDialog(null,"Código ou produto não correspondem!","Aviso!",JOptionPane.WARNING_MESSAGE);
		    	TF_ID_Produto.setBackground(Color.RED);
		    }
		}
		
		TF_ID_Produto.setBackground(Color.WHITE);
		TF_nome_produto.setBackground(Color.WHITE);
		TF_quantidade_produto.setBackground(Color.WHITE);
	}
	
	public void OnClickAtualizarMecanica(){
		String nomeProduto = TF_nome_produto.getText().toUpperCase();

		int idMecanica;
		try{
			idMecanica = Integer.parseInt(TF_ID_Produto.getText());
			if(idMecanica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idMecanica,"Aviso!",JOptionPane.WARNING_MESSAGE);
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

		if (nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_produto.setBackground(Color.RED);
			return;
		}else {
			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_quantidade_produto.getText());
				Secao_Mecanica SM = new Secao_Mecanica(quantidade);
				if (SM.getQuantidade() < 0){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+quantidade,
                            "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade_produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
		                                          "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}else {
				    JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade_produto.getText(),
						                          "Aviso!",JOptionPane.WARNING_MESSAGE); 
				    TF_quantidade_produto.setBackground(Color.RED);
				    return;
				}
			}
			
			///Produto quant = new Produto(quantidade);
			
			if (BD.aumentarQuantidadeSecaoMecanica(idMecanica,nomeProduto,quantidade).equals("Quantidade adicionada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Quantidade adicionada com sucesso!");
				gravar_arquivo();
				//SalvarDados();
				limparCampos();
				return;
		    } else if ((BD.aumentarQuantidadeSecaoMecanica(idMecanica,nomeProduto,quantidade).equals("Quantidade inválida a ser adicionada\nQuantidade : "+quantidade))){
				JOptionPane.showMessageDialog(null,"Quantidade inválida a ser adicionada\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_quantidade_produto.setBackground(Color.RED);
				return;
		    }else if(BD.aumentarQuantidadeSecaoMecanica(idMecanica,nomeProduto,quantidade).equals("Código ou produto não correspondem!")){
		    	JOptionPane.showMessageDialog(null,"Código ou produto não correspondem!","Aviso!",JOptionPane.WARNING_MESSAGE);
		    	TF_ID_Produto.setBackground(Color.RED);
		    }
		}
		
		TF_ID_Produto.setBackground(Color.WHITE);
		TF_nome_produto.setBackground(Color.WHITE);
		TF_quantidade_produto.setBackground(Color.WHITE);
	}


	
	public void OnClickAtualizarOutros(){
		String nomeProduto = TF_nome_produto.getText().toUpperCase();

		int idOutros;
		try{
			idOutros = Integer.parseInt(TF_ID_Produto.getText());
			if(idOutros < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idOutros,"Aviso!",JOptionPane.WARNING_MESSAGE);
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

		if (nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_produto.setBackground(Color.RED);
			return;
		}else {
			int quantidade;
			try {
				quantidade = Integer.parseInt(TF_quantidade_produto.getText());
				Secao_Outros SO = new Secao_Outros(quantidade);
				if (SO.getQuantidade() < 0){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+quantidade,
                            "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_quantidade_produto.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+null,
		                                          "Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_quantidade_produto.setBackground(Color.RED);
					return;
				}else {
				    JOptionPane.showMessageDialog(null,"Valor digitado inválido\nQuantidade do produto : "+TF_quantidade_produto.getText(),
						                          "Aviso!",JOptionPane.WARNING_MESSAGE); 
				    TF_quantidade_produto.setBackground(Color.RED);
				    return;
				}
			}
			
			///Produto quant = new Produto(quantidade);
			
			if (BD.aumentarQuantidadeSecaoMecanica(idOutros,nomeProduto,quantidade).equals("Quantidade adicionada com sucesso!")){
				JOptionPane.showMessageDialog(null,"Quantidade adicionada com sucesso!");
				gravar_arquivo();
				//SalvarDados();
				limparCampos();
				return;
		    } else if ((BD.aumentarQuantidadeSecaoMecanica(idOutros,nomeProduto,quantidade).equals("Quantidade inválida a ser adicionada\nQuantidade : "+quantidade))){
				JOptionPane.showMessageDialog(null,"Quantidade inválida a ser adicionada\nQuantidade : "+quantidade,"Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_quantidade_produto.setBackground(Color.RED);
				return;
		    }else if(BD.aumentarQuantidadeSecaoMecanica(idOutros,nomeProduto,quantidade).equals("Código ou produto não correspondem!")){
		    	JOptionPane.showMessageDialog(null,"Código ou produto não correspondem!","Aviso!",JOptionPane.WARNING_MESSAGE);
		    	TF_ID_Produto.setBackground(Color.RED);
		    }
		}
		
		TF_ID_Produto.setBackground(Color.WHITE);
		TF_nome_produto.setBackground(Color.WHITE);
		TF_quantidade_produto.setBackground(Color.WHITE);
	}
	


	///////////////////////////////////////////////////////////////////////////////

	public void limparCampos(){
		TF_ID_Produto.setText("");
		TF_nome_produto.setText("");
		TF_quantidade_produto.setText("");
	}
	
	public void gravar_arquivo(){
		try{
			FileOutputStream f = new FileOutputStream("c:/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
			JOptionPane.showMessageDialog(null,"Informações gravadas com sucesso !");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo de dados nao Encontrado");
		}

	}
	
	public void ler_arquivo(){
		try{
			FileInputStream f = new FileInputStream("c:\\Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectInputStream o = new ObjectInputStream(f);
			BD = (BancoDeDados) o.readObject();
			o.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo de dados nao Encontrado");
		}
	}



}