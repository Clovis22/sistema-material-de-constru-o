package parteGrafica;

import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Form_Org_Indexada{
	public  JFrame formulario_cadastro;
	private JTextField tf_id,tf_nome,tf_idade,tf_sexo,tf_email,tf_endereco;
	private JLabel lb_id,lb_nome,lb_endereco,lb_sexo,lb_idade,lb_email,lb_duvida;
	private JButton btn_salvar,btn_limpar,btn_exibir,btn_position,btn_limit,btn_criar_espaco;
//	private Lista lista_de_duvidas; // lista encadeada com duvidas de usuarios;
//	private Manipulacao manipulacao; // classe responsavel pela manipulação em arquivos
	private ImageIcon ic_org_indexada = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Clientes.png"));
	    public Form_Org_Indexada(){
	    	
	    	//lista_de_duvidas = new Lista(); // lista encadeada com duvidas de usuarios
//	    	manipulacao = new Manipulacao();
	    	
	    	formulario_cadastro = new JFrame("Cadastro de Clientes");
	    	formulario_cadastro.setLayout(null);
	    	
	    	lb_id = new JLabel("Matricula");
	    	lb_nome = new JLabel("Nome");
	    	lb_endereco = new JLabel("Endereco");
	    	lb_duvida = new JLabel("Duvida");
	    	lb_idade  = new JLabel("Idade");
	    	lb_sexo   = new JLabel("Sexo");
	    	lb_email  = new JLabel("Email");
	    	
	    	tf_id = new JTextField();
	    	tf_nome = new JTextField();
	    	tf_endereco = new JTextField();
	    	tf_idade    = new JTextField();
	    	tf_sexo    = new JTextField();
	    	tf_email    = new JTextField();
	    	
	    	
	    	btn_salvar       = new JButton("Salvar");
	    	btn_limpar       = new JButton("Limpar");
	    	btn_exibir       = new JButton("Exibir");
	    	btn_position     = new JButton("Posição");
	    	btn_limit        = new JButton("Limite");
	    	btn_criar_espaco = new JButton("Criar Espaço");
	    	
	    	formulario_cadastro.add(lb_id);
	    	formulario_cadastro.add(lb_nome);
	    	formulario_cadastro.add(lb_endereco);
	    	formulario_cadastro.add(lb_idade);
	    	formulario_cadastro.add(lb_sexo);
	    	formulario_cadastro.add(lb_email);
	    	
	    	formulario_cadastro.add(tf_id);
	    	formulario_cadastro.add(tf_nome);
	    	formulario_cadastro.add(tf_endereco);
	    	formulario_cadastro.add(tf_idade);
	    	formulario_cadastro.add(tf_sexo);
	    	formulario_cadastro.add(tf_email);
	    	
	    	
	    	formulario_cadastro.add(btn_salvar);
	    	formulario_cadastro.add(btn_limpar);
	    	formulario_cadastro.add(btn_exibir);
	    	formulario_cadastro.add(btn_position);
	    	formulario_cadastro.add(btn_limit);
	    	formulario_cadastro.add(btn_criar_espaco);
	    	
		    formulario_cadastro.setSize(522,295);
			formulario_cadastro.setLocationRelativeTo(null);
			formulario_cadastro.setResizable(false);
			formulario_cadastro.setIconImage(ic_org_indexada.getImage());
	    	
			// localização dos componentes
			
			lb_id.setBounds(01,10,50,24);
			lb_nome.setBounds(159,5,40,36);
			lb_endereco.setBounds(265,5,60,36);
			lb_idade.setBounds(01,65,220,36);
			lb_sexo.setBounds(265,65,220,36);
			lb_email.setBounds(159,65,220,36);
			
			tf_id.setBounds(01,30,150,27);
			tf_nome.setBounds(159,30,102,27);
			tf_endereco.setBounds(265,30,90,27);
			tf_idade.setBounds(01,90,150,27);
			tf_email.setBounds(159,90,90,27);
			tf_sexo.setBounds(265,90,90,27);
			
			
			btn_salvar.setBounds(390,30,100,20);
			btn_limpar.setBounds(390,60,100,20);
			btn_exibir.setBounds(390,90,100,20);
			btn_position.setBounds(390,120,100,20);
			btn_limit.setBounds(390,150,100,20);
			btn_criar_espaco.setBounds(390,180,100,20);
			
			
			/// Eventos Janela
			
			formulario_cadastro.addWindowListener( new WindowAdapter (){
				public void windowClosing(WindowEvent e){
					Principal Principal = new Principal();
					Principal.frame_Menu_Principal.show();
					SwingUtilities.updateComponentTreeUI(Principal.frame_Menu_Principal);
				}});
			
			/// Eventos Botões
			
		    btn_salvar.addMouseListener(new MouseAdapter (){
		        public void mouseClicked(MouseEvent me){
     	        	SalvarDadosArquivo();
		        	limparCampos();
				}});
		    
		    btn_limpar.addMouseListener(new MouseAdapter (){
		        public void mouseClicked(MouseEvent me){
		        	limparCampos();
				}});
		    
		    btn_exibir.addMouseListener(new MouseAdapter (){
		        public void mouseClicked(MouseEvent me){
		        	
		        	try{
		 //       	JOptionPane.showMessageDialog(null,manipulacao.LerDados());
		        	Form_Exibir form_exibir = new Form_Exibir();
		        	form_exibir.frame_exibir.show();
		        	formulario_cadastro.hide();
		        	}catch(Exception e){
		        		e.printStackTrace();
		        	}
		        	
				}});
		    
		    btn_position.addMouseListener(new MouseAdapter (){
		        public void mouseClicked(MouseEvent me){
//		        	JOptionPane.showMessageDialog(null, "Posição Atual : "+manipulacao.PositionAtual());
				}});
		    
		    btn_criar_espaco.addMouseListener(new MouseAdapter (){
		        public void mouseClicked(MouseEvent me){
		        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho que deseja alocar em bytes!"));
//		        manipulacao.AlocarEspaco(tamanho);
				}});
			
	    }
	    
	    public void SalvarDadosArquivo(){
	    	   int id          = Integer.parseInt(tf_id.getText());
	    	String nome        = tf_nome.getText();
	    	String endereco    = tf_endereco.getText();
	    	short  idade       = (short) Integer.parseInt(tf_idade.getText());
	    	String sexo        = tf_sexo.getText();
	    	String email       = tf_email.getText();	
	    	try{
	    		IFileOrganizer org = new OrganizadorSimples("escola.db");
	    		Aluno novo_aluno = new Aluno(id,nome,endereco,idade,sexo,email);
	    		boolean resultado = org.addReg(novo_aluno);
				if(resultado == true){
					JOptionPane.showMessageDialog(null,"Aluno Cadastrado!");
				}else
					JOptionPane.showMessageDialog(null,"Um Erro Ocorreu!!");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void limparCampos(){
	    	tf_id.setText(null);
	    	tf_nome.setText(null);
	    	tf_endereco.setText(null);
	    	tf_idade.setText(null);
	    	tf_sexo.setText(null);
	    	tf_email.setText(null);
	    }
	    
	    public void AbrirFormulario(){
	    	formulario_cadastro.setVisible(true);	    	
	    }
	    

}
