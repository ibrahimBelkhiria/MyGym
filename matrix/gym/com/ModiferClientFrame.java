package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class ModiferClientFrame extends JFrame implements ActionListener {

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
	private Client client;

	/**
	 * Create the frame.
	 */
	public ModiferClientFrame(Client client) {
		setTitle("Modifier");
		this.client = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		nomField = new JTextField();
		nomField.setBounds(191, 38, 116, 20);
		nomField.setText(client.getNom());
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setText(client.getPrenom());
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
		ageField.setText(String.valueOf(client.getAge()));
		ageField.setBounds(191, 111, 60, 20);
		contentPane.add(ageField);
		
		cinField = new JFormattedTextField(maskCin);
		cinField.setText(client.getCin());
		cinField.setBounds(191, 142, 116, 20);
		contentPane.add(cinField);
		
		 phoneField = new JFormattedTextField(maskPhone);
		 phoneField.setText(String.valueOf(client.getPhone()));
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
		
		btnAjouter = new JButton("Modifier");
		btnAjouter.setForeground(new Color(0, 128, 0));
		btnAjouter.setBounds(323, 242, 89, 23);
		btnAjouter.addActionListener(this);
		contentPane.add(btnAjouter);
		
		JLabel lblAjouterUnClient = new JLabel("Modifier un client");
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
			
			Client client_local = new Client();
			client_local.setNom(this.nomField.getText());
			client_local.setPrenom(this.prenomField.getText());
			client_local.setAge(Integer.parseInt(this.ageField.getText()));
			client_local.setCin(this.cinField.getText());
			client_local.setPhone(Integer.parseInt(this.phoneField.getText()));
			
			if(rdbtnMale.isSelected()) {
				client_local.setGenre("male");
			}else if(rdbtnFemale.isSelected()) {
				client_local.setGenre("female");
			}
			
			
			
			Admin admin = new Admin();
			
			if (admin.modifierClient(client_local, client.getCin())== true) {
				JOptionPane.showMessageDialog(null, "Un client modifie avec success.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
			
			
			
		}else if (e.getSource()==btnAnuler) {
			this.dispose();
			
		}
		
	
		
	}

}
