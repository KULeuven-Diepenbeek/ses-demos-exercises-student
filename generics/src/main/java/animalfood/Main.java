package animalfood;

class Animal {
    public void eat(Food food) { }
}
class Cat extends Animal {}
class Dog extends Animal {}
class Food {}

public class Main {
    public static void main(String[] args) {
        Food catFood = new Food();
        Food dogFood = new Food();

        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.eat(catFood); // OK
        dog.eat(dogFood); // OK

        cat.eat(dogFood); // <- moet een compiler error geven!
    }
}