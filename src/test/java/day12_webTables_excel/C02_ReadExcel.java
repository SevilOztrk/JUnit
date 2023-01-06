package day12_webTables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // dosya yolunu olusturalim.
        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";

        // FileInpuStream objesi olusturup parametre olarak dosya yolunu yazalim.

        FileInputStream fis=new FileInputStream(dosyaYolu);

        // Kod alanimizda excelin bir kopyasini olusturup
        // tum bilgileri ona kopyalicaz.


        Workbook workbook= WorkbookFactory.create(fis); // file inputu kullanarak dosyaya ulasma yetkisi verdik sonra onun oludugunuda
        // workbooka cevirmis olduk.

        // workbook icerisinde birden fazla sayfa olabilir.
        // istedigimiz sayfaya gidelim.


        Sheet sheet= workbook.getSheet("Sayfa1");

        // Angolayı yazdirmak istedigmz icin 5. satira gidelim.

        Row row= sheet.getRow(5);

        // 5. satirda 2. indexteki datayı alalim.

        Cell cell= row.getCell(2);

        System.out.println(cell);


        // once dosyaya ulastk
        //file ile dosyayı okuduk
        //1. sayfaya gittik
        // istedgimz satira gittik
        // o satirdada istedimz dataya gittik

    }


}
