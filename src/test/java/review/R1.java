package review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class R1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // Baslik Amazon iceriyor mu
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Testi PASSED");
        }else System.out.println("Title " + expectedTitle + "'yi icermiyor, Title Testi FAILED");

        // Url "https://amazon.com" a esit mi
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://amazon.com";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url Testi PASSED");
        }else System.out.println("Url " + expectedUrl + "'yi icermiyor, Url Testi FAILED");

        driver.close();
    }
}
