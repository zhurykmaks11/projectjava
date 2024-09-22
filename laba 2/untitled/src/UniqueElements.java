import java.util.*;

public class UniqueElements {

    // Метод для отримання унікальних елементів з List
    public static <T> Set<T> getUniqueElements(List<T> list) {
        return new HashSet<>(list);  // Перетворюємо List в Set, який зберігає тільки унікальні елементи
    }

    // Метод для підрахунку кількості входжень кожного елемента в List
    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> occurrencesMap = new HashMap<>();  // Створюємо Map для збереження елементів і їх кількості

        // Проходимо по списку
        for (T element : list) {
            occurrencesMap.put(element, occurrencesMap.getOrDefault(element, 0) + 1);
        }

        return occurrencesMap;
    }

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // унікальні елементи
        Set<String> uniqueElements = getUniqueElements(items);
        System.out.println("Унікальні елементи: " + uniqueElements);
        // Підрахунок
        Map<String, Integer> occurrences = countOccurrences(items);
        System.out.println("Кількість входжень кожного елемента: " + occurrences);
    }
}
