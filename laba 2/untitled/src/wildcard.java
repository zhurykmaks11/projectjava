import java.util.List;
import java.util.ArrayList;

public class wildcard {

    public static void addToList(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);  // Додаємо числа від 1 до 10
        }
    }

    public static void main(String[] args) {
        // Приклад із List<Integer>
        List<Integer> integerList = new ArrayList<>();
        addToList(integerList);
        System.out.println("List<Integer>: " + integerList);

        // Приклад із List<Number>
        List<Number> numberList = new ArrayList<>();
        addToList(numberList);
        System.out.println("List<Number>: " + numberList);
    }
}