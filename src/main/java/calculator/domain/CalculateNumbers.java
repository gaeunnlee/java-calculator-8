package calculator.domain;

public class CalculateNumbers {
    public static int getSum(int[] numbers) {

        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
