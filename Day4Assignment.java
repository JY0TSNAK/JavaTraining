
public class Day4Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirConditionerCompany airCondComObj = new AirConditionerCompany();
		airCondComObj.setOwner("Aparna");
		RawMaterial rm = new RawMaterial();
		AirConditioner airConObj = airCondComObj.manufactures(rm);
		Revenue r = airCondComObj.saleofAirConditionesr();
		ReportCard rc = airCondComObj.getFeedback(airConObj);

		
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
	
	Account openAccount() {
		Account acctObj = new Account();
		return acctObj;
	}
}

class Account {
		
}

final class DematAccount extends Account {
	
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
	String StockId;
	float price;
	
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
	static int booksAvailableToBorrow; //static
	
	void borrowBook(Book bookObj, Person p) {
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
