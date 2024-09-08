// Загальний клас Box<T>, де T - тип об'єкта, що зберігається в коробці
public class Box<T> {
    private T item; // Поле для зберігання елемента

    // Метод для поміщення предмета в коробку
    public void put(T item) {
        this.item = item;
        System.out.println("Предмет поміщено у коробку: " + item);
    }

    // Метод для вилучення предмета з коробки
    public T get() {
        System.out.println("Предмет вилучено з коробки: " + item);
        return item;
    }

    public static void main(String[] args) {
        // Створюємо коробку для зберігання рядкових значень (String)
        Box<String> stringBox = new Box<>();
        stringBox.put("Привіт, світ!");
        String str = stringBox.get();

        // Створюємо коробку для зберігання цілих чисел (Integer)
        Box<Integer> intBox = new Box<>();
        intBox.put(123);
        Integer number = intBox.get();

        // Створюємо коробку для зберігання об'єктів типу Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.put(3.14);
        Double decimal = doubleBox.get();
    }
}
