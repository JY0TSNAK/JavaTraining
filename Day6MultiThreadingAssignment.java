
public class Day6MultiThreadingAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManufacturingUnit muObj1 = new ManufacturingUnit(101, "Mumbai");
		ManufacturingUnit muObj2 = new ManufacturingUnit(102, "Hyderabad");
		ManufacturingUnit muObj3 = new ManufacturingUnit(103, "Chennai");
		
		muObj1.start();
		muObj2.start();
		muObj3.start();

	}

}

class ManufacturingUnit extends Thread {
	
	int unitId;
	String location;
	
	public ManufacturingUnit(int unitId, String location) {
		super();
		this.unitId = unitId;
		this.location = location;
	}
	
	public void run() {
		for (int i=0; i<=100; i++) {
			System.out.println("Unit " + unitId + " at " + location+ " is manufacturing Product Number :" +unitId+ "_"+i);
		}
	}
	
}