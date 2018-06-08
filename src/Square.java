import java.util.List;
import java.util.ListIterator;

public class Square extends Rectangle implements IPricer {
  private double size;

  public Square(double length, double width) throws InstantiationException {
    super(length, width);
    if (length == width) {
      this.size = length;
    } else if (length == 5) {
      throw new RuntimeException("Can't create dude! This square is too big!!");
    } else {
      throw new InstantiationException("this is not a square");
    }
  }

  public Square(double size) {
    super(size, size);
  }

  public static void printArea(List<Square> squareList) {
    ListIterator<Square> squareListIterator = squareList.listIterator();
    while (squareListIterator.hasNext()) {
      System.out.println(squareListIterator.next().getArea());
    }
  }

  @Override
  public String identifySelf() {
    return "I am a Square";
  }

  @Override
  public double getPrice() {
    return size * size * 3;
  }
}
