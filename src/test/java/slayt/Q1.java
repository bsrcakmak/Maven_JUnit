package slayt;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import javax.swing.*;

public class Q1 extends TestBase {

    @Test
    public void test(){
        // 1. Yeni bir package olusturalim : day01
        //2. Yeni bir class olusturalim : C03_GetMethods
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //4. Sayfa basligini(title) yazdirin
        String title = driver.getTitle();
        System.out.println("Baslik : "+title);

        //5. Sayfa basliginin "Amazon" icerdigini test edin
        Assert.assertTrue(title.contains("Amazon"));

        //6. Sayfa adresini(url) yazdirin
        String url = driver.getCurrentUrl();
        System.out.println("Sayfa url'si : "+url);

        //7. Sayfa url'inin "amazon" icerdigini test edin.
        Assert.assertTrue(url.contains("amazon"));

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle Degeri : "+ driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));
    }
}
