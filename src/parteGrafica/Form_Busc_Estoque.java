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
import java.io.Serializable;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;


import br.material.construcao.p2.*;


public class Form_Busc_Estoque{
	
	private ImageIcon Pesq_Estoque = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Pesquisar_M_Estoque.png"));
	protected JFrame frame_Busc_Estoque;
	private JButton btn_Buscar_Produto;
	private JTextArea jta_Exibir_Res_Estoque;
	private JComboBox jcb_Sec;
	private JTextField tf_ID_Produto,tf_Pesquisa;
	private JLabel lb_Resultado_Pesq,lb_ID_Produto,lb_Pesq_Produto,lb_Secoes;
	private String secao[] = {"----------","Elétrica","Hidráulica","Mecânica","Outros"};
	protected byte valor; 

	BancoDeDados BD = new BancoDeDados();
	Form_Mov_Estoque Form_Mov_Estoque;

	
	
	
	public Form_Busc_Estoque(){
		ler_arquivo();
		frame_Busc_Estoque = new JFrame("Pesquisa de Produtos");
		frame_Busc_Estoque.setLayout(null);
		
		btn_Buscar_Produto     = new JButton();
		jta_Exibir_Res_Estoque = new JTextArea(270,185);
		lb_Resultado_Pesq      = new JLabel("Resultado Da Pesquisa");
		lb_ID_Produto          = new JLabel("Código");
		lb_Pesq_Produto        = new JLabel("Pesquisar Produto");
		lb_Secoes              = new JLabel("Sessões");
		jcb_Sec                = new JComboBox(secao);
		tf_ID_Produto          = new JTextField();
		tf_Pesquisa            = new JTextField();
		jcb_Sec.setMaximumRowCount(5);

		btn_Buscar_Produto.setText("Pesquisar");

		frame_Busc_Estoque.add(btn_Buscar_Produto);
		frame_Busc_Estoque.add(jta_Exibir_Res_Estoque);
		frame_Busc_Estoque.add(lb_ID_Produto);
		frame_Busc_Estoque.add(tf_ID_Produto);
		frame_Busc_Estoque.add(lb_Resultado_Pesq);
		frame_Busc_Estoque.add(lb_Pesq_Produto);
		frame_Busc_Estoque.add(lb_Secoes);
		frame_Busc_Estoque.add(jcb_Sec);
		frame_Busc_Estoque.add(tf_Pesquisa);


		btn_Buscar_Produto.setBounds(200,209,100,20);
		jta_Exibir_Res_Estoque.setBounds(115,20,270,185);
		lb_Resultado_Pesq.setBounds(115,01,150,20);
		lb_ID_Produto.setBounds(01,60,40,20);
		lb_Pesq_Produto.setBounds(01,100,110,20);
		lb_Secoes.setBounds(390,100,100,20);
		jcb_Sec.setBounds(390,120,100,24);
		tf_ID_Produto.setBounds(01,80,60,24);
		tf_Pesquisa.setBounds(01,120,109,24);


		//jta_Exibir_Res_Estoque.setForeground(Color.DARK_GRAY);
		jta_Exibir_Res_Estoque.setFont(new Font(null,Font.BOLD,11));

		//jta_Exibir_Res_Estoque.setBackground(Color.LIGHT_GRAY);

		jta_Exibir_Res_Estoque.setEditable(false);

		frame_Busc_Estoque.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Mov_Estoque = new Form_Mov_Estoque();
				Form_Mov_Estoque.frame_Cadastro_Estoque.show();
			}});

		btn_Buscar_Produto.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//Obtem o valor(posição) que foi selecionado
				valor = (byte) jcb_Sec.getSelectedIndex();
				switch(valor){
				case 0:
					JOptionPane.showMessageDialog(null, "Não é possível pesquisar"+"\n"+"sem uma seção definida","Aviso!",JOptionPane.WARNING_MESSAGE);
					break;	
				case 1:	
					onClickBuscarEletrica();
					limparCampos();
					break;
				case 2:
					onClickBuscarHidraulica();
					limparCampos();
					break;
				case 3:
					onClickBuscarMecanica();
					limparCampos();
					break;
				case 4:
					onClickBuscarOutros();
					limparCampos();
					break;	
				}
			}});		

		frame_Busc_Estoque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Busc_Estoque.setSize(500,260);
		frame_Busc_Estoque.setLocationRelativeTo(null);
		frame_Busc_Estoque.setVisible(true);
		frame_Busc_Estoque.setResizable(false);
		frame_Busc_Estoque.setIconImage(Pesq_Estoque.getImage());	
	}

	public void onClickBuscarEletrica(){
		String nomeProduto = tf_Pesquisa.getText();

		int idEletrica;
		try{
			idEletrica = Integer.parseInt(tf_ID_Produto.getText());
			if(idEletrica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+idEletrica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(tf_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
			    tf_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+tf_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}
		
		if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "O campo está em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			tf_Pesquisa.setBackground(Color.RED);
			jta_Exibir_Res_Estoque.setText("");
			return;
		}else 
			jta_Exibir_Res_Estoque.setText(BD.pesquisarSecaoEletrica(idEletrica,nomeProduto.toUpperCase()));
		
		
		tf_ID_Produto.setBackground(Color.WHITE);
		tf_Pesquisa.setBackground(Color.WHITE);
	}

	public void onClickBuscarHidraulica(){
		String nomeProduto = tf_Pesquisa.getText();

		int idHidraulica;
		try{
			idHidraulica = Integer.parseInt(tf_ID_Produto.getText());
			if(idHidraulica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+idHidraulica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(tf_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
			    tf_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+tf_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}
		
		if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "O campo está em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			tf_Pesquisa.setBackground(Color.RED);
			jta_Exibir_Res_Estoque.setText("");
			return;
		}else 
			jta_Exibir_Res_Estoque.setText(BD.pesquisarSecaoHidraulica(idHidraulica,nomeProduto.toUpperCase()));
		
		
		tf_ID_Produto.setBackground(Color.WHITE);
		tf_Pesquisa.setBackground(Color.WHITE);
	}

	public void onClickBuscarMecanica(){
		String nomeProduto = tf_Pesquisa.getText();

		int idMecanica;
		try{
			idMecanica = Integer.parseInt(tf_ID_Produto.getText());
			if(idMecanica < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+idMecanica,"Aviso!",JOptionPane.WARNING_MESSAGE);
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(tf_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
			    tf_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+tf_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}
		
		if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "O campo está em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			tf_Pesquisa.setBackground(Color.RED);
			jta_Exibir_Res_Estoque.setText("");
			return;
		}else 
			jta_Exibir_Res_Estoque.setText(BD.pesquisarSecaoMecanica(idMecanica,nomeProduto.toUpperCase()));
		
		
		tf_ID_Produto.setBackground(Color.WHITE);
		tf_Pesquisa.setBackground(Color.WHITE);
	}

	public void onClickBuscarOutros(){
		String nomeProduto = tf_Pesquisa.getText();

		int idOutros;
		try{
			idOutros = Integer.parseInt(tf_ID_Produto.getText());
			if(idOutros < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+idOutros,"Aviso!",JOptionPane.WARNING_MESSAGE);
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}catch(NumberFormatException nfe){
			if(tf_ID_Produto.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+null,
						"Aviso!",JOptionPane.WARNING_MESSAGE);
			    tf_ID_Produto.setBackground(Color.RED);
				return;
			}else {
				JOptionPane.showMessageDialog(null,"Valor de código inválido para pesquisa\nValor : "+tf_ID_Produto.getText(),
						"Aviso!",JOptionPane.WARNING_MESSAGE); 
				tf_ID_Produto.setBackground(Color.RED);
				return;
			}
		}
		
		if(nomeProduto.equals("")){
			JOptionPane.showMessageDialog(null, "O campo está em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			tf_Pesquisa.setBackground(Color.RED);
			jta_Exibir_Res_Estoque.setText("");
			return;
		}else 
			jta_Exibir_Res_Estoque.setText(BD.pesquisarSecaoOutros(idOutros,nomeProduto.toUpperCase()));
		
		
		tf_ID_Produto.setBackground(Color.WHITE);
		tf_Pesquisa.setBackground(Color.WHITE);
	}

	public void limparCampos(){
		tf_ID_Produto.setText("");
		tf_Pesquisa.setText("");
	}
	public void gravar_arquivo(){
		try{
			FileOutputStream f = new FileOutputStream("c:/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
			JOptionPane.showMessageDialog(null,"Informações gravadas com sucesso!");
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