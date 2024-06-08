package org.example.auto_test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class NumberProcessorTest {

    public static void main(String[] args) {
        XYSeries series = new XYSeries("Время выполнения");

        for (int numCount = 1000; numCount <= 1000000; numCount += 1000) {
            String fileName = "test.txt";
            try {
                FileWriter writer = new FileWriter(fileName);
                for (int i = 1; i <= numCount; i++) {
                    writer.write(1 + " ");
                }
                writer.close();
            } catch (IOException e) {
                fail("Failed to write numbers to file");
            }
            long startTime = System.currentTimeMillis();
            try {
                String[] arg = {fileName};
                Main.main(arg);
            } catch (Exception e) {
                fail("Exception occurred during execution: " + e.getMessage());
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            series.add(numCount, duration);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Зависимость времени выполнения от количества чисел в файле",
                "Количество чисел в файле", "Время выполнения (мс)",
                dataset);

        // Calculate linear regression parameters
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < series.getItemCount(); i++) {
            double x = series.getX(i).doubleValue();
            double y = series.getY(i).doubleValue();
            points.add(x, y);
        }
        double[] params = PolynomialCurveFitter.create(1).fit(points.toList());
        double a = params[1]; 
        double b = params[0]; 

        XYSeries regressionSeries = new XYSeries("Regression");
        double minX = series.getMinX();
        double maxX = series.getMaxX();
        regressionSeries.add(minX, a * minX + b);
        regressionSeries.add(maxX, a * maxX + b);
        dataset.addSeries(regressionSeries);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("График");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            ChartPanel chartPanel = new ChartPanel(chart);
            frame.add(chartPanel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
