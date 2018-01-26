import java.io.Serializable;

public class Address  implements Serializable{

	private static final long serialVersionUID = -4572175691860111819L;
	private String type;
	private String streetAddress;
	private String city;
	private String county;
	private String state;
	private String zip;
	

	public Address(String type, String streetAddress, String city, String county, String state, String zip) {
		super();
		this.type = type;
		this.streetAddress = streetAddress;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zip = zip;
	}


	@Override
	public String toString() {
		return "\n   Type: " + type +"\n   Street: " + streetAddress + "\n   City: " + city + "\n   County: " + county + "\n   State: " + state + "\n   Zipcode: " + zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
