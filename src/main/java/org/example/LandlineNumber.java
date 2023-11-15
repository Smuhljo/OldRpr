package org.example;

import java.util.Objects;

/**
 * Class for landline phones
 *
 * @author Hana Mahmutović
 */
public class LandlineNumber extends PhoneNumber{

    private City city;
    private String number;

    public LandlineNumber(City city, String number) {
        if (null == city) throw new NumberException("Landline number is not OK!");
        this.city = city;
        this.number = number;
    }

    @Override
    public String print() {
        if (city != null && number != null){
            return city.getPhoneNumber()+"/"+number;
        }else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, number);
    }

    public City getCity() {
        return city;
    }

    public String getNumber() {
        return number;
    }
}