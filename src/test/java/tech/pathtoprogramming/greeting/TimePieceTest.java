package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class TimePieceTest {
    @Test
    void getTimeOfDay() {
        int localTime = LocalTime.now().getHour();
        System.out.println("Time now: " + localTime);
    }
}
