import org.junit.*;
import static org.junit.Assert.*;

public class DictionaryTest {

  @Test
  public void dictionaryInstantiatesCorrectly_true() {
    Dictionary testDictionary = new Dictionary();
    assertEquals(true, testDictionary instanceof Dictionary);
  }

  // @Test
  // public void emptyDictionaryIsCorrectSizeTrue(){
  // 	Dictionary testDictionary = new Dictionary();
  // 	Integer testSize = testDictionary.getDictionarySize();
  // 	assertEquals(1, testSize);
  // }
}