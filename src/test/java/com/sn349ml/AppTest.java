package com.sn349ml;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AppTest {
    private String expectedEmptyWarning = "Your input was empty, please try again";

    @Test
    public final void exceptionIsThrownOnEmptyArg() {
        final Throwable thrown = Assertions.catchThrowable(() -> new App().exec());
        Assertions.assertThat(thrown).hasMessage(this.expectedEmptyWarning);
    }

}
