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

	@Test
	public void getDefinitionIsCorrect_true() {
	Definition testDefinition = new Definition("A furry mammal");
	String testDescription =  "A furry mammal";
	assertEquals(testDescription,testDefinition.getDefinition());
	}

  @Test
  public void clear_clearsAllDefinitions() {
  Definition testDefinition = new Definition("A furry mammal");
  Definition.clear();
  assertEquals(Definition.all().size(), 0);
	}

}
