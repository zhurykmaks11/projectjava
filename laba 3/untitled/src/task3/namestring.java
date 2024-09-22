package task3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class namestring {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Jonathan", "Bob", "Catherine");

        // Виклик функції для знаходження найдовшого імені
        Optional<String> longestName = findLongestName(names);

        // Виведення результату
        longestName.ifPresentOrElse(
                System.out::println, () -> System.out.println("No names found")
        );
    }

    public static Optional<String> findLongestName(List<String> names) {
        return names.stream()
                .max(Comparator.comparingInt(String::length));
    }
}