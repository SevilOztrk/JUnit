package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeSSTumSayfa extends TestBase {

    @Test
    public static void test01(){

        // wisequarter anasayfaya gidin

        driver.get("https://www.wisequarter.com");

        // ana sayfaya gittiginiz test edin,

        String expectedUrl="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tum sayfa ss alin.

        ReusableMethods.tumSayfaScreenshotCek(driver);


    }
}
