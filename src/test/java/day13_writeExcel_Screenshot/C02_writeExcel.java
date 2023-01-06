package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_writeExcel {

    @Test
    public void test01() throws IOException {

        // excel dosyasindan kopyaladigimiz workbook objesi uzerinde degisiklik yapabiliriz.
        // bunun icin oncelikle excel'in kopyasi olan workbook'u olusturalim.

        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);


        // 5. sutun olarak Nufus basligi ile bir sutun olusturalim.

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        // 3. satirdaki nufus bilgisini 1500000 yapalim.

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        // 7. satidaki nufus bilgisini 3000000 yapalim.

        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");

        // yaptigimiz degisiklikler kopya workbok uzerinde
        // bu degisiklikleri asıl excel'e kaydetmek icin
        // bunun icin FileOutoutStream class'ini kullanmaliyiz.

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

    }
}
