package ekpractice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {

    @Test
    public void test() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//div[@class='imgHolder  cargoCampaign '])[1]")).click();
        Set<String> windowHandelSeti = driver.getWindowHandles();
        String sayfa2Handle=" ";
        for (String w:windowHandelSeti){
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println(windowHandelSeti);
        System.out.println(sayfa1Handle);
        driver.switchTo().window(sayfa2Handle);

        // Basligin 'Oppo' icerdigini test edin.
        String oppoBaslik = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertTrue(oppoBaslik.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);

    }
}
