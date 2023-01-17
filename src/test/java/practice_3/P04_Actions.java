package practice_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P04_Actions extends TestBase {

    @Test
    public void test() {
        // http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        // -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        WebElement fleet = driver.findElement(By.xpath("//*[text()='Fleet']"));
        fleet.click();

        // -Sayfa başlığının Fleet içerdiğini test edelim

    }
}
