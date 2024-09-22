package task7;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transaction {
    private int amount;
    private String category;

    public Transaction(int amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Transaction{amount=" + amount + ", category='" + category + "'}";
    }
}
class Main {
    public static void main(String[] args) {
        // Створюємо список транзакцій
        List<Transaction> transactions = Arrays.asList(
                new Transaction(100, "Food"),
                new Transaction(200, "Food"),
                new Transaction(300, "Utilities"),
                new Transaction(400, "Utilities"),
                new Transaction(150, "Entertainment"),
                new Transaction(50, "Food")
        );

        // Лямбда-функція для підсумовування транзакцій за категоріями
        Map<String, Integer> categorySums = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,// Групуємо за категорією
                        Collectors.summingInt(Transaction::getAmount) // Підсумовуємо суми по кожній категорії
                ));

        // Виведення результату
        categorySums.forEach((category, sum) ->
                System.out.println("Category: " + category + ", Total Amount: " + sum)
        );
    }
}