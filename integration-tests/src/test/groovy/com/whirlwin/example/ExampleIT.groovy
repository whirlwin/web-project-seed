package com.whirlwin.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
class ExampleIT extends TestCase {

    private static final String BASE_URL = "http://localhost:10001/web-project-seed-integration-tests"

    private WebDriver webDriver

    @Before
    @Override
    void setUp() throws Exception {
        webDriver = new FirefoxDriver()
    }

    @Test
    void checkIndexPageWorks() throws InterruptedException {
        webDriver.get BASE_URL
        assertThat webDriver.getTitle(), is("Web Project Seed")
    }

    @After
    @Override
    void tearDown() {
        webDriver.quit()
    }
}
