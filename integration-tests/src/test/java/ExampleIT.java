import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public final class ExampleIT {

    private static final String BASE_URL = "http://localhost:10001/web-project-seed-integration-tests";

    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        webDriver = new FirefoxDriver();
    }

    @Test
    public void example() throws InterruptedException {
        webDriver.get(BASE_URL);
        assertThat(webDriver.getTitle(), is("Web Project Seed"));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
