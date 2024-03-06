import student.*;

public class Main {

	public static void main(String[] args) {
		var student = new Student("Jos");
		System.out.println("Hekyes " + student.getName());
	}
}

// Ga naar de build directory: `$ cd build`
// Build de packaged/jar program: `$ jar cvf programma.jar *`
// Run je jar programma met: `$ java -cp "./programma.jar;." Main