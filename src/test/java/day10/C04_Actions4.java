package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest() {  // suruklemk icin EN FAZLA bu method kullanilir

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");

        // kaynak ve hedef elementleri Iframe'in icinde bulunuyor bu nedenle icine girmeliyiz
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        // dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();  // en cok bu kullanilir
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");

        // kaynak ve hedef elementleri Iframe'in icinde bulunuyor bu nedenle icine girmeliyiz
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        // dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)  // kaynagi tut
                .moveToElement(hedef)  // hedefe koy
                .release()             // elemani birak
                .build()               // onceki methodlarin iliskisini kur/guclendir. Birden fazla method bir aradaysa kullanilmasi tercih edilir.
                .perform();            // islemi gerceklestir, bu hep en son kullanilir.
    }

    @Test
    public void moveByOffSetTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");

        // kaynak ve hedef elementleri Iframe'in icinde bulunuyor bu nedenle icine girmeliyiz
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        // dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak) // kaynagi tut
                .moveByOffset(430,30)
                .release()  // kaynagi birak
                .build()
                .perform();
    }
}
