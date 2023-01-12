package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
       Explicit wait kullanildiginda ve locater bulunamadiginda TimeoutException alinir
     */



    @Test
    public void timeOutExceptionTest() {

        driver.get("https://www.techproeducation.com ");
        // Explit wait icin olusturdugumuz methodlardan birini kullanalim
        // Parametre 1: beklemek istedigim element, Parametre 2: Max sure
        // waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")),15).sendKeys("QA"+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:

    }

     /*
        *** TimeOutException: ***
        *
     & Explicit wait kullanildiginda ve element bulunamadiginda alinir
     & Explictly wait ve yanlis locater varsa --> timeout alinir
     & Explictly wait ve dogru locater ve sure yeterli degilse --> timeout
     & Explictly wait ve dogru locater ve sure yeterli ama iframe var --> timeout
     *
     * Solution: ==> Cozum
     * Sureyi arttirmak
     * Farkli explicit wait yöntemleri kullanırız. Örn: VisibilityOfElementLocated çözmedi yerine presenceOfElementLocator kullanılabilir.
Ya da javascript executor da ki waitleri sayfa geçişlerini beklemek için kullanabiliriz.
Locatorı kontrol ederiz.
Frameworkümde hazır reusable methodlar var. Bu durumda TimeOutException aldığımda o methodlar yardımıyla problemi çözebiliriz.

     */
    /*
    TimeOutException:
If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
Simply put, wait time is over but the commend is not completed
Solution:
-Increase the wait time
-Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
-I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
-Case by case, I prefer different explicit waits to maximize the performance of the automation script
     */
}
