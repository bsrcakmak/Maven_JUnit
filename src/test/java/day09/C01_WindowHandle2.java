package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();
        System.out.println("Ilk pencere handle degeri : " + window1Handle);

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedWindow1Text = "Opening a new window";
        Assert.assertEquals(expectedWindow1Text, actualWindow1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindow1Title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(expectedWindow1Title,actualWindow1Title);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        waitFor(3);  // reuseble method'dan geliyor

        // IKINCI PENCERE acilir ve ikinci pencerede islem yapmak istedigimden o pencereye switch(gecis) yapmaliyiz
        switchToWindow(1);  // 2. window'a gecis yaptik, driver artik 2. window'da

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertEquals(expectedWindow2Title,actualWindow2Title);

    }
}
