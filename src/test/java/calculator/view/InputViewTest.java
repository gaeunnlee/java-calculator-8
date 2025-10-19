package calculator.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputViewTest {
    @Test
    public void enterInput() throws Exception {
        // given
        String str = "1,2:3";
        System.setIn(new ByteArrayInputStream(str.getBytes()));

        // when
        String input = InputView.inputString();

        // then
        Assertions.assertThat(input).isEqualTo("1,2:3");
    }

    @Test
    public void enterBlank() throws Exception {
        // given
        String str = "\n";
        System.setIn(new ByteArrayInputStream(str.getBytes()));

        // when
        String input = InputView.inputString();

        // then
        Assertions.assertThat(input).isEqualTo("");
    }
}