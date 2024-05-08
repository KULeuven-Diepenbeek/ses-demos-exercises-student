package exercises.visitor;

public class Main {
    public static void main(String[] args) {
        ComputerSystem sys = new ComputerSystem(new CPU("Intel", 16),
                new GPU("nvidia", 2048),
                new HardDrive("Seagate", 200));
        sys.accept(new DisplayVisitor());
        sys.accept(new HealthVisitor());
    }
}
