package calculator.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterExtractorTest {
    @Test
    public void extractDelimiter() throws Exception {
        // given
        String str = "//!\n1!2:3";

        // when
        DelimiterExtractor.ExtractResult extractResult = DelimiterExtractor.extractDelimiter(str);
        String extractedString = extractResult.getExtractedString();
        String delimiter = extractResult.getDelimiter();

        // then
        assertThat(extractedString).isEqualTo("1!2:3");
        assertThat(delimiter).isEqualTo("!");
    }

    @Test
    public void extractNonExistDelimiter() throws Exception {
        // given
        String str = "1,2,3";

        // when
        DelimiterExtractor.ExtractResult extractResult = DelimiterExtractor.extractDelimiter(str);
        String extractedString = extractResult.getExtractedString();
        String delimiter = extractResult.getDelimiter();

        // then
        assertThat(extractedString).isEqualTo("1,2,3");
        assertThat(delimiter).isEqualTo("");
    }
}