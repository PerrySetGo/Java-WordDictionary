import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesCorrectly_true() {
    Word testWord = new Word("Dog", 1);
    assertEquals(true, testWord instanceof Word);
  }

  // @Test
  // public void getSuit_returnsACardsSuit_Spades() {
  //   Card testCard = new Card("Spades", "Ace");
  //   assertEquals("Spades", testCard.getSuit());
  // }

  // @Test
  // public void getValue_returnsACardsSuit_Ace() {
  //   Card testCard = new Card("Spades", "Ace");
  //   assertEquals("Ace", testCard.getValue());
  // }

  // @Test
  // public void name_returnsAFormattedNameForCard_AceOfSpades() {
  //   Card testCard = new Card("Spades", "Ace");
  //   assertEquals("Ace of Spades", testCard.name());
  // }
}
