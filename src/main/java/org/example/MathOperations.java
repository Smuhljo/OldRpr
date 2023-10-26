package org.example;

public class MathOperations {
    public static double calculateSine(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return Math.sin(angleInRadians);
    }

    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
