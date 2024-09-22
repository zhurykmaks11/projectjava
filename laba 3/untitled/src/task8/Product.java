package task8;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}

class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = Arrays.asList(
                new Product("Product1", 100),
                new Product("Product2", 300),
                new Product("Product3", 250),
                new Product("Product4", 500),
                new Product("Product5", 200)
        );

        Optional<String> secondMostExpensive = findSecondMostExpensiveProduct(products);

        // Виведення результату
        secondMostExpensive.ifPresentOrElse(
                System.out::println,      // Виводимо назву другого найдорожчого продукту
                () -> System.out.println("There is no second most expensive product") // Якщо продуктів недостатньо
        );
    }

    // Метод для знаходження другого найдорожчого продукту
    public static Optional<String> findSecondMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()) // Сортуємо за ціною в порядку спадання
                .skip(1) // Пропускаємо найдорожчий продукт
                .findFirst() // Беремо другий найдорожчий
                .map(Product::getName); // Повертаємо назву продукту
    }
}
