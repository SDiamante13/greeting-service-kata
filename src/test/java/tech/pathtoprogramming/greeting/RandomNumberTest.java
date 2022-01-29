package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    void randomNumberReturnsANumberRangingFromZeroToThree() {
        int randomlyGeneratedNumber = new RandomNumber().generateRandom();

        assertThat(randomlyGeneratedNumber)
                .isBetween(0, 3);
    }
}