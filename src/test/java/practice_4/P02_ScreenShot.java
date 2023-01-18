package practice_4;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_ScreenShot extends TestBase {

    String tarih;
    @Test
    public void name() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String window1Handle = driver.getWindowHandle();

        //Tüm sayfanın resmini alalım
        tarih= new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa_"+tarih+".jpeg"));

        /*
        FILEUTILS CLASS'I, FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHOT'LAR ICERIR.
        BU METHOD'LARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI
        COK DAHA KOLAY YAPABILIRIZ.
         */


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        waitFor(3);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih= new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa_"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(window1Handle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Arama sonucunun resmini alalım
        //driver.findElement()
        //FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
    }
}
