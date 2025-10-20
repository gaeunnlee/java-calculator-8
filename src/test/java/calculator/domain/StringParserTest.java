package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {
    @Test
    public void parse() throws Exception {
        // given
        String str = "1!2:3";

        // when
        int[] result = StringParser.parse(str, "!");

        // then
        Assertions.assertThat(result[0]).isEqualTo(1);
        Assertions.assertThat(result[1]).isEqualTo(2);
        Assertions.assertThat(result[2]).isEqualTo(3);
    }
    
    @Test
    public void parseNonCustomDelimiter() throws Exception {
        // given
        String str = "12,2:3";

        // when
        int[] result = StringParser.parse(str, "");

        // then
        Assertions.assertThat(result[0]).isEqualTo(12);
        Assertions.assertThat(result[1]).isEqualTo(2);
        Assertions.assertThat(result[2]).isEqualTo(3);
    }

    @Test
    public void parseBlank() throws Exception {
        // given
        String str = "";

        // when
        int[] result = StringParser.parse(str, "");

        // then
        Assertions.assertThat(result.length).isEqualTo(0);
    }

}