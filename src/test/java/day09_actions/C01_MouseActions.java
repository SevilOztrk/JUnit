package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions extends TestBase {




    @Test
    public void test01(){

        /*
    1- Yeni bir class olusturalim: MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    3- Cizili alan uzerinde sag click yapin
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
   0 5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

        driver.get("https://the-internet.herokuapp.com/context_menu");


        Actions action=new Actions(driver);  // 1. adım obje olustur, mouse ve klavye hareketlerinde actions kullanilir. parametre dirver gir.
        WebElement ciziliAlanElementi= driver.findElement(By.xpath("//div[@id='hot-spot']")); // 2 adım locate et
        action.contextClick(ciziliAlanElementi).perform(); // sağ click yap sonuna performu koy.



        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();  // alerte gecip yazıyı almak icin swicth to ve alert get text
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);


        // 5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();  //  tekrar alerte gec ve tamam demek için accept de.



        // 6- Elemental Selenium linkine tiklayalim

        String ilkSayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();


        //  7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfaninWHD=driver.getWindowHandles();

        String ikincisyfWHD="";

        for (String eachWHD: ikiSayfaninWHD
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikincisyfWHD=eachWHD;
            }
        }


        driver.switchTo().window(ikincisyfWHD); // artk ikinci tabdayiz.

        String expectedYeniSayfaYazi="Elemental Selenium";  // test edelim elemental seleniumu
        String actualYeniSayfaYazi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);



        ReusableMethods.bekle(3);

    }



}
