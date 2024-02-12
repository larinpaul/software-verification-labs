package org.example;

public class GeometricSeries {
    public static double sum(double x, double epsilon) {
        // Initialize the first term and the partial sum
        double a1 = x / 36.0;
        double sn = a1;
        int n = 1;

        // Calculate the sum of the series until the difference between
        // the current partial sum and the previous partial sum is less than epsilon
        while (true) {
            // Calculate the next term in the series
            double an = a1 * Math.pow(2.0 / 36.0, n);

            // Calculate the new partial sum
            double sn_new = sn + an;

            // Check if the difference between the current partial sum and the previous partial sum is less than epsilon
            if (Math.abs(sn_new - sn) < epsilon) {
                return sn_new;
            }

            // Update the partial sum and the term number
            sn = sn_new;
            n++;
        }
    }

    public static void main(String[] args) {
        double x = 1.0;
        double epsilon = 1e-6;
        double sum = sum(x, epsilon);
        System.out.println("The sum of the series is: " + sum);
    }
}