package org.example.auto_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String FILE_PATH = "input.txt";

    public static void main(String[] args) {

        if (args.length > 0) {FILE_PATH = args[0];} // строка нужна для тестов в NumberProcessorTest, чтобы вызываться от сгенерированных тестовых данных

        try {
            int[] numbers = readNumbersFromFile(FILE_PATH);
            if (numbers != null) {
                System.out.println("Минимальное: " + _min(numbers));
                System.out.println("Максимальное: " + _max(numbers));
                System.out.println("Сумма: " + _sum(numbers));
                System.out.println("Произведение: " + _mult(numbers));
            } else {
                System.err.println("Файл пуст или не найден.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static int[] readNumbersFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null) {
                return null;
            }

            String[] parts = line.split(" ");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
            return numbers;
        }
    }

    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int _sum(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += (long) number;
            if (sum > (long) Integer.MAX_VALUE || sum < (long) Integer.MIN_VALUE) {
                throw new ArithmeticException("Сумма превышает диапазон int.");
            }
        }
        return (int) sum;
    }

    public static long _mult(int[] numbers) {
        long mult = 1;
        for (int number : numbers) {
            mult *= (long) number;
            if (mult > (long) Integer.MAX_VALUE || mult < (long) Integer.MIN_VALUE) {
                throw new ArithmeticException("Произведение превышает диапазон int.");
            }
        }
        return (int) mult;
    }

    public static double _avg(int[] numbers) { // Доп. метод
        if (numbers.length == 0) {
            return 0;
        }
        int sum = _sum(numbers);
        return (double) sum / numbers.length;
    }
}