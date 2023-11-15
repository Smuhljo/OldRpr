package org.example;

import java.util.Objects;

public class InternationalNumber extends PhoneNumber{

    private String country;
    private String number;

    public InternationalNumber(String country, String number){
        this.country = country;
        this.number = number;
    }

    @Override
    public String print() {
        if (country != null && number != null){
            return country+number; //maybe different formatting of number
        }else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, number);
    }
}