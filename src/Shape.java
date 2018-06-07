import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class Shape<T> implements IPricer {
    @Override
    public double getPrice() {
        return 0;
    }
    public abstract double getArea();
    public abstract String identifySelf();

    public static <T extends Shape> void printGenericAreas(List<T> shapes) {
        ListIterator<T> shapeIterator = shapes.listIterator();
        while(shapeIterator.hasNext()){
            System.out.println(shapeIterator.next().getArea());
        }
    }

    public static void printShapeAreas(List<Shape> shapes) throws ShapeException{
        ListIterator<Shape> shapeIterator = shapes.listIterator();
        Shape newShape;
        while(shapeIterator.hasNext()){
            try{
                newShape = shapeIterator.next();
            }catch(Exception e){
                throw new ShapeException("wrong variable");
            }
            System.out.println(newShape.getArea());
        }
    }

    public static void printObjectAreas(List<Object> objects) throws ShapeException{
        ListIterator<Object> objectIterator = objects.listIterator();
        Shape newShape = null;
        while(objectIterator.hasNext()){
            try{
                newShape = (Shape)objectIterator.next();
            }catch(ShapeException e){
                System.out.println("alas.... I don't know how to handle this");
            //Catching an exception but not handling it properly is bad practice.
            //Maybe like using pain killers without knowing what caused it.
            }catch(ClassCastException e2){
                throw new ShapeException("wrong shape");
            }
            System.out.println(newShape.getArea());
        }
    }
}
