package MateAcademy.equals_hashcode_clone;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarTest {
  @Test
  public void car_checkThatCarImplementsCloneable() {
    String cloneableInterface = "java.lang.Cloneable";
    List<Type> interfaces = Arrays.asList(Car.class.getGenericInterfaces());
    interfaces.stream()
      .filter(i -> i.getTypeName().equals(cloneableInterface))
      .findFirst().orElseThrow(
        () -> new RuntimeException("Class Car should implement interface Cloneable"));
  }

  @Test
  public void car_checkCarFieldsCount() {
    List<Field> privateFields = new ArrayList<>();
    List<Field> allFields = Arrays.asList(Car.class.getDeclaredFields());
    for (Field field : allFields) {
      if (Modifier.isPrivate(field.getModifiers())) {
        privateFields.add(field);
      }
    }

    Assert.assertEquals("You should have private fields only!",
      allFields.size(), privateFields.size());
    Assert.assertEquals("You should have at least 5 fields in the Car class",
      true, privateFields.size() >= 5);
  }

  @Test
  public void car_checkEngineExistsInCar() {
    List<Field> allFields = Arrays.asList(Car.class.getDeclaredFields());
    Optional<Field> engine = allFields.stream()
      .filter(f -> f.getGenericType().getTypeName().endsWith("Engine")
        && f.getName().equals("engine"))
      .findAny();
    Assert.assertEquals("You should have an `Engine engine` field in your car",
      true, engine.isPresent());
  }

  @Test
  public void car_checkThatMethodCloneExists() {
    car_getCloneMethod();
  }

  @Test
  public void car_checkThatMethodCloneHasNoParameters() {
    Method cloneMethod = car_getCloneMethod();
    int parameterCount = cloneMethod.getParameterCount();
    Assert.assertEquals("You shouldn't use parameters in clone method signature",
      0, parameterCount);
  }

  @Test
  public void engine_checkThatEngineClassImplementsCloneable() {
    String cloneableInterface = "java.lang.Cloneable";
    List<Type> interfaces = Arrays.asList(Engine.class.getGenericInterfaces());
    interfaces.stream()
      .filter(i -> i.getTypeName().equals(cloneableInterface))
      .findFirst().orElseThrow(
        () -> new RuntimeException("Class Engine should implement interface Cloneable"));
  }

  @Test
  public void engine_checkEngineFieldsCount() {
    List<Field> privateFields = new ArrayList<>();
    List<Field> allFields = Arrays.asList(Engine.class.getDeclaredFields());
    for (Field field : allFields) {
      if (Modifier.isPrivate(field.getModifiers())) {
        privateFields.add(field);
      }
    }

    Assert.assertEquals("You should have private fields only!",
      allFields.size(), privateFields.size());
    Assert.assertEquals("You should have at least 5 fields in the Engine class",
      true, privateFields.size() >= 5);
  }

  @Test
  public void engine_checkThatMethodCloneExists() {
    engine_getCloneMethod();
  }

  @Test
  public void engine_checkThatMethodCloneHasNoParameters() {
    Method cloneMethod = engine_getCloneMethod();
    int parameterCount = cloneMethod.getParameterCount();
    Assert.assertEquals("You shouldn't use parameters in clone method signature",
      0, parameterCount);
  }

  @Test
  public void car_checkDeepCloning() {
    Car car = null;
    Engine engine = null;
    try {
      engine = Engine.class.getDeclaredConstructor().newInstance();
    } catch (ReflectiveOperationException e) {
      Assert.fail("You should have a public empty constructor in your Engine class!");
    }
    try {
      car = Car.class.getDeclaredConstructor().newInstance();
    } catch (ReflectiveOperationException e) {
      Assert.fail("You should have a public empty constructor in your Car class!");
    }
    try {
      car_getSetEngineMethod().invoke(car, engine);
    } catch (ReflectiveOperationException e) {
      Assert.fail("You should have a `setEngine(Engine engine)` method in your Car class!");
    }
    try {
      Car clonedCar = (Car) car_getCloneMethod().invoke(car);
      if (car_getEngineFieldValue(car) == car_getEngineFieldValue(clonedCar)) {
        Assert.fail("You should implement a deep cloning of Car! "
          + "Now both original car and cloned car reference the same Engine instance");
      }
    } catch (ReflectiveOperationException e) {
      Assert.fail("You should have a clone() method in your Car class!");
    }
  }

  private Method car_getCloneMethod() {
    List<Method> carMethods = Arrays.asList(Car.class.getDeclaredMethods());
    return carMethods.stream()
      .filter(m -> m.getName().equals("clone"))
      .filter(clone -> ! clone.toString().contains("Object")) // remove default method
      .findFirst()
      .orElseThrow(() ->
        new RuntimeException("Method clone() should be present in the Car class"));
  }

  private Method engine_getCloneMethod() {
    List<Method> engineMethods = Arrays.asList(Engine.class.getDeclaredMethods());
    return engineMethods.stream()
      .filter(m -> m.getName().equals("clone"))
      .filter(clone -> clone.toString().contains("Object")) // remove default method
      .findFirst()
      .orElseThrow(() ->
        new RuntimeException("Method clone() should be present in the Engine class"));
  }

  private Method car_getSetEngineMethod() {
    List<Method> carMethods = Arrays.asList(Car.class.getDeclaredMethods());
    return carMethods.stream()
      .filter(m -> m.getName().equals("setEngine"))
      .findFirst()
      .orElseThrow(() ->
        new RuntimeException("Method setEngine() should be present in the Car class"));
  }

  private Engine car_getEngineFieldValue(Car car) {
    try {
      return (Engine) Arrays.stream(Car.class.getDeclaredFields())
        .filter(field -> field.getName().equals("engine"))
        .peek(field -> field.setAccessible(true))
        .findFirst()
        .orElseThrow()
        .get(car);
    } catch (Exception e) {
      throw new RuntimeException("You should have an `Engine engine` field in your Car class");
    }
  }
}
