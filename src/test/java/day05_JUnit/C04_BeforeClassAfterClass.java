package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
       @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
       Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir
     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Butun Testlerden Once Calisti");
        System.out.println("******************************");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Butun Testlerden Sonra Calisti");
        System.out.println("******************************");
    }


    @Before
    public void setUp01(){
        System.out.println("Her Testten Once Calisir");
        System.out.println("******************************");
    }


    @After
    public void tearDown01(){
        System.out.println("Her Testten Sonra Calisir");
        System.out.println("******************************");

    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");
        System.out.println("******************************");

    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }

    @Test
    @Ignore   // Eger bir testi calistirmak istemezsek bu sekilde kullaniriz
    public void test03(){
        System.out.println("Ucuncu Test");
    }


}
