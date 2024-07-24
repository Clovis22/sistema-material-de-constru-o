package parteGrafica;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;


import br.material.construcao.p2.*;


public class Principal implements Gravacao{
	
	private static final ImageIcon ic_org_indexada  = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Clientes.png"));
	private static final ImageIcon ic_org_indexada_s = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Clientes_S.png"));
	private static final ImageIcon ic_org_brent = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Estoque.png"));
	private static final ImageIcon ic_org_brent_s = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Estoque_S.png"));
	private static final ImageIcon Mov_Vendas = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Vendas.png"));
	private static final ImageIcon Mov_Vendas_S = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Vendas_S.png"));
	private static final ImageIcon Mov_Lucros = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Lucros.png"));
	private static final ImageIcon Mov_Lucros_S = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Lucros_S.png"));
	private static final ImageIcon Mov_Aparencia = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Aparencia.png"));
	private static final ImageIcon Mov_Aparencia_S = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Aparencia_S.png"));
	private static final ImageIcon Mov_Sair = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Sair.png"));
	private static final ImageIcon Mov_Sair_S = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Sair_S.png"));
	private static final ImageIcon Mov_Principal = new ImageIcon(ClassLoader.getSystemResource("Aparencia/home.png"));
    private static final ImageIcon Exportar_Movel = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Exportar.png"));   
 
	protected JFrame frame_Menu_Principal;
	private JButton btn_org_indexada;
	private JButton btn_org_brent;
	private JButton btn_mov_vendas;
	private JButton btn_Lucros;
	private JButton btn_Aparencia;
	private JButton btn_sair_sistema;
	private JButton btn_Exportar_Movel;
	
	private JLabel lb_Menu_Principal;
	
	BancoDeDados BD = new BancoDeDados();
	
	
	public Principal(){
		
		frame_Menu_Principal = new JFrame("Sistema Material de Construção");
		frame_Menu_Principal.setLayout(null);

		lb_Menu_Principal = new JLabel();
		btn_org_indexada   = new JButton();
		btn_org_brent   = new JButton();
		btn_mov_vendas    = new JButton();
		btn_Lucros  = new JButton();
		btn_Aparencia     = new JButton();
		btn_sair_sistema  = new JButton();

		lb_Menu_Principal.setText("Seja Bem-Vindo!");

		btn_org_indexada.setIcon(ic_org_indexada);
		btn_org_indexada.setRolloverIcon(ic_org_indexada_s);
		
		btn_org_brent.setIcon(ic_org_brent);
		btn_org_brent.setRolloverIcon(ic_org_brent_s);
		
		btn_Exportar_Movel  = new JButton(Exportar_Movel);
		btn_Exportar_Movel.setToolTipText("Envia o Arquivo de Dados para um dispositivo Android compativel!");
		
		btn_mov_vendas.setIcon(Mov_Vendas);
		btn_mov_vendas.setRolloverIcon(Mov_Vendas_S);
		
		btn_Lucros.setIcon(Mov_Lucros);
		btn_Lucros.setRolloverIcon(Mov_Lucros_S);
		
		btn_Aparencia.setIcon(Mov_Aparencia);
		btn_Aparencia.setRolloverIcon(Mov_Aparencia_S);
		
		btn_sair_sistema.setIcon(Mov_Sair);
		btn_sair_sistema.setRolloverIcon(Mov_Sair_S);
		
		

		frame_Menu_Principal.add(btn_org_indexada);
		frame_Menu_Principal.add(btn_org_brent);
		frame_Menu_Principal.add(btn_mov_vendas);
		frame_Menu_Principal.add(btn_Lucros);
		frame_Menu_Principal.add(btn_Aparencia);
		frame_Menu_Principal.add(btn_sair_sistema);
		frame_Menu_Principal.add(btn_Exportar_Movel);
		frame_Menu_Principal.add(lb_Menu_Principal);
		
		lb_Menu_Principal.setBounds(185,200,210,36);

		btn_org_indexada.setBounds(50, 30, 80,70);
		btn_org_brent.setBounds(190,30,80,70);
		btn_mov_vendas.setBounds(330,30,80,70);
		btn_Lucros.setBounds(50,130,80,70);
		btn_Exportar_Movel.setBounds(01,200,53,28);
		btn_Aparencia.setBounds(330,130,80,70);
		btn_sair_sistema.setBounds(190,130,80,70);


		btn_org_indexada.setFocusable(false);
		btn_org_brent.setFocusable(false);
		btn_mov_vendas.setFocusable(false);
		btn_Lucros.setFocusable(false);
		btn_Aparencia.setFocusable(false);
		btn_Exportar_Movel.setFocusable(false);
		btn_sair_sistema.setFocusable(false);


		// Aqui começa o evento do Mouse
		btn_org_indexada.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				//btn_mov_cliente.setIcon(img2);
				btn_org_indexada.setToolTipText("Ordenação Indexada dos registros nos arquivos!");
				lb_Menu_Principal.setText("    Sequencial Indexada      ");
				lb_Menu_Principal.setBounds(160,200, 210,36);
			}public void mouseExited(MouseEvent me){
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				Form_Org_Indexada Form_Org_Indexada = new Form_Org_Indexada();
				Form_Org_Indexada.AbrirFormulario();
				frame_Menu_Principal.hide();
			}});

		btn_org_brent.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				btn_org_brent.setToolTipText("Ordenação direta através do mêtodo Brent");
				lb_Menu_Principal.setText("       Organização Brent");
				lb_Menu_Principal.setBounds(160,200, 210,36);
			}public void mouseExited(MouseEvent me){
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				Form_Mov_Estoque Form_Org_Brent = new Form_Mov_Estoque();
				Form_Org_Brent.frame_Cadastro_Estoque.show();
				frame_Menu_Principal.hide();
			}});

		btn_mov_vendas.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				btn_mov_vendas.setToolTipText("Realiza vendas e gerencia lucros e relatorios");
				lb_Menu_Principal.setText("Movimentação de Vendas");
				lb_Menu_Principal.setBounds(160,200, 210,36);
			}public void mouseExited(MouseEvent me){
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				Form_Mov_Vendas Form_Mov_Vendas = new Form_Mov_Vendas();
				Form_Mov_Vendas.frame_Mov_Vendas.show();
				//deixa o formulario Principal oculto
				frame_Menu_Principal.hide();
			}});


		btn_Lucros.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				//btn_mov_vendas.setIcon(img6);
				btn_Lucros.setToolTipText("Exibe informações sobre as estatísticas de vendas");
				lb_Menu_Principal.setText("        Lucros de Vendas");
				lb_Menu_Principal.setBounds(160,200, 210,36);
			}public void mouseExited(MouseEvent me){
				//btn_mov_vendas.setIcon(img5);
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				Form_Exibir Form_Estatisticas = new Form_Exibir();
				Form_Estatisticas.frame_exibir.show();
				frame_Menu_Principal.hide();
			}});
		
		
		btn_Aparencia.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				//btn_mov_vendas.setIcon(img6);
				btn_Aparencia.setToolTipText("Altera as cores e Janelas do Sistema");
				lb_Menu_Principal.setText("Alteração de Aparencia");
				lb_Menu_Principal.setBounds(160,200, 210,36);
			}public void mouseExited(MouseEvent me){
				//btn_mov_vendas.setIcon(img5);
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				Aparencia Aparencia = new Aparencia(); 
				Aparencia.frame_Aparencia.show();
				//deixa o formulario Principal oculto
				frame_Menu_Principal.hide();
			}});



		btn_sair_sistema.addMouseListener(new MouseAdapter (){
			public void mouseEntered(MouseEvent me){
				btn_sair_sistema.setToolTipText("Fecha o Sistema Material de Construção");
				lb_Menu_Principal.setText("Sair do Sistema");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseExited(MouseEvent me){
				lb_Menu_Principal.setText("Menu Principal");
				lb_Menu_Principal.setBounds(190,200, 210,36);
			}public void mouseClicked(MouseEvent me){
				System.exit(0);
			}});
		btn_Exportar_Movel.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent me){
				//diretorios dos arquivo no sistema
        		File dir = new File("f:/Sistema Material de Construcao/");
        		if (dir.exists()){
        			ler_arquivo();
        			gravar_arquivo();
        		}else{
        			dir.mkdir();
        			JOptionPane.showMessageDialog(null,"Dispositivo Compativel não encontrado!"+"\n"+"Não é possivel transferir!");
        		}
        	}
		});
		
			
		//propriedades padrão do JFrame do formulario Principal
		frame_Menu_Principal.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Menu_Principal.setSize(460,260);
		frame_Menu_Principal.setLocationRelativeTo(null);
		frame_Menu_Principal.setVisible(true);
		frame_Menu_Principal.setResizable(false);
		frame_Menu_Principal.setIconImage(Mov_Principal.getImage());
	}
	public void gravar_arquivo(){
		try{
			String nome_diretorio = JOptionPane.showInputDialog("Informe a letra da unidade do dispositivo :");		
			FileOutputStream f = new FileOutputStream(""+nome_diretorio+":/Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(BD);
			o.close();
			JOptionPane.showMessageDialog(null,"Arquivo do Sistema Transferido !");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo nao Exportado");
		}
	}
	public void ler_arquivo(){
		try{
			FileInputStream f = new FileInputStream("c:\\Sistema Material de Construcao/Sistema_Material_de_Construcao.txt");
			ObjectInputStream o = new ObjectInputStream(f);
			BD = (BancoDeDados) o.readObject();
			o.close();
			//JOptionPane.showMessageDialog(null,"Arquivo do Sistema movel carregado !");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Arquivo nao Carregado");
		}
	}

	
	
}