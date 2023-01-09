package day10;

public class Actions_Class {

    /*
       1- Actions ve Actions Class nedir?
          Actions Selenium'dan gelen bir kutuphanedir. Ayni zamanda Mouse ve Keyboard islemlerini gerceklestirmek
      icin kullandigimiz hazir bir Selenium kutuphanesidir

          Ornegin: sag tiklamak(contextClick), cift tiklamak(doubleClick), elementin uzerine gitmek(moveToElement)
      gibi mouse islemlerini gerceklestirebiliriz. Ayni zamanda shift, control, delete, enter gibi keyboard
      tuslarina da actions yardimiyla basabiliriz. Bu tur islemlerde sendKeys methodu kullanilir.

      2- Ne tur method'lar kullandin/
         Actions methodlar onemlidir ve tekrar tekrar kullanmam gerektiginden Actions methodlarini iceren
         Resuable method'lari olusturdum. Gerektignde bu Resuable methodlari kullaniyorum.

         Ornegin: rightClick() methodunu bir elemente sag tiklamak icin test class'imdan cagirabilirim.

      3- Hangi method'lari   kullandin, hangisi ne ise yarar?
         Ornegin: sag tiklamak(contextClick), cift tiklamak(doubleClick), elementin uzerine gitmek(moveToElement)
      gibi mouse islemlerini gerceklestirebiliriz. Ayni zamanda shift, control, delete, enter gibi keyboard
      tuslarina da actions yardimiyla basabiliriz. Bu tur islemlerde sendKeys methodu kullanilir.
     */

     /*
        ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions.dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;

      */
}
