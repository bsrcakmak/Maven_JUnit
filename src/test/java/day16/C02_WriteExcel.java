package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws Exception {

        // WORKBOOK(Excel Dosyasi) > WORKSHEET/SHEET(Sayfa) > ROW(Satir) > CELL(Veri Hucresi) > WRITE > SAVE(Kaydet)
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

        //  Ilk satir 3. sutunu create et
        Cell cell3 = row1.createCell(2);

        // Nufus yaz
        cell3.setCellValue("NUFUS");

        // 2. satir 3. sutuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

        // 3. satir 3. sutuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        // KAYDET: KAYIT ISLEMI FILE OUTPUT STREAM ILE YAPILIR
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }
}
