package org.example;

/**
 * Enum for area landline phones inside the Bosnia
 * @author Hana Mahmutović
 */
public enum City {
    TRAVNIK("030"),
    ODZAK("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    POSUSJE("039"),
    BRCKO("049"),
    MRKONJIC_GRAD("050"),
    BANJA_LUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    SAMAC("054"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    FOCA("058"),
    TREBINJE("059");

    private String phoneNumber;

    City(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public static City fromPhoneNumber(String phoneNumber){
        for(City g: City.values()){
            if (g.getPhoneNumber().equals(phoneNumber)){
                return g;
            }
        }
        return null;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}