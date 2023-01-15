package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws Exception {

        // WORKBOOK(Excel Dosyasi) > WORKSHEET/SHEET(Sayfa) > ROW(Satir) > CELL(Veri Hucresi)
        String path = "./src/test/java/resources/Capitals.xlsx";  // . demek tamami anlaminda

        // Dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);

        // Excel dosyasini ac / Workbook ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Sayfayi ac / Sheet1
        //Sheet sheet1 = workbook.getSheetAt(0);   // Index 0 dan baslar, ilk sayfayi acmak icin de 0. index kullaniriz
        Sheet sheet1 = workbook.getSheet("Sheet1"); // Sheet1 isimli sayfayi ac

        // Ilk satira git / Row
        Row row1 = sheet1.getRow(0);//ILK SATIRA GIT

        // Ilk satirdaki ilk veriyi al
        Cell cell1 = row1.getCell(0);//ILK HUCREDEKI DATAYI VER

        // O veriyi yazdir
        System.out.println("1. satir 1. sutun: "+cell1); // COUNTRY

        // 1. satir 2. sutun
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println("1. satir 2. sutun: "+cell12); // CAPITAL

        // 3. satir 1. sutun yazdir ve o verinin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println("3. satir 1. sutun: "+cell31);
        Assert.assertEquals("France",cell31);

        // Excel'deki toplam satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; // son satir numarasi,
        // index 0'dan baslar, sayma sayilari 1'den, o nedenle +1 yazariz sonuna
        System.out.println(toplamSatirSayisi); // 11

        // Kullanilan satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();  // 1 den basliyor
        System.out.println(kullanilanToplamSatirSayisi);  // 11
        // bos karakter varsa onlari atlayarak sayar

        // COUNTRY, CAPITAL key ve value'lari map'e alip print et
        // {USA, D.C.}, {FRANCE, PARIS}

        // variable olusturalim, bu variable excel'deki country, capital verilerini tutacak
        Map<String,String> ulkeBaskentleri= new HashMap<>();

        for (int satirSayisi=1; satirSayisi<kullanilanToplamSatirSayisi; satirSayisi++ ){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println("Ulkeler-Baskentler: "+ulkeBaskentleri);


    }
}
