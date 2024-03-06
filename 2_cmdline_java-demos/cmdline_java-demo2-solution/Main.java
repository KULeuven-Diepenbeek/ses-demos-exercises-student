import student.*;

public class Main {

	public static void main(String[] args) {
		var student = new Student("Jos");
		System.out.println("Hekyes " + student.getName());
	}
}

// Compile alle files tesamen en plaats ze in een build directory: `$ javac -d ./build *.java`
// Verander directory naar de build/ directory: `$ cd build`
// Run nu je de javaklasse Main: `$ java Main`
