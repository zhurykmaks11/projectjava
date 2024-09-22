import java.util.List;

// Абстрактний клас Shape
abstract class Shape {
    public abstract double getArea();
}
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    // Конструктор для ініціалізації ширини та висоти
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Реалізація методу getArea() для прямокутника
    @Override
    public double getArea() {
        return width * height;
    }
}

class ShapeCalculator {

    public static double calculateTotalArea(List<? extends Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public static void main(String[] args) {
        // Створення об'єктів типів Circle і Rectangle
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        // Додавання їх до списку
        List<Shape> shapes = List.of(circle, rectangle);

        // Обчислення загальної площі
        double totalArea = calculateTotalArea(shapes);

        // Виведення результату
        System.out.println("Загальна площа всіх форм: " + totalArea);
    }
}

