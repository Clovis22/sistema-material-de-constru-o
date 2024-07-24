package parteGrafica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import br.material.construcao.p2.*;


public class Form_Relatorio_Vendas {
	
	protected ImageIcon Relat_Vendas = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Relatorio_S.png"));
	protected JFrame frame_relatorio_venda;
	protected JTextArea Exibir_Relatorio_Vendas_Eletrica,
	Exibir_Relatorio_Vendas_Hidraulica,
	Exibir_Relatorio_Vendas_Mecanica,
	Exibir_Relatorio_Vendas_Outros;

	
	protected JTabbedPane JTP_Relatorio_Venda;

	BancoDeDados BD = new BancoDeDados();
	
	public Form_Relatorio_Vendas(){
		
		frame_relatorio_venda = new JFrame("Relatorio Vendas");
		frame_relatorio_venda.setLayout(null);
		
		Exibir_Relatorio_Vendas_Eletrica = new JTextArea(503,425);
		Exibir_Relatorio_Vendas_Hidraulica = new JTextArea(503,425);
		Exibir_Relatorio_Vendas_Mecanica = new JTextArea(503,425);
		Exibir_Relatorio_Vendas_Outros = new JTextArea(503,425);
		
		Exibir_Relatorio_Vendas_Eletrica.setEditable(false);
		Exibir_Relatorio_Vendas_Hidraulica.setEditable(false);
		Exibir_Relatorio_Vendas_Mecanica.setEditable(false);
		Exibir_Relatorio_Vendas_Outros.setEditable(false);
		
		
		JTP_Relatorio_Venda = new JTabbedPane();
		JTP_Relatorio_Venda.setSize(500,400);

		JTP_Relatorio_Venda.addTab("Seção Elétrica",new JScrollPane(Exibir_Relatorio_Vendas_Eletrica));
		JTP_Relatorio_Venda.addTab("Seção Hidráulica",new JScrollPane(Exibir_Relatorio_Vendas_Hidraulica));
		JTP_Relatorio_Venda.addTab("Seção Mecânica",new JScrollPane(Exibir_Relatorio_Vendas_Mecanica));
		JTP_Relatorio_Venda.addTab("Seção Outros",new JScrollPane(Exibir_Relatorio_Vendas_Outros));

		frame_relatorio_venda.add(JTP_Relatorio_Venda);
		
		frame_relatorio_venda.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Form_Mov_Vendas Form_Mov_Vendas = new Form_Mov_Vendas();
				Form_Mov_Vendas.frame_Mov_Vendas.show();
			}});
		
		frame_relatorio_venda.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_relatorio_venda.setSize(503,425);
		frame_relatorio_venda.setLocationRelativeTo(null);
		frame_relatorio_venda.setVisible(true);
		frame_relatorio_venda.setResizable(false);
		frame_relatorio_venda.setIconImage(Relat_Vendas.getImage());
		
		
		
	}
	
}
