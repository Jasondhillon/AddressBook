import javax.swing.table.*;
import java.util.*;

public class EmployeeTableModel  extends AbstractTableModel{
	
	private static final long serialVersionUID = -91249378017634916L;
	private static final int COLUMN_NAME = 0;
	private static final int COLUMN_NUMBER = 1;
	private static final int COLUMN_ADDRESS = 2;
	private static final int COLUMN_GROUP = 3;
	private static final int COLUMN_EMAIL = 4;
	private static final int COLUMN_PERSON = 5;
	private String[] columnNames = {"Name","Number","Address", "Group", "Email"};
	private List<Person> Person;

	public EmployeeTableModel(List<Person> listEmployees){
		this.Person = listEmployees;

	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return Person.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = Person.get(rowIndex);
		Object retVal = null;
		switch(columnIndex){
			case COLUMN_NAME: retVal = person.getFirstName()+ " " +person.getMiddleName()+ " " +person.getLastName(); break;
			case COLUMN_NUMBER: retVal = person.getPhone().get(0).getNumber(); break;
			case COLUMN_ADDRESS: retVal = person.getAddress().get(0).getStreetAddress(); break;
			case COLUMN_GROUP: retVal = person.getGroup().get(0).toString(); break;
			case COLUMN_EMAIL: retVal = person.getEmail().get(0).getEmail(); break;
			case COLUMN_PERSON: retVal = person; break;
			default: throw new IllegalArgumentException("Invalid column index.");
		}
		return retVal;
	}
	@Override
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex){
		if(Person.isEmpty()) return Object.class;
		else return getValueAt(0, columnIndex).getClass();
	}
	
   public String[] getColumnNames(){
      return columnNames;
   }
   public void addRow(Person person){
	   Person.add(person);
   }
}
