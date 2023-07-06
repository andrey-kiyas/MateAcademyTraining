package MateAcademy.more;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {
  @Test
  public void findMostSimilar_cherryInDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
    Assert.assertEquals(String.format("The result for the input term \"%s\" should be \"%s\" from the fruits dictionary\n",
      "berry", "cherry"), "cherry", dictionary.findMostSimilar("berry"));
  }

  @Test
  public void findMostSimilar_strawberryInDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
    Assert.assertEquals(String.format("The result for the input term \"%s\" should be \"%s\" from the fruits dictionary\n",
      "strawberry", "strawberry"), "strawberry", dictionary.findMostSimilar("strawberry"));
  }

  @Test
  public void findMostSimilar_javaInDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
    Assert.assertEquals(String.format("The result for the input term \"%s\" should be \"%s\" from the languages dictionary\n",
      "heaven", "java"), "java", dictionary.findMostSimilar("heaven"));
  }

  @Test
  public void findMostSimilar_pythonInDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
    Assert.assertEquals(String.format("The result for the input term \"%s\" should be \"%s\" from the languages dictionary\n",
      "piton", "python"), "python", dictionary.findMostSimilar("piton"));
  }

  @Test
  public void findMostSimilar_thingsInDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"earth", "mars", "uranus", "venus", "saturn"});
    Assert.assertEquals(String.format("The result for the input term \"%s\" should be \"%s\" from the planet dictionary\n",
      "moon", "mars"), "mars", dictionary.findMostSimilar("moon"));
  }
}
