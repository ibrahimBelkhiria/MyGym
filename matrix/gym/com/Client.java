package matrix.gym.com;

public class Client {

	
	private String nom ;
	private String prenom;
	private String cin ;
	private String Genre;
	private int age;
	private int phone;
	
	
	public Client(String nom, String prenom, String cin, String genre, int age, int phone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		Genre = genre;
		this.age = age;
		this.phone = phone;
	}



	public Client() {
	
		
	}

	
	
	public String getGenre() {
		return Genre;
	}


	public void setGenre(String genre) {
		Genre = genre;
	}

	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", Genre=" + Genre + ", age=" + age
				+ ", phone=" + phone + "]";
	}

	
	
}
