package exercises.visitor;

public class HealthVisitor implements ComponentVisitor {
    @Override
    public void visitCPU(CPU cpu) {
        System.out.println("Checking CPU health...");
    }

    @Override
    public void visitGPU(GPU gpu) {
        System.out.println("Checking GPU health...");
    }

    @Override
    public void visitHarddrive(HardDrive hardDrive) {
        System.out.println("Checking harddrive health...");
    }

    @Override
    public void visitSystem(ComputerSystem computerSystem) {
        computerSystem.getCPU().accept(this);
        computerSystem.getGPU().accept(this);
        computerSystem.getHardDrive().accept(this);
    }
}
