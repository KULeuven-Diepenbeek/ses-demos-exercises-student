package exercises.visitor;

interface HardwareComponent {
    void accept(ComponentVisitor visitor);
}

