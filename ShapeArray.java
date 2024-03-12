public class ShapeArray {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(3.0);
        Cylinder cylinder = new Cylinder(2.0, 4.0);
        Cone cone = new Cone(2.0, 5.0);

        Shape[] shapeArray = {sphere, cylinder, cone};

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}