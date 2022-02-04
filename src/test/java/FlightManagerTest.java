import Logistics.Airport;
import Logistics.Flight;
import Logistics.FlightManager;
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

import static junit.framework.TestCase.assertEquals;

public class FlightManagerTest {

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
    public void totalPassengerBagAllowance() {
        assertEquals(500.0, FlightManager.totalPassengerBagAllowance(this.flight));
    }

    @Test
    public void calculateBaggageWeightPerPassenger() {
        assertEquals(5.0, FlightManager.baggageWeightPerPassenger(this.flight));
    }

    @Test
    public void currentBaggageWeight() {
        assertEquals(20.0, FlightManager.currentBaggageWeight(this.flight));
    }

    @Test
    public void remainingBaggageAllowance() {
        assertEquals(480.0, FlightManager.remainingBaggageAllowance(this.flight));
    }
}
