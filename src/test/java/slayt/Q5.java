package slayt;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class Q5 extends TestBase {

    @Test
    public void test(){
        // 1.Yeni bir class olusturalim (Homework)

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "Facebook"
        driver.get("https://www.facebook.com");

        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Facebook"));

        //3.Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i
        //yazdirin.
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("facebook"));

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        //5. Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        String title2 = driver.getTitle();
        Assert.assertTrue(title2.contains("Walmart.com"));

        //6. Tekrar "facebook" sayfasina donun
        driver.navigate().back();

        //7. Sayfayi yenileyin
        driver.navigate().refresh();

        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //9.Browser'i kapatin
        driver.quit();
    }
}
