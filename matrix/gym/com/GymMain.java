package matrix.gym.com;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class GymMain {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		Authentification authentification= new Authentification();
		authentification.setVisible(true);
		
	}

		
}
