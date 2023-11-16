package test;

import org.example.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {

    private static final Phonebook phonebook = new Phonebook();

    @BeforeAll
    public static void setup(){
        phonebook.add("Eldar", new LandlineNumber(City.SARAJEVO, "225-883"));
        phonebook.add("Dino", new LandlineNumber(City.ZENICA, "225-884"));
        phonebook.add("Amir", new MobileNumber(61, "225-885"));
        phonebook.add("Chris", new InternationalNumber("+44", "7768878794"));
    }

    @Test
    public void getNumberFound(){
        String number = phonebook.getNumber("Eldar");
        assertEquals(number, "033/225-883");
    }
    @Test
    public void getNumberNotFound(){
        String number = phonebook.getNumber("Elldaron");
        assertNull(number);
    }

    @Test
    public void addTestPositive(){
        PhoneNumber br = new MobileNumber(61, "507-855");
        phonebook.add("Andrew", br);

        String number = phonebook.getNumber("Andrew");
        assertEquals(number, "061/507-855");
    }

    @Test
    public void addLandlineException(){
        //old school
        assertThrows(NumberException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new LandlineNumber(null, "123-123");
            }
        });

        //lambda
        assertThrows(NumberException.class, () -> {new LandlineNumber(null, "123-123");});
    }

}