import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String dateString = "2024-08-31"; // Задаємо рядок з датою
        try {
            Date date = convertStringToDate(dateString);
            System.out.println("Дата: " + date);
        } catch (ParseException e) {
            System.out.println("Неправильний формат дати: " + e.getMessage());
        }
    }

    public static Date convertStringToDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Формат дати
        return dateFormat.parse(dateStr); // Перетворення рядка на дату
    }
}
