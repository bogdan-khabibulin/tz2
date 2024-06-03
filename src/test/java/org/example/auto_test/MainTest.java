package org.example.auto_test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest {

    @Test
    public void testFindMin() {
        int[] numbers = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertEquals(-10, Main._min(numbers));
    }
    
    @Test
    public void testFindMax() {
        int[] numbers = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertEquals(19, Main._max(numbers));
    }
    
    @Test
    public void testCalculateSum() {
        int[] numbers = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertEquals(42, Main._sum(numbers));
    }
    
    @Test
    public void testCalculateProduct() {
        int[] numbers = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertEquals(22982400, Main._mult(numbers)); // Произведение всех чисел в массиве
    }    

    @Test // Доп тест
    public void testSingleNumberFile() {
        String fileName = "single_number.txt";
        int expectedNumber = 42;

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(String.valueOf(expectedNumber));
            writer.close();
        } catch (IOException e) {
            fail("Failed to write number to file");
        }

        try {
            String[] arg = {"single_number.txt"};
            Main.main(arg);
        } catch (Exception e) {
        }
    }

    @Test
    public void testPerformance() {

        String fileName = "input.txt";
        int numCount = 1000000;
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
            String[] arg = {"input.txt"};
            Main.main(arg);
        } catch (Exception e) {
            fail("Exception occurred during execution: " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Время выполнения для " + numCount + " чисел: " + duration + " мс");

        assertTrue(duration < 1000);
    }
}
