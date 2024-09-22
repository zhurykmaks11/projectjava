import java.util.ArrayList;
import java.util.List;

public class Pair<T1, T2 > implements Comparable <Pair<T1,T2>>
{
    private T1 first; // Перший елемент пари
    private T2 second; // Другий елемент пари

    // Конструктор для ініціалізації двох елементів
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    //доступи до гет
    public T1 getFirst() {
        return first;
    }
    public T2 getSecond() {
        return second;
    }
    // Сеттер для зміни
    public void setFirst(T1 first) {
        this.first = first;
    }
    public void setSecond(T2 second) {
        this.second = second;
    }
    // Метод порівняння двох пар
    public static <T1 extends Comparable, T2> boolean compare(Pair<T1, T2> pair1, Pair<T1, T2> pair2) {
        T2 second1 = pair2.getSecond();
        return compare(pair1) && compare(Pair<T1, T2> pair2);
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    public static void main(String[] args) {
        // Створюємо пару Pair<Integer, String>
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");

        // Перевірка порівняння двох пар
        System.out.println("Порівняння pair1 і pair2: " + Pair.compare(pair1, pair2)); // true

        // Створюємо пару Pair<String, List<Integer>>
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        Pair<String, List<Integer>> pair3 = new Pair<>("Numbers", list);

        // Виведення пари
        System.out.println(pair3);
    }

    @Override
    public int compareTo(Object o) {
        return first.compareTo(o);
    }
}
