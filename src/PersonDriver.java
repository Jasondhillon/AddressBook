import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author Jason Dhillon
 * COP - 2805C
 * Professor Jeho Park
 * Fall 2017
 */

public class PersonDriver  implements Serializable{

	private static final long serialVersionUID = -1827583478851155723L;

	public static void main(String[] args) {
		ArrayList<Person> toWrite = new ArrayList<Person>();
		File saveInstance = new File("saveInstance.txt");
		if(!saveInstance.exists()) {

			Person a = new Person("Jason", "", "Dhillon", "Personal", "407-777-7777", "Personal",  "0000 Orlando Ave.", "Orlando", "Orange", "Florida", "32828", "Me","Personal", "jason@dhillon.com", "This is a note");
			toWrite.add(a);
			
			Person b = new Person("Kristen", "G", "Vogel", "Personal", "740-717-5688", "Personal", "3964 Viking Drive", "Orlando", "Orange", "Florida", "32828", "Coworker", "Personal", "KristenGVogel@armyspy.com", "This is a note");
			b.addPhoneNumber("Work", "321-111-1111");
			
			Person c = new Person("Jacinta", "W", "Miller", "Personal", "518-974-7552", "Personal", "1673 Elk Rd Little", "Orlando", "Orange", "Florida", "32828", "Friend", "Personal", "JacintaWMiller@dayrep.com", "This is a note");
			c.addPhoneNumber("Work","407-000-0000");
			c.addPhoneNumber("Cell","412-231-4321");
			toWrite.add(c);
			
			Person d = new Person("Mark", "V", "Sanford", "Personal", "215-255-9854","Personal",   "4576 Burning Memory Lane", "Orlando", "Orange", "Florida", "32828", "Coworker","Personal",  "MarkVSanford@armyspy.com", "This is a note");
			d.addAddress("Work","1885 Hershell Hollow Road", "Everett", "", "Washington", "98208");
			toWrite.add(d);
			
			Person e = new Person("Leslie", "S", "Rowen", "Personal", "720-281-7344", "Personal",  "3234 Davis Lane", "Orlando", "Orange", "Florida", "32828", "Coworker","Personal",  "LeslieSRowen@armyspy.com", "This is a note");
			e.addAddress("Work","2442 Hall Street", "Las Vegas", "", "Nevada", "89101" );
			e.addAddress("Vacation Home","1108 Marshall Street", "Hanover", "", "Maryland", "21076");
			toWrite.add(e);
			
			Person f = new Person("David", "K", "Le","Personal",  "484-548-8148","Personal",   "4358 Franklee Lane", "Orlando", "Orange", "Florida", "32828", "Friend","Personal",  "DavidKLe@teleworm.us", "This is a note");
			f.addEmail("Work", "David.Le@yahoo.com");
			toWrite.add(f);
			
			Person g = new Person("Kenneth ", "B", "Wieland","Personal",  "313-232-2958", "Personal",  "4140 Nash Street", "Orlando", "Orange", "Florida", "32828", "Coworker", "Personal", "KennethBWieland@teleworm.us", "This is a note");
			g.addEmail("Work","Kenneth.Wieland@yahoo.com");
			g.addEmail("Work2","K.Wieland@gmail.com");
			toWrite.add(g);
			
			Person h = new Person("Lawrence", "C", "Rosa", "Personal", "814-217-8999",  "Personal", "3838 Collins Street", "Orlando", "Orange", "Florida", "32828", "Coworker", "Personal", "LawrenceCRosa@rhyta.com", "This is a note");
			toWrite.add(h);
			
			Person i = new Person("Alvin", "D", "Campbell", "Personal", "231-286-5249",  "Personal", "4071 Wetzel Lane", "Orlando", "Orange", "Florida", "32828", "Family", "Personal", "AlvinDCampbell@jourrapide.com", "This is a note");
			toWrite.add(i);
			
			Person j = new Person("Lindsey", "B", "Doby", "Personal", "315-329-8555",  "Personal", "4246 Oak Street", "Orlando", "Orange", "Florida", "32828", "Client", "Personal", "LindseyBDoby@dayrep.com", "This is a note");
			toWrite.add(j);
			
//			for(int z = 1; z<=toWrite.size();z++){
//				System.out.println("Person " + z + ": \n------------\n" + toWrite.get(z-1)+"\n\n");
//			}
			new SerializationWrite(saveInstance, toWrite);
			new GUI();
	
		}else{
			new GUI();
		}
		
	}
}
