package com.coveros.training.mtw.sample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

import io.github.bonigarcia.wdm.MarionetteDriverManager;

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
	public static void setupClass() {
		MarionetteDriverManager.getInstance().setup();
	}

	@Before
	public void setUp() throws Exception {
		driver = new MarionetteDriver();
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
		driver.quit();
	}
}
