package task5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> product = calculateOddProduct(numbers);


        product.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No found numbers")
        );
    }

    public static Optional<Integer> calculateOddProduct(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .reduce((a, b) -> a * b);
    }
}
