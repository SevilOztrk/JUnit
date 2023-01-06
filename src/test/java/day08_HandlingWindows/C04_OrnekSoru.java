package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C04_OrnekSoru extends TestBase {


    @Test
    public void Test01(){


        driver.get("https://the-internet.herokuapp.com/iframe");



        String ilkSHD= driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> tumdegerlerSeti=driver.getWindowHandles();
        String ikinciSWHD="";
        for (String eachWHD: tumdegerlerSeti
             ) {

            if (!eachWHD.equals(ilkSHD)){

                ikinciSWHD= eachWHD;
            }

        }
        driver.switchTo().window(ikinciSWHD);


        String expectedElement="Elemental Selenium";
        String actualElement=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(expectedElement,actualElement);




        driver.switchTo().window(ilkSHD);
        String actualFrame=driver.findElement(By.tagName("h3")).getText();
        String expectedFrame="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(expectedFrame,actualFrame);





    }

}
