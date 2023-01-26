package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_FilesUpload extends TestBase {

    @Test
    public void test03() {

        // Exercise 3...
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz

        // "C:\Users\Administrator"C:\Users\Administrator\Desktop\deneme.txt""
        String farkliKisim =System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\deneme.txt";
        String yuklenecekDosyaYolu = farkliKisim+ortakKisim;

        driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys(yuklenecekDosyaYolu);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin





    }
}
