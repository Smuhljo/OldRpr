package org.example;

import java.util.Scanner;

public class Main {

    public static int sumaCifara(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number n: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int sum = sumaCifara(i);
            if (sum != 0 && i % sum == 0) {
                System.out.println(i);
            }
        }
    }
}
