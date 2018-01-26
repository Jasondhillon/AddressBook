
/*
 * @author Jason Dhillon
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{

	private static final long serialVersionUID = 6214457697162439444L;
	private String firstName;
	private String middleName;
	private String lastName;
	private ArrayList<PhoneNumber> phoneNumber = new ArrayList<PhoneNumber>();
	private ArrayList<Address> address = new  ArrayList<Address>();
	private ArrayList<String> group = new ArrayList<String>();
	private ArrayList<Email> email = new ArrayList<Email>();
	private String note;
	
	
		
	public Person(String firstName, String middleName, String lastName, String phoneNumberId, String phoneNumber, String addressId,
			String streetAddress, String city, String county, String state, String zip , String group, String emailId, String email, String note) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		createPhoneNumber(phoneNumberId, phoneNumber);
		createAddress(addressId, streetAddress, city, county, state, zip);
		this.group.add(group);
		createEmail(emailId, email);
		this.note = note;
	}
	
	public Person(String firstName, String middleName, String lastName, ArrayList<PhoneNumber> phoneNumber,
			ArrayList<Address> address , ArrayList<String> group, ArrayList<Email> email, String note) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.group = group;
		this.email = email;
		this.note = note;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder temp =  new StringBuilder(firstName +" " + middleName + " " + lastName);
		for(String g: group)
			temp.append(" (" + g.toString()+")");
		
		temp.append("\n----------------------------------------\nPhone:" );	
		for(PhoneNumber a: phoneNumber){
				temp.append(a.toString());	
		}
		
		temp.append("\n");
		for(int i = 1; i<=address.size(); i++) {
			if(address.size() > 1){
				temp.append("\nAddress "+ i + ": ");
				temp.append(address.get(i-1).toString());
			}else{
				temp.append("\nAddress: " + address.get(i-1).toString());
			}
		}
		
		temp.append("\n\nEmail:" );	
		for(Email a: email){
				temp.append(a.toString());	
		}
		
		temp.append("\n\nNote: "+note);
		return temp.toString();
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void addPhoneNumber(String a, String b){
		createPhoneNumber(a,b);
	}
	public ArrayList<PhoneNumber> getPhone(){
		return phoneNumber;
	}
	public void createPhoneNumber(String a, String b) {
		PhoneNumber temp = new PhoneNumber(a,b);
		phoneNumber.add(temp);
	}
	public ArrayList<Address> getAddress() {
		return address;
	}
	public void addAddress(String addressId, String streetAddress, String city, String county, String state, String zip) {
		createAddress(addressId, streetAddress, city, county, state, zip);
	}
	public ArrayList<String> getGroup() {
		return group;
	}
	public void addGroup(String group) {
		this.group.add(group);
	}
	public void addEmail(String a, String b){
		createEmail(a,b);
	}
	public ArrayList<Email> getEmail(){
		return email;
	}
	public void createEmail(String a, String b) {
		Email temp = new Email(a,b);
		email.add(temp);
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private void createAddress(String addressId, String streetAddress, String city, String county, String state, String zip){
		Address temp = new Address(addressId, streetAddress, city, county, state, zip);		
		address.add(temp);
	}
	
}
