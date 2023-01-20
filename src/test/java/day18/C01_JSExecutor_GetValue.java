package day18;

import org.junit.Test;
import utilities.TestBase;

public class C01_JSExecutor_GetValue extends TestBase {

    @Test
    public void getValueTest() {

        //	https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        //	Tarih kısmındaki Yazili metinleri al ve yazdır

        getValueByJS("hotelDates");




    }
}
