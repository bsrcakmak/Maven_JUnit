package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Work01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");


        // 3- cookies uyarisini kabul ederek kapatin


        //4Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Testi PASSED");
        }else System.out.println("Title Testi FAILED");


        //5Arama cubuguna “Nutella” yazip aratin
        WebElement arama = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        arama.sendKeys("Nutella");
        arama.submit();

        // 6-Bulunan sonuc sayisini yazdirin
        List<WebElement> aramaSonucYazisi = driver.findElements(By.xpath("//*[@id='result-stats']"));
        System.out.println("Arama Sonuc Yazisi : "+aramaSonucYazisi.get(0).getText());
        String [] sonucSayisi = aramaSonucYazisi.get(0).getText().split(" ");
        // System.out.println(Arrays.toString(sonucSayisi));
        System.out.println("Sonuc Sayisi : " + sonucSayisi[1]);
        String sayi = sonucSayisi[1];
        String newNum = sayi.replace(".","");
        int yeniSayi = Integer.parseInt(newNum);
        System.out.println(yeniSayi);


        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if (yeniSayi>10000000){
            System.out.println("Sonuc Sayisi Testi PASSED");
        } else System.out.println("Sonuc Sayisi Testi FAILED");

        // 8- Sayfayi kapatin
        driver.close();
    }
}
