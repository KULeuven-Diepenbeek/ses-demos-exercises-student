package streams.exercises.exercise1;

import java.util.Collections;
import java.util.List;

public class Data {

    public static void main(String[] args) {
        System.out.println(DATASET.stream().mapToInt(Person::age).summaryStatistics());
        System.out.println(DATASET.stream().flatMap(p -> p.children().stream()).mapToInt(Person::age).summaryStatistics());
    }

    public static final List<Adult> DATASET = List.of(
            new Adult("John", "Doe", 30, "12345", List.of(
                    new Child("Alice", "Doe", 5, "12345"),
                    new Child("Liam", "Doe", 7, "12345"))),
            new Adult("Jane", "Smith", 28, "23456", List.of(
                    new Child("Bob", "Smith", 3, "23456"),
                    new Child("Charlie", "Smith", 6, "23456"),
                    new Child("Daisy", "Smith", 8, "23456"))),
            new Adult("Michael", "Johnson", 35, "34567", List.of(
                    new Child("Daniel", "Johnson", 7, "34567"),
                    new Child("Sophia", "Johnson", 4, "34567"))),
            new Adult("Emily", "Davis", 32, "45678", List.of(
                    new Child("Emma", "Davis", 2, "45678"))),
            new Adult("David", "Wilson", 29, "56789", List.of(
                    new Child("Nora", "Wilson", 5, "56789"),
                    new Child("Evan", "Wilson", 10, "56789"))),
            new Adult("Sarah", "Martinez", 24, "67890", List.of(
                    new Child("Mia", "Martinez", 3, "67890"))),
            new Adult("Daniel", "Anderson", 31, "78901", List.of(
                    new Child("Olivia", "Anderson", 6, "78901"))),
            new Adult("Laura", "Taylor", 27, "89012", Collections.emptyList()),
            new Adult("James", "Thomas", 45, "90123", List.of(
                    new Child("Isaac", "Thomas", 9, "90123"),
                    new Child("Zoe", "Thomas", 13, "90123"),
                    new Child("Ava", "Thomas", 11, "90123"))),
            new Adult("Susan", "Jackson", 26, "01234", Collections.emptyList()),
            new Adult("Robert", "White", 50, "12345", List.of(
                    new Child("Tyler", "White", 14, "12345"))),
            new Adult("Linda", "Harris", 48, "23456", List.of(
                    new Child("Grace", "Harris", 8, "23456"))),
            new Adult("William", "Clark", 51, "34567", Collections.emptyList()),
            new Adult("Barbara", "Lewis", 34, "45678", List.of(
                    new Child("Jasper", "Lewis", 6, "45678"),
                    new Child("Lucy", "Lewis", 10, "45678"))),
            new Adult("Richard", "Robinson", 58, "56789", Collections.emptyList()),
            new Adult("Mary", "Walker", 60, "67890", List.of(
                    new Child("Ella", "Walker", 5, "67890"),
                    new Child("Ruby", "Walker", 7, "67890"))),
            new Adult("Joseph", "Perez", 29, "78901", Collections.emptyList()),
            new Adult("Karen", "Hall", 43, "89012", List.of(
                    new Child("Gavin", "Hall", 13, "89012"))),
            new Adult("Paul", "Young", 22, "90123", Collections.emptyList()),
            new Adult("Lisa", "Allen", 37, "01234", List.of(
                    new Child("Harper", "Allen", 9, "01234"))),
            new Adult("Kevin", "King", 33, "12345", Collections.emptyList()),
            new Adult("Nancy", "Wright", 29, "23456", List.of(
                    new Child("Mason", "Wright", 4, "23456"))),
            new Adult("George", "Scott", 40, "34567", Collections.emptyList()),
            new Adult("Betty", "Green", 30, "45678", Collections.emptyList()),
            new Adult("Steven", "Adams", 36, "56789", Collections.emptyList()));
}