package ru.netology.delivery.data;


import lombok.Value;
import lombok.val;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int shift) {

        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateCity(String locale) {

        Random random = new Random();
        int rand = random.nextInt(5);
        String city[] = {"Москва", "Брянск", "Калининград", "Кемерово", "Краснодар", "Санкт-Петербург"};
        return city[rand];
    }

    public static String generateName(String locale) {

        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {

        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}