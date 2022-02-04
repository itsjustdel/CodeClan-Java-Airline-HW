package Logistics;

import People.Passenger;

import java.util.ArrayList;

public class FlightManager {

    public static double totalPassengerBagAllowance(Flight flight){
        return flight.getPlane().getTotalWeight() / 2;
    }

    public static double baggageWeightPerPassenger(Flight flight){
        double weightPerPassenger = totalPassengerBagAllowance(flight) / flight.getPlane().getCapacity();
        return weightPerPassenger;
    }

    public static double currentBaggageWeight(Flight flight){
        //loop through all passengers, get bag amount
        ArrayList<Passenger> passengers = flight.getPassengers();
        int totalBags = 0;
        for(Passenger passenger: passengers)
        {
            totalBags += passenger.getBags();
        }

        int standardBagWeight = 10;
        return totalBags * standardBagWeight;
    }

    public static double remainingBaggageAllowance(Flight flight) {
        return totalPassengerBagAllowance(flight) - currentBaggageWeight(flight);
    }
}
