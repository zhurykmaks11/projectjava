public class Box<T> {
    private T item;
    public void put(T item) {
        this.item = item;
        System.out.println("Предмет поміщено у коробку: " + item);
    }

    public T get() {
        System.out.println("Предмет вилучено з коробки: " + item);
        return item;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.put("Привіт, світ!");
        String str = stringBox.get();

        Box<Integer> intBox = new Box<>();
        intBox.put(123);
        Integer number = intBox.get();

        Box<Double> doubleBox = new Box<>();
        doubleBox.put(3.14);
        Double decimal = doubleBox.get();
    }
}
