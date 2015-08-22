import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void wordInitializesCorrectly_true() {
    Word testWord = new Word("Dog");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWordName_returnsWordName_true() {
    Word testWord = new Word("Dog");
    assertEquals("Dog", testWord.getName());
   }

  @Test
    public void getWordIdisCorrect_true() {
    Word testWord = new Word("Dog");
    assertEquals(1, testWord.getWordId());
  }
}
