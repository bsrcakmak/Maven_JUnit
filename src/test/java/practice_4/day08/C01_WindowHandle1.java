package practice_4.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
         driver.get("https://the-internet.herokuapp.com/windows");

        //        Ilk sayfanin id sini alalim
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,window1Text);

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,window1Title);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(3000);


        //       Bu noktada iki pencere acik ve 2. sine gecis yapmak istiyoruz
        //       Bunun icin driver.getWindowHandles() ile tum pencerelerin idlerini alalim
        Set<String> allWindowHandles = driver.getWindowHandles();  // {window1Handle , window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                // Eger listedeki id window1 e esit degilse otomatik olarak bir sonrakine esittir
                driver.switchTo().window(eachHandle);  // Buradaki eachHandle window2 nin handle'ina esittir.
                break;
            }
        }

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        String window2Title = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", window2Title);

        String window2Handle = driver.getWindowHandle();

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);
        //      1. window'a gecis yapiyoruz
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);
        Assert.assertEquals("The Internet", driver.getTitle());

        // 2. window'a gecelim
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);

        // 1. window'a gecelim
        driver.switchTo().window(window1Handle);

    }

}
