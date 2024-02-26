package Helper;

public class AirportInfo {
    public String ICAO, name, city;
    public ProvinceInfo province;

    public AirportInfo(String ICAO, String name, String city, ProvinceInfo province) {
        this.ICAO = ICAO;
        this.name = name;
        this.city = city;
        this.province = province;
    }
    
   
}
