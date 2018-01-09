package matrix.gym.com;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;



public class TableClientModel extends AbstractTableModel {

	
	private String[] ColumnsName;
	private Class[] ColumnClass;
	private int columnCount;
	private List<Object[]> data;
	

	public TableClientModel(ResultSet resultat) {
	
		try{
			ResultSetMetaData resultSetMetaData = resultat.getMetaData();
			columnCount= resultSetMetaData.getColumnCount();
			
			ColumnsName = new String[columnCount];
			ColumnClass = new Class[columnCount];
			
			for(int i=1;i<=columnCount;i++){
				ColumnsName[i-1]=resultSetMetaData.getColumnName(i);
				ColumnClass[i-1]=Class.forName(resultSetMetaData.getColumnClassName(i));
			}
			
			
			data = new ArrayList<Object[]>();
		
		
		while(resultat.next()){
			
			Object[] temp = new Object[columnCount];
			
			for(int i=0;i<columnCount;i++){
				temp[i]=resultat.getObject(i+1);
				
			} 
			
			data.add(temp);
			
		}
		
		
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}

		
		
		
		
	}
	
	
	@Override
	public int getColumnCount() {
		
		return columnCount;
	}

	@Override
	public int getRowCount() {
		
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return   ((Object[])(data.get(row)))[col];
	}

	 
	
	public  String getColumnName(int col)
	{
		return this.ColumnsName[col];
	}	
	
	
	public void removeRow(int row,int client_id) {
		Admin admin = new Admin();
		admin.supprimerClient(client_id);
		data.remove(row);
		this.fireTableRowsDeleted(row, row);
	}
		
	
}
