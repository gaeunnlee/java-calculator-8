package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringParser {

    public static int[] parse(String input, String customDelimiter) {
        DelimiterExtractor.ExtractResult extractResult = DelimiterExtractor.extractDelimiter(input);
        String numbers = extractResult.getExtractedString();

        String regex = "[,:]";
        if (!customDelimiter.isEmpty()) {
            regex = regex + "|" + Pattern.quote(customDelimiter);
        }

        String[] tokens = numbers.split(regex);

        return Arrays.stream(tokens)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
