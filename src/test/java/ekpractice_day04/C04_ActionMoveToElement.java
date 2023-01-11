package ekpractice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test04() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement dilSecenek = driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        actions.moveToElement(dilSecenek).perform();
        waitFor(3);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("//div[@class='icp-mkt-change-lnk']")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Turkey (Türkiye)");

        // DropDown opsiyon listesi "Go to website" butonuna ulasmamiza engel oldugu icin
        // herhangi bir yere click yapip dropDown opsiyon listesinin
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

        Set<String> windowHandelSeti = driver.getWindowHandles();
        String sayfa2Handle=" ";
        for (String w:windowHandelSeti){
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println(windowHandelSeti);
        System.out.println(sayfa1Handle);
        driver.switchTo().window(sayfa2Handle);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String newTitle = driver.getTitle();
        Assert.assertTrue(newTitle.contains("Elektronik"));
    }
}
