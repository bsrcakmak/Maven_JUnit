package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Odev_2 extends TestBase {

   @Test
    public void test(){
       //https://testcenter.techproeducation.com/index.php?page=multiple-windows
       driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

       //Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
       Assert.assertEquals(expectedTitle,actualTitle);

       //Click here a tiklayin
       driver.findElement(By.linkText("Click Here")).click();

       //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
       String window1 = driver.getWindowHandle();
       Set<String> allHandles = driver.getWindowHandles();
       for (String w: allHandles){
           if (!w.equals(window1)){
               driver.switchTo().window(w);
           }
       }
       Assert.assertEquals("New Window", driver.getTitle());
   }
}
