package exercises.visitor;

public interface ComponentVisitor {
    void visitCPU(CPU cpu);

    void visitGPU(GPU gpu);

    void visitHarddrive(HardDrive hardDrive);

    void visitSystem(ComputerSystem computerSystem);
}
