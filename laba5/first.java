import java.io.PrintStream;
import java.util.*;


public class first {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Jonathan", "Bob", "Catherine");
        Optional<String> longestName = findLongestName(names);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        longestName.ifPresentOrElse(var10001::println, () -> {
            System.out.println("No names found");
        });
    }

    public static Optional<String> findLongestName(List<String> names) {
        return names.stream().max(Comparator.comparingInt(String::length));
    }
}
