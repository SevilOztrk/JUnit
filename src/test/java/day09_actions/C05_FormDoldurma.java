package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {



    @Test
    public void test01(){

        // facebook.com sayfasina gidin

        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin.

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        ReusableMethods.bekle(5);


        // ilgili alanlari faker kutuphanesinden degerlerle doldurun

        WebElement firstNameKutusu= driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        String mailAdresi=faker.internet().emailAddress();
        // mail fake oldugu icin iki kere kullanamayiz
        // ondan kaydettikki istedigmz kadar kullanalim.



        actions.click(firstNameKutusu).
                sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Aralık")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform(); // sağ tus

        ReusableMethods.bekle(5);

        // kaydol butonuna basin.

        WebElement kaydolButonu= driver.findElement(By.name("websubmit"));
        kaydolButonu.click();

        // kayit olamadiginizi test edin.

        ReusableMethods.bekle(15);

       WebElement hataMEsajElementi=driver.findElement(By.id("reg_error_inner"));


       Assert.assertTrue(hataMEsajElementi.isDisplayed());











    }



}
