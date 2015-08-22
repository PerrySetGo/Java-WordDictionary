import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

	@Override
	public WebDriver getDefaultDriver() {
	return webDriver;
	}

	@ClassRule
	public static ServerRule server = new ServerRule();

	@Rule
  	public ClearRule clearRule = new ClearRule();

	@Test
	public void rootTest() {
	goTo("http://localhost:4567/");
	assertThat(pageSource()).contains("Word Dictionary");
	}

	@Test
	public void wordIsCreatedTest() {
	goTo("http://localhost:4567/");
	fill("#userInputWordName").with("Dog");
	submit("#addWordButton");
	assertThat(pageSource()).contains("Dog");
	}

	@Test
	public void wordisCreatedWithoutADefinitionTest() {
	goTo("http://localhost:4567/");
	fill("#userInputWordName").with("Dog");
	submit("#addWordButton");
	click("a", withText("Dog"));
	assertThat(pageSource()).contains("Looks like nobody defined this word yet");
	}

	@Test
	public void DefinitionFormLoadsTest() {
	goTo("http://localhost:4567/");
	fill("#userInputWordName").with("Dog");
	submit("#addWordButton");
	click("a", withText("Dog"));
	click("a", withText("Add a new definition"));
	assertThat(pageSource()).contains("Add a Definition to Dog");
	}

	@Test
	public void DefinitionFormsDescriptionCorrectlyTest() {
	goTo("http://localhost:4567/");
	fill("#userInputWordName").with("Dog");
	submit("#addWordButton");
	click("a", withText("Dog"));
	click("a", withText("Add a new definition"));
	assertThat(pageSource()).contains("Add a Definition to Dog");
	fill("#description").with("A furry mammal");
	click(".btn");
	assertThat(pageSource()).contains("A furry mammal");
	}
}
