import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI{
	ArrayList<Person> data;
	JFrame frame;
	JPanel mainPanel;
	JPanel addContactDialog;
	JPanel addPhoneDialog;
	JPanel addAddressDialog;
	JPanel addEmailDialog;
	JScrollPane contactsPanel;
	JTextArea details;
	JScrollPane detailsPanel;
	JMenuBar menuBar;
	JMenu menu1;
	JMenu menu2;
	EmployeeTableModel tableModel;
	JTable table;
	JTextField firstNameField;
	JTextField middleNameField;
	JTextField lastNameField;
	JTextField phoneNumberTypeField;
	JTextField phoneNumberField;
	JTextField addressTypeField;
	JTextField addressField;
	JTextField cityField;
	JTextField countyField;
	JTextField stateField;
	JTextField zipField;
	JTextField groupField;
	JTextField emailTypeField;
	JTextField emailField;
	JTextField noteField;

	public GUI() {
		//Retrieve the data from the file and populate the contacts/details panels
		getContactData();

		//Initialize basic components
		frame = new JFrame();
		mainPanel = new JPanel();
		details = new JTextArea("Click on a contact to see their details");
		detailsPanel = new JScrollPane(details);

		//Initialize MenuBar components
		menuBar = new JMenuBar();
		menu1 = new JMenu("File");
		menu2 = new JMenu("Edit");

		//Initialize JTable  components
		tableModel = new EmployeeTableModel(data);
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		contactsPanel = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 1){
					JTable target = (JTable)e.getSource();
					int row = table.convertRowIndexToModel(target.getSelectedRow());
					details.setText(tableModel.getValueAt(row, 5).toString());
					details.setCaretPosition(0);
				}
			}
		});
		table.setAutoCreateRowSorter(true);

		//Initialize JOption components
		firstNameField = new JTextField(5);
		middleNameField = new JTextField(5);
		lastNameField = new JTextField(5);
		phoneNumberTypeField = new JTextField(5);
		phoneNumberField = new JTextField(5);
		addressTypeField = new JTextField(5);
		addressField = new JTextField(5);
		cityField = new JTextField(5);
		countyField = new JTextField(5);
		stateField = new JTextField(5);
		zipField = new JTextField(5);
		groupField = new JTextField(5);
		emailTypeField = new JTextField(5);
		emailField = new JTextField(5);
		noteField = new JTextField(5);

		//Setup MenuBar
		setupMenuBar();

		//Setup the frame
		setupFrame();

	}

	public void getContactData(){
		SerializationRead read = new SerializationRead();
		data = read.getData();
	}
	

	public JPanel addContactDialog(){
		addContactDialog = new JPanel();
		firstNameField.setText("");
		middleNameField.setText("");
		lastNameField.setText("");
		phoneNumberTypeField.setText("");
		phoneNumberField.setText("");
		addressTypeField.setText("");
		addressField.setText("");
		cityField.setText("");
		countyField.setText("");
		stateField.setText("");
		zipField.setText("");
		groupField.setText("");
		emailTypeField.setText("");
		emailField.setText("");
		noteField.setText("");

		addContactDialog.setLayout(new BoxLayout(addContactDialog, BoxLayout.Y_AXIS));
		addContactDialog.add(new JLabel("First Name:"));
		addContactDialog.add(firstNameField);
		addContactDialog.add(new JLabel("Middle Name:"));
		addContactDialog.add(middleNameField);
		addContactDialog.add(new JLabel("Last Name:"));
		addContactDialog.add(lastNameField);
		addContactDialog.add(new JLabel("Phone Type:"));
		addContactDialog.add(phoneNumberTypeField);
		addContactDialog.add(new JLabel("Phone Number:"));
		addContactDialog.add(phoneNumberField);
		addContactDialog.add(new JLabel("Address Type:"));
		addContactDialog.add(addressTypeField);
		addContactDialog.add(new JLabel("Street Address:"));
		addContactDialog.add(addressField);
		addContactDialog.add(new JLabel("City:"));
		addContactDialog.add(cityField);
		addContactDialog.add(new JLabel("County:"));
		addContactDialog.add(countyField);
		addContactDialog.add(new JLabel("State:"));
		addContactDialog.add(stateField);
		addContactDialog.add(new JLabel("Zip:"));
		addContactDialog.add(zipField);
		addContactDialog.add(new JLabel("Group:"));
		addContactDialog.add(groupField);
		addContactDialog.add(new JLabel("Email Type:"));
		addContactDialog.add(emailTypeField);
		addContactDialog.add(new JLabel("Email:"));
		addContactDialog.add(emailField);
		addContactDialog.add(new JLabel("Note:"));
		addContactDialog.add(noteField);

		return addContactDialog;
	}
	

	public JPanel addPhoneNumberDialog(){
		addPhoneDialog = new JPanel();
		phoneNumberTypeField.setText("");
		phoneNumberField.setText("");

		addPhoneDialog.setLayout(new BoxLayout(addPhoneDialog, BoxLayout.Y_AXIS));
		addPhoneDialog.add(new JLabel("Phone Type:"));
		addPhoneDialog.add(phoneNumberTypeField);
		addPhoneDialog.add(new JLabel("Phone Number:"));
		addPhoneDialog.add(phoneNumberField);
		return addPhoneDialog;
	}

	
	public JPanel addAddressDialog(){
		addAddressDialog = new JPanel();
		addressTypeField.setText("");
		addressField.setText("");
		cityField.setText("");
		countyField.setText("");
		stateField.setText("");
		zipField.setText("");

		addAddressDialog.setLayout(new BoxLayout(addAddressDialog, BoxLayout.Y_AXIS));
		addAddressDialog.add(new JLabel("Address Type:"));
		addAddressDialog.add(addressTypeField);
		addAddressDialog.add(new JLabel("Street Address:"));
		addAddressDialog.add(addressField);
		addAddressDialog.add(new JLabel("City:"));
		addAddressDialog.add(cityField);
		addAddressDialog.add(new JLabel("County:"));
		addAddressDialog.add(countyField);
		addAddressDialog.add(new JLabel("State:"));
		addAddressDialog.add(stateField);
		addAddressDialog.add(new JLabel("Zip:"));
		addAddressDialog.add(zipField);

		return addAddressDialog;
	}

	
	public JPanel addEmailDialog(){
		addEmailDialog = new JPanel();
		emailTypeField.setText("");
		emailField.setText("");

		addEmailDialog.setLayout(new BoxLayout(addEmailDialog, BoxLayout.Y_AXIS));
		addEmailDialog.add(new JLabel("Email Type:"));
		addEmailDialog.add(emailTypeField);
		addEmailDialog.add(new JLabel("Email:"));
		addEmailDialog.add(emailField);

		return addEmailDialog;
	}

	//Most of the operations are here
	
	public void setupMenuBar(){
		JMenuItem deleteFile = new JMenuItem("Delete saveInstance");
		deleteFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File saveInstance = new File("saveInstance.txt");
				saveInstance.delete();
				frame.dispose();
			}});
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}});
		JMenuItem add = new JMenuItem("Add Contact");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, addContactDialog(), 
						"Please Enter A New Contact", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION){
					Person temp = new Person(firstNameField.getText(), middleNameField.getText(),
							lastNameField.getText(), phoneNumberTypeField.getText(), phoneNumberField.getText(),
							addressTypeField.getText(), addressField.getText(), cityField.getText(), countyField.getText(),
							stateField.getText(), zipField.getText(), groupField.getText(), emailTypeField.getText(),
							emailField.getText(), noteField.getText());
					data.add(temp);
					tableModel.fireTableDataChanged();
					saveData();
				}
			}});
		JMenuItem delete = new JMenuItem("Delete Contact");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete\n" +
							table.getValueAt(table.getSelectedRow(), 0), "Delete Contact?", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.OK_OPTION){	
						data.remove(tableModel.getValueAt(table.getSelectedRow(), 5));
						tableModel.fireTableDataChanged();
						details.setText("Click on a contact to see their details");
						saveData();
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Please select a contact first");
				}
			}});
		JMenuItem addPhone = new JMenuItem("Add Phone Number");
		addPhone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int result = JOptionPane.showConfirmDialog(frame, addPhoneNumberDialog(),"Add a New Phone Number for " + tableModel.getValueAt(table.getSelectedRow(), 0), JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){	
						Person temp = (Person)tableModel.getValueAt(table.getSelectedRow(), 5);
						temp.addPhoneNumber(phoneNumberTypeField.getText(), phoneNumberField.getText());
						details.setText((tableModel.getValueAt(table.getSelectedRow(), 5).toString()));
						details.setCaretPosition(0);
						saveData();
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Please select a contact first");
				}
			}});
		JMenuItem addAddress = new JMenuItem("Add Address");
		addAddress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int result = JOptionPane.showConfirmDialog(frame, addAddressDialog(),"Add a New Address for " + tableModel.getValueAt(table.getSelectedRow(), 0), JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){	
						Person temp = (Person)tableModel.getValueAt(table.getSelectedRow(), 5);
						temp.addAddress(addressTypeField.getText(), addressField.getText(), cityField.getText(), countyField.getText(), stateField.getText(), zipField.getText());
						details.setText((tableModel.getValueAt(table.getSelectedRow(), 5).toString()));
						details.setCaretPosition(0);
						saveData();
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Please select a contact first");
				}
			}});
		JMenuItem addEmail = new JMenuItem("Add Email");
		addEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int result = JOptionPane.showConfirmDialog(frame, addEmailDialog(),"Add a New Email Address for " + tableModel.getValueAt(table.getSelectedRow(), 0), JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){	
						Person temp = (Person)tableModel.getValueAt(table.getSelectedRow(), 5);
						temp.addEmail(emailTypeField.getText(), emailField.getText());
						details.setText((tableModel.getValueAt(table.getSelectedRow(), 5).toString()));
						details.setCaretPosition(0);
						saveData();
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Please select a contact first");
				}
			}});	

		//Add menu to bar
		menu1.add(deleteFile);
		menu1.add(exit);
		menu2.add(add);
		menu2.add(delete);
		menu2.addSeparator();
		menu2.add(addPhone);
		menu2.add(addAddress);
		menu2.add(addEmail);
		menuBar.add(menu1);
		menuBar.add(menu2);
	}
	

	public void setupFrame(){
		//Stylize lists
		contactsPanel.getViewport().getView().setFont(new Font("Dialog", Font.BOLD, 18));
		contactsPanel.setPreferredSize(new Dimension(600, 0));
		detailsPanel.getViewport().getView().setFont(new Font("Dialog", Font.PLAIN, 16));

		//Add the panels to the mainPanel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(contactsPanel);
		mainPanel.add(detailsPanel);

		//Add menuBar and mainPanel to the frame
		frame.setJMenuBar(menuBar);
		frame.add(mainPanel);

		//Frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("AddressBook");
		ImageIcon icon = new ImageIcon("icon.png");
		frame.setIconImage(icon.getImage());
		frame.setSize(1000,230);
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -frame.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -frame.getHeight()/2);
		frame.setVisible(true);
	}

	@SuppressWarnings("serial")
	public void saveData(){
		new File("saveInstance.txt"){{delete();}};
		new SerializationWrite(new File("saveInstance.txt"), data);
	}
}