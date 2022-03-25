
public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RawMaterial rw = new RawMaterial("Parts");
		CarManufacturingUnit cmuObj = new CarManufacturingUnit(123);
		cmuObj.makeNew(rw);
		
		DriveSafe ds = new DriveSafe();
		AlertDriving.driveWithoutSleep(ds);
	}

}

class RawMaterial {
	String material;

	public RawMaterial(String material) {
		super();
		this.material = material;
	}
		
}

interface Manufacturing {
	void makeNew(RawMaterial rw);
}

class ManufacturingUnit {
	int unitId;

	public ManufacturingUnit(int unitId) {
		super();
		this.unitId = unitId;
	}
	
}

class CarManufacturingUnit extends ManufacturingUnit implements Manufacturing {

	
	public CarManufacturingUnit(int unitId) {
		super(unitId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeNew(RawMaterial rw) {
		// TODO Auto-generated method stub
		System.out.println("Manufacturing Car at Unit " + this.unitId + " using " + rw.material);
		
	}
	
}


interface Sleeping {
	void sleep();
}

interface Driving {
	void drive();
}

class DriveSafe implements Sleeping, Driving {

	@Override
	public void drive() {
		System.out.println("Do not drive while sleeping");
		
	}

	@Override
	public void sleep() {
		System.out.println("Sleeping");
		
	}
}

class AlertDriving {
	
	static void driveWithoutSleep(Driving d) {
		d.drive();
	}
}