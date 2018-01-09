package matrix.gym.com;

import javax.swing.JFrame;

public class TableauDesClients extends JFrame {

	
	public TableauDesClients() {
	
		this.setTitle("Tableau des Clients ");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		
		
		PanelClientTable panelClientTable = new PanelClientTable();
		this.add(panelClientTable);
		
	
	}
	
	
	
	
}
