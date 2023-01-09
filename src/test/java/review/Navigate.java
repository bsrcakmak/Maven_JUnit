package review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Navigate {

    public static void main(String[] args) {

        /*
        Eger test sirasinda birden fazla sayfa arasinda ileri geri hareket edeceksek
        driver.get() yerine driver.navigate().to() methodu kulaniriz
        ve sonrasinda forword(), back() veya refresh() method'larini kullanabiliriz

         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        Bir sayfa acilirken ilk basta sayfanin icerisinde bulunan elementlere gore
        bir yukleme suresine ihtiyac vardir veya bir wewbelwmwntinin kullanilabilmesi icin zamana ihtiyac olabilir,
        implicitlyWait() bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icin beklenecek
        MAX sureyi belirleme olanagi tanir.

         */

        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();

    }
}
