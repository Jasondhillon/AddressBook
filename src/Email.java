import java.io.Serializable;

public class Email implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -391658302019078180L;
	String type;
	String email;

	public Email(String type, String email) {
		this.type = type;
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n   " + type + ": " + email;
	}
	
	
}
