
public class Day4Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirConditionerCompany airCondComObj = new AirConditionerCompany();
		airCondComObj.setOwner("Aparna");
		
		RawMaterial rm = new RawMaterial();
		System.out.println("Total numer of Air Conditioners manufactured : " + AirConditionerCompany.totalNumberofACs);
		AirConditioner airConObj1 = airCondComObj.manufactures(rm);
		AirConditioner airConObj2 = airCondComObj.manufactures(rm);
		System.out.println("Total numer of Air Conditioners manufactured : " + AirConditionerCompany.totalNumberofACs);
		
		Revenue r = airCondComObj.saleofAirConditionesr();
		
		ReportCard rc = airCondComObj.getFeedback(airConObj1);
		
		DematAccount daNum = new DematAccount(123, airCondComObj.ownerObj.name);
		Trading t = new Trading(daNum, 456, 500.0f);
		
		Library l = new Library();
		Book b = new Book();
		l.borrowBook(b, airCondComObj.ownerObj);
		System.out.println("Available number books in library : " + Library.booksAvailableToBorrow);
		
		KFC kfcObj = new KFC();
		Food f = kfcObj.buyKFCFood();
		
		
		//Toy newToy = new Toy();
		//Shirt newShirt = new Shirt();
	}
}

class Person {
	String name;
	
}

class Owner extends Person { //isA
	
}

class Bank {
	
	Branch openBranch() {
		Branch branchObj = new Branch();
		return branchObj;
	}
}

class Branch {
	
	Account openAccount(int acctNum, String acctHolderName) {
		Account acctObj = new Account(acctNum, acctHolderName);
		return acctObj;
	}
}

class Account {
	int acctNum;
	String acctHolderName;
	public Account(int acctNum, String acctHolderName) {
		super();
		this.acctNum = acctNum;
		this.acctHolderName = acctHolderName;
	}
	
}

final class DematAccount extends Account {

	public DematAccount(int acctNum, String acctHolderName) {
		super(acctNum, acctHolderName);
		// TODO Auto-generated constructor stub
	}

	
}

class Company {

}

class AirConditionerCompany extends Company { // isA
	
	Company Id;
	Owner ownerObj = new Owner(); //hasA
	int capital;
	RawMaterial rm;
	static int totalNumberofACs; //static
	
	void setOwner (String ownerName) {
		this.ownerObj.name = ownerName;
		System.out.println(this.ownerObj.name + " is owner of Air Conditioner Company");
	}
	
	//producesA					usesA
	final AirConditioner manufactures(RawMaterial rm) //final
	{
		AirConditioner ac = new AirConditioner();
		System.out.println("Manufacturing Air Conditioner");
		totalNumberofACs++;
		return ac;
		
	}
	
	Revenue saleofAirConditionesr() {
		Revenue r = new Revenue();
		System.out.println("Sale of Air Conditioners");
		return r;
	}
	
	ReportCard getFeedback(AirConditioner ac)
	{
		ReportCard rc = new ReportCard();
		System.out.println("Report Card of Air Conditioner");
		return rc;
	}
	
}

class Revenue {
	
}

class RawMaterial {
	
}

class AirConditioner {
	int acId;
	
}

class Hotel {
	
	
}

class Restaurant {

}

class FoodRestaurant extends Restaurant {

}

class HolidayHome {

}

class FeedbackForm {

}

class ReportCard extends FeedbackForm {

}

class Trading {
	DematAccount da;
	int StockId;
	float price;
	public Trading(DematAccount da, int stockId, float price) {
		super();
		this.da = da;
		StockId = stockId;
		this.price = price;
		System.out.println(da.acctHolderName + " does trading");
	}
	
	
}


class Laptop {

}

class Movie {

	
}

class Book {
	int bookId;
	String bookName;
}

class Library {
	static int booksAvailableToBorrow = 100; //static
	
	void borrowBook(Book bookObj, Person p) {
		System.out.println(p.name + " borrowed book to read");
		booksAvailableToBorrow--;
	}
}

class Toy {
	
}

class Shirt {
		
}

class ClassRoom {
	
}

class LearningGuitar {
	
}

class Aquarium {
	void visitAquarium() {
	 System.out.println("Visiting Aquarium");	
	}
}

class KFC extends FoodRestaurant {
	Food buyKFCFood () {
		Food foodObj = new Food();
		System.out.println("Buying KFC");
		return foodObj;
	}
}

class Food {
	
}

class Vehicle {
	
}

class TwoWheeler extends Vehicle {
	void drive() {
		System.out.println("Driving two wheeler");
	}
}

class Gas {
	GasBill useGas() {
		GasBill gb = new GasBill();
		return gb;
	}
}

class GasBill {
	int gasBillId;
	void payGasBill(int gasBillId) {
		System.out.println("Paying Gas Bill");
	}
}

class Customer extends Person {
	int customerId;
}

class GasCustomer extends Customer {
	int gasConnectionId;
}
