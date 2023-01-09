package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Odev extends TestBase {
    //Bir class olusturun: IframeOdev
    //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    //sayfadaki toplam iframe sayısını bulunuz.
    //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
    //Paragrafdaki yaziyi silelim
    //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
    //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim

    @Test
    public void test(){
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String title = driver.findElement(By.xpath("//h3")).getText();

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        int count = iframe.size();
        System.out.println(count);

        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        Assert.assertTrue(title.contains("Editor"));

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement paragrafYazisi = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        paragrafYazisi.clear();

        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        paragrafYazisi.sendKeys("iframein icindeyim");

        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String text = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertTrue(text.contains("Elemental Selenium"));

    }
}
