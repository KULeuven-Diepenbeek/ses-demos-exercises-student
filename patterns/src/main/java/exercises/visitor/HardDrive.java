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
    public void display() {
        System.out.println("Hard Drive Type: " + type + ", Capacity: " + capacity + "GB");
    }

    @Override
    public void checkHealth() {
        System.out.println("Checking harddrive health...");
    }
}
