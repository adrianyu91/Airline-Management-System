package AirlineManagement;

public class Aircraft {
    String aircraftType;
    int max_seats;

    public String getAircraftType() {
        return aircraftType;
    }

    public int getMax_seats() {
        return max_seats;
    }

    public Aircraft() {

    }
    public Aircraft(String aircraftType, int max_seats) {
        this.aircraftType = aircraftType;
        this.max_seats = max_seats;
    }

    
}
