package org.example.auto_test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;

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
        int[] numbers1 = {Integer.MAX_VALUE, 1};
        int[] numbers2 = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertAll(
            () -> assertThrows(ArithmeticException.class, () -> Main._sum(numbers1)),
            () -> assertEquals(42, Main._sum(numbers2))
        );
    }
    
    @Test
    public void testCalculateProduct() {
        int[] numbers1 = {Integer.MAX_VALUE, 2};
        int[] numbers2 = {12, 3, -5, 7, 19, 8, 2, -10, 6};
        assertAll(
            () -> assertThrows(ArithmeticException.class, () -> Main._mult(numbers1)),
            () -> assertEquals(22982400, Main._mult(numbers2))
        );
    }    

    @Test // Доп. тест
    public void testCalculateAvg() {
        int[] numbers1 = {};
        int[] numbers2 = {0, 100, 50};
        assertAll(
            () -> assertEquals(0, Main._avg(numbers1)),
            () -> assertEquals(50, Main._avg(numbers2))
        );
    }

    @Disabled
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException{
        Thread.sleep(200);
    }

}
