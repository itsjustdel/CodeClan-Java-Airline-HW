package People;

import Logistics.Flight;

import java.util.ArrayList;

public class Passenger extends Person{
    private int numberOfBags;
    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
        this.seatNumber = -1;
    }

    public int getBags() {
        return this.numberOfBags;
    }


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }
}
