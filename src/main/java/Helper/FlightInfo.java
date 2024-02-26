package Helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FlightInfo {
    public int id;
    public int durationMinutes;
    public float ticketPrice;
    public AirportInfo origin, destination;
    public String timeDeparture;
    public AircraftInfo aircraft;
    public int seatsAvailable = 3;

    public FlightInfo(int id, int durationMinutes, float ticketPrice, AirportInfo origin, AirportInfo destination, String timeDeparture, AircraftInfo aircraft) {
        this.id = id;
        this.durationMinutes = durationMinutes;
        this.ticketPrice = ticketPrice;
        this.origin = origin;
        this.destination = destination;
        this.timeDeparture = timeDeparture;
        this.aircraft = aircraft;
    }
    public int getId() {
        return id;
    }
    public boolean isAvailable(){
        return (getRemainingSeats() > 0);
    }
    public int getRemainingSeats() {
        return this.seatsAvailable;
    }
public double getPrice()
    {
        return this.ticketPrice;
    }
    public String getOrigin() {
        return this.origin.ICAO;
    }

    public String getDepartureTime() {
        //return new SimpleDateFormat("HH:mm").format(this.timeDeparture);
        return this.timeDeparture.split("\\ ")[1];
    }
    public String getDate(){
        //return new SimpleDateFormat("yyyy-MM-dd").format(this.timeDeparture);
        return this.timeDeparture.split("\\ ")[0];
    }
    public int getFlightDuration() {
        return this.durationMinutes;
    }

    public String getDestination() {
        return this.destination.ICAO;
    }
    // for testing
    public void bookSeat(){
        this.seatsAvailable -=1;
    }
}
