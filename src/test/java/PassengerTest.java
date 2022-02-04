import Logistics.Flight;
import Logistics.Plane;
import People.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
;

public class PassengerTest {

    private Passenger passenger;
    private Flight flight;
    private Plane plane;
    private ArrayList<Passenger> passengers;
    @Before
    public void before(){


        passenger = new Passenger("Bob",4);
        passengers = new ArrayList<Passenger>();
        passengers.add(passenger);

        plane = Plane.BIG;
        flight = new Flight(null,null, passengers, plane,
                null,null,null,null);
    }

    @Test
    public void hasNameBob(){
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void hasBags4(){
        assertEquals(4, passenger.getBags());
    }

    @Test
    public void canSetAndGetFlight()
    {
        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void hasAssignedFlight() {

        flight.addPassenger(passenger);
        assertEquals(passenger.getFlight(), flight);
    }

    @Test
    public void hasSeatNumber() {
        flight.assignSeatNumber(passenger);
        //check for range
        int seatNumber = passenger.getSeatNumber();
        assertTrue(seatNumber < flight.getPlane().getCapacity());
        assertTrue(seatNumber > 0);

        //TODO add 100 passengers and check for all seats unique

    }
}
