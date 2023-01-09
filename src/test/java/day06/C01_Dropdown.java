package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;

    // Eger test sinifinda birden fazla method olustrulmussa, @Before kullanilir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){
        // 1. Locate dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        // 2. Select objesi olustur, yil secimi
        Select yearDropdown = new Select(year);

        // 3. Select object'i kullanarak 3 farkli sekilde secim yapabiliriz
        // Dogum yilini, ayini ve gubunu su sekilde secer.  2000, January, 10
        yearDropdown.selectByIndex(22);  // secenek sirasi 0. indeksten baslar,  2000 yili 23. sirada yani 22. indexte

        // Ay secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");  // option in value degeri ile secim yapilabilir. January seceneginin value'su 0

        // Gun secimi selectByVisibleText
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));   // By.id(
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10"); // Case Sensitive
    }

    @Test
    public void printAllTest(){
        // Tum eyalet isimlerini consola yazdiralim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
        for (WebElement eachState:stateList){
            System.out.println(eachState.getText());
        }
        // lambda ile de listelenebilir
        // stateList.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest(){
        // State dropdown'indaki varsayilan(default) secili secenegin Select a State oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        System.out.println("Varsayilan Text : "+varsayilanText);
        Assert.assertEquals("Select a State",varsayilanText);
    }

    @After
    public void tearDown(){
        driver.close();
    }
    /*
         1. What is dropdown? Dropdown nedir?
            Dropdown liste olusturmak icin kullanilir.
         2. How to handle dropdown elements? Dropdown nasil automate edilir?
            -Dropdown'i Locate ederim
            -Select object'i olustururum
            -Select object'i ile istedigim secenegi secerim
         NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi
         3. Tum dropdown seceneklerini nasil print ederiz?
            - Tum dropdown elementlerini getOptions() methodu ile listeye koyariz
            - Sonra secenekleri loop ile yazdiririz veya lambda ile
         4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
            Ornek: Gun olaral 10'u sectik ama ya secilmediyse
            getFirstSelectedOption() methodu secili olan secenegi return eder
    */
}
