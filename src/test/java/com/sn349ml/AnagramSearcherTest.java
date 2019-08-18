package com.sn349ml;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

public class AnagramSearcherTest {
    private static final String ABNORMAL_WARNING = "User input has abnormal character";

    @Test
    public final void returnAbnormalWarningFromSpecialCharacter() throws IOException {
        final Throwable expected = Assertions.catchThrowable(() -> new AnagramSearcher("Dogd$$$"));
        Assertions.assertThat(expected).hasMessageContaining(ABNORMAL_WARNING);
    }

    @Test
    public final void returnValidResultFromNormalCharacter() throws IOException {
        final AnagramSearcher expected = new AnagramSearcher("dog");
        Assertions.assertThat(expected.findALlWords().contains("god")).isTrue();
    }

    @Test
    public final void returnValidResultFromAllCapCharacter() throws IOException {
        final AnagramSearcher expected = new AnagramSearcher("DOG");
        Assertions.assertThat(expected.findALlWords().contains("god")).isTrue();
    }

    @Test
    public final void returnValidResultFromMixedCharacter() throws IOException {
        final AnagramSearcher expected = new AnagramSearcher("dOg");
        Assertions.assertThat(expected.findALlWords().contains("god")).isTrue();
    }

    @Test
    public final void returnEmptyResultFromMixedCharacter() throws IOException {
        final AnagramSearcher expected = new AnagramSearcher("dOsdfafdsafsfdsfdsafsdfg");
        Assertions.assertThat(expected.findALlWords().size() == 0).isTrue();
    }
}
