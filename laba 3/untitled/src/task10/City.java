package task10;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class City {
    public static void main(String[] args) {
        // Створюємо мапу з містами та їх температурами
        Map<String, List<Integer>> cityTemperatures = Map.of(
                "CityA", Arrays.asList(22, 24, 26, 23, 21),
                "CityB", Arrays.asList(18, 20, 19, 17, 21),
                "CityC", Arrays.asList(30, 32, 31, 29, 28),
                "CityD", Arrays.asList(25, 26, 24, 27, 23)
        );

        // Виклик методу для знаходження міста з найвищою середньою температурою
        Optional<String> cityWithHighestAverageTemperature = findCityWithHighestAverageTemperature(cityTemperatures);

        // Виведення результату
        cityWithHighestAverageTemperature.ifPresentOrElse(
                city -> System.out.println("City with highest average temperature: " + city),
                () -> System.out.println("No cities found")
        );
    }

    // Метод для знаходження міста з найвищою середньою температурою
    public static Optional<String> findCityWithHighestAverageTemperature(Map<String, List<Integer>> cityTemperatures) {
        return cityTemperatures.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,                  // Ключ - назва міста
                        entry -> entry.getValue().stream()  // Значення - стрім температур
                                .mapToInt(Integer::intValue)    // Перетворюємо температури в int
                                .average()                      // Обчислюємо середню температуру
                                .orElse(Double.NaN)             // Випадок, якщо список порожній
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())      // Знаходимо місто з максимальною середньою температурою
                .map(Map.Entry::getKey);                // Повертаємо назву міста
    }
}
