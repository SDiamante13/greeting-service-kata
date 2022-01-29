package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimePieceTest {

    private final Timepiece timepiece = new Timepiece();

    @Test
    void getCurrentHourReturnsANumberBetweenOneAndTwentyFourDependingOnTheTimeOfDay() {
        HourOfDay currentHour = timepiece.getCurrentHour();

        assertThat(currentHour.hour())
                .isBetween(0, 23);
    }
}
