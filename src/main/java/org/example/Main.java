package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Molimo unesite broj za izračunavanje njegovog sinusa i faktorijela: ");
        String input = scanner.nextLine();

        try {
            double num = Double.parseDouble(input);
            System.out.println("Izračunavam sinus i faktorijel za broj: " + num);

            double sineValue = MathOperations.calculateSine(num);
            System.out.println("Sinus od " + num + " stepeni: " + sineValue);

            if (num < 0 || (int) num != num) {
                System.out.println("Faktorijel nije definisan za negativne ili necelobrojne brojeve.");
            } else {
                long factorialValue = MathOperations.calculateFactorial((int) num);
                System.out.println("Faktorijel od " + (int) num + ": " + factorialValue);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nevažeći unos. Molimo unesite broj.");
        }

        scanner.close();
    }
}
