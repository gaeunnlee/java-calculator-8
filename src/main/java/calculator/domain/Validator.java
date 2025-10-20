package calculator.domain;

public class Validator {
    public static void validateNumber(String token) {
        if (!token.matches("-?\\d+")) {
            throw new IllegalArgumentException("잘못된 입력입니다: '" + token + "' 는 숫자가 아닙니다.");
        }

        int number = Integer.parseInt(token);

        if (number <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다: '" + number + "' 는 양수가 아닙니다");
        }
    }
}
