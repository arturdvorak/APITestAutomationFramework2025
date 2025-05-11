package models;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class SuiteFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Suite getSuite() {
        return Suite.builder()
                .title(usFaker.company().name())
                .position(1)
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();
    }

    public Suite getSuiteToPut(int suiteId) {
        return Suite.builder()
                .id(suiteId)
                .title(RandomStringUtils.randomAlphabetic(10))
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();
    }
}
