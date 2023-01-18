package practice_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_UploadFile extends TestBase {

    @Test
    public void name() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        // "C:\Users\Administrator\Desktop\hi.txt"  // dosyanin gercek yolunu alip gorebilmek icin buraya koyuyoruz
        // String anayol = System.getProperty("user.home"); // C:\Users\Administrator
        // String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
        // String dosyaYolu = anaYol+ortakYol;

        String dosyaYolu = "C://Users//Administrator//Desktop//hi.txt";

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);


        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
