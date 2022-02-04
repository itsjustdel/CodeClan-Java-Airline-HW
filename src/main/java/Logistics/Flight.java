package Logistics;

import People.CabinCrewMember;
import People.Passenger;
import People.Pilot;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {
    private final Pilot pilot;
    private final ArrayList<CabinCrewMember> cabinCrewMembers;
    private final ArrayList<Passenger> passengers;
    private final Plane plane;
    private final String flightNumber;
    private final Airport destinationAirport;
    private final Airport departureAirport;
    private final LocalDateTime departureTime;

    public Flight(Pilot pilot, ArrayList<CabinCrewMember> cabinCrewMembers,
                  ArrayList<Passenger> passengers, Plane plane, String flightNumber,
                  Airport destinationAirport, Airport departureAirport, LocalDateTime departureTime) {

        this.pilot = pilot;
        this.cabinCrewMembers = cabinCrewMembers;
        this.passengers = passengers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public ArrayList<CabinCrewMember> getCabinCrewMembers() {
        return cabinCrewMembers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getNumberOfAvailableSeats(){
        return this.plane.getCapacity() - this.passengers.size();
    }

    public boolean canBookPassenger() {
        return this.passengers.size() < this.plane.getCapacity();
    }

    public void addPassenger(Passenger newPassenger){
        //add to passenger list
        this.passengers.add(newPassenger);

        //also give this flight instance to the passenger
        newPassenger.setFlight(this);

        //now book seat
        assignSeatNumber(newPassenger);
    }

    public void assignSeatNumber(Passenger passenger){

        ArrayList<Integer> availableSeats = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            //add index if it is not in already booked seats
            boolean foundMatch = false;
            for(int j = 0; j < this.passengers.size(); j++){
                if(i == this.passengers.get(j).getSeatNumber())
                {
                    //we found a booked seat, flag and break out of j loop
                    foundMatch = true;
                    break;
                }
            }

            if(!foundMatch) {
                //this seat is available, save in list
                availableSeats.add(i);
            }
        }

        int random = getRandomNumber(0,availableSeats.size() );
        passenger.setSeatNumber( availableSeats.get(random) );
    }

    //random number helper
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
