package parteGrafica;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Form_Org_Brent {
	private JFrame frame_tabela;
	private JTable tabela;
	private ScrollPane scroll;
	
	private String[] colunas = new String[]{"Indice","Chave"};
	private String[][] dados = new String[][]{
		    {"0","28"},
		    {"1",""},
		    {"2",""},
		    {"3",""},
		    {"4","33"},
		    {"5",""},
		    {"6",""}
		};
	
	
	public Form_Org_Brent(){
	    frame_tabela = new JFrame("Exemplo de Tabela com Dados");
	    JTable tabela = new JTable(dados,colunas);
		JScrollPane scroll = new JScrollPane();
		frame_tabela.setLayout(new FlowLayout());
	
		//instanciando a JTable
 
        tabela.setPreferredScrollableViewportSize(new Dimension(100,200));//barra de rolagem
		scroll.setViewportView(tabela);
		frame_tabela.add(scroll);
		
		frame_tabela.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Principal Principal = new Principal();
				Principal.frame_Menu_Principal.show();
			}});
		
		
		frame_tabela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_tabela.setSize(500,400);
		frame_tabela.setLocationRelativeTo(null);
		frame_tabela.setVisible(true);
		frame_tabela.setResizable(false);	
	}
	

	public void AbrirFormulario(){
		frame_tabela.show();
	}

}
