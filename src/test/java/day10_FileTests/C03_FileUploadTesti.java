package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){

        //  1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");
        // 2. chooseFile butonuna basalim
        //3.  Yuklemek istediginiz dosyayi secelim.

        /*

        Bu gorevi yapabilmek icin chooseFile butonuna basildiginda acilan bilgisayarizimdaki
        file dosyalarini click yapabilmemiz gerekir.
        ancak selenium bilgisayaraımızdaki dosyalari click yapamaz.

        bunun yerine söyle bir cozum uretilmistir
        1- chooseFile butonunu locate et
        2- yuklemek edilecek dosyanin dosya yolunu olusturun.
        3- chooseFile butonuna senkeys ile dosya yolunu gonder

         */

        WebElement chooseFileButonu=driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabJava.docx";
        chooseFileButonu.sendKeys(dosyaYolu);

        // 4. Upload butonuna basalim.

        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();

        // 5. “File Uploaded!” textinin goruntulendigini test edelim.

      WebElement fileUploaded=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploaded.isDisplayed());




    }



}
