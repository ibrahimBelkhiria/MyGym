package matrix.gym.com;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;

public class PanelClientTable extends JPanel {
	
	private ResultSet resultat;
	private Statement statement;
	private BaseConnexion connexion;
	private JTable table;
	private JPopupMenu popup;
	private JMenuItem deleteItem;
	private JMenuItem modifierItem;
	private TableClientModel clientModel;
	
	
	public PanelClientTable() {
		this.setLayout(new BorderLayout());
	
		
		popup = new JPopupMenu();
		deleteItem = new JMenuItem("supprimer le client selectioneé");
		modifierItem = new JMenuItem("modifier le client selectioneé");
		popup.add(deleteItem);
		popup.add(modifierItem);
		
		
		
		String request="SELECT * from client";
		connexion = new  BaseConnexion();
		try
		{
			statement = connexion.getConnexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      	resultat=statement.executeQuery(request);
		
		}catch(SQLException e)
		{
		
			e.printStackTrace();
		}
		
		clientModel = new TableClientModel(resultat);
		table = new JTable();
		JScrollPane jScrollPane = new JScrollPane(table);
		
		table.setModel(clientModel);
		this.add(jScrollPane, BorderLayout.CENTER);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { 
			
				if(e.getButton()==e.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
					
				}
			}
		});
		
	
		
		
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				int client_id= (int)table.getValueAt(row, 0);
				
					System.out.println(row);
					JOptionPane jOptionPane = new JOptionPane();
					int verification = jOptionPane.showConfirmDialog(table, "Vous etes sur ??");
					
				   if (verification ==JOptionPane.OK_OPTION) {
					
					clientModel.removeRow(row,client_id);
					
				}
				
			}
		});
		
		
		
		modifierItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				System.out.println(row);
				System.out.println((String)table.getValueAt(row, 1));
				Client client = new Client((String)table.getValueAt(row, 1),(String) table.getValueAt(row, 2),(String) table.getValueAt(row, 4),(String) table.getValueAt(row, 6), (int)table.getValueAt(row, 3),(int) table.getValueAt(row, 5));
				
			     ModiferClientFrame clientFrame = new ModiferClientFrame(client);
			     clientFrame.setVisible(true);
				
			}
		});
		
		
	}
	
	
	
	
	
	
	

}
