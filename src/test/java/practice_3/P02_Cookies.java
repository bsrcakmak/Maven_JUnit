package practice_3;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookies extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test02() {

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        waitFor(5);

        //Sayfadaki cookie'lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        int cookie = cookies.size();
        System.out.println("Cookilerin sayisi : " + cookie);

        //Sayfadaki cookie'lerin isim ve değerlerini yazdırınız
        for (Cookie w: cookies){
            System.out.println(w.getName()+":"+w.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);
        System.out.println("------------");

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Cookilerin sayisi : " + cookies2.size());
        for (Cookie w: cookies2){
            System.out.println(w.getName()+":"+w.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println("---------------");
        System.out.println("Cookie'lerin son sayisi : "+cookies3.size());
    }
}
