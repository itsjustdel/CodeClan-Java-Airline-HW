import Logistics.Flight;
import Logistics.Plane;
import People.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    }

    @Test
    public void noDoubleBookingsTrue(){
        //book all the seats
        passengers.clear();
        for(int i = 0; i < flight.getPlane().getCapacity(); i++)
            flight.addPassenger(new Passenger("Robot",1));

        //check if all seat numbers are unique
        Set<Integer> uniques = new HashSet<Integer>();
        for (Passenger passenger : flight.getPassengers())
            uniques.add(passenger.getSeatNumber());

        //set size will match plane capacity if we have been successful
        //sets will not add any duplicates
        assertEquals(flight.getPlane().getCapacity(), uniques.size());
    }
}