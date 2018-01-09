package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;

public class FormulaireInscription extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField nomField;
	private JTextField prenomField;
	private JFormattedTextField ageField;
	private JFormattedTextField cinField;
	private JFormattedTextField phoneField;
	private JButton btnAjouter;
	private JButton btnAnuler;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	/**
	 * Create the frame.
	 */
	public FormulaireInscription() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nomField = new JTextField();
		nomField.setBounds(191, 38, 116, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setBounds(191, 80, 116, 20);
		contentPane.add(prenomField);
		prenomField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(120, 41, 46, 14);
		contentPane.add(lblNom);
		
		
		/**
		 * definie des Mask pour les formatted text field 
		 */
		
		
		MaskFormatter maskAge=null;
		MaskFormatter maskCin=null;
		MaskFormatter maskPhone=null;
		
		try {
           
            maskAge = new MaskFormatter("##");
            
            
            maskCin=new MaskFormatter("########");
            maskPhone = new MaskFormatter("########");
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		
		 ageField = new JFormattedTextField(maskAge);
		ageField.setBounds(191, 111, 60, 20);
		contentPane.add(ageField);
		
		 cinField = new JFormattedTextField(maskCin);
		cinField.setBounds(191, 142, 116, 20);
		contentPane.add(cinField);
		
		 phoneField = new JFormattedTextField(maskPhone);
		phoneField.setBounds(191, 173, 116, 20);
		contentPane.add(phoneField);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(106, 83, 100, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(120, 114, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblCin = new JLabel("Cin :");
		lblCin.setBounds(120, 145, 46, 14);
		contentPane.add(lblCin);
		
		JLabel lblTel = new JLabel("Tel :");
		lblTel.setBounds(120, 176, 46, 14);
		contentPane.add(lblTel);
		
		 btnAnuler = new JButton("Anuler ");
		btnAnuler.setForeground(Color.RED);
		btnAnuler.addActionListener(this);
		
		btnAnuler.setBounds(203, 242, 89, 23);
		contentPane.add(btnAnuler);
		
		 btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(new Color(0, 128, 0));
		btnAjouter.setBounds(323, 242, 89, 23);
		btnAjouter.addActionListener(this);
		contentPane.add(btnAjouter);
		
		JLabel lblAjouterUnClient = new JLabel("Ajouter un client");
		lblAjouterUnClient.setFont(new Font("Calibri", Font.BOLD, 14));
		lblAjouterUnClient.setBounds(163, 11, 161, 16);
		contentPane.add(lblAjouterUnClient);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		
		 rdbtnMale = new JRadioButton("male");
		rdbtnMale.setBounds(176, 200, 109, 23);
		contentPane.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setBounds(303, 200, 109, 23);
		contentPane.add(rdbtnFemale);
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setBounds(120, 204, 46, 14);
		contentPane.add(lblSexe);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnAjouter) {
			
			Client client = new Client();
			client.setNom(this.nomField.getText());
			client.setPrenom(this.prenomField.getText());
			client.setAge(Integer.parseInt(this.ageField.getText()));
			client.setCin(this.cinField.getText());
			client.setPhone(Integer.parseInt(this.phoneField.getText()));
			
			if(rdbtnMale.isSelected()) {
				client.setGenre("male");
			}else if(rdbtnFemale.isSelected()) {
				client.setGenre("female");
			}
			
			
			
			Admin admin = new Admin();
			//admin.ajouterClient(client);
			if (admin.ajouterClient(client)==true) {
				JOptionPane jOptionPane = new JOptionPane();
				jOptionPane.showMessageDialog(null, "Un client est ajouté  a votre club.","Confirmation",jOptionPane.INFORMATION_MESSAGE);
				this.refresh();
			}else {
				
			}
			
			
			
		}else if (e.getSource()==btnAnuler) {
			this.dispose();
			
		}
		
		
		
		
	}
	
	
	
	public void refresh() {
		this.ageField.setText("");
		this.phoneField.setText("");
		this.prenomField.setText("");
		this.nomField.setText("");
		this.cinField.setText("");
		this.rdbtnFemale.setSelected(false);
		this.rdbtnMale.setSelected(false);
		
	}
	
	
}
