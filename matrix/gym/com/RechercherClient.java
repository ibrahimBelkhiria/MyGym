package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class RechercherClient extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField formattedTextField;
	private JButton btnRechercher;
	protected Client client;
	protected Admin admin;
	private JLabel lblResultatnom;
	private JLabel lblResulatprenom;
	private JLabel lblResulatcin;
	private JLabel lblResultatgenre;
	private JLabel lblResulatage;
	private JLabel lblResultatphone;
	private JButton btnSupprimer;
	JButton btnModifier;
	
	
	public RechercherClient() {
		setTitle("Rechercher un client ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel labelCin = new JLabel("cin de client ");
		labelCin.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelCin.setBounds(23, 23, 93, 35);
		contentPane.add(labelCin);
		
		MaskFormatter maskFormatter=null;
		
		try {
			
			maskFormatter = new MaskFormatter("########");
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
	    formattedTextField = new JFormattedTextField(maskFormatter);
		formattedTextField.setBounds(150, 32, 101, 20);
		contentPane.add(formattedTextField);
		
			
		
		btnRechercher = new JButton("Rechercher ");
		btnRechercher.setBounds(286, 31, 117, 23);
		contentPane.add(btnRechercher);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 79, 434, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblResulatDeRecherche = new JLabel("Resulat de Recherche");
		lblResulatDeRecherche.setBounds(122, 11, 145, 34);
		panel.add(lblResulatDeRecherche);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 50, 56, 22);
		panel.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(10, 90, 56, 22);
		panel.add(lblPrenom);
		
		JLabel lblCin = new JLabel("cin :");
		lblCin.setBounds(10, 123, 46, 27);
		panel.add(lblCin);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(231, 56, 46, 14);
		panel.add(lblGenre);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(231, 92, 46, 18);
		panel.add(lblAge);
		
		JLabel lblPhone = new JLabel("   Phone :");
		lblPhone.setBounds(221, 125, 56, 22);
		panel.add(lblPhone);
		
	    lblResultatnom = new JLabel();
		lblResultatnom.setBounds(76, 54, 104, 14);
		panel.add(lblResultatnom);
		
		lblResulatprenom = new JLabel();
		lblResulatprenom.setBounds(76, 94, 104, 14);
		panel.add(lblResulatprenom);
		
		lblResulatcin = new JLabel();
		lblResulatcin.setBounds(76, 129, 81, 14);
		panel.add(lblResulatcin);
		
		lblResultatgenre = new JLabel();
		lblResultatgenre.setBounds(298, 56, 75, 14);
		panel.add(lblResultatgenre);
		
		lblResulatage = new JLabel();
		lblResulatage.setBounds(287, 94, 86, 14);
		panel.add(lblResulatage);
		
		lblResultatphone = new JLabel();
		lblResultatphone.setBounds(287, 129, 104, 14);
		panel.add(lblResultatphone);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(179, 273, 89, 23);
		contentPane.add(btnModifier);
		btnModifier.setEnabled(false);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(290, 273, 113, 23);
		contentPane.add(btnSupprimer);
		btnSupprimer.setEnabled(false);
		
		
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					admin= new Admin();
					client = new Client();
				
				String client_cin=formattedTextField.getText(); 
				
				client=admin.rechercherClientByName(client_cin);
				
				if(client!=null) {
					lblResultatnom.setText(client.getNom());
					lblResulatprenom.setText(client.getPrenom());
					lblResulatcin.setText(client.getCin());
					lblResulatage.setText(Integer.toString(client.getAge()));
					lblResultatgenre.setText(client.getGenre());
					lblResultatphone.setText(Integer.toString(client.getPhone()));
					
					btnModifier.setEnabled(true);
					btnSupprimer.setEnabled(true);
					
				}else {
					System.out.println("cin non trouvé !");
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "le client n'existe pas ou bien verifier le cin ","Message",JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
		});
																
		
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String client_cin=formattedTextField.getText();
				Client client = new Client(lblResultatnom.getText(), lblResulatprenom.getText(), lblResulatcin.getText(), lblResultatgenre.getText(), Integer.valueOf(lblResulatage.getText()), Integer.valueOf(lblResultatphone.getText()));
				
				System.out.println(client.toString());
				
				  ModiferClientFrame   modifierClient=new ModiferClientFrame(client);
				  modifierClient.setVisible(true);
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String client_cin=formattedTextField.getText();
				JOptionPane jOptionPane = new JOptionPane();
				int verification = jOptionPane.showConfirmDialog(null, "Vous etes sur ??");
				
				   if (verification ==JOptionPane.OK_OPTION) {
					Admin admin = new Admin();
					admin.supprimerClientByCin(client_cin);
					JOptionPane.showMessageDialog(null, "Un client supprimé avec success.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		
		
		
	}
}
