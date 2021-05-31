package mcgee.provider;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

@Component
public class IndexNameProvider {

    public String timeSuffix() {
        return LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString().replace(":", "-");
    }

}
