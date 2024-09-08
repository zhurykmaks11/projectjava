import java.util.*;

public class UniqueElements {

    // Метод для отримання унікальних елементів з List
    public static <T> Set<T> getUniqueElements(List<T> list) {
        return new HashSet<>(list);  // Перетворюємо List в Set, який зберігає тільки унікальні елементи
    }

    // Метод для підрахунку кількості входжень кожного елемента в List
    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> occurrencesMap = new HashMap<>();  // Створюємо Map для збереження елементів і їх кількості

        // Проходимо по кожному елементу в списку
        for (T element : list) {
            // Збільшуємо лічильник для кожного елемента, якщо він вже є в Map
            occurrencesMap.put(element, occurrencesMap.getOrDefault(element, 0) + 1);
        }

        return occurrencesMap;  // Повертаємо Map з кількістю входжень
    }

    public static void main(String[] args) {
        // Приклад списку об'єктів
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // Отримання унікальних елементів
        Set<String> uniqueElements = getUniqueElements(items);
        System.out.println("Унікальні елементи: " + uniqueElements);
        // Підрахунок кількості входжень
        Map<String, Integer> occurrences = countOccurrences(items);
        System.out.println("Кількість входжень кожного елемента: " + occurrences);
    }
}
