package review;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        System.out.println("Pencere olculeri : "+ driver.manage().window().getSize());
        System.out.println("Pencere konumu : "+ driver.manage().window().getPosition());
        Thread.sleep(2000);

        // pencerenin konumunu ve buyuklugunu degistirelim
        driver.manage().window().setPosition(new Point(15,15));
        driver.manage().window().setSize(new Dimension(900,600));

        System.out.println("Yeni pencere olculeri : "+ driver.manage().window().getSize());
        System.out.println("Yeni pencere konumu : "+ driver.manage().window().getPosition());

        // fullscreen iken boyutlar
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen boyut : "+ driver.manage().window().getSize());
        System.out.println("Fullscreen konum : "+ driver.manage().window().getPosition());


        driver.close();
    }
}
