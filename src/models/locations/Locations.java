/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locations;

/**
 *
 * @author aceng
 */
public class Locations {
    private int id;
    private String street_address;
    private String postal_code;
    private String city;
    private String state_province;
    private String country_id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return street_address;
    }
    
    public void setStreetAddress(String alamat) {
        this.street_address = alamat;
    }
    
    public String getPostalCode() {
        return postal_code;
    }
    
    public void setPostalCode(String kodepos) {
        this.postal_code = kodepos;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateProvince() {
        return state_province;
    }

    public void setStateProvince(String provinsi) {
        this.state_province = provinsi;
    }
    
    public String getCountry() {
        return country_id;
    }

    public void setCountry(String contryid) {
        this.country_id = contryid;
    }
    
    @Override
    public String toString() {
        String kembalian = "Locations{" + "id=" + id + ", alamat=" + street_address + 
               ", kodepos=" + postal_code + ", city=" + city + ", provinsi=" + state_province + 
               ", countryid=" + country_id +'}';
        return kembalian;
    }
}
