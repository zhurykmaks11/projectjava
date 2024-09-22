package task6;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private List<Person> friends;

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Main {
    public static void main(String[] args) {
        // Створюємо приклад даних
        Person alice = new Person("Alice", List.of());
        Person bob = new Person("Bob", List.of(alice));
        Person charlie = new Person("Charlie", List.of(alice, bob));

        // Виклик функції для отримання унікальних імен друзів
        List<String> uniqueFriendNames = getUniqueFriendNames(List.of(alice, bob, charlie));

        // Виведення результату
        System.out.println(uniqueFriendNames); // [ALICE, BOB, CHARLIE]
    }

    // Функція для отримання унікальних імен друзів у верхньому регістрі
    public static List<String> getUniqueFriendNames(List<Person> people) {
        return people.stream()
                .flatMap(person -> person.getFriends().stream()) // Отримуємо стрім друзів кожної особи
                .map(Person::getName) // Отримуємо ім'я кожного друга
                .map(String::toUpperCase) // Перетворюємо ім'я в верхній регістр
                .collect(Collectors.toCollection(HashSet::new)) // Збираємо унікальні імена в Set
                .stream() // Перетворюємо Set назад у стрім
                .sorted() // Сортуємо для наочності
                .collect(Collectors.toList()); // Збираємо у список
    }
}