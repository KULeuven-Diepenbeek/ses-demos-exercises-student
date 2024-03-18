package org.example;
interface WithDistanceTo {
    public double distanceTo(Coordinate other);
}
public record Coordinate(double x, double y)
implements  WithDistanceTo {

    public double distanceTo(Coordinate other) {
        double dx = other.x() - this.x();
        double dy = other.y() - this.y();
        return Math.sqrt(dx*dx+dy*dy);
    }

    public Coordinate translate(double dx, double dy) {
        return new Coordinate(x + dx, y + dy);
    }

    public Coordinate withX(double x) {
        return new Coordinate(x, this.y);
    }
}
