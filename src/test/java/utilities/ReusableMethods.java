package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver)  {

        // 1- Take SS objesi olustur

        TakesScreenshot tss=(TakesScreenshot)driver;

        // 2- resmi olarak son olarak kaydedecegimz dosyayi olustur.

        // her resim cektiginde ust uste kaydetmemesi ivin resim dosya yoluna tarih ve saat iceren bir ek yapalim.

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimler/tumEkranSS"+tarih+".jpeg";

        File tumSayfaSS=new File(dosyaYolu);

        //3- tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydedelm.

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi ana dosyaya kopyala

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
