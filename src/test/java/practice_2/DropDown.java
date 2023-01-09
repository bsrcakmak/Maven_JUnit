package practice_2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class DropDown extends TestBase {

    @Test
    public void test01(){
        // Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        // Dropdown menuyu yazdirirken onceki yontem;
        //    -WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //    -Select select = new Select(dropdown);

        // Dropdown menuyu yazdiralim
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t-> System.out.println(t.getText()));

        // Dropdown menuden baby secelim ve
        // Arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB, "Milk" , Keys.ENTER);


    }
}
