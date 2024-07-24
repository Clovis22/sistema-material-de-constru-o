package parteGrafica;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class Form_List_Estoque{
	protected JFrame frame_List_Estoque;
	protected JTextArea Exibir_List_Estoque_Eletrica,
	Exibir_List_Estoque_Hidraulica,
	Exibir_List_Estoque_Mecanica,
	Exibir_List_Estoque_Outros;
	
	private JTabbedPane JTP_Estoque;

	private ImageIcon List_Estoque = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Listar_Estoque_S.png"));
	
	public Form_List_Estoque(){
		frame_List_Estoque = new JFrame("Lista Estoque");
		frame_List_Estoque.setLayout(null);
		
		Exibir_List_Estoque_Eletrica   = new JTextArea(503,425);
		Exibir_List_Estoque_Mecanica   = new JTextArea(503,425);
		Exibir_List_Estoque_Hidraulica = new JTextArea(503,425);
		Exibir_List_Estoque_Outros     = new JTextArea(503,425);

		Exibir_List_Estoque_Eletrica.setEditable(false);
		Exibir_List_Estoque_Mecanica.setEditable(false);
		Exibir_List_Estoque_Hidraulica.setEditable(false);
		Exibir_List_Estoque_Outros.setEditable(false);
		
		JTP_Estoque = new JTabbedPane();
		JTP_Estoque.setSize(500,400);

		JTP_Estoque.addTab("Seção Elétrica",new JScrollPane(Exibir_List_Estoque_Eletrica));
		JTP_Estoque.addTab("Seção Hidráulica",new JScrollPane(Exibir_List_Estoque_Hidraulica));
		JTP_Estoque.addTab("Seção Mecânica",new JScrollPane(Exibir_List_Estoque_Mecanica));
		JTP_Estoque.addTab("Seção Outros",new JScrollPane(Exibir_List_Estoque_Outros));

        frame_List_Estoque.add(JTP_Estoque);


		frame_List_Estoque.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Mov_Estoque Form_Mov_Estoque = new Form_Mov_Estoque();
				Form_Mov_Estoque.frame_Cadastro_Estoque.show();
			}});
		
		frame_List_Estoque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_List_Estoque.setSize(503,425);
		frame_List_Estoque.setLocationRelativeTo(null);
		frame_List_Estoque.setVisible(true);
		frame_List_Estoque.setResizable(false);
		frame_List_Estoque.setIconImage(List_Estoque.getImage());
	}
	
}