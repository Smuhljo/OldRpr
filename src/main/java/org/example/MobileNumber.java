package org.example;

import java.util.Objects;

/**
 * Class for mobile phone numbers
 *
 * @author Hana Mahmutović
 */
public class MobileNumber extends PhoneNumber{

    private int mobileNetwork;
    private String number;

    public MobileNumber(int mobileNetwork, String number){
        this.mobileNetwork = mobileNetwork;
        this.number = number;
    }

    @Override
    public String print() {
        if (number != null){
            return "0"+mobileNetwork+"/"+number;
        }else{
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNetwork, number);
    }
}