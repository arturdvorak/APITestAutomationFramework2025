package models;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Locale;

public class ProjectFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Project getProject() {
        return Project.builder().title(usFaker.company().name())
                .description(usFaker.company().name())
                .code(RandomStringUtils.randomAlphabetic(10))
                .description(usFaker.company().catchPhrase())
                .access("all")
                .group("Test123")
                .build();
    }
}
