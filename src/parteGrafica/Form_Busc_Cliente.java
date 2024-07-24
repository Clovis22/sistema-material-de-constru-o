package parteGrafica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.*;

public class Form_Busc_Cliente {
	private static final ImageIcon Busc_Cliente = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Pesquisar_Clientes.png"));
	protected JFrame frame_Busc_Cliente;

	protected JTextArea ta_Resultado;
	
	public Form_Busc_Cliente(){
		frame_Busc_Cliente = new JFrame("Buscar");
		frame_Busc_Cliente.setLayout(null);
		
		ta_Resultado = new JTextArea();
		
		ta_Resultado.setEditable(false);
		
		frame_Busc_Cliente.add(ta_Resultado);
		
		ta_Resultado.setBounds(01,01,500,400);
	  	
	    frame_Busc_Cliente.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Organizacao_Indexada form_Cad_Cliente;
				form_Cad_Cliente = new Form_Organizacao_Indexada();
				form_Cad_Cliente.frame_org_indexada.show();
			}});
	    
		frame_Busc_Cliente.setSize(500,400);
		frame_Busc_Cliente.setLocationRelativeTo(null);
		frame_Busc_Cliente.setVisible(true);
		frame_Busc_Cliente.setResizable(false);
		frame_Busc_Cliente.setIconImage(Busc_Cliente.getImage());	
		
	}
}