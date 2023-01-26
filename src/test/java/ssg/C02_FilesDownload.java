package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {

    @Test
    public void test02() {

        // Exercise 2...
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. LambdaTest.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();

        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
        // Burdan sonrasi JAVA'nin isi, oncesi Selenium'un

        // "C:\Users\Administrator\Downloads\LambdaTest.txt"

        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Administrator\\Downloads\\LambdaTest.txt")));

        // Bu islemi dinamik hale getirelim.

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\LambdaTest.txt";

        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
