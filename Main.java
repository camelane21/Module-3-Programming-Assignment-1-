import java.util.Date;

// 1) The abstract base class

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        this.color      = color;
        this.filled     = filled;
        dateCreated     = new Date();
    }

    public String getColor()       { return color; }
    public void setColor(String c) { color = c; }

    public boolean isFilled()         { return filled; }
    public void setFilled(boolean f)  { filled = f; }

    public Date getDateCreated() { return dateCreated; }

    // Must be implemented by subclasses
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "created on " + dateCreated +
               "\ncolor: " + color + " and filled: " + filled;
    }
}


// 2) The Circle class
class Circle extends GeometricObject implements Comparable<Circle> {
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

    public double getRadius()             { return radius; }
    public void   setRadius(double r)     { radius = r; }

    @Override
    public double getArea()               { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter()          { return 2 * Math.PI * radius; }

    public double getDiameter()           { return 2 * radius; }

    @Override
    public int compareTo(Circle o)        { 
        return Double.compare(this.radius, o.radius); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return Double.compare(this.radius, other.radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius +
               ", color=" + getColor() +
               ", filled=" + isFilled() + "]";
    }
}

// 3) The driver with main()
public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0, "blue", true);
        Circle c2 = new Circle(3.0);

        System.out.println("c1: " + c1);
        System.out.println(" Area:      " + c1.getArea());
        System.out.println(" Perimeter: " + c1.getPerimeter());
        System.out.println(" Diameter:  " + c1.getDiameter());
        System.out.println();

        System.out.println("c2: " + c2);
        System.out.println(" Area:      " + c2.getArea());
        System.out.println(" Perimeter: " + c2.getPerimeter());
        System.out.println(" Diameter:  " + c2.getDiameter());
        System.out.println();

        int cmp = c1.compareTo(c2);
        System.out.println("c1.compareTo(c2) = " + cmp
            + " (" + (cmp > 0 ? "c1 larger" : cmp < 0 ? "c2 larger" : "equal") + ")");
        System.out.println("c1.equals(c2)? " + c1.equals(c2));
    }
}
