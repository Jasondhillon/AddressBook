import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializationRead implements Serializable{

	private static final long serialVersionUID = 8507285645906252064L;
	
	private ArrayList<Person> temp;

	@SuppressWarnings("unchecked")
	public SerializationRead(){
		ObjectInputStream in;

		try{
			in = new ObjectInputStream(new FileInputStream("saveInstance.txt"));
			temp =  (ArrayList<Person>) in.readObject();
			System.out.println("Read objects from file successfully");
			in.close();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Person> getData(){
		return temp;
	}

}


