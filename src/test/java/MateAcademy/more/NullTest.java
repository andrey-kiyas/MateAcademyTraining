package MateAcademy.more;

import org.junit.Assert;
import org.junit.Test;

public class NullTest {
  @Test
  public void hashCode_returns0() {
    Null n = new Null();
    Assert.assertEquals("The method 'hashCode()' should return 0 when invoked in a new instance of Null\n",
      0, n.hashCode());
  }

  @Test
  public void hashCode_returnsSameValue() {
    Null n = new Null();
    Assert.assertEquals("The method 'hashCode()' should return the same values after being called in different instances of Null\n",
      new Null().hashCode(), n.hashCode());
  }

  @Test
  public void equals_equalsNull() {
    Null n = new Null();
    Assert.assertEquals("A new instance of Null should equal null\n",
      n, null);
  }

  @Test
  public void equals_sameInstance() {
    Null n = new Null();
    Assert.assertEquals("Instance of Null should be the same\n",
      n, n);
  }

  @Test
  public void equals_equalInstances() {
    Null n = new Null();
    Assert.assertEquals("Two instances of Null should equal each other\n",
      n, new Null());
  }

  @Test
  public void equals_notEqualsToObject() {
    Null n = new Null();
    Object obj = new Object();
    Assert.assertEquals("The instance of Null should not equal to an instance of a new Object\n",
      false, n == obj);
  }

  @Test
  public void toString_returnsStringNull() {
    Null n = new Null();
    Assert.assertEquals("The method 'toString()' should return a string \"null\" when invoked in a new instance of Null\n",
      "null", n.toString());
  }
}
