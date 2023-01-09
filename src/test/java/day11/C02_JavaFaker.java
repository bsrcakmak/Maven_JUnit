package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {

        // 1- Faker objesi olustur
        Faker faker = new Faker();

        // 2- Faker objesi ile fake data olustur
        // first name datasi
        String fName = faker.name().firstName();
        System.out.println("First Name : "+fName);

        // last name datasi
        String lName = faker.name().lastName();
        System.out.println("Last Name : "+lName);

        // username datasi
        String username = faker.name().username();
        System.out.println("Username : "+username);

        // job datasi
        String jobTitle = faker.name().title();
        System.out.println("Job : "+jobTitle);

        // city datasi
        System.out.println("City : "+faker.address().city());

        // state datasi
        System.out.println("State : "+faker.address().state());

        // full adress datasi
        System.out.println("Full Adress : "+faker.address().fullAddress());

        // cell Phone number datasi
        System.out.println("Cell Phone Number : "+faker.phoneNumber().cellPhone());

        // email adress
        System.out.println("Email Adress : "+faker.internet().emailAddress());

        // zip code(posta kodu)
        System.out.println("Zip Code : "+faker.address().zipCode());

        // rastgele 15 haneli numara
        System.out.println("Random Number : "+faker.number().digits(15));


        /*
            TEST DATA : kullanici adi, sifre, tel no, email, sehir, kredi kart no, ... turden isimlere data diyoruz.
            Test datalari kimden alinir/
              1- Business Anaylist(BA) -> Acceptance Criteria'lari yazar
              2- Test Lead
              3- Manuel Tester
              4- Tech Lead & Team Lead & Dev Lead -> Takima gore degisir
              5- Developer -> Bazi durumlarda
              6- Database
              7- API call'lar -> Uygulamanin kendisinden data cekilebilir
              8- Documentation -> API swagger document
              9- Java Faker -> Fake data almak icin kullanilabilir

            Test datalari kimden gelmez?
              1- Kullanicidan alinmaz (end user)
              2- Scrum Master'dan alinmaz -> isin teknigini bilemez
         */

    }
}
