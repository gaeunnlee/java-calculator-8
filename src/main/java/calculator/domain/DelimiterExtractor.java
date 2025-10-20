package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    public static ExtractResult extractDelimiter(String input) {
        Pattern pattern = Pattern.compile("^//(.)(?:\\\\n|\n)(.*)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return new ExtractResult(delimiter, numbers);
        }

        return new ExtractResult("", input);
    }

    public static class ExtractResult {
        private final String delimiter;
        private final String extractedString;

        public ExtractResult(String delimiter, String extractedString) {
            this.delimiter = delimiter;
            this.extractedString = extractedString;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getExtractedString() {
            return extractedString;
        }
    }
}
