import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void wordInitializesCorrectly_true() {
    Word testWord = new Word("Dog", 1, "A furry mammal");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWordName_returnsWordName_true() {
    Word testWord = new Word("Dog", 1, "A furry mammal");
    assertEquals("Dog", testWord.getName());
   }

   @Test
   public void getWordIdreturnsWordName_true() {
    Word testWord = new Word("Dog", 1, "A furry mammal");
    assertEquals(1, testWord.getWordId());
  }

  @Test
  public void getWordDefinitionReturnsDefinition_true() {
    Word testWord = new Word("Dog", 1, "A furry mammal");
    assertEquals("A furry mammal", testWord.getDefinition());
  }
}
