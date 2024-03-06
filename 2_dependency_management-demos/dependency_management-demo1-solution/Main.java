import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(1));
    }
}

// `$ javac Main.java` gives error => download jar Gson
// Add `import com.google.gson.*;`
// Compile with gson jar: `$ javac -cp gson-2.9.0.jar Main.java`

// Run with link to jar: `$ java -cp "gson-2.9.0.jar;." Main`