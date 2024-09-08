package task8;

import java.util.ArrayList;
import java.util.List;

// Абстрактний клас Animal з методом makeSound()
abstract class Animal {
    public abstract void makeSound();
}

// Клас Dog, що наслідує Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Клас Cat, що наслідує Animal
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Клас Labrador, що наслідує Dog
class Labrador extends Dog {
    @Override
    public void makeSound() {
        System.out.println("Woof! I'm a Labrador!");
    }
}

// Клас AnimalShelter, що зберігає тварин
class AnimalShelter {
    private List<Dog> dogs = new ArrayList<>();
    private List<Animal> otherAnimals = new ArrayList<>();

    // Метод для додавання собак і підкласів собак
    public void addAnimals(List<? super Dog> animalList, Dog dog) {
        animalList.add(dog);
    }

    // Метод для додавання тварин до притулку
    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void addOtherAnimal(Animal animal) {
        if (!(animal instanceof Dog)) {
            otherAnimals.add(animal);
        }
    }

    // Метод для друку звуків усіх тварин
    public void printAnimalSounds() {
        System.out.println("Sounds from all dogs:");
        for (Dog dog : dogs) {
            dog.makeSound();
        }
        System.out.println("Sounds from other animals:");
        for (Animal animal : otherAnimals) {
            animal.makeSound();
        }
    }
}

// Демонстрація роботи
class AnimalShelterDemo {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        // Створюємо об'єкти тварин
        Dog dog = new Dog();
        Cat cat = new Cat();
        Labrador labrador = new Labrador();

        // Додаємо тварин до притулку
        shelter.addDog(dog);
        shelter.addDog(labrador); // Додаємо підклас Labrador
        shelter.addOtherAnimal(cat); // Додаємо іншу тварину, кішку

        // Виводимо звуки усіх тварин
        shelter.printAnimalSounds();
    }
}
