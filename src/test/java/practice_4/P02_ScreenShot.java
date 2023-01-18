package practice_4;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_ScreenShot extends TestBase {

    @Test
    public void name() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın resmini alalım
        String tarih= new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa_"+tarih+".jpeg"));

        /*
        FILEUTILS CLASS'I, FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHOT'LAR ICERIR.
        BU METHOD'LARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI
        COK DAHA KOLAY YAPABILIRIZ.
         */


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım
    }
}
