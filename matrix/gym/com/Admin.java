package matrix.gym.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {

	private String nom;
	private String password;
	private BaseConnexion baseConnexion;
	private Statement statement;
	private ResultSet resultatRecherche;
	private Client client;
	
	
	public Admin( ) {
		
		
	}
	
	
	
	public boolean ajouterClient(Client client) {
		String sql="insert into client(nom,prenom,age,cin,phone,genre) values(?,?,?,?,?,?)";
		baseConnexion = new BaseConnexion();
		
		try {
			PreparedStatement preparedStatement = this.baseConnexion.getConnexion().prepareStatement(sql);
			
			preparedStatement.setString(1,client.getNom());
			preparedStatement.setString(2,client.getPrenom());
			preparedStatement.setInt(3, client.getAge());
			preparedStatement.setString(4, client.getCin());
			preparedStatement.setInt(5, client.getPhone());
			preparedStatement.setString(6, client.getGenre());
			preparedStatement.executeUpdate();
			System.out.println("Record inserted succesfully");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	
		
		
	}
	
	
	
	public  Boolean modifierClient(Client client,String client_cin) {
		
			String sql="update client set nom=?,prenom=?,age=?,cin=?,phone=?,genre=? where cin="+client_cin;
			baseConnexion = new BaseConnexion();
		try {
			
			 PreparedStatement  statement = baseConnexion.getConnexion().prepareStatement(sql);
			 statement.setString(1,client.getNom());
			 statement.setString(2,client.getPrenom());
			 statement.setInt(3, client.getAge());
			 statement.setString(4, client.getCin());
			 statement.setInt(5, client.getPhone());
			 statement.setString(6, client.getGenre());
			 statement.executeUpdate();
			 statement.executeUpdate();
			 System.out.println("update avec success");
			 return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void supprimerClient(int client_id) {
	
		String sql="delete from client where id ="+client_id;
		baseConnexion = new BaseConnexion();
		try {
			statement = baseConnexion.getConnexion().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	
	public void supprimerClientByCin(String client_cin) {
		
		String sql="delete from client where cin="+client_cin;
		baseConnexion = new BaseConnexion();
		try {
			statement = baseConnexion.getConnexion().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	
	
	
	
	
	
	public  Client rechercherClientByName(String client_cin) {
		
		String sql ="select * from client where cin="+client_cin;
		
		baseConnexion = new BaseConnexion();
		try {
			
			Statement statement =  baseConnexion.getConnexion().createStatement();
			resultatRecherche = statement.executeQuery(sql);
			
			//
			if(resultatRecherche.next()) {
				System.out.println(resultatRecherche.getString("nom"));
			String nom = resultatRecherche.getString("nom");					
			String prenom = resultatRecherche.getString("prenom");
			int age = resultatRecherche.getInt("age");
			int phone = resultatRecherche.getInt("phone");
			String cin = resultatRecherche.getString("cin");
			String genre = resultatRecherche.getString("genre");
			client = new Client(nom, prenom, cin, genre, age, phone);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}	
			
			return client;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

	
}
