package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){


        //  2. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");


       // 3. Facebookd.png dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();

        //  4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // test icin oncelikle dosyanın indirildignde dosyaYolu ne olacak bunu olusturmalıyız.

        String dosyaYolu=System.getProperty("user.home")+ "\\Downloads\\Facebookd.png";

        // bir dosyanın pc'de var oldugunu (exists) test etmek icin javadaki Files classindan yardım aliriz.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }


    @Test

    public void test02(){

        // masaustunde MerhabJava.docx dosyasi oldugunu test edin.
        // dinamik dosya yolunu olustur
        // assert de

        String dosyaYolu=System.getProperty("user.home") + "\\Desktop\\MerhabJava.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


    // https://the-internet.herokuapp.com/upload
}
