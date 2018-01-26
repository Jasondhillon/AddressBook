import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializationWrite implements Serializable{

	private static final long serialVersionUID = 597488397844365520L;

	public SerializationWrite(File saveInstance, ArrayList<Person> toWrite){
		ObjectOutputStream out;

		try{
			saveInstance.createNewFile();
			out = new ObjectOutputStream(
				new FileOutputStream("saveInstance.txt"));
			out.writeObject(toWrite);
			out.close();
			

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println("Wrote objects into file successfully");
	}

}

