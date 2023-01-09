package day11;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest() {

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);  // C:\Users\Administrator\IdeaProjects\com.B103Maven_Junit

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME); // C:\Users\Administrator

        String dosyaYolu = userHOME + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));  // dosya varsa true
        System.out.println(isExist);
    }
}
