import java.util.HashMap;
import java.util.Map;

class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentRegistry {
    private Map<String, Student> students = new HashMap<>();

    // Додавання студента
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Видалення студента за ID
    public void removeStudent(String id) {
        students.remove(id);
    }

    // Пошук студента за ID
    public Student getStudent(String id) {
        return students.get(id);
    }

    // Виведення списку всіх студентів
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Реєстр порожній.");
        } else {
            students.values().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        // Створення кількох студентів
        Student student1 = new Student("1", "Іван Іванов", 20);
        Student student2 = new Student("2", "Марія Петрівна", 22);
        Student student3 = new Student("3", "Костя Константинович", 17);
        Student student4 = new Student("4", "Максим Антонович", 19);
        Student student5 = new Student("5", "Анастасія Василіна", 18);


        // Додавання студентів у реєстр
        registry.addStudent(student1);
        registry.addStudent(student2);
        registry.addStudent(student3);
        registry.addStudent(student4);
        registry.addStudent(student5);

        // Виведення всіх студентів
        registry.displayAllStudents();
        System.out.println("----------------------------------------");

        // Пошук студента за ID
        System.out.println("Знайдений студент: " + registry.getStudent("4"));
        System.out.println("----------------------------------------");

        // Видалення студента за ID
        registry.removeStudent("5");

        // Виведення всіх студентів після видалення
        registry.displayAllStudents();
        System.out.println("Знайдений студент: " + registry.getStudent("5"));
        System.out.println("----------------------------------------");
    }
}
