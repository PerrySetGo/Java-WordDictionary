import org.junit.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void definitionInitializesCorrectly_true() {
    Definition testDefinition = new Definition("A furry mammal");
    assertEquals(true, testDefinition instanceof Definition);
  }
}
