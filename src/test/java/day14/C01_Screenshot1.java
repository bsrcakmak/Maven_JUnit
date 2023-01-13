package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

    /*
    Selenium da tum ekran goruntusu nasil alinir/
      - tum ekran goruntusu Selenium'dan gelen getScreenshotAs() methodu ile alinir
      - getScreenshotAs() methodu Selenium'daki TakesScreenshot API dan gelir
     */

    @Test
    public void fullPageScreenshotTest() throws IOException {

        // Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");
        waitFor(1);

        // 1. Ekran goruntusunu getScreenshotAs() methodu ile alip File olarak olusturalim
        TakesScreenshot ts = (TakesScreenshot) driver; // screenshot objesi
        File goruntu = ts.getScreenshotAs(OutputType.FILE); // screenshot'i alip file dosyasina attik

        // 2. Almis oldugumuz ekran goruntusunu belirledigimiz bir Path'e kaydet  dir=directory=dosya
        // NOTE: Kayit ismini dinamik yapmak icin date objesi kullandik
        String  currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // goruntunun alindigi an
        String path = System.getProperty("user.dir") + "/test-output/EkranGoruntuleri/"+currentDate+".image.png";
        File hedef = new File(path); // hedef de File tipinde olmak zorunda

        // 3. Goruntumuz ile dosyamizi birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

        // Alternatif olarak tum bu adimlari tek seferde degisken kullanmadan da yapabiliriz
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), // goruntu
//                new File(System.getProperty("user.dir") + "/test-output/EkranGoruntuleri/image.png")); // hedef


        // “QA” aramasi yap
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA", Keys.ENTER);
        waitFor(3);

        // Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String text = driver.findElement(By.xpath("//h1[text()='Search Results for: QA']")).getText();
        Assert.assertTrue("Search Results for: QA".contains(text));

        // Reusable method yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();

    }
}
