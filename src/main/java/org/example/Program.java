package org.example;

import java.util.Scanner;
        import java.util.Set;

public class Program {
    public static Scanner scanner = new Scanner(System.in);
    public static Phonebook phonebook = new Phonebook();

    public static void main(String[] args) {
        fillData();
        while(true){
            System.out.println("Enter command [add, getNumber, getName, onLetter, fromCity, fromCityNumbers, phonebook, exit]");
            String command = scanner.nextLine();
            switch (command){
                case "add":
                    addNumber();
                    break;
                case "getNumber":
                    getNumber();
                    break;
                case "getName":
                    getName();
                    break;
                case "onLetter":
                    onLetter();
                    break;
                case "fromCity":
                    fromCity();
                    break;
                case "fromCityNumbers":
                    fromCityNumbers();
                    break;
                case "phonebook":
                    printPhonebook();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command.");
            }
        }
    }
    private static void fromCityNumbers(){
        System.out.println("Enter city name: ");
        String city = scanner.nextLine();
        try{
            City c = City.valueOf(city);
            Set<PhoneNumber> response = phonebook.fromCityNumbers(c);
            for (PhoneNumber number : response){
                System.out.println(number.print());
            }
        }catch (Exception e){
            System.out.println("Wrong city");
            return;
        }
    }
    private static void fromCity(){
        System.out.println("Enter city name: ");
        String grad = scanner.nextLine();
        try{
            City c = City.valueOf(grad);
            Set<String> response = phonebook.fromCity(c);
            System.out.println(response);
        }catch (Exception e){
            System.out.println("Wrong city");
            return;
        }
    }
    private static void onLetter(){
        System.out.println("Enter first letter of the name: ");
        String c = scanner.nextLine();
        String response = phonebook.onLetter(c.toCharArray()[0]);
        System.out.println(response);
    }
    private static void getName() {
        PhoneNumber number = enterPhoneNumber();
        String name = phonebook.getName(number);
        if(name == null){
            System.out.println("Doesnt exist in phonebook!");
        }else{
            System.out.println("Number owner "+ number.print()+" je "+ name);
        }
    }
    private static PhoneNumber enterPhoneNumber(){
        System.out.println("Enter number type[landline, mobile, international]:");
        String type = scanner.nextLine();
        switch (type){
            case "landline":
                System.out.println("Enter landline: ");
                String landline = scanner.nextLine();
                System.out.println("Enter number: ");
                String number = scanner.nextLine();
                return new LandlineNumber(City.fromPhoneNumber(landline), number);
            case "mobile":
                System.out.println("Enter network: ");
                int network = scanner.nextInt();
                String mobileNumber = scanner.nextLine();
                System.out.println("Enter number: ");
                mobileNumber = scanner.nextLine();
                return new MobileNumber(network, mobileNumber);
            case "international":
                System.out.println("Enter country code [+387]: ");
                String code = scanner.nextLine();
                System.out.println("Enter number: ");
                String intNumber = scanner.nextLine();
                return new InternationalNumber(code, intNumber);
        }
        return null;
    }
    private static void addNumber(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        PhoneNumber number = enterPhoneNumber();
        phonebook.add(name, number);
    }

    private static void printPhonebook(){
        System.out.println(phonebook.toString());
    }

    private static void getNumber(){
        System.out.println("Enter name: ");
        String ime = scanner.nextLine();
        String result = phonebook.getNumber(ime);
        System.out.println(result == null ? "Not in Phonebook!" : result);
    }

    private static void fillData(){
        phonebook.add("Eldar", new LandlineNumber(City.SARAJEVO, "225-883"));
        phonebook.add("Dino", new LandlineNumber(City.ZENICA, "225-884"));
        phonebook.add("Amir", new MobileNumber(61, "225-885"));
        phonebook.add("Chris", new InternationalNumber("+44", "7768878794"));
    }
}