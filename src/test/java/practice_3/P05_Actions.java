package practice_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class P05_Actions extends TestBase {
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
}
