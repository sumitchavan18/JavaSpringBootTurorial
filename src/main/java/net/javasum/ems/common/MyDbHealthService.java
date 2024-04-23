package net.javasum.ems.common;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyDbHealthService implements HealthIndicator {
    @Override
    public Health health() {
        return null;
    }
}
