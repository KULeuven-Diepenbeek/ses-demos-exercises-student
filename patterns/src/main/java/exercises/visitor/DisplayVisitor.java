package exercises.visitor;

public class DisplayVisitor implements ComponentVisitor {
    @Override
    public void visitCPU(CPU cpu) {
        System.out.println("CPU Model: " + cpu.getModel() + ", Cores: " + cpu.getCores());
    }

    @Override
    public void visitGPU(GPU gpu) {
        System.out.println("GPU Model: " + gpu.getModel() + ", Memory: " + gpu.getMemory() + "GB");
    }

    @Override
    public void visitHarddrive(HardDrive hardDrive) {
        System.out.println("Hard Drive Type: " + hardDrive.getType() +
                ", Capacity: " + hardDrive.getCapacity() + "GB");
    }

    @Override
    public void visitSystem(ComputerSystem computerSystem) {
        computerSystem.getCPU().accept(this);
        computerSystem.getGPU().accept(this);
        computerSystem.getHardDrive().accept(this);
    }
}
