/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author student
 */
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
