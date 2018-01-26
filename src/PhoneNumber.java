import java.io.Serializable;

public class PhoneNumber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7897826019696566281L;
	private String type;
	private String number;

	public PhoneNumber(String type, String number) {
		this.type = type;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "\n   " + type + ": " + number;
	}
	
	

}
