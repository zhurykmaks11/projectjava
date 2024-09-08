// Загальний клас з методом findMax
public class Generic {

    // Загальний метод findMax для пошуку максимального елемента в масиві
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        T max = array[0]; // Припускаємо, що перший елемент - максимальний
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element; // Оновлюємо максимальний елемент
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Перевірка методу з масивом цілих чисел
        Integer[] intArray = {1, 5, 3, 9, 2};
        System.out.println("Максимум в масиві Integer: " + findMax(intArray));

        // Перевірка методу з масивом дробових чисел
        Double[] doubleArray = {1.1, 3.3, 2.2, 5.5};
        System.out.println("Максимум в масиві Double: " + findMax(doubleArray));

        // Перевірка методу з масивом символів
        Character[] charArray = {'a', 'z', 'm', 'b'};
        System.out.println("Максимум в масиві Character: " + findMax(charArray));

        // Перевірка методу з масивом рядкових значень
        String[] stringArray = {"apple", "orange", "banana", "pear"};
        System.out.println("Максимум в масиві String: " + findMax(stringArray));
    }
}
