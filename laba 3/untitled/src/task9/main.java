package task9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        // Створюємо мапу з ідентифікаторами продуктів та необов'язковими назвами
        Map<Integer, Optional<String>> productMap = Map.of(
                1, Optional.of("apple"),
                2, Optional.of("banana"),
                3, Optional.empty(),
                4, Optional.of("cherry"),
                5, Optional.empty()
        );


        List<String> productNamesUpperCase = getProductNamesUpperCase(productMap);

        // Виведення результату
        System.out.println(productNamesUpperCase); // [APPLE, BANANA, CHERRY]
    }

    // Метод для отримання списку назв продуктів у верхньому регістрі
    public static List<String> getProductNamesUpperCase(Map<Integer, Optional<String>> productMap) {
        return productMap.values().stream()    // Отримуємо стрім значень (Optional<String>)
                .flatMap(Optional::stream)      // Розгортаємо непорожні Optional в стрім
                .map(String::toUpperCase)      // Перетворюємо назви в верхній регістр
                .collect(Collectors.toList()); // Збираємо результат у список
    }
}

