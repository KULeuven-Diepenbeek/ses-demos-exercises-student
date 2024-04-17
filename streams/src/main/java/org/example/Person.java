package org.example;

import java.util.List;

interface Person { String firstName(); String lastName(); int age(); String zipCode(); }
record Child (String firstName, String lastName, int age, String zipCode) implements Person { }
record Adult(String firstName, String lastName, int age, String zipCode, List<Child> children)  implements Person {
}
