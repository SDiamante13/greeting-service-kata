package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Timepiece {
    public HourOfDay getCurrentHour() {
        return new HourOfDay(LocalTime.now().getHour());
    }
}
