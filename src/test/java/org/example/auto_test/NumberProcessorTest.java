package org.example.auto_test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class NumberProcessorTest {

    public void main() {
        XYSeries series = new XYSeries("Время выполнения");

        for (int numCount = 1000; numCount <= 5000000; numCount += 100000) {
            String fileName = "numbers_" + numCount + ".txt";
            try {
                FileWriter writer = new FileWriter(fileName);
                for (int i = 1; i <= numCount; i++) {
                    writer.write(i + " ");
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
            Thread.sleep(60000); // Изменить при желании увидеть график (Например 60000)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
