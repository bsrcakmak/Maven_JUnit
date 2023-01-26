package ssg;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files {

    @Test
    public void test01() {

        // Exercise 1...
        // masaustunde bir text dosyası olusturun
        // masaustundeki text dosyasının varlıgını test edin

        // "C:\Users\Administrator    \Desktop\text.txt"

        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Administrator\\Desktop\\text.txt")));

        // ==> Bu islemi daha dinamik hale getirebiliriz


        String farkliKisim = System.getProperty("user.home");
        System.out.println(farkliKisim); // C:\Users\Administrator

        String ortakKisim = "\\Desktop\\text.txt";
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
