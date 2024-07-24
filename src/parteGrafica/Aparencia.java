package parteGrafica;



import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.material.construcao.p2.*;


public class Aparencia {

	BancoDeDados BD = new BancoDeDados();



	private ImageIcon menuPrevisualizar = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Nimbus.png"));
	private ImageIcon Mov_Aparencia = new ImageIcon(ClassLoader.getSystemResource("Aparencia/Mov_Aparencia.png"));
	private JLabel LB_Temas;
	private JLabel LB_Imagem = new JLabel(menuPrevisualizar);

	private String Temas[]={"Padrão","Creme","Prata","Oliva"};
	private JComboBox selecao;
	protected  JFrame frame_Aparencia;
	public static String opcao;

	private byte valor;


	public Aparencia(){
		frame_Aparencia = new JFrame("Aparencia Do Sistema");
		frame_Aparencia.setLayout(null);

		LB_Temas = new JLabel("Aparencias:");
		selecao = new JComboBox(Temas);
		selecao.setMaximumRowCount(4);

		
		
		
		frame_Aparencia.add(selecao);
		frame_Aparencia.add(LB_Imagem);
		frame_Aparencia.add(LB_Temas);


		selecao.setBounds(184,267,100,20);
		LB_Imagem.setBounds(01,01,460,260);
		LB_Temas.setBounds(199,250,100,20);

		selecao.setFocusable(false);
		selecao.addItemListener(new ItemListener(){ 
			public void itemStateChanged(ItemEvent event){
				if(event.getStateChange() == ItemEvent.SELECTED){
					valor = (byte) selecao.getSelectedIndex();
					switch(valor){
					case 0:
						try {
							for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(info.getName())) {//Padrao Laranja
									LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Padrao.png")));
									UIManager.setLookAndFeel(info.getClassName());
									UIManager.put("nimbusBase", Color.red);
									UIManager.put("nimbusBlueGrey", new Color(255,201,14));
									UIManager.put("control", new Color(255,201,14));
									SwingUtilities.updateComponentTreeUI(frame_Aparencia);
									break;
								}
							}
						} catch (Exception e) {}
						break;	
					case 1:
						try {
							for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(info.getName())) {//Cor Creme
									LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Creme.png")));
									UIManager.setLookAndFeel(info.getClassName());
									UIManager.put("nimbusBase", new Color(255,255,255));
									UIManager.put("nimbusBlueGrey", new Color(255,255,255));
									UIManager.put("control", new Color(255,255,255));
									SwingUtilities.updateComponentTreeUI(frame_Aparencia);
									break;
								}
							}
						} catch (Exception e) {}
						break;
					case 2:
						try {
							for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(info.getName())) {//Prata
									LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Prata.png")));
									UIManager.setLookAndFeel(info.getClassName());
									UIManager.put("nimbusBase", new Color(208,208,208));
									UIManager.put("nimbusBlueGrey", new Color(208,208,208));
									UIManager.put("control", new Color(208,208,208));
									SwingUtilities.updateComponentTreeUI(frame_Aparencia);
									break;
								}
							}
						} catch (Exception e) {}
						break;
					case 3:
						try {
							for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(info.getName())) {//Oliva
									LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Oliva.png")));
									UIManager.setLookAndFeel(info.getClassName());
									UIManager.put("nimbusBase", new Color(242,242,189));
									UIManager.put("nimbusBlueGrey", new Color(242,242,189));
									UIManager.put("control", new Color(242,242,189));
									SwingUtilities.updateComponentTreeUI(frame_Aparencia);
									break;
								}
							}
						} catch (Exception e) {}
						break;
					}
				}
				
			}
		});

		frame_Aparencia.addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent e){
				Principal Principal = new Principal();
				Principal.frame_Menu_Principal.show();
				SwingUtilities.updateComponentTreeUI(Principal.frame_Menu_Principal);
			}});

		frame_Aparencia.addWindowListener( new WindowAdapter (){
			public void windowOpened(WindowEvent e){
				LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Padrao.png")));
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {//Padrao Laranja
							LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Padrao.png")));
							UIManager.setLookAndFeel(info.getClassName());
							UIManager.put("nimbusBase", new Color(255,201,14));
							UIManager.put("nimbusBlueGrey", new Color(255,201,14));
							UIManager.put("control", new Color(255,201,14));
							SwingUtilities.updateComponentTreeUI(frame_Aparencia);
							break;
						}
					}
				} catch (Exception em) {}
			}});


		frame_Aparencia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame_Aparencia.setSize(470,320);
		frame_Aparencia.setLocationRelativeTo(null);
		frame_Aparencia.setVisible(true);
		frame_Aparencia.setResizable(false);
		frame_Aparencia.setIconImage(Mov_Aparencia.getImage());

	}


}
