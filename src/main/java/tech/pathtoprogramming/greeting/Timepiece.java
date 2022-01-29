package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Component;

@Component
public class Timepiece {
    public HourOfDay getCurrentHour() {
        return new HourOfDay(-1);
    }
}
