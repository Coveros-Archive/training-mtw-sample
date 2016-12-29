package com.coveros.training.mtw.sample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Simple test class that verifies proper installation of MTW tools and
 * libraries
 * 
 * @author brian
 *
 */
public class SampleFirefoxTest {
	private WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/geckodriver");
	}

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new MarionetteDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Runs a simple test verifying the title of the amazon.com homepage.
	 * 
	 * @throws Exception
	 */
	@Test
	public void coveros() throws Exception {
		driver.get("https://www.coveros.com/");
		assertEquals("Coveros", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
