package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

public class FirstInterface extends JFrame implements ActionListener{

	
	private PanelPhoto panelImage;
	private JPanel panelChoix;
	private BufferedImage image;
	private JButton ButtonParcourrir;
	private JButton buttonRechercherClient;
	private JButton buttonStatistiques;
	private JButton ButtonAjouter;
	
	

	/**
	 * Create the frame.
	 */
	public FirstInterface() {
		this.setTitle("Matrix Gym");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 2));
		
		try {
			image = ImageIO.read(new File("gym.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
         panelImage= new PanelPhoto();
		
		panelImage.setBi(image);
		getContentPane().add(panelImage);
		
		panelChoix = new JPanel();
		
		ButtonParcourrir = new JButton("Afficher les donnees ");
		ButtonParcourrir.setBounds(69, 76, 179, 23);
		panelChoix.add(ButtonParcourrir);
		
		ButtonAjouter = new JButton("Ajouter un client ");
		ButtonAjouter.setBounds(69, 139, 179, 23);
		panelChoix.add(ButtonAjouter);
		
		buttonRechercherClient = new JButton("Rechercher un client ");
		buttonRechercherClient.setBounds(69, 204, 179, 23);
		panelChoix.add(buttonRechercherClient);

		
		ButtonParcourrir.addActionListener(this);
		ButtonAjouter.addActionListener(this);
		buttonRechercherClient.addActionListener(this);
		//buttonStatistiques.addActionListener(this);
		
		
		
		panelChoix.setLayout(null);
		
		JLabel lblBienvenuChezMatrix = new JLabel("Bienvenu chez  Matrix Gym ");
		lblBienvenuChezMatrix.setForeground(UIManager.getColor("List.foreground"));
		lblBienvenuChezMatrix.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblBienvenuChezMatrix.setBounds(27, 11, 221, 36);
		panelChoix.add(lblBienvenuChezMatrix);
	    getContentPane().add(panelChoix);
	
	     setResizable(false);
	
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ButtonParcourrir) {
			System.out.println("parcouriri clicked");
			TableauDesClients clients = new TableauDesClients();
			clients.setVisible(true);
			
		}else if(e.getSource()==ButtonAjouter) {
			System.out.println("ajouter clicked");
			FormulaireInscription formulaireInscription= new FormulaireInscription();
			formulaireInscription.setVisible(true);
		}else if (e.getSource()==buttonRechercherClient) {
			System.out.println("rechercher clicked");
			
			RechercherClient rechercher = new RechercherClient();
			rechercher.setVisible(true);
			
		}else if(e.getSource()==buttonStatistiques) {
			System.out.println("statistique clicked");
		}
		
		
		
		
	}
}
