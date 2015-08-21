import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
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

	@Test
	public void rootTest() {
	goTo("http://localhost:4567/");
	assertThat(pageSource()).contains("Word Dictionary");
	}

	@Test
	public void wordIsCreatedTest() {
	goTo("http://localhost:4567/");
	fill("#addWordName").with("Dog");
	fill("#addWordDefinition").with("A furry mammal");
	submit("#addWordButton");
	assertThat(pageSource()).contains("Your word has been saved.");
	}

	@Test
	public void wordIsDisplayedTest() {
	goTo("http://localhost:4567/");
	fill("#addWordName").with("Dog");
	fill("#addWordDefinition").with("A furry mammal");
	submit("#addWordButton");;
	click("a", withText("Go Back"));
	assertThat(pageSource()).contains("Dog");
	}

	@Test
	public void multipleWordsAreDisplayedTest() {
	goTo("http://localhost:4567/");
	fill("#addWordName").with("Dog");
	fill("#addWordDefinition").with("A furry mammal");
	submit("#addWordButton");;
	click("a", withText("Go Back"));
	fill("#addWordName").with("Pigeon");
	fill("#addWordDefinition").with("A flying rat");
	submit("#addWordButton");;
	click("a", withText("Go Back"));
	assertThat(pageSource()).contains("Dog");
	assertThat(pageSource()).contains("Pigeon");

	}
}
