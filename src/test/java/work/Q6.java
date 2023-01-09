package work;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q6 extends TestBase {

   /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */

    @Test
    public void test() throws InterruptedException {

        // Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net");

        // Then new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
        Thread.sleep(3000);

        // Verileri girer
        driver.findElement(By.id("DTE_Field_first_name")).sendKeys("Busra", Keys.TAB, "Cakmak", Keys.TAB, "QA" , Keys.TAB ,
                "Turkey", Keys.TAB, "123", Keys.TAB, "2023-01-03",Keys.TAB,"120000",Keys.ENTER  );
        Thread.sleep(3000);

        // Then Kullanıcının eklendiğini doğrular.
       WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
       search.sendKeys("Busra" , Keys.ENTER);
       Thread.sleep(3000);
       String name = driver.findElement(By.xpath("//*[text()='Busra Cakmak']")).getText();
       Assert.assertTrue(name.contains("Busra"));
       Thread.sleep(3000);

        // And Eklediği kullanıcı kaydını siler
        search.clear();
        search.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[text()='Busra Cakmak']")).click();
        Thread.sleep(3000);

        // Delete butonuna tikladi
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();
        Thread.sleep(3000);

        //Onayladi
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        Thread.sleep(3000);

        // Then Kullanıcinin silindiğini doğrular.
        search.sendKeys("Busra" , Keys.ENTER);
        Thread.sleep(3000);

        String noName = driver.findElement(By.className("dataTables_empty")).getText();
        String expectedName = "Busra";
        Assert.assertFalse(noName.contains(expectedName));

















    }








}
