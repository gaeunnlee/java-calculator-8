package calculator.domain;

public class CalculateNumbers {
    public static int getSum(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }
        return sum;
    }
}
