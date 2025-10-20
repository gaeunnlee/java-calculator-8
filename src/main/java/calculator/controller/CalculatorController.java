package calculator.controller;

import calculator.domain.CalculateNumbers;
import calculator.domain.DelimiterExtractor;
import calculator.domain.StringParser;
import calculator.view.InputView;

public class CalculatorController {
    public static void run() {
        String input = InputView.inputString();
        DelimiterExtractor.ExtractResult extractResult = DelimiterExtractor.extractDelimiter(input);
        int[] numbers = StringParser.parse(extractResult.getExtractedString(), extractResult.getDelimiter());
        int result = CalculateNumbers.getSum(numbers);
        System.out.println("결과 : " + result);
    }
}
