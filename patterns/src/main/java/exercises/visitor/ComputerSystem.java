package exercises.visitor;

public class ComputerSystem implements HardwareComponent {
    private CPU cpu;
    private GPU gpu;
    private HardDrive hd;

    public ComputerSystem(CPU cpu, GPU gpu, HardDrive hd) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.hd = hd;
    }

    public CPU getCPU() {
        return cpu;
    }

    public GPU getGPU() {
        return gpu;
    }

    public HardDrive getHardDrive() {
        return hd;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSystem(this);
    }

}
