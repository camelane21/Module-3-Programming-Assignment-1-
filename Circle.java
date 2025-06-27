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

     @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

      /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    // Compare by radius
    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }
