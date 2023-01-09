package slayt;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

import java.awt.*;

public class Q3 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //1. Yeni bir Class olusturalim.C06_ManageWindow
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("position : "+position);

        Dimension size = driver.manage().window().getSize();
        System.out.println("size : "+size);

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().maximize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        Point maxPosition = driver.manage().window().getPosition();
        System.out.println("position : "+position);

        Dimension maxSize = driver.manage().window().getSize();
        System.out.println("size : "+size);

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        Point fullPosition = driver.manage().window().getPosition();
        System.out.println("position : "+position);

        Dimension fullSize = driver.manage().window().getSize();
        System.out.println("size : "+size);

    }
}
