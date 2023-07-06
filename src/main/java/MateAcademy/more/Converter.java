package MateAcademy.more;

public class Converter {
  public static float toKiloPerLiter(float mpg) {
    // write code here
    return (float) (Math.round((mpg / 2.82485875706215f) * 100.0) / 100.0);
  }

  public static void main(String[] args) {
    System.out.println(toKiloPerLiter(10));
  }
}
//Math.round(random * 100.0) / 100.0

// 2,82485875706215