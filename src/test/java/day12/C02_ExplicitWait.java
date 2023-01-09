package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void explicitWaitTest() {

        /*
        // Note: implicitlyWait Sayfa'daki webelement'lerin yüklenmesi için bekliyor
        ama içerde bir buttona basınca loading yani bekleme yaparken çalışmıyor.
        Bu gibi durumlarda da explicitlyWait kullaniyoruz.
         */

        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        //Assert.assertEquals("HelloWorld!",helloWorldElement.getText());
        // IMPLICITLY WAIT ile test case calismadi
        // Cozum EXPLICITLY WAIT

        //  1. WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //  2. wait objesini kullanarak bekleme problemini cozmeye calis
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }
}
