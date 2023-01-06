package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_istenenElementSS extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazona gidelim
        driver.get("https://www.amazon.com");
        // nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // sonuclarin nutella icerdigini test et

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKElime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedKElime));

        // arama sonuc eleöentini SS'ini cek.

        // 1- SS alacaginz elementi locate et
        // 2- kaydedecegimz dosyayi olustur

        File elementSS=new File("target/ekranResimleri/elementSS.jpeg");

        // 3- gecici dosyayi olusturup element uzerinden SS yap.

        File gecici=aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayı hedef dosyaya kopyala

        FileUtils.copyFile(gecici,elementSS);


    }
}
