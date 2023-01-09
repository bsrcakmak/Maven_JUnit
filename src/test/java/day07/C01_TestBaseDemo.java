package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
      UTILITIES;
    - Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir
       # TestBase
       # Driver -> Sonra
       # ExcelUtil -> Sonra
       # Configuration -> Sonra
    - Utilities paketinde Test case'ler yazilmaz(test siniflarinda yazilir)
    - Sadece tekrar kullanilabilecek destek siniflari(support class) olusturulur
    - Bu support class'lar test case'lerin yazilmasini hizlandirir
     */

    @Test
    public void test01(){
        //techproeducation ana sayfasina git
        driver.get("https://www.techproeducation.com");

        // ve tittle'in "Bootcamps' kelimesini icerdigini test edelim
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamps"));

    }
}
