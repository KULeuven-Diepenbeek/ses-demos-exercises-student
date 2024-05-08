package exercises.visitor;

class GPU implements HardwareComponent {
    private String model;
    private int memory;

    public GPU(String model, int memory) {
        this.model = model;
        this.memory = memory;
    }

    @Override
    public void display() {
        System.out.println("GPU Model: " + model + ", Memory: " + memory + "GB");
    }

    @Override
    public void checkHealth() {
        System.out.println("Checking GPU health...");
    }
}
