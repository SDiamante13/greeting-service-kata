package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {

    public static final int NUMBER_OF_MESSAGES = 4;
    private final Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int generateRandom(int upperBound) {
        return random.nextInt(NUMBER_OF_MESSAGES);
    }
}
