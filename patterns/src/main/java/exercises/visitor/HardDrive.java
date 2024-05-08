package exercises.visitor;

class HardDrive implements HardwareComponent {
    private String type;
    private int capacity;

    public HardDrive(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitHarddrive(this);
    }
}
