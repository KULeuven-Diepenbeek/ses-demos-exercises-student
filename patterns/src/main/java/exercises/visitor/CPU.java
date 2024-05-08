package exercises.visitor;

class CPU implements HardwareComponent {
    private String model;
    private int cores;

    public CPU(String model, int cores) {
        this.model = model;
        this.cores = cores;
    }

    public String getModel() {
        return model;
    }

    public int getCores() {
        return cores;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitCPU(this);
    }

}
