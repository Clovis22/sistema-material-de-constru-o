package parteGrafica;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;


import javax.swing.*;

public class Form_List_Cliente {
	JFrame frame_List_Cliente;
	JTextArea Exibir_List_Cliente;

	ImageIcon List_Cliente = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Listar_Cliente.png"));

	public Form_List_Cliente(){


		frame_List_Cliente = new JFrame("Lista Clientes");

		Exibir_List_Cliente = new JTextArea(300,150);
       
		frame_List_Cliente.add(new JScrollPane(Exibir_List_Cliente));

		Exibir_List_Cliente.setEditable(false);
		Exibir_List_Cliente.setBounds(01,01,500,400);

		frame_List_Cliente.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Organizacao_Indexada Form_Cad_Cliente = new Form_Organizacao_Indexada();
				Form_Cad_Cliente.frame_org_indexada.show();	
			}});


		frame_List_Cliente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_List_Cliente.setSize(500,400);
		frame_List_Cliente.setLocationRelativeTo(null);
		frame_List_Cliente.setVisible(true);
		frame_List_Cliente.setResizable(false);
		frame_List_Cliente.setIconImage(List_Cliente.getImage());
	}
}