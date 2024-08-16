package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidTest {
    @Test
    public void androidLaunchLoginTest() throws MalformedURLException, InterruptedException {
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setAutomationName("UiAutomator2");
//        options.setDeviceName("Android Emulator");
//        options.setApp(System.getProperty("C:\\Users\\omkar\\Downloads\\level-supermind-meditations-3-0-41.apk"));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "level.game");
        caps.setCapability("appActivity", ".MainActivity ");
        caps.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),caps);
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("9819914730");
        driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Arrow Right\"])[1]")).click();
        Thread.sleep(8000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.gms:id/positive_button\"]")).click();
        Thread.sleep(6000);
        WebElement homeElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Tell us about yourself for personalised recommendations\"]"));
        if (homeElement.isDisplayed()) {
            System.out.println("Login successful!");
            System.out.println(homeElement.getText());
        } else {
            System.out.println("Login failed!");
        }
        Thread.sleep(4000);
    }
    @Test
    public void androidInvalidLoginTest() throws MalformedURLException, InterruptedException {
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setAutomationName("UiAutomator2");
//        options.setDeviceName("Android Emulator");
//        options.setApp(System.getProperty("C:\\Users\\omkar\\Downloads\\level-supermind-meditations-3-0-41.apk"));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "level.game");
        caps.setCapability("appActivity", ".MainActivity ");
        caps.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),caps);
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("9819914730");
        driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Arrow Right\"])[1]")).click();
        Thread.sleep(6000);
//        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.gms:id/negative_button\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("123456");
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Arrow Right\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[@text=\"Invalid OTP\"]")));
        String toastText = toastMessage.getText();
        // Verify the toast message text
        String expectedMessage = "Invalid OTP";
        if (toastText.equals(expectedMessage)) {
            System.out.println("Test Passed: Toast message is correct.");
        } else {
            System.out.println("Test Failed: Toast message is incorrect.");
            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + toastText);
        }
    }
}
