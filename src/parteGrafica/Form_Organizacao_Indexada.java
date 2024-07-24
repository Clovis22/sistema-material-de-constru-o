package parteGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.text.MaskFormatter;
import javax.swing.*;

import br.material.construcao.p2.*;

public class Form_Organizacao_Indexada implements Gravacao{
   
	BancoDeDados BD = new BancoDeDados();


	protected  JFrame frame_org_indexada;
	private JButton btn_gravar_cliente;
	private JButton btn_listar_cliente;
	private JButton btn_buscar_cliente;
	private JButton btn_alterar_cliente;
	private JButton btn_remover_cliente;

	private ImageIcon Cad_Cliente = new ImageIcon(ClassLoader.getSystemResource("Aparencia/OrdenacaoInd.png"));

	private JLabel LB_nome_Cliente,
	LB_nome_Antigo,
	LB_CPF_Cliente,
	LB_CPF_Antigo,
	LB_RG_Cliente,
	LB_DT_Nasc_Cliente,
	LB_Telefone_Cliente,
	LB_Celular_Cliente,
	LB_Email_Cliente,
	LB_Endereco_Cliente,
	LB_N_Casa_Cliente,
	LB_Bairro_Cliente,
	LB_Cidade_Cliente,
	LB_CEP_Cliente,
	LB_Estado_Cliente;

	protected JTextField TF_nome_Cliente;
	private JTextField TF_nome_Antigo,
	TF_Email_Cliente,
	TF_Endereco_Cliente,
	TF_Bairro_Cliente,
	TF_Cidade_Cliente,
	TF_N_Casa_Cliente,
	TF_Estado_Cliente;

	private MaskFormatter MF_Telefone_Cliente;
	private JFormattedTextField formato_Telefone;

	private MaskFormatter MF_Celular_Cliente;
	private JFormattedTextField formato_Celular;

	private MaskFormatter MF_CPF_Cliente;
	protected JFormattedTextField formato_CPF; 

	private MaskFormatter MF_CPF_Antigo_Cliente;
	private JFormattedTextField formato_CPF_Antigo; 

	private MaskFormatter MF_RG_Cliente;
	private JFormattedTextField formato_RG;    

	private MaskFormatter MF_DT_Nasc_Cliente;
	private JFormattedTextField formato_DATA;

	private MaskFormatter MF_CEP_Cliente;
	private JFormattedTextField formato_CEP;

	private JCheckBox JCB_HAB_Alterar;
	private JCheckBox JCB_HAB_Busca;
	private JCheckBox JCB_HAB_Remover;

	public Form_Organizacao_Indexada() {
         ler_arquivo();
		
		frame_org_indexada = new JFrame("Ordenação Sequencial Indexada");
		frame_org_indexada.setLayout(null);

		btn_gravar_cliente  = new JButton("Cadastrar");
		btn_listar_cliente  = new JButton("Listar");
		btn_buscar_cliente  = new JButton("Pesquisar");
		btn_alterar_cliente = new JButton("Alterar");
		btn_remover_cliente = new JButton("Remover");

		btn_buscar_cliente.setVisible(false);
		btn_alterar_cliente.setVisible(false);

		LB_nome_Cliente = new JLabel();
		LB_nome_Antigo  = new JLabel("Nome Cadastrado");
		LB_nome_Antigo.setEnabled(false);

		LB_CPF_Cliente      = new JLabel();
		LB_CPF_Antigo       = new JLabel();
		LB_CPF_Antigo.setEnabled(false);

		LB_RG_Cliente       = new JLabel();
		LB_DT_Nasc_Cliente  = new JLabel();
		LB_Telefone_Cliente = new JLabel();
		LB_Celular_Cliente  = new JLabel();
		LB_Email_Cliente    = new JLabel();
		LB_Endereco_Cliente = new JLabel();
		LB_N_Casa_Cliente   = new JLabel();
		LB_Bairro_Cliente   = new JLabel();
		LB_Cidade_Cliente   = new JLabel();
		LB_CEP_Cliente      = new JLabel();
		LB_Estado_Cliente   = new JLabel();

		TF_nome_Cliente = new JTextField();
		TF_nome_Antigo  = new JTextField();
		TF_nome_Antigo.setEnabled(false);

		try {
			MF_CPF_Cliente        = new MaskFormatter("#->###|###|##");
			MF_CPF_Antigo_Cliente = new MaskFormatter("###.###.###-##");
			MF_RG_Cliente         = new MaskFormatter("#######-#");
			MF_DT_Nasc_Cliente    = new MaskFormatter("## / ## / ####");

			MF_Telefone_Cliente   = new MaskFormatter("(##) #### - ####");
			MF_Celular_Cliente    = new MaskFormatter("(##) #### - ####");
			MF_CEP_Cliente        = new MaskFormatter("##### - ###");
		} catch (ParseException e1) {}

		formato_CPF        = new JFormattedTextField(MF_CPF_Cliente);
		formato_CPF_Antigo = new JFormattedTextField(MF_CPF_Antigo_Cliente);
		formato_CPF_Antigo.setEnabled(false);

		formato_RG         = new JFormattedTextField(MF_RG_Cliente);
		formato_DATA       = new JFormattedTextField(MF_DT_Nasc_Cliente);
		formato_Telefone   = new JFormattedTextField(MF_Telefone_Cliente);
		formato_Celular    = new JFormattedTextField(MF_Celular_Cliente);

		TF_Email_Cliente    = new JTextField();
		TF_Endereco_Cliente = new JTextField();
		TF_N_Casa_Cliente   = new JTextField();

		TF_Bairro_Cliente = new JTextField();
		TF_Cidade_Cliente = new JTextField();
		formato_CEP       = new JFormattedTextField(MF_CEP_Cliente); 
		TF_Estado_Cliente = new JTextField();
		JCB_HAB_Alterar   = new JCheckBox("Habilitar Alteração");
		JCB_HAB_Busca     = new JCheckBox("Habilitar Busca");
		JCB_HAB_Remover   = new JCheckBox("Habilitar Remoção");

		LB_nome_Cliente.setText("Nome");
		LB_CPF_Cliente.setText("CPF");
		LB_CPF_Antigo.setText("CPF Cadastrado");
		LB_RG_Cliente.setText("RG");
		LB_DT_Nasc_Cliente.setText("D.Nascimento");
		LB_Telefone_Cliente.setText("Telefone");
		LB_Celular_Cliente.setText("Celular");
		LB_Email_Cliente.setText("Email");
		LB_Endereco_Cliente.setText("Endereco");
		LB_N_Casa_Cliente.setText("Nº Casa");
		LB_Bairro_Cliente.setText("Bairro");
		LB_Cidade_Cliente.setText("Cidade");
		LB_CEP_Cliente.setText("CEP");
		LB_Estado_Cliente.setText("Estado");
		JPanel painelFundo = new JPanel();
		
		String [] colunas = {"Nome", "Telefone", "Email"};
		Object [][] dados = {
				{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
				{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
			};
		JTable tabela = new JTable(dados, colunas); 
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);
		frame_org_indexada.add(painelFundo);
		

//		frame_Cadastro_Cliente.add(btn_gravar_cliente);
//		frame_Cadastro_Cliente.add(btn_buscar_cliente);
//		frame_Cadastro_Cliente.add(btn_alterar_cliente);
//		frame_Cadastro_Cliente.add(btn_remover_cliente);
//		frame_Cadastro_Cliente.add(btn_listar_cliente);
//		frame_Cadastro_Cliente.add(LB_nome_Cliente);
//		frame_Cadastro_Cliente.add(LB_nome_Antigo);
//		frame_Cadastro_Cliente.add(LB_CPF_Cliente);
//		frame_Cadastro_Cliente.add(LB_CPF_Antigo);
//		frame_Cadastro_Cliente.add(LB_RG_Cliente);
//		frame_Cadastro_Cliente.add(LB_DT_Nasc_Cliente);
//		frame_Cadastro_Cliente.add(LB_Telefone_Cliente);
//		frame_Cadastro_Cliente.add(LB_Celular_Cliente);
//		frame_Cadastro_Cliente.add(LB_Email_Cliente);
//		frame_Cadastro_Cliente.add(LB_Endereco_Cliente);
//		frame_Cadastro_Cliente.add(LB_N_Casa_Cliente);
//		frame_Cadastro_Cliente.add(LB_Bairro_Cliente);
//		frame_Cadastro_Cliente.add(LB_Cidade_Cliente);
//		frame_Cadastro_Cliente.add(LB_CEP_Cliente);
//		frame_Cadastro_Cliente.add(LB_Estado_Cliente);
//
//		frame_Cadastro_Cliente.add(TF_nome_Cliente);
//		frame_Cadastro_Cliente.add(TF_nome_Antigo);
//		frame_Cadastro_Cliente.add(formato_CPF);
//		frame_Cadastro_Cliente.add(formato_CPF_Antigo);
//		frame_Cadastro_Cliente.add(formato_RG);
//		frame_Cadastro_Cliente.add(formato_DATA);
//		frame_Cadastro_Cliente.add(formato_Telefone);
//		frame_Cadastro_Cliente.add(formato_Celular);
//		frame_Cadastro_Cliente.add(TF_Email_Cliente);
//		frame_Cadastro_Cliente.add(TF_Endereco_Cliente);
//		frame_Cadastro_Cliente.add(TF_N_Casa_Cliente);
//		frame_Cadastro_Cliente.add(TF_Bairro_Cliente);
//		frame_Cadastro_Cliente.add(TF_Cidade_Cliente);
//		frame_Cadastro_Cliente.add(formato_CEP);
//		frame_Cadastro_Cliente.add(TF_Estado_Cliente);
//		frame_Cadastro_Cliente.add(JCB_HAB_Alterar);
//		frame_Cadastro_Cliente.add(JCB_HAB_Busca);
//		frame_Cadastro_Cliente.add(JCB_HAB_Remover);

		btn_gravar_cliente.setBounds(390,30,100,20);
		btn_listar_cliente.setBounds(390,60, 100,20);
		LB_nome_Cliente.setBounds(01,10,50,24);
		LB_nome_Antigo.setBounds(01, 218, 130, 20);
		LB_CPF_Cliente.setBounds(159,5,33,36);
		LB_CPF_Antigo.setBounds(160, 218, 130, 20);
		LB_RG_Cliente.setBounds(265,5,33,36);
		LB_DT_Nasc_Cliente.setBounds(01,46,80,36);
		LB_Telefone_Cliente.setBounds(106,46,80,36);
		LB_Celular_Cliente.setBounds(220,55,40,20);
		LB_Email_Cliente.setBounds(01,88,220,36);
		LB_Endereco_Cliente.setBounds(220,88,220,36);
		LB_N_Casa_Cliente.setBounds(01,130,220,36);
		LB_Bairro_Cliente.setBounds(60,130,220,36);
		LB_Cidade_Cliente.setBounds(01,171,220,36);
		LB_CEP_Cliente.setBounds(220,132, 32, 32);
		LB_Estado_Cliente.setBounds(220,171,220,36);
		JCB_HAB_Alterar.setBounds(390, 180, 125, 20);
		JCB_HAB_Busca.setBounds(390, 205, 125, 20);
		JCB_HAB_Remover.setBounds(390, 230, 130, 20);

		TF_nome_Cliente.setBounds(01,30,150,25);
		TF_nome_Antigo.setBounds(01, 235, 150, 25);
		formato_CPF.setBounds(159,30,102,25);
		formato_CPF_Antigo.setBounds(160, 235, 102,25);
		formato_RG.setBounds(265,30,90,25);
		formato_DATA.setBounds(01,70,100,25);
		formato_Telefone.setBounds(106,70,107,25);
		formato_Celular.setBounds(220,70,109,25);
		TF_Email_Cliente.setBounds(01,113,204,25);
		TF_Endereco_Cliente.setBounds(220,113,110,25);
		TF_N_Casa_Cliente.setBounds(01,155,48,25);
		TF_Bairro_Cliente.setBounds(60,155,145,25);
		TF_Cidade_Cliente.setBounds(01,195,204,25);
		formato_CEP.setBounds(220,155,110, 25);
		TF_Estado_Cliente.setBounds(220,195,110,25);

		frame_org_indexada.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Principal Principal = new Principal();
				Principal.frame_Menu_Principal.show();
				SwingUtilities.updateComponentTreeUI(Principal.frame_Menu_Principal);
			}});

		btn_gravar_cliente.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onClickSalvar();
			}});

		btn_listar_cliente.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				if (me.getSource() == btn_listar_cliente){
					onClickListar();
				}
			}});

		btn_buscar_cliente.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onClickBuscar();
			}});

		btn_alterar_cliente.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onClickAlterar();
			}});

		btn_remover_cliente.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				onClickRemover();
			}});

		JCB_HAB_Alterar.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){

				if(JCB_HAB_Alterar.isSelected() == true){

					LB_nome_Antigo.setEnabled(true);
					LB_CPF_Antigo.setEnabled(true);
					TF_nome_Antigo.setEnabled(true);
					formato_CPF_Antigo.setEnabled(true);

					btn_listar_cliente.setVisible(true);
					btn_alterar_cliente.setVisible(true);

					btn_listar_cliente.setBounds(390,30,100,20);
					btn_alterar_cliente.setBounds(390,60, 100,20);

					btn_gravar_cliente.setVisible(false);
					btn_buscar_cliente.setVisible(false);
					btn_remover_cliente.setVisible(false);


				}else{	

					btn_gravar_cliente.setVisible(true);
					btn_listar_cliente.setVisible(true);
					btn_buscar_cliente.setVisible(false);
					btn_alterar_cliente.setVisible(false);
					//btn_remover_cliente.setVisible(true);

					btn_gravar_cliente.setBounds(390,30,100,20);
					btn_listar_cliente.setBounds(390,60, 100,20);
					// btn_remover_cliente.setBounds(390,90,100,20);

					LB_nome_Antigo.setEnabled(false);
					LB_CPF_Antigo.setEnabled(false);
					TF_nome_Antigo.setEnabled(false);
					formato_CPF_Antigo.setEnabled(false);
				}

			}});



		JCB_HAB_Busca.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){

				if(JCB_HAB_Busca.isSelected() == true){
					//JCB_HAB_Alterar.doClick();
					LB_nome_Antigo.setEnabled(true);
					LB_CPF_Antigo.setEnabled(true);
					TF_nome_Antigo.setEnabled(true);
					formato_CPF_Antigo.setEnabled(true);

					btn_listar_cliente.setVisible(true);
					btn_buscar_cliente.setVisible(true);


					btn_listar_cliente.setBounds(390,30,100,20);
					btn_buscar_cliente.setBounds(390,60, 100,20);

					btn_gravar_cliente.setVisible(false);
					btn_alterar_cliente.setVisible(false);
					btn_remover_cliente.setVisible(false);

					LB_nome_Cliente.setEnabled(false);
					LB_CPF_Cliente.setEnabled(false);
					LB_RG_Cliente.setEnabled(false);
					LB_DT_Nasc_Cliente.setEnabled(false);
					LB_Telefone_Cliente.setEnabled(false);
					LB_Celular_Cliente.setEnabled(false);
					LB_Email_Cliente.setEnabled(false);
					LB_Endereco_Cliente.setEnabled(false);
					LB_N_Casa_Cliente.setEnabled(false);
					LB_Bairro_Cliente.setEnabled(false);
					LB_Cidade_Cliente.setEnabled(false);
					LB_CEP_Cliente.setEnabled(false);
					LB_Estado_Cliente.setEnabled(false);

					TF_nome_Cliente.setEnabled(false);
					formato_CPF.setEnabled(false);
					formato_RG.setEnabled(false);
					formato_DATA.setEnabled(false);
					formato_Telefone.setEnabled(false);
					formato_Celular.setEnabled(false);
					TF_Email_Cliente.setEnabled(false);
					TF_Endereco_Cliente.setEnabled(false);
					TF_N_Casa_Cliente.setEnabled(false);
					TF_Bairro_Cliente.setEnabled(false);
					TF_Cidade_Cliente.setEnabled(false);
					formato_CEP.setEnabled(false);
					TF_Estado_Cliente.setEnabled(false);
				}else{	 

					btn_gravar_cliente.setVisible(true);
					btn_listar_cliente.setVisible(true);
					btn_buscar_cliente.setVisible(false);
					btn_alterar_cliente.setVisible(false);
					// btn_remover_cliente.setVisible(true);

					btn_gravar_cliente.setBounds(390,30,100,20);
					btn_listar_cliente.setBounds(390,60, 100,20);
					// btn_remover_cliente.setBounds(390,90,100,20);

					LB_nome_Antigo.setEnabled(false);
					LB_CPF_Antigo.setEnabled(false);
					TF_nome_Antigo.setEnabled(false);
					formato_CPF_Antigo.setEnabled(false);

					LB_nome_Cliente.setEnabled(true);
					LB_CPF_Cliente.setEnabled(true);
					LB_RG_Cliente.setEnabled(true);
					LB_DT_Nasc_Cliente.setEnabled(true);
					LB_Telefone_Cliente.setEnabled(true);
					LB_Celular_Cliente.setEnabled(true);
					LB_Email_Cliente.setEnabled(true);
					LB_Endereco_Cliente.setEnabled(true);
					LB_N_Casa_Cliente.setEnabled(true);
					LB_Bairro_Cliente.setEnabled(true);
					LB_Cidade_Cliente.setEnabled(true);
					LB_CEP_Cliente.setEnabled(true);
					LB_Estado_Cliente.setEnabled(true);

					TF_nome_Cliente.setEnabled(true);
					formato_CPF.setEnabled(true);
					formato_RG.setEnabled(true);
					formato_DATA.setEnabled(true);
					formato_Telefone.setEnabled(true);
					formato_Celular.setEnabled(true);
					TF_Email_Cliente.setEnabled(true);
					TF_Endereco_Cliente.setEnabled(true);
					TF_N_Casa_Cliente.setEnabled(true);
					TF_Bairro_Cliente.setEnabled(true);
					TF_Cidade_Cliente.setEnabled(true);
					formato_CEP.setEnabled(true);
					TF_Estado_Cliente.setEnabled(true);
				}

			}});

		JCB_HAB_Remover.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){

				if(JCB_HAB_Remover.isSelected() == true){

					LB_nome_Antigo.setEnabled(true);
					LB_CPF_Antigo.setEnabled(true);
					TF_nome_Antigo.setEnabled(true);
					formato_CPF_Antigo.setEnabled(true);

					btn_listar_cliente.setVisible(true);
					btn_remover_cliente.setVisible(true);


					btn_listar_cliente.setBounds(390,30,100,20);
					btn_remover_cliente.setBounds(390,60, 100,20);

					btn_gravar_cliente.setVisible(false);
					btn_buscar_cliente.setVisible(false);
					btn_alterar_cliente.setVisible(false);

					LB_nome_Cliente.setEnabled(false);
					LB_CPF_Cliente.setEnabled(false);
					LB_RG_Cliente.setEnabled(false);
					LB_DT_Nasc_Cliente.setEnabled(false);
					LB_Telefone_Cliente.setEnabled(false);
					LB_Celular_Cliente.setEnabled(false);
					LB_Email_Cliente.setEnabled(false);
					LB_Endereco_Cliente.setEnabled(false);
					LB_N_Casa_Cliente.setEnabled(false);
					LB_Bairro_Cliente.setEnabled(false);
					LB_Cidade_Cliente.setEnabled(false);
					LB_CEP_Cliente.setEnabled(false);
					LB_Estado_Cliente.setEnabled(false);

					TF_nome_Cliente.setEnabled(false);
					formato_CPF.setEnabled(false);
					formato_RG.setEnabled(false);
					formato_DATA.setEnabled(false);
					formato_Telefone.setEnabled(false);
					formato_Celular.setEnabled(false);
					TF_Email_Cliente.setEnabled(false);
					TF_Endereco_Cliente.setEnabled(false);
					TF_N_Casa_Cliente.setEnabled(false);
					TF_Bairro_Cliente.setEnabled(false);
					TF_Cidade_Cliente.setEnabled(false);
					formato_CEP.setEnabled(false);
					TF_Estado_Cliente.setEnabled(false);
				}else {	

					btn_gravar_cliente.setVisible(true);
					btn_listar_cliente.setVisible(true);
					btn_buscar_cliente.setVisible(false);
					btn_alterar_cliente.setVisible(false);
					btn_remover_cliente.setVisible(false);

					btn_gravar_cliente.setBounds(390,30,100,20);
					btn_listar_cliente.setBounds(390,60, 100,20);
					// btn_remover_cliente.setBounds(390,90,100,20);

					LB_nome_Antigo.setEnabled(false);
					LB_CPF_Antigo.setEnabled(false);
					TF_nome_Antigo.setEnabled(false);
					formato_CPF_Antigo.setEnabled(false);

					LB_nome_Cliente.setEnabled(true);
					LB_CPF_Cliente.setEnabled(true);
					LB_RG_Cliente.setEnabled(true);
					LB_DT_Nasc_Cliente.setEnabled(true);
					LB_Telefone_Cliente.setEnabled(true);
					LB_Celular_Cliente.setEnabled(true);
					LB_Email_Cliente.setEnabled(true);
					LB_Endereco_Cliente.setEnabled(true);
					LB_N_Casa_Cliente.setEnabled(true);
					LB_Bairro_Cliente.setEnabled(true);
					LB_Cidade_Cliente.setEnabled(true);
					LB_CEP_Cliente.setEnabled(true);
					LB_Estado_Cliente.setEnabled(true);

					TF_nome_Cliente.setEnabled(true);
					formato_CPF.setEnabled(true);
					formato_RG.setEnabled(true);
					formato_DATA.setEnabled(true);
					formato_Telefone.setEnabled(true);
					formato_Celular.setEnabled(true);
					TF_Email_Cliente.setEnabled(true);
					TF_Endereco_Cliente.setEnabled(true);
					TF_N_Casa_Cliente.setEnabled(true);
					TF_Bairro_Cliente.setEnabled(true);
					TF_Cidade_Cliente.setEnabled(true);
					formato_CEP.setEnabled(true);
					TF_Estado_Cliente.setEnabled(true);
				}

			}});


		frame_org_indexada.setSize(522,295);
		frame_org_indexada.setLocationRelativeTo(null);
		frame_org_indexada.setVisible(true);
		frame_org_indexada.setResizable(false);
		frame_org_indexada.setIconImage(Cad_Cliente.getImage());

	}

	public void onClickSalvar(){
		String nomeCliente = TF_nome_Cliente.getText();
		String Cpf         = formato_CPF.getText();
		String RG          = formato_RG.getText();
		String Data        = formato_DATA.getText();
		String Endereco    = TF_Endereco_Cliente.getText();
		String Bairro      = TF_Bairro_Cliente.getText();
		String Cidade      = TF_Cidade_Cliente.getText();
		String CEP         = formato_CEP.getText(); 
		String Estado      = TF_Estado_Cliente.getText();
		String Telefone    = formato_Telefone.getText();
		String Celular     = formato_Celular.getText();
		String Email       = TF_Email_Cliente.getText();

		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if (Cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_CPF.setBackground(Color.RED);
			return;
		}else if (RG.equals("       - ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_RG.setBackground(Color.RED);
			return;
		}else if (Data.equals("   /    /     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_DATA.setBackground(Color.RED);
			return;
		}else if (Telefone.equals("(  )      -     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_Telefone.setBackground(Color.RED);
			return; 
		}else if (Celular.equals("(  )      -     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_Celular.setBackground(Color.RED);
			return; 
		}else if (Email.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_Email_Cliente.setBackground(Color.RED);
			return;
		}else if (Endereco.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_Endereco_Cliente.setBackground(Color.RED);
			return;
		}else {

			int Numero;
			try {
				Numero = Integer.parseInt(TF_N_Casa_Cliente.getText());
				if ((Numero < 0)){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+Numero,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_N_Casa_Cliente.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+null,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+TF_N_Casa_Cliente.getText(),"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}
			}

			if (Bairro.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Bairro_Cliente.setBackground(Color.RED);
				return;
			}else if (CEP.equals("      -    ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				formato_CEP.setBackground(Color.RED);
				return; 
			}else if (Cidade.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Cidade_Cliente.setBackground(Color.RED);
				return;
			}else if (Estado.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Estado_Cliente.setBackground(Color.RED);
				return;
			}

			if(BD.verifica_CPF(Cpf).equals("O CPF informado já existe no Sistema!")){
				JOptionPane.showMessageDialog(null,"O CPF informado já existe no Sistema!");
				formato_CPF.setBackground(Color.RED);
				return;
			}else if(BD.verifica_CPF(Cpf).equals("")){

				BD.inserirCliente(nomeCliente.toUpperCase(),Cpf,RG,Data,Endereco,Numero,Bairro,Cidade,CEP,Estado,Telefone,Celular,Email);
				JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!","Informação!",JOptionPane.INFORMATION_MESSAGE);
				gravar_arquivo();
			}
		}

		limparCampos();

		TF_nome_Cliente.setBackground(Color.WHITE);
		formato_CPF.setBackground(Color.WHITE);
		formato_RG.setBackground(Color.WHITE);
		formato_DATA.setBackground(Color.WHITE);
		TF_Endereco_Cliente.setBackground(Color.WHITE);
		TF_N_Casa_Cliente.setBackground(Color.WHITE);
		TF_Bairro_Cliente.setBackground(Color.WHITE);
		TF_Cidade_Cliente.setBackground(Color.WHITE);
		formato_CEP.setBackground(Color.WHITE); 
		TF_Estado_Cliente.setBackground(Color.WHITE);
		formato_Telefone.setBackground(Color.WHITE);
		formato_Celular.setBackground(Color.WHITE);
		TF_Email_Cliente.setBackground(Color.WHITE);
	}

	public void onClickListar(){
		Form_List_Cliente Form_List_Cliente = new Form_List_Cliente();
		Form_List_Cliente.Exibir_List_Cliente.setText(BD.listar_Cliente());
		frame_org_indexada.hide();
	}

	public void onClickBuscar(){
		String nomeCliente = TF_nome_Antigo.getText().toUpperCase();
		String Cpf_Antigo  = formato_CPF_Antigo.getText();
		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Antigo.setBackground(Color.RED);
			return;
		}else if (Cpf_Antigo.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_CPF_Antigo.setBackground(Color.RED);
			return;
		}

		if (BD.buscarCliente(nomeCliente.toUpperCase(),Cpf_Antigo).equals("Nenhum registro foi encontrado!")){
			JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado!");
			limparCampos();
			TF_nome_Antigo.setBackground(Color.WHITE);
			formato_CPF_Antigo.setBackground(Color.WHITE);
		}else {
			Form_Busc_Cliente form_Busc_cliente = new Form_Busc_Cliente();
			form_Busc_cliente.ta_Resultado.setText(BD.buscarCliente(nomeCliente.toUpperCase(),Cpf_Antigo));
			frame_org_indexada.hide();
		}
	}

	public void onClickAlterar(){
		String nomeCliente = TF_nome_Cliente.getText().toUpperCase();
		String nomeAntigo  = TF_nome_Antigo.getText().toUpperCase();
		String Cpf         = formato_CPF.getText();
		String Cpf_Antigo  = formato_CPF_Antigo.getText();
		String RG          = formato_RG.getText();
		String Data        = formato_DATA.getText();
		String Endereco    = TF_Endereco_Cliente.getText();
		String Bairro      = TF_Bairro_Cliente.getText();
		String Cidade      = TF_Cidade_Cliente.getText();
		String CEP         = formato_CEP.getText(); 
		String Estado      = TF_Estado_Cliente.getText();
		String Telefone    = formato_Telefone.getText();
		String Celular     = formato_Celular.getText();
		String Email       = TF_Email_Cliente.getText();

		if (nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Cliente.setBackground(Color.RED);
			return;
		}else if (Cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_CPF.setBackground(Color.RED);
			return;
		}else if (RG.equals("       - ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_RG.setBackground(Color.RED);
			return;
		}else if (Data.equals("   /    /     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_DATA.setBackground(Color.RED);
			return;
		}else if (Telefone.equals("(  )      -     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_Telefone.setBackground(Color.RED);
			return; 
		}else if (Celular.equals("(  )      -     ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_Celular.setBackground(Color.RED);
			return; 
		}else if (Email.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_Email_Cliente.setBackground(Color.RED);
			return;
		}else if (Endereco.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_Endereco_Cliente.setBackground(Color.RED);
			return;
		}else {

			int Numero;
			try {
				Numero = Integer.parseInt(TF_N_Casa_Cliente.getText());
				if ((Numero < 0)){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+Numero,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}
			}catch(NumberFormatException nfe){
				if (TF_N_Casa_Cliente.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+null,"Aviso!",JOptionPane.WARNING_MESSAGE);
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}else {
					JOptionPane.showMessageDialog(null,"Valor digitado inválido\nNúmero da casa : "+TF_N_Casa_Cliente.getText(),"Aviso!",JOptionPane.WARNING_MESSAGE); 
					TF_N_Casa_Cliente.setBackground(Color.RED);
					return;
				}
			}

			if (Bairro.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Bairro_Cliente.setBackground(Color.RED);
				return;
			}else if (CEP.equals("      -    ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				formato_CEP.setBackground(Color.RED);
				return; 
			}else if (Cidade.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Cidade_Cliente.setBackground(Color.RED);
				return;
			}else if (Estado.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_Estado_Cliente.setBackground(Color.RED);
				return;
			}else if(nomeAntigo.equals("")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				TF_nome_Antigo.setBackground(Color.RED);
				return;
			}else if (Cpf_Antigo.equals("   .   .   -  ")){
				JOptionPane.showMessageDialog(null,"Existem campos em branco!","Aviso!",JOptionPane.WARNING_MESSAGE);
				formato_CPF_Antigo.setBackground(Color.RED);
				return;
			}

			Cliente cliente = new Cliente(nomeCliente,Cpf,RG,Data,Endereco,Numero,Bairro,Cidade,CEP,Estado,Telefone,Celular,Email);

			if (BD.alterarCliente(nomeAntigo,Cpf_Antigo, cliente).equals("Registro alterado com sucesso!")){
				JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!");
				gravar_arquivo();
				limparCampos();
			}else {
				JOptionPane.showMessageDialog(null,BD.alterarCliente(nomeAntigo,Cpf_Antigo, cliente),"Aviso!",JOptionPane.WARNING_MESSAGE); 
				TF_nome_Antigo.setText("");
				formato_CPF_Antigo.setText("");
			}
		}

		TF_nome_Cliente.setBackground(Color.WHITE);
		TF_nome_Antigo.setBackground(Color.WHITE);
		formato_CPF.setBackground(Color.WHITE);
		formato_CPF_Antigo.setBackground(Color.WHITE);
		formato_RG.setBackground(Color.WHITE);
		formato_DATA.setBackground(Color.WHITE);
		TF_Endereco_Cliente.setBackground(Color.WHITE);
		TF_N_Casa_Cliente.setBackground(Color.WHITE);
		TF_Bairro_Cliente.setBackground(Color.WHITE);
		TF_Cidade_Cliente.setBackground(Color.WHITE);
		formato_CEP.setBackground(Color.WHITE); 
		TF_Estado_Cliente.setBackground(Color.WHITE);
		formato_Telefone.setBackground(Color.WHITE);
		formato_Celular.setBackground(Color.WHITE);
		TF_Email_Cliente.setBackground(Color.WHITE);

	}

	public void onClickRemover(){
		String nomeCliente = TF_nome_Antigo.getText().toUpperCase();
		String Cpf_Antigo  = formato_CPF_Antigo.getText();
		if(nomeCliente.equals("")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			TF_nome_Antigo.setBackground(Color.RED);
			return;
		}else if (Cpf_Antigo.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null,"Existem campos em branco","Aviso!",JOptionPane.WARNING_MESSAGE);
			formato_CPF_Antigo.setBackground(Color.RED);
			return;
		}

		if (BD.removerCliente(nomeCliente.toUpperCase(),Cpf_Antigo).equals("Registro removido com sucesso!")){
			JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");
			gravar_arquivo();
			limparCampos();
		}else {
			JOptionPane.showMessageDialog(null,BD.removerCliente(nomeCliente.toUpperCase(),Cpf_Antigo));
			limparCampos();
		}

		TF_nome_Antigo.setBackground(Color.WHITE);
		formato_CPF_Antigo.setBackground(Color.WHITE);
	}

	public void limparCampos(){
		TF_nome_Cliente.setText("");
		TF_nome_Antigo.setText("");
		formato_Telefone.setText("");
		formato_Celular.setText("");
		TF_Email_Cliente.setText("");
		TF_Endereco_Cliente.setText("");
		TF_N_Casa_Cliente.setText("");
		TF_Bairro_Cliente.setText("");
		TF_Cidade_Cliente.setText("");
		TF_Estado_Cliente.setText("");
		formato_CPF.setText("");
		formato_CPF_Antigo.setText("");
		formato_RG.setText("");
		formato_CEP.setText("");
		formato_DATA.setText("");
	}
	public void gravar_arquivo(){
		try{
			FileOutputStream f = new FileOutputStream("c:/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
			}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo de dados não encontrado");
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