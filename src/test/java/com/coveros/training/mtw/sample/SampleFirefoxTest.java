package com.coveros.training.mtw.sample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Simple test class that verifies proper installation of MTW tools and
 * libraries
 * 
 * @author brian
 *
 */
public class SampleFirefoxTest {
	private WebDriver driver;

	private static String getOs() {
		String os = System.getProperty("os.name");
		os = os.substring(0, os.indexOf(" ")).toLowerCase();
		return os;
	}

	@BeforeClass
	public static void beforeClass() {
		String os = getOs();
		String driverName = "geckodriver";
		if (os.equals("windows")) {
			driverName += ".exe";
		}
		System.setProperty("webdriver.gecko.driver", "src/test/drivers/" + driverName + "/" + os + "/" + driverName);
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Runs a simple test verifying the title of the amazon.com homepage.
	 * 
	 * @throws Exception
	 */
	@Test
	public void coveros() throws Exception {
		driver.navigate().to("https://www.coveros.com/");
		assertEquals("Coveros", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
