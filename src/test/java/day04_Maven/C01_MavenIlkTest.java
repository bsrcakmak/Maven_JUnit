package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");


        // arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));


       // "Samsung headphones" ile arama yapalim
       aramaKutusu.sendKeys("Samsung headphones"); // Keys.ENTER  da yapabiliriz
       aramaKutusu.submit();  // Enter'a bastik


        // Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu : "+aramaSonucu.getText());


        // Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();


        // Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklariListesi = driver.findElements(By.xpath("//h1"));
        for (WebElement w:sayfaBasliklariListesi){
            System.out.println(w.getText());
        }

        // 2. yol: lambda ile cozum
        // sayfaBasliklariListesi.forEach(t-> System.out.println(t.getText()));


        // sayfayi kapatiniz
        driver.close();

    }
}
