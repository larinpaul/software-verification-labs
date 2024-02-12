package org.example;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.*;

import java.util.ArrayList;
import java.util.List;

public class XChartTest {

    public static void main(String[] args) {

        // Constants
        final double x = 2.0;
        final double epsilon = 0.001;

        // Create an array of N values
        List<Integer> nValues = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            nValues.add(i);
        }

        // Create an array of sum values
        List<Double> sumValues = new ArrayList<>();
        for (int n : nValues) {
            double sum = sumOfSeries(x, n, epsilon);
            sumValues.add(sum);
        }

        // Create a new XYChart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Sum of Series").xAxisTitle("Number of Series Members").yAxisTitle("Sum of Series").build();

        // Add the data to the chart
        chart.addSeries("Sum of Series for x=" + x, nValues.stream().mapToDouble(Integer::doubleValue).toArray());

        // Show the chart
        new SwingWrapper(chart).displayChart();

        // Print the result
        double result = sumOfSeries(x, 100, epsilon);
        System.out.println("The sum of the series with a precision of " + epsilon + " for x=" + x + " is " + result + ".");
    }

    public static double sumOfSeries(double x, int n, double epsilon) {
        double sum = 0;
        double a = Math.pow(x, 2) / 49;
        double r = Math.pow(x, 2) / 49;
        for (int i = 0; i < n; i++) {
            sum += a;
            r *= Math.pow(x, 2) / 49;
            a *= r;
        }
        return sum;
    }
}