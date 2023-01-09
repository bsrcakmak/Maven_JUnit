package review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverMethodlari {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // amazon sitesindeki kaynak kodlarinda "spend less' yazdigini test edin
        String sayfaKaynakKodlari = driver.getPageSource();  // ctrl+U  sayfada kaynak kodlari gosterir
        String arananKelime = "spend less";
        if (sayfaKaynakKodlari.contains(arananKelime)){
            System.out.println("Kaynak Kodu Testi PASSED");
        }else System.out.println("Kaynak kodlarinda "+ arananKelime + " yok, test FAILED");

        driver.close();

    }
}
