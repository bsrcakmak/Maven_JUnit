package practice_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions_SekilCizme extends TestBase {
    @Test
    public void test() {

        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement signaturePad = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(signaturePad,100,100);
        actions.clickAndHold();
        actions.moveByOffset(50,0);
        actions.moveByOffset(0,50);
        actions.moveByOffset(-50,0);
        actions.moveByOffset(0,-50);
        actions.moveByOffset(50,0);
        actions.release().perform();
        waitFor(5);

        //    - Son olarak sayfayı temizleyiniz
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
    }

    @Test
    public void test02() {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yazitahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yazitahtasi).clickAndHold();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,-5);
        }
        for (int i = 0; i < 32; i++) {
            actions.moveByOffset(-5,0);
        }

         actions.release().build().perform();
        // release olmazsa mouse kalmadan islem yapmaya devam eder

        //    - Son olarak sayfayı temizleyiniz
        driver.findElement(By.xpath("//*[text()='Clear']")).click();



    }
}
