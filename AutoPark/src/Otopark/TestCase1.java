package Otopark;

import static org.junit.Assert.*;

import org.junit.*;

public class TestCase1 {
	// In this test case we are testing methods for all positive scenarios
	
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
    	test.addVehicle(subscription2.getVehicle());
		test.addVehicle(subscription3.getVehicle());
		
		try { // New vehicles enters the autopark
			test.vehicleEnters("34 EP 6932", new Time(12, 45), false, Date.getToday());
			test.vehicleEnters("34 ZEH 11", new Time(15, 01), false, Date.getToday());
			test.vehicleEnters("34 ASD 56", new Time(17, 30), false, Date.getToday());
			test.vehicleEnters("06 FZC 15", new Time(9, 17), false, Date.getToday());
			test.vehicleEnters("35 FB 19", new Time(16, 23), true, Date.getToday());
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
    
    @Test
    public void testIsValid() {
    	boolean output = subscription1.isValid(); //subscription is still valid
		assertEquals(true, output); // returns true
    }
    
    @Test
    public void testAddVehicle() {
    	boolean output = test.addVehicle(subscription1.getVehicle()); //add new subscription
    	assertEquals(true, output); //returns true
    }
    
    
    @Test
    public void testSearchVehicle() {
    	SubscribedVehicle vehicle = test.searchVehicle("34 ZEH 11"); //search for subscribed vehicle
		assertEquals(subscription2.getVehicle(), vehicle); //the vehicle is on the list
	}
    
    @Test
    public void testVehicleEnters() {
	    boolean output = false;
		try { 
			output = test.vehicleEnters("35 HB 1512", new Time(23, 20), true, Date.getToday()); //new vehicle enters to the auto park
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		}
		assertEquals(true, output);// returns true
	}
   
    
    @Test
    public void testIsParked() {
    	boolean output = test.isParked("34 EP 6932"); //isParked() for already parked vehicle
    	assertEquals(true, output); // returns true
    }
    
    @Test
    public void testVehicleExits() {
    	boolean output = false;
    	try {
    		output = test.vehicleExits("34 ASD 56", new Date(7, 5, 2019), new Time(17, 0)); //parked vehicle exits from the auto park
    	}
    	catch (Exception e){ 
    		e.printStackTrace();
    	}
    	assertEquals(true, output);//returns true
    }
    
    @Test
	public void testIncomeDaily() {
    	try {
    		test.vehicleExits("06 FZC 15", new Date(5, 5, 2019), new Time(1, 0)); // regular vehicle exits from auto park
    	}
    	catch (Exception e){ 
    		e.printStackTrace();
    	}
		assertEquals(180.0, test.getIncomeDaily(), 0); //income daily increases
	}
    
    @Test
	public void testCurrentCapacity() {
		assertEquals(95, test.getCurrentCapacity()); // current capacity decreases because of the before method
	}
   

}
