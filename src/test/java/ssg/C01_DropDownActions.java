package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_DropDownActions extends TestBase {

    @Test
    public void name() {

        // Exercise 1...

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilMenusu = driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilMenusu).perform();


        // Change butonuna basiniz
        driver.findElement(By.xpath("(//a[text()='Change'])[1]")).click();

        // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın

        // 1. adim dropdown locate edilir.
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-currency-dropdown']"));
        // ** dropdown varken locate alacaksak select atribuite ini kullaniriz.

        // 2. adim Select objesi olusturulur.
        Select select = new Select(ddm);

        // 3. adim bir obtion secilir
        select.selectByVisibleText("TRY - Turkish Lira");

        // Obtion'i yazdirdik
        System.out.println(select.getFirstSelectedOption().getText());


        // Tüm option'ları yazdırın
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w:allOptions){
            System.out.println(w.getText());
        }


        // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
        int expected = 68;
        int actual = allOptions.size();
        Assert.assertEquals(expected,actual);


        // Save Changes butonuna basınız
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
        waitFor(2);


        // arama motoruna 'Kitap' yazip aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Kitap", Keys.ENTER);


        // ilk cikan urunun para biriminin 'TRY' oldugunu test edin
        String expected2 = "TRY";

        WebElement paraBirimi = driver.findElement(By.xpath("(//span[text()='TRY'])[1]"));
        String actual2 = paraBirimi.getText();

        Assert.assertEquals(expected2,actual2);
    }
}
