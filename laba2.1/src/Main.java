import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class OrderQueue {
    // Черга для зберігання замовлень
    private Queue<String> orders;

    // Конструктор ініціалізує чергу
    public OrderQueue() {
        orders = new LinkedList<>();
    }

    // Метод для додавання замовлення до черги
    public void addOrder(String order) {
        orders.add(order);
        System.out.println("Додано замовлення: " + order);
    }

    // Метод для обробки (видалення) першого замовлення
    public void processOrder() {
        try {
            // Видаляємо та отримуємо перше замовлення з черги
            String processedOrder = orders.remove();
            System.out.println("Оброблено замовлення: " + processedOrder);
        } catch (NoSuchElementException e) {
            // Якщо черга порожня, виводимо повідомлення про помилку
            System.out.println("Немає замовлень для обробки.");
        }
    }

    public static void main(String[] args) {
        // Створюємо об'єкт OrderQueue
        OrderQueue queue = new OrderQueue();

        // Додаємо кілька замовлень до черги

        // Обробляємо всі замовлення
        queue.processOrder();
        queue.processOrder();

        // Пробуємо обробити замовлення з порожньої черги
        queue.processOrder();
    }
}
