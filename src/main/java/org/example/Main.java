package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        List<Double> brojevi = new ArrayList<>();

        while (true) {
            System.out.println("Unesite broj ili 'stop' za završetak: ");
            String unos = skener.nextLine();

            if (unos.equalsIgnoreCase("stop")) {
                break;
            } else {
                try {
                    double broj = Double.parseDouble(unos);
                    brojevi.add(broj);
                } catch (NumberFormatException e) {
                    System.out.println("Nevažeći unos. Ponovite unos.");
                }
            }
        }

        if (brojevi.isEmpty()) {
            System.out.println("Lista je prazna. Nema statistika za prikaz.");
        } else {
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            double suma = 0;

            for (double broj : brojevi) {
                if (broj < min) min = broj;
                if (broj > max) max = broj;
                suma += broj;
            }

            double srednjaVrijednost = suma / brojevi.size();

            double sumaKvadratnihOdudaranja = 0;
            for (double broj : brojevi) {
                sumaKvadratnihOdudaranja += Math.pow(broj - srednjaVrijednost, 2);
            }

            double standardnaDevijacija = Math.sqrt(sumaKvadratnihOdudaranja / brojevi.size());

            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Srednja vrijednost: " + srednjaVrijednost);
            System.out.println("Standardna devijacija: " + standardnaDevijacija);
        }

        skener.close();
    }
}
