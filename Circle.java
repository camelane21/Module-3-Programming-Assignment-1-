public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

 //Return radius 
    public double getRadius() {
        return radius;
    }

    // Set a new radius 
    public void setRadius(double radius) {
        this.radius = radius;
    }