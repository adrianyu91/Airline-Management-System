package AirlineManagement;

import java.util.ArrayList;

public class FlightsPrototype {
    private static FlightsPrototype fltsObject;
    private ArrayList<Flight> flights = new ArrayList<>();
    private FlightsPrototype(){
        flights.add(new Flight(0, 293, "CYYZ", "CYYC", new Aircraft("B737", 150), 1709703936, 240));
        flights.add(new Flight(1, 194, "CYHM", "CYPQ", new Aircraft("B777", 300), 1709221675, 37));
    }
    
    public static FlightsPrototype getInstance(){
        if (fltsObject == null)
            fltsObject = new FlightsPrototype();
        return fltsObject;
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }
}
