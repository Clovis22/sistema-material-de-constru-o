package parteGrafica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import br.material.construcao.p2.*;


public class Form_Exibir{
	
	
	protected JFrame frame_exibir;
	private JTextArea Exibir_Info;
	
	JTabbedPane JTP_Info;
	ImageIcon Mov_Lucros = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Lucros.png"));
	
    BancoDeDados BD = new BancoDeDados();
    
	
	public Form_Exibir(){
		
		
		frame_exibir = new JFrame("Exibir Informações");
		frame_exibir.setLayout(null);
		
		Exibir_Info   = new JTextArea(503,425);


		Exibir_Info.setEditable(false);

		JTP_Info = new JTabbedPane();
		JTP_Info.setSize(500,400);

		JTP_Info.addTab("Informações Indexada",Exibir_Info);

		
        frame_exibir.add(JTP_Info);


		frame_exibir.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Org_Indexada form_Org_Indexada = new Form_Org_Indexada();
				form_Org_Indexada.AbrirFormulario();
				frame_exibir.hide();
			}});
		
		frame_exibir.addWindowListener( new WindowAdapter (){
			public void windowOpened(WindowEvent e){
				try {
					IFileOrganizer org = new OrganizadorSimples("escola.db");
					Exibir_Info.setText(org.ExibirTodosAluno());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}});
		
		frame_exibir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_exibir.setSize(457,300);
		frame_exibir.setLocationRelativeTo(null);
		frame_exibir.setVisible(true);
		frame_exibir.setResizable(false);
		frame_exibir.setIconImage(Mov_Lucros.getImage());

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