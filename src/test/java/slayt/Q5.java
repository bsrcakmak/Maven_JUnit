package slayt;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class Q5 extends TestBase {

    @Test
    public void test(){
        // 1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
        driver.get("https://www.facebook.com");

        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String title = driver.getTitle();


        //3.Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i
        //yazdirin.
        //4.https://www.walmart.com/ sayfasina gidin.
        //5. Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        //6. Tekrar "facebook" sayfasina donun
        //7. Sayfayi yenileyin
        //8.Sayfayi tam sayfa (maximize) yapin
        //9.Browser'i kapatin
    }
}
