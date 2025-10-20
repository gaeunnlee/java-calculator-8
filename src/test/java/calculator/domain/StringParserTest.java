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

    @Test
    public void parseInvalidCharacter() throws Exception {
        // given
        String str = "123;4";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parse(str, "");
        });
    }

    @Test
    public void parseWithNegativeNumber() {
        // given
        String str = "1,-2,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parse(str, "");
        });
    }

    @Test
    public void parseWithZero() {
        // given
        String str = "1,0,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parse(str, "");
        });
    }
}