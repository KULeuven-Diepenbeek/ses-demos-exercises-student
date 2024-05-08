package exercises.visitor;

class CPU implements HardwareComponent {
    private String model;
    private int cores;

    public CPU(String model, int cores) {
        this.model = model;
        this.cores = cores;
    }

    @Override
    public void display() {
        System.out.println("CPU Model: " + model + ", Cores: " + cores);
    }

    @Override
    public void checkHealth() {
        System.out.println("Checking CPU health...");
    }
}
