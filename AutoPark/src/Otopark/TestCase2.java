package Otopark;

import static org.junit.Assert.*;
import org.junit.*;

public class TestCase2 {
	//In this test case we are testing all methods for negative scenarios
	
	Subscription subscription1 = new Subscription("34 FAZ 07", new Date(7, 6, 1998), new Date(10, 5, 2020));
    Subscription subscription2 = new Subscription("34 ZEH 11", new Date(11, 11, 1999), new Date(11, 11, 2019));
    Subscription subscription3 = new Subscription("34 ASD 56", new Date(15, 4, 2000), new Date(3, 5, 2019)); //subscription ended
    RegularVehicle vehicle2 = new RegularVehicle("34 EP 6932");
    RegularVehicle vehicle3 = new RegularVehicle("06 FZC 15");
    OfficialVehicle vehicle4 = new OfficialVehicle("35 HB 1512");
    OfficialVehicle vehicle5 = new OfficialVehicle("35 FB 19");
	AutoPark test = new AutoPark(12, 100);
	
	@Before
    public void setUp() {
    	Date.setToday(new Date(4, 5, 2019));
    	test.addVehicle(subscription1.getVehicle());
    	test.addVehicle(subscription2.getVehicle());
		test.addVehicle(subscription3.getVehicle());
		
		try { // New vehicles enters the autopark
			test.vehicleEnters("34 EP 6932", new Time(12, 45), false, Date.getToday());
			test.vehicleEnters("34 ZEH 11", new Time(15, 01), false, Date.getToday());
			test.vehicleEnters("35 HB 1512", new Time(23, 20), true, Date.getToday());
			test.vehicleEnters("34 ASD 56", new Time(17, 30), false, Date.getToday());
			test.vehicleEnters("06 FZC 15", new Time(9, 17), false, Date.getToday());
			test.vehicleEnters("35 FB 19", new Time(16, 23), true, Date.getToday());
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		}
		
		try {
    		test.vehicleExits("35 FB 19", new Date(5, 5, 2019), new Time(1, 0)); // regular vehicle exits from auto park
    	}
    	catch (Exception e){ }
	}
	
	@Test
	public void testIsValid() {
		boolean output = subscription3.isValid(); //subscription ended
		assertEquals(false, output); // returns false
	}
	
	@Test
    public void testAddVehicle() {
    	boolean output = test.addVehicle(subscription2.getVehicle()); // try to add already added vehicle
    	assertEquals(false, output); // returns false
    }
	
	@Test
    public void testSearchVehicle() {
    	SubscribedVehicle vehicle = test.searchVehicle("34 ABC 11"); //search for the plate that does not exist
		assertEquals(null, vehicle); //returns null
	}
	
	@Test
    public void testVehicleEnters() {
		try { 
			test.vehicleEnters("34 ASD 56", new Time(17, 30), false, Date.getToday()); //enters the vehicle that already entered
		}
		catch(Exception e) { 
			assertEquals("This vehicle is already parked", e.getMessage());// throws new AlreadyParkedException
		}
	}
	
	@Test
    public void testIsParked() {
		boolean output = test.isParked("35 FB 19"); //isParked() for vehicle that already exited
    	assertEquals(false, output); // returns false
    }
	
	@Test
    public void testVehicleExits() {
    	try {
    		test.vehicleExits("35 FB 19", new Date(7, 5, 2019), new Time(17, 0)); //vehicle that already exited try to exit from auto park
    	}
    	catch (Exception e){ 
    		assertEquals("Vehicle is not parked in autopark!", e.getMessage()); // throws new VehicleIsNotParkedException
    	}
    }
	
	@Test
	public void testIncomeDaily() {
		System.out.println(test.getIncomeDaily());
    	try {
    		test.vehicleExits("34 ASD 56", new Date(6, 5, 2019), new Time(1, 0)); // subscription-ended vehicle exits from auto park
    	}
    	catch (Exception e){ 
    		e.printStackTrace();
    	}
    	System.out.println(test.getIncomeDaily());
		assertEquals(372.0, test.getIncomeDaily(), 0); //income daily increases
	}
	
	@Test
	public void testCurrentCapacity() {
		assertEquals(95, test.getCurrentCapacity()); // current capacity decreases because of the before method
	}
	
	@Test
	public void testCapacityFullSituation() {
		test.setCapacity(5);
		
		try { 
			test.vehicleEnters("34 ABC 56", new Time(17, 30), false, Date.getToday()); //enters new vehicle
		}
		catch(Exception e) { 
			assertEquals("The capacity is full!", e.getMessage());// throws new FullCapacityException
		}
		
	}

}
