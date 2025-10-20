package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateNumbersTest {

    @Test
    public void getSum() throws Exception {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // when
        int result = CalculateNumbers.getSum(numbers);

        // then
        Assertions.assertThat(result).isEqualTo(45);
    }

    @Test
    public void getEmptyArraySum() throws Exception {
        // given
        int[] numbers = {};

        // when
        int result = CalculateNumbers.getSum(numbers);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

}