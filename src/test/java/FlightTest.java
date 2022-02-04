import Logistics.Airport;
import Logistics.Flight;
import Logistics.Plane;
import People.CabinCrewMember;
import People.Passenger;
import People.Pilot;
import People.Rank;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    private Flight flight;
    private Pilot pilot;
    private ArrayList<CabinCrewMember> cabinCrewMembers;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport destinationAirport;
    private Airport departureAirport;
    private LocalDateTime departureTime;

    @Before
    public void before(){
        pilot = new Pilot("Bob", Rank.PILOT,"AH123456");

        CabinCrewMember cabinCrewMember = new CabinCrewMember("Robot",Rank.CABINCREW);
        cabinCrewMembers = new ArrayList<CabinCrewMember>();
        cabinCrewMembers.add(cabinCrewMember);
        cabinCrewMembers.add(cabinCrewMember);

        Passenger passenger = new Passenger("Robot",1);
        passengers = new ArrayList<Passenger>();
        passengers.add(passenger);
        passengers.add(passenger);

        plane = Plane.BIG;

        destinationAirport = Airport.EDI;
        departureAirport = Airport.GLA;

        departureTime = LocalDateTime.of(2022, Month.FEBRUARY, 20, 06, 30);

        flight = new Flight(pilot, cabinCrewMembers, passengers, plane, flightNumber, destinationAirport, departureAirport, departureTime);
    }

    @Test
    public void hasPilot() {
        assertEquals(this.pilot, flight.getPilot());
    }

    @Test
    public void hasCabinCrewMembers() {
        assertEquals(this.cabinCrewMembers, flight.getCabinCrewMembers());
    }

    @Test
    public void hasPassengers() {
        assertEquals(this.passengers, flight.getPassengers());
    }

    @Test
    public void hasPlane() {
        assertEquals(this.plane, flight.getPlane());
    }

    @Test
    public void hasDestinationAirport() {
        assertEquals(this.destinationAirport, flight.getDestinationAirport());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals(this.departureAirport, flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals(this.departureTime, flight.getDepartureTime());
    }

    @Test
    public void availableSeats(){
        assertEquals(98, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void canBookPassengerTrue() {
        assertEquals(true, flight.canBookPassenger());
    }

    @Test
    public void canBookPassengerFalse() {
        //populate new passenger list to capacity of new plane
        ArrayList<Passenger> lotsOfPassengers = new ArrayList<Passenger>();

        Plane fullPlane = Plane.MEGABIG;
        for(int i = 0;i <= fullPlane.getCapacity(); i++)
            lotsOfPassengers.add(new Passenger("Robot",1));

        Flight fullFlight = new Flight(pilot, cabinCrewMembers, lotsOfPassengers, fullPlane, flightNumber, destinationAirport, departureAirport, departureTime);

        assertEquals(false, fullFlight.canBookPassenger());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(new Passenger("Bernard", 2));
        assertEquals(3, flight.getPassengers().size());
    }

    @Test
    public void hasDate() {
        assertEquals(this.departureTime, flight.getDepartureTime());
    }
}
