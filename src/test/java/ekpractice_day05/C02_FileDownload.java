package ekpractice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        // C:\Users\Administrator                     \Downloads\some-file.txt

        // 1. yol;
        // String dosyaYolu = "C://Users//Administrator//Downloads//some-file.txt";
        // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));  // exists -> mevcut mu

        // 2. yol;
        String farkliKisim = System.getProperty("user.home");  // daha dinamik olmasi icin bunu kullandik
        String ortakKisim = "//Downloads//some-file.txt";
        String dosyaYolu2 = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }
}
