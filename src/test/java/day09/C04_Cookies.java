package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {

        // 1. Amazona git
        driver.get("https://amazon.com");
        waitFor(2);

        // 2.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies(); // toplam cerez sayisi
        int cookiesSayisi = allCookies.size();
        System.out.println("Sayfada "+ cookiesSayisi+ " adet cookie var");

        // tum cookies leri yazdiralim
        // allCookies.stream().forEach(t-> System.out.println(t.getName()));
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie : "+eachCookie); // COOKIE nin tamamini yazdik
            System.out.println("Cookie Isimleri : "+eachCookie.getName()); // sadece isimlerini verdi
        }

        // 3. Bir Cookie yi smiyle bul
        System.out.println("Cookie'yi ismiyle cagiriyoruz ==> "+driver.manage().getCookieNamed("i18n-prefs"));

        // 4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam","antep-Fistikli-Cikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());

        // 5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        // 6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("Tum cookie'leri sildik, yeni cookie sayisi : "+driver.manage().getCookies().size());
    }
}
