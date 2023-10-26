package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite prvi cijeli broj: ");
        int prviBroj = scanner.nextInt();

        System.out.println("Unesite drugi cijeli broj: ");
        int drugiBroj = scanner.nextInt();

        System.out.println("Unijeli ste sljedeće brojeve: " + prviBroj + " i " + drugiBroj);

        scanner.close();
    }

}