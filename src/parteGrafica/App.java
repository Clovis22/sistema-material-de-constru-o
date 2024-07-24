package parteGrafica;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.io.*;

import javax.swing.JOptionPane;

public class App {
	private ImageIcon Mov_Principal = new ImageIcon(ClassLoader.getSystemResource("Aparencia/home.png"));
	private JLabel LB_Informacao = new JLabel();
	private int z = 450;
	private int a = 0;
	protected JFrame frame_apresentacao = new JFrame();
	private ImageIcon imagem = new ImageIcon(ClassLoader.getSystemResource("Aparencia/smc.jpg"));
	private JLabel img = new JLabel(imagem);
	private JProgressBar progresso = new JProgressBar();

	public App(){

		File dir = new File("c:/Sistema Material de Construcao");
		File arq = new File(dir,"Sistema_Material_de_Construcao.txt");
		
		if (dir.exists()){
			LB_Informacao.setText("<html><i><Body>Verificando Diretorio do Sistema</Body></i></html>");
		}else if (dir.mkdir()) {  
			LB_Informacao.setText("<html><i>Criando Diretorios do Sistema</i></html>");
		}

		progresso.setMinimum(a);   
		progresso.setMaximum(z);

		frame_apresentacao.addWindowListener( new WindowAdapter (){
			public void windowOpened(WindowEvent e){
				do{
					a++;
					progresso.setValue(a);
					progresso.setIndeterminate(true);
				}while(a > z);
			}});


		frame_apresentacao.add(LB_Informacao);
		frame_apresentacao.add(progresso);
		progresso.setBounds(01,387,497,10);
		frame_apresentacao.add(img);
		LB_Informacao.setBounds(01,220,350,250);
		frame_apresentacao.setUndecorated(true);
		
		frame_apresentacao.setSize(500,400);
		frame_apresentacao.setVisible(true);
		frame_apresentacao.setLocationRelativeTo(null);
		frame_apresentacao.show();
		frame_apresentacao.setIconImage(Mov_Principal.getImage());

	}

	public static void main(String[] args) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {//Padrao Laranja
				//	LB_Imagem.setIcon(new ImageIcon(ClassLoader.getSystemResource("Aparencia/Padrao.png")));
					UIManager.setLookAndFeel(info.getClassName());
					UIManager.put("nimbusBase", new Color(242,242,189));
					UIManager.put("nimbusBlueGrey", new Color(242,242,189));
					UIManager.put("control", new Color(242,242,189));
					//SwingUtilities.updateComponentTreeUI(frame_Menu);
					break;
				}
			}
		} catch (Exception e) {}


		App apresentacao = new App();

		for (int i = 0; i < 50; i++){

			if (i == 49)
				apresentacao.frame_apresentacao.hide();	

			try {    
				Thread.sleep(50);  
			}catch (InterruptedException e) {}
		}

		Principal p = new Principal();
		p.frame_Menu_Principal.show();

	}
}