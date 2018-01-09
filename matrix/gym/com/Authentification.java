package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Authentification extends JFrame implements ActionListener {

	private JTextField fieldUsername;
	private JPasswordField passwordField;
	private JButton buttonConnecter;
	private JButton buttonAnuler;
	
	
	public Authentification() {
		// set the frame 
		this.setTitle("Authentification");
		this.setSize(600,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//this.setLayout(new FlowLayout());
		
		JPanel panelChamp = new JPanel();
		JPanel panelButtons = new JPanel();
		
		
		JLabel jLabelNom = new JLabel("votre nom :");
		JLabel jLabelPassword = new JLabel("Mot de passe :");
		
		fieldUsername = new JTextField(15);
		passwordField = new JPasswordField(15);
		buttonConnecter =new JButton("Connecter");
		buttonConnecter.addActionListener(this);
		buttonAnuler = new JButton("Annuler");
		buttonAnuler.addActionListener(this);
		
		this.setResizable(false);
		
		panelChamp.add(jLabelNom);
		panelChamp.add(fieldUsername);
		
		panelChamp.add(jLabelPassword);
		panelChamp.add(passwordField);
		
		panelButtons.add(buttonConnecter);
		panelButtons.add(buttonAnuler);
		
		this.add(panelChamp,BorderLayout.NORTH);
		this.add(panelButtons,BorderLayout.CENTER);
		
	}

	
	
	public boolean verifierAdmin(String name,String password) {
		
		BaseConnexion baseConnexion= new BaseConnexion();
		
		try {
			
			Statement statement = baseConnexion.getConnexion().createStatement();
			ResultSet resultSet= statement.executeQuery("select * from admin where nom='"+name+"' and password='"+password+"'");
			if(resultSet.next()) {
				System.out.println("admin exsit !");
				return true;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	     if(e.getSource()==buttonConnecter) {
	    	 
	    	 Boolean value=this.verifierAdmin(fieldUsername.getText(), passwordField.getText());
	    	 if(value==true) {
	    		 System.out.println("You are now connected");
	    		 this.dispose();
	    		new FirstInterface().setVisible(true);
	    	 }else {
	    		 System.out.println("verify your credentials!");
	    		 
	    JOptionPane jOptionPane = new JOptionPane();
	    jOptionPane.showMessageDialog(null, "S'il vous plait verifier vos inputs ! ","Erreur d'Authentification",JOptionPane.ERROR_MESSAGE);
	    		 
	    	 }
	    	 
	     }else if(e.getSource()==buttonAnuler) {
	    	
	    	System.exit(EXIT_ON_CLOSE);
	     }
		
	}	
	
	
	
	
	
	
	
}
