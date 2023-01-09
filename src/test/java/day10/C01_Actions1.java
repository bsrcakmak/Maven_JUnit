package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClick() {

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 1- Actions objesi olustur
        Actions actions = new Actions(driver);

        // 2- Element'i locate edelim
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //Kutuya sag tıklayın
        // Tum actionslar ACTIONS objesi ile baslar "perform()" ile biter
        actions.contextClick(kutu).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        // Object olusturmak wait gerektiren durumlarda makuldur, burda gerek yoktur
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
