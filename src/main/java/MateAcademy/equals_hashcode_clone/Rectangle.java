package MateAcademy.equals_hashcode_clone;

public class Rectangle {
  private Integer width;
  private Integer length;
  private String color;

  public Rectangle(Integer width, Integer length, String color) {
    this.width = width;
    this.length = length;
    this.color = color;
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getLength() {
    return length;
  }

  public String getColor() {
    return color;
  }

  // https://www.youtube.com/watch?v=JDuKKpTWZhs
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Rectangle rectangle = (Rectangle) o;

    if (width != null ? !width.equals(rectangle.width) : rectangle.width != null) return false;
    if (length != null ? !length.equals(rectangle.length) : rectangle.length != null) return false;
    return color != null ? color.equals(rectangle.color) : rectangle.color == null;
  }

  @Override
  public int hashCode() {
    int result = width != null ? width.hashCode() : 0;
    result = 31 * result + (length != null ? length.hashCode() : 0);
    result = 31 * result + (color != null ? color.hashCode() : 0);
    return result;
  }
}
