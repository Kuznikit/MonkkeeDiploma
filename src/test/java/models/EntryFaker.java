package models;

import com.github.javafaker.Faker;
import java.util.Locale;

public class EntryFaker {
    public String RandomEntryText() {
        Faker faker = new Faker(
                new Locale("en-GB"));
        return faker.funnyName().name();
    }
}
