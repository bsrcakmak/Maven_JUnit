package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Work02 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.“https://www.saucedemo.com”Adresinegidin
        driver.get("https://www.saucedemo.com");


        //2.Username kutusuna “standard_user”yazdirin
        WebElement username = driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]"));
        username.sendKeys("standard_user");


        //3.Password kutusuna “secret_sauce”yazdirin
        WebElement password = driver.findElement(By.xpath("(//*[@class='input_error form_input'])[2]"));
        password.sendKeys("secret_sauce");


        //4.Login tusunabasin
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();


        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasinagidin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        System.out.println("Ilk Urun Ismi : "+ilkUrun.getText());
        ilkUrun.click();

        //6.Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


        //7.Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8.Sectiginiz urunun basarili olarak sepete eklendigini controledin
        WebElement seciliUrun= driver.findElement(By.xpath("//*[@class='cart_item_label']"));
        if (seciliUrun.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //9.Sayfayikapatin
        Thread.sleep(3000);
        driver.close();





    }
}
