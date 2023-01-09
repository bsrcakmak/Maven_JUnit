package work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // Bos bir browser acar
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //  3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //  4. Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //  5. Sayfa basliginin "Amazon" icerdigini test edin
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //  6. Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        //  7. Sayfa url'inin "amazon" icerdigini test edin.
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //  8. Sayfa handle degerini yazdirin
        String handleDegeri = driver.getWindowHandle();
        System.out.println("handle = " + handleDegeri);

        //  9. Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        String actualKod = driver.getPageSource();
        String expectedKod = "Gateway";
        Assert.assertTrue(actualKod.contains(expectedKod));

        //   10. Sayfayi kapatin.
        driver.close();






    }
}
