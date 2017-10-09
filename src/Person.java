import java.util.Calendar;
import java.util.Optional;

class Person {
    private String name;
    private int yearOfBirth;
    private Gender gender;

    Person (String name, int yearOfBirth, Gender gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    int getYearOfBirth() {
        return yearOfBirth;
    }

    int getAge() {
        return (getCurrentYear() - yearOfBirth);
    }

    Gender getGender() {
        return gender;
    }

    Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
