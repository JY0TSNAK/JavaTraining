import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Log> logAL = new ArrayList<Log>();
		System.out.println("Array List");
		logAL.add(new Log("Missed", LocalDate.of(2022, 3, 20), "abc"));
		logAL.add(new Log("Dialed", LocalDate.of(2022, 3, 21), "abc"));
		logAL.add(new Log("Received", LocalDate.of(2022, 3, 22), "def"));
		
		for (int i = 0; i < logAL.size(); i++) {
			System.out.println("Log Details : " + logAL.get(i));
		}
		System.out.println("-----------------------");
		
		//Linked List
		LinkedList<Contact> contactLL = new LinkedList<Contact>();
		System.out.println("Linked List");
		contactLL.add(new Contact("abc", 1234567890L, "abc@gm.com"));
		contactLL.add(new Contact("def", 4567891230L, "def@rm.com"));
		contactLL.add(new Contact("ghi", 7891234560L, "ghi@gm.com"));
		
		for (int i = 0; i < contactLL.size(); i++) {
			System.out.println("Contact Details : " + contactLL.get(i));
		}
		System.out.println("-----------------------");
		
		//Hash Set
		HashSet<Book> bookHS = new HashSet<Book>();
		System.out.println("Hash Set");
		bookHS.add(new Book("ISBN-10_0544340620", "abc", "xyz", 250));
		bookHS.add(new Book("ISBN-11_4565412312", "hkj", "bmm", 100));
		bookHS.add(new Book("ISBN-12_7656235630", "sdfs", "gdf", 50));
		
		Iterator<Book> iteratorBookHS = bookHS.iterator();
		while(iteratorBookHS.hasNext()) {
			Book theBook = iteratorBookHS.next();
			System.out.println("Book Details : " + theBook);
		}
		System.out.println("-----------------------");
		
		//Tree Set
		TreeSet<ChemicalElement> chemicalElementTS = new TreeSet<ChemicalElement>();
		System.out.println("Tree Set");
		System.out.println("Chemical Element Tree Set is created..");
		
		System.out.println("Adding Element 1..");
		chemicalElementTS.add(new ChemicalElement(1, "Hydrogen", "H", 1.0078d));
		System.out.println("Adding Element 2..");
		chemicalElementTS.add(new ChemicalElement(2, "Helium", "He", 4.0026d));
		System.out.println("Adding Element 3..");
		chemicalElementTS.add(new ChemicalElement(3, "Lithium", "Li", 6.9410d));
		System.out.println("Adding Element 4..");
		chemicalElementTS.add(new ChemicalElement(4, "Beryllium", "Be", 9.0122d));
		System.out.println("Adding Element 5..");
		chemicalElementTS.add(new ChemicalElement(5, "Boron", "B", 10.811d));
		
		Iterator<ChemicalElement> iteratorCETS = chemicalElementTS.iterator();
		while(iteratorCETS.hasNext()) {
			ChemicalElement thechemicalElement = iteratorCETS.next();
			System.out.println("Chemical Element Details : " + thechemicalElement);
		}
		System.out.println("-----------------------");
	}

}

class Log { 
	// Array List
	String logType; //missed, dialed, received
	LocalDate logDate;
	String name;
	public Log(String logType, LocalDate logDate, String name) {
		super();
		this.logType = logType;
		this.logDate = logDate;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Log [logType=" + logType + ", logDate=" + logDate + ", name=" + name + "]";
	}
	
	
}

class Contact {
	// Linked List
	String contactName;
	Long mobileNumber;
	String emailAddr;
	public Contact(String contactName, Long mobileNumber, String emailAddr) {
		super();
		this.contactName = contactName;
		this.mobileNumber = mobileNumber;
		this.emailAddr = emailAddr;
	}
	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", mobileNumber=" + mobileNumber + ", emailAddr=" + emailAddr
				+ "]";
	}
	
	
}

class ChemicalElement implements Comparable<ChemicalElement> {
	//Tree Set
	int atomicNumber;
	String atomicName;
	String atomicSymbol;
	double atomicMass;
	public ChemicalElement(int atomicNumber, String atomicName, String atomicSymbol, double atomicMass) {
		super();
		this.atomicNumber = atomicNumber;
		this.atomicName = atomicName;
		this.atomicSymbol = atomicSymbol;
		this.atomicMass = atomicMass;
	}
	@Override
	public String toString() {
		return "ChemicalElement [atomicNumber=" + atomicNumber + ", atomicName=" + atomicName + ", atomicSymbol="
				+ atomicSymbol + ", atomicMass=" + atomicMass + "]";
	}
	@Override
	public int compareTo(ChemicalElement o) {
		// TODO Auto-generated method stub
		System.out.println("Comparing " + atomicSymbol + " with " + o.atomicSymbol);
		return atomicSymbol.compareTo(o.atomicName);
	}
	
	
	
	
}

class Book {
	//Hash Set
	String isbnNumber;
	String bookName;
	String author;
	int numOfPages;
	public Book(String isbnNumber, String bookName, String author, int numOfPages) {
		super();
		this.isbnNumber = isbnNumber;
		this.bookName = bookName;
		this.author = author;
		this.numOfPages = numOfPages;
	}
	@Override
	public String toString() {
		return "Book [isbnNumber=" + isbnNumber + ", bookName=" + bookName + ", author=" + author + ", numOfPages="
				+ numOfPages + "]";
	}
	
	
}