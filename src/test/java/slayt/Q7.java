package slayt;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Q7 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // 1. Bir class oluşturun : AmazonSearchTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //b. Search(ara) "city bike"
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("city bike", Keys.ENTER);

        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        String search = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String result = search.split(" ")[2];
        System.out.println("ilgili sonuc sayisi : "+result);

        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        Thread.sleep(3000);
    }

}
