package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration; // Import the Duration class

public class Demoqa_Reloaded {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Create a replacement using the actual path to the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");

        // Implement login functionality here (replace with your login logic)
    }

    @Test
    public void addBookToProfile() throws InterruptedException {
        // Add a book to the profile (replace with actual book selection logic)
        WebElement bookTitle = driver.findElement(By.xpath("//h5[text()='Git Pocket Guide']"));
        bookTitle.click();

        // Improve validation with explicit wait and assertion
        new WebDriverWait(driver, Duration.ofSeconds(10)) // Use Duration object
                .until(ExpectedConditions.presenceOfElementLocated(By.id("book-details")));

        driver.findElement(By.linkText("Back To Book Store")).click();
    }

    @Test
    public void removeBookFromProfile() throws InterruptedException {
        // Implement login functionality in order to access profile page

        // Making the assumption that the profile page is loaded and book exists
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        removeButton.click();

        // Improve validation with wait for confirmation message
        new WebDriverWait(driver, Duration.ofSeconds(10)) // Use Duration object
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[text()='Book to be removed']")));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}