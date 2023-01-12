package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    StateElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,
sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
Elemanı tekrar bulmak.

 */

    @Test
    public void staleElementReferenceExceptionTest() {

        driver.get("https://www.techproeducation.com ");

        // LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLogin.click(); // LMS'e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms")); // URL'in lms kelimesini icerdigini test et
        waitFor(5);

        // Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back(); // tekrar anasayfaya gir
        waitFor(5);
        lmsLogin.click(); // LMS'e git  // org.openqa.selenium.StaleElementReferenceException

        /*
           lmsLogin linkini sayfa yenilendikten (back()) sonra kullandigimiz icin
           StaleElementReferenceException aliriz
         */
    }

    @Test
    public void staleElementReferenceExceptionTest2() {

        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        // sayfa yenilenmeden once buldugumuz elementi sayfa yenilendikten sonra kullandik
        lmsLoginLink.click();   // org.openqa.selenium.StaleElementReferenceException

        // COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        // driver.findElement(By.linkText("LMS LOGIN")).click();
    }
}
