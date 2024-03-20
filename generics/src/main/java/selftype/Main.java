package selftype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // een List<String>
        List<String> someListOfStrings = List.of("hello", "there", "how", "are", "you");
        MyAssertions.assertThat(someListOfStrings).isNotNull().hasSize(5).containsItem("hello");

        // een String
        String someString = "hello";
        MyAssertions.assertThat(someString).isNotNull().isEqualToIgnoringCase("hello");

        // een Integer
        int someInteger = 4;
        MyAssertions.assertThat(someInteger).isNotNull().isGreaterThan(4);

        MyAssertions.assertThat(someInteger).isNotNull().isEqualToIgnoringCase("hello"); // <= compileert niet
    }
}
