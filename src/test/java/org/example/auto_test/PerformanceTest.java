package org.example.auto_test;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {
        String fileName = "input.txt";
        int numCount = 1000000;
        
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 1; i <= numCount; i++) {
                writer.write(i + " ");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write numbers to file");
            e.printStackTrace();
            return;
        }

        long startTime = System.nanoTime();
        try {
            String[] arg = {"input.txt"};
            Main.main(arg);
        } catch (Exception e) {
            System.err.println("Exception occurred during execution: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time for " + numCount + " numbers: " + duration + " ns");

        if (duration >= 1000000000) { // 1 second = 1,000,000,000 nanoseconds
            System.err.println("Test failed: Execution time is too long.");
        } else {
            System.out.println("Test passed: Execution time is within acceptable limits.");
        }
    }
}
