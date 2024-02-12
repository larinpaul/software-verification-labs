package org.example;

import org.knowm.xchart.*;

import java.util.Random;

public class XChartTestOld {

    public static void main(String[] args) {

        // Create a new XYChart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("XChart Test").xAxisTitle("X").yAxisTitle("Y").build();

        // Add some sample data to the chart
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            double x = i;
            double y = random.nextDouble() * 10;
            chart.addSeries("Series " + i, new double[] { x }, new double[] { y });
        }

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}