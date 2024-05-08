package exercises.visitor;

class GPU implements HardwareComponent {
    private String model;
    private int memory;

    public GPU(String model, int memory) {
        this.model = model;
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitGPU(this);
    }
}
