package day11_seleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    /*
    1.“https://www.amazon.com” adresine gidin
    2.Sayfanin en altina inin
    3.Web table tum body’sini yazdirin
    4.Web table’daki satir sayisinin 9 oldugunu test edin
    5.Tum satirlari yazdirin

    7. 5.sutunu yazdirin
    8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
     */





    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        // 2
        Actions action=new Actions(driver);
        action.sendKeys(Keys.END).perform();


        //3
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));



        //4
        List<WebElement> satirlar=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(9,satirlar.size());


        //5

        for (WebElement eachRow:satirlar
             ) {
            System.out.println(eachRow.getText());
        }

        //  6. Web table’daki sutun sayisinin 13 olduğunu test edin

        List<WebElement> ucunsatirSutunListesi = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucunsatirSutunListesi);



        // 7. 5.sutunu yazdirin

        List<WebElement> besinciSutunElementi=driver.findElements(By.xpath("//tbody/tr[3]/td"));

        for (WebElement eachElement: besinciSutunElementi
             ) {
            System.out.println(eachElement.getText());

        }


        // 8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        WebElement istenenDataElementi=getElement(3,5);
        System.out.println(istenenDataElementi.getText());



    }

    private WebElement getElement(int satir, int sutun) {

        String dinamikxpath="//tbody/tr["+satir+"]/td["+sutun+"]";  // 3. satirin 5. sütunu , bunu dinamik yapalim onun icin 3 yerine satir 5 yerine sütun

        WebElement istenenElement= driver.findElement(By.xpath(dinamikxpath));
        return istenenElement;

    }
}
