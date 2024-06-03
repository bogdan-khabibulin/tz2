package org.example.auto_test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(22982400, Main._mult(numbers));
    }    

    @Test // Доп. тест
    public void testCalculateAvg() {
        int[] numbers = {0, 100, 50};
        assertEquals(50, Main._avg(numbers)); 
    }    
}
