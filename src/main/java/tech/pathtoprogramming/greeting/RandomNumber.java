package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {

    private final Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int generateRandom() {
        return random.nextInt(4);
    }
}
