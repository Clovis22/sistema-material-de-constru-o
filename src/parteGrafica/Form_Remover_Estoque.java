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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.material.construcao.p2.*;


public class Form_Remover_Estoque {

	private ImageIcon Remov_Estoque = new ImageIcon(ClassLoader.getSystemResource("Aparencia/removerEstoque.png"));
	public  JFrame frame_Remover_Estoque;
	private JLabel LB_ID_Produto,LB_nome_produto,LB_Secao;
	private JTextField TF_ID_Produto,TF_nome_produto;
	private JButton btn_Remover_produto;
	private JComboBox JCB_Secao;
	private String secao[]={"----------","Elétrica","Hidráulica","Mecânica","Outros"};
	private byte valor;

	BancoDeDados BD = new BancoDeDados();

	public Form_Remover_Estoque(){
        ler_arquivo();
        
		frame_Remover_Estoque = new JFrame("Remover Estoque");
		frame_Remover_Estoque.setLayout(null);
		
		LB_ID_Produto   = new JLabel("Código");
		TF_ID_Produto   = new JTextField();
		LB_nome_produto = new JLabel("Nome do Produto");
		TF_nome_produto = new JTextField();
		LB_Secao = new JLabel("Seção");
		btn_Remover_produto = new JButton("Remover");
		JCB_Secao = new JComboBox(secao);

		JCB_Secao.setMaximumRowCount(5);

		frame_Remover_Estoque.add(LB_ID_Produto);
		frame_Remover_Estoque.add(TF_ID_Produto);
		frame_Remover_Estoque.add(LB_nome_produto);
		frame_Remover_Estoque.add(TF_nome_produto);
		frame_Remover_Estoque.add(LB_Secao);
		frame_Remover_Estoque.add(JCB_Secao);
		frame_Remover_Estoque.add(btn_Remover_produto);


		LB_ID_Produto.setBounds(01,05,70,36);
		TF_ID_Produto.setBounds(01,30,70,20);
		LB_nome_produto.setBounds(100,05,100,36);
		TF_nome_produto.setBounds(100,30,120,20);

		LB_Secao.setBounds(245,13,100,20);
		JCB_Secao.setBounds(245,30,100,20);

		btn_Remover_produto.setBounds(133,90,80,25);

		frame_Remover_Estoque.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Mov_Estoque form_mov_Estoque = new Form_Mov_Estoque();
				form_mov_Estoque.frame_Cadastro_Estoque.show();
			}});

		btn_Remover_produto.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//Obtem o valor(posição) que foi selecionado
				valor = (byte) JCB_Secao.getSelectedIndex();
				switch(valor){
				case 0:
					JOptionPane.showMessageDialog(null, "Não é possível remover "+
							"\n"+"sem uma seção definida","Aviso!",JOptionPane.WARNING_MESSAGE);
					break;	
				case 1:
					OnClickRemoverEletrica();
					break;
				case 2:
					OnClickRemoverHidraulica();
					break;
				case 3:
					OnClickRemoverMecanica();
					break;
				case 4:
					OnClickRemoverOutros();
					break;	
				}
			}});

		frame_Remover_Estoque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Remover_Estoque.setSize(352,150);
		frame_Remover_Estoque.setLocationRelativeTo(null);
		frame_Remover_Estoque.setVisible(true);
		frame_Remover_Estoque.setResizable(false);
		frame_Remover_Estoque.setIconImage(Remov_Estoque.getImage());

	}

	public void OnClickRemoverEletrica(){
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
		}

		if (BD.removerSecaoEletrica(idEletrica,nomeProduto).equals("Registro removido com sucesso!")){
			JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");
			gravar_arquivo();
			TF_ID_Produto.setBackground(Color.WHITE);
			TF_nome_produto.setBackground(Color.WHITE);
			limparCampos();
			return;
		}else {
			JOptionPane.showMessageDialog(null,BD.removerSecaoEletrica(idEletrica,nomeProduto),"Aviso!",JOptionPane.WARNING_MESSAGE);
			limparCampos();
			return;
		}
	}
    
	public void OnClickRemoverHidraulica(){
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
		}

		if (BD.removerSecaoHidraulica(idHidraulica,nomeProduto).equals("Registro removido com sucesso!")){
			JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");
		    gravar_arquivo();
			TF_ID_Produto.setBackground(Color.WHITE);
			TF_nome_produto.setBackground(Color.WHITE);
			limparCampos();
			return;
		}else {
			JOptionPane.showMessageDialog(null,BD.removerSecaoHidraulica(idHidraulica,nomeProduto),"Aviso!",JOptionPane.WARNING_MESSAGE);
			limparCampos();
			return;
		}

	}
	
	public void OnClickRemoverMecanica(){
		
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
		}
		
		if (BD.removerSecaoMecanica(idMecanica,nomeProduto).equals("Registro removido com sucesso!")){
			JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");
			gravar_arquivo();
			TF_ID_Produto.setBackground(Color.WHITE);
			TF_nome_produto.setBackground(Color.WHITE);
			limparCampos();
			return;
		}else {
			JOptionPane.showMessageDialog(null,BD.removerSecaoMecanica(idMecanica,nomeProduto),"Aviso!",JOptionPane.WARNING_MESSAGE);
			limparCampos();
			return;
		}
	}

	public void OnClickRemoverOutros(){
		
		String nomeProduto = TF_nome_produto.getText().toUpperCase();
		
		int idOutro;
		try{
			idOutro = Integer.parseInt(TF_ID_Produto.getText());
			if(idOutro < 0){
				JOptionPane.showMessageDialog(null,"Valor de código inválido para remoção\nValor : "+idOutro,"Aviso!",JOptionPane.WARNING_MESSAGE);
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
		}
		
		if (BD.removerSecaoOutros(idOutro,nomeProduto).equals("Registro removido com sucesso!")){
			JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");
			gravar_arquivo();
			TF_ID_Produto.setBackground(Color.WHITE);
			TF_nome_produto.setBackground(Color.WHITE);
			limparCampos();
			return;
		}else {
			JOptionPane.showMessageDialog(null,BD.removerSecaoOutros(idOutro,nomeProduto),"Aviso!",JOptionPane.WARNING_MESSAGE);
			limparCampos();
			return;
		}
		
	}

	
	public void limparCampos(){
		TF_ID_Produto.setText("");
		TF_nome_produto.setText("");
	}
	
	public void gravar_arquivo(){
		try{
			FileOutputStream f = new FileOutputStream("c:/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
			}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo nao Encontrado");
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