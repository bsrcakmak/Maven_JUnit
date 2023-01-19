package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {

    // scrollIntoViewTest metotu olustur
    //Techpro education ana sayfasina git
    //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al - DONE
    //Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    //Ayni sayfada tekrar Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al


    @Test
    public void scrollIntoViewTest() throws IOException {

        driver.get("https://techproeducation.com");
        waitFor(3);

        // ** We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        // 1. Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));
        waitFor(3);

        //2. JS Executor objesi olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 3. Yapmak istedigimiz islemi js.executeScript() methodu ile yap
        // scrollIntoView(true) methodu belirli bir elemente scroll yapmak icin kullanilir
        // arguments[0] ilk parametredeki element
        // istenen eleman gorunene kadar method'daki isi yap
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);

        // Sayfa goruntusunu al
        takeScreenShotOfPage();


        // ** Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();


        // ** Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();



        // ** Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        // Sayfanin en ustune git
        scrollTopJS();
        waitFor(3);


        // Sayfanin en altina git
        scrollEndJS();
        waitFor(3);
    }
}
