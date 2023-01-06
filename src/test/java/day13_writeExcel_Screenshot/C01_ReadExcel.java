package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excel dosyalari bilgisayarımızda oldugu icn
        // javadan FileInpuStream class'i yardımı ile ulasicaz.

        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);  // ulkeler excelindeki tum bilgiler buraya kopyalandi.

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));
        // sayfa 1 isimli 3. indexe sahip satirinin 1. indexe sahip cell bilgisini yazdircak


        // satir ve sutun bilgisini parametre olarak alip
        // o hucredeki bilgiyi yazdiran bir method olusturun.

        dataYazdir(25,2);
        dataYazdir(5,3);


    }

    private void dataYazdir(int satir, int sutun) throws IOException {

        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));
    }
}
