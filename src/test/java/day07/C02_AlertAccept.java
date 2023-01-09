package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {

         /*
    Alertleri nasil automate ederiz? How to handle alerts in selenium?
    Alertler Javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */


      //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

      //1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
      // uyarıdaki OK butonuna tıklayın

        Thread.sleep(5000);
        driver
                .switchTo()// degistir
                .alert()  // alerte degistir
                .accept();  // okey diyecegimiz icin accept() secilir, cansel dicek olsaydik dismiss() secerdik
        Thread.sleep(5000);

        // ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);
    }
}
