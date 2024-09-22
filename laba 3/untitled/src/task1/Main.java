import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Xylophone", "Hello", "Xtrao", "Example");

        Optional<String> result = Optional.empty();
        for (String s : list) {
            if (s.startsWith("X") && s.length() > 5) {
                result = Optional.of(s);
                break;
            }
        }

        System.out.println(result.orElse("Default"));
    }
}