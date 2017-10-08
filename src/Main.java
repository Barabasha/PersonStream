import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
1. Создать класс человек - имя , дата рождения, пол (enum);
2. Инициализировать список объектов класс человек;
3. Найти всех людей призывного возраста;
4. Найти средний возраст женщин;
5. Найти всех людей кто 1990 г. рождения.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person("Ivanov", 1990, Gender.Male));
        listOfPerson.add(new Person("Petrov", 1992, Gender.Male));
        listOfPerson.add(new Person("Sidorov", 2001, Gender.Male));
        listOfPerson.add(new Person("Pupkina", 1990, Gender.Female));
        listOfPerson.add(new Person("Moloduhina", 2002, Gender.Female));
        listOfPerson.add(new Person("Staruhina", 1940, Gender.Female));

        //1
        List<Person> militaryMan;
        int militaryAgeBeginning = 20;
        int militaryAgeEnding = 27;
        militaryMan = listOfPerson.stream()
                .filter(personM -> (personM.getAge() >= militaryAgeBeginning &&
                                    personM.getAge() <= militaryAgeEnding &&
                                    personM.getGender() == Gender.Male))
                .collect(Collectors.toList());
        System.out.print("List of recruit: ");
        for (Person personM : militaryMan) {
            System.out.print(personM.getName() + ", ");
        }
        System.out.println();

        //2
        double averageAge;
        averageAge = listOfPerson.stream()
                .filter(personA -> personA.getGender() == Gender.Female)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of women: " + (int) averageAge);

        //3
        List<Person> listOfYear;
        int yearOfBirth = 1990;
        listOfYear = listOfPerson.stream()
                .filter((personY -> personY.getYearOfBirth() == yearOfBirth))
                .collect(Collectors.toList());
        System.out.print("People born in 1990: ");
        for (Person personY : listOfYear) {
            System.out.print(personY.getName() + ", ");
        }
    }
}
