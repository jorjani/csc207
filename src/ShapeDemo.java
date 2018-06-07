import java.util.ArrayList;
import java.util.List;

public class ShapeDemo {
    public static void main(String[] args) throws InstantiationException {
        List<Shape> shapes = new ArrayList<Shape>();
        Shape s1 = new Square(1, 1);
        Shape s2 = new Rectangle(2, 1);
        Shape s3 = new Circle(3);
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);

        List<Circle> circles = new ArrayList<Circle>();
        circles.add((Circle)s3);

        List<Square> squares = new ArrayList<Square>();
        Square sq1 = new Square(4,4);
        squares.add(sq1);

        //Step 1: Using printArea with specific objects. What do you think?
        Square.printArea(squares);
        Circle.printArea(circles);


        //Step 2: Using printArea with Objects. Is this better? Is there a disadvantage?
        Point newPoint = new Point(1,2);
        List<Object> objects = new ArrayList<Object>();
        objects.add(newPoint);
        Shape.printObjectAreas((new ArrayList<Object>(objects)));


        //Step 3: Using print method with shapes. How does this compare to the previous steps?
        Shape.printShapeAreas(shapes);

        //Step 4: Using a Generic method. How does this compare to the previous steps?
        Shape.<Square>printGenericAreas(squares);

        try{
            Shape.printObjectAreas(objects);
        }catch (ShapeException e3){
            System.out.println(e3.getMessage());
        }
    }
}

