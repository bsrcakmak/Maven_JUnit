package slayt;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class Q4 extends TestBase {

    @Test
    public void test(){

        // 1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("position : "+position);

        Dimension size = driver.manage().window().getSize();
        System.out.println("size : "+size);

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(600,600));
        driver.manage().window().setSize(new Dimension(50,50));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Dimension actualNewSize = driver.manage().window().getSize(); //Dimension yerine String yazamayiz hata veriyor
        if (actualNewSize.getWidth()==600 && actualNewSize.getHeight()==600){
            System.out.println("Size passed the test");
        }else System.out.println("Size failed the test");


        Point actualYeniKonum = driver.manage().window().getPosition();
        if(actualYeniKonum.getX()==50 && actualYeniKonum.getY()==50){
            System.out.println("Konum TESTİ PASSED");
        }else System.out.println("Konum TESTİ FAILED");

    }
}
