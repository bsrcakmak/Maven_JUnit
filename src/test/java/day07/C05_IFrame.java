package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest(){
             // Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
             // tag[.='text'];   --> Bana bu tagli metni ver demek
             // tag[text()='text'];
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);  // index 0 dan baslar, ilk iframe e switch yapiyoruz
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedIcText = "Applications lists";
        Assert.assertEquals(expectedIcText,icMetin);
        // Assert.assertTrue(icMetin.contains(expectedIcText));   --> 2.yol
        // Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed()); --> 3. yol ama tavsiye edilmez

        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip
        // Anasayfadaki Povered by yazisini test etmek istiyoruz ancak driver hala iframein icinde
        // Iframe disina cikmak icin driver.switchTo.defaultContent/parentFrame() kullaniriz
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));



    }
}
