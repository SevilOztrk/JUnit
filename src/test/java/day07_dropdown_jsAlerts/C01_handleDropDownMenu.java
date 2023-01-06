package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropDownMenu {


   WebDriver driver;

   @Before
   public void setUp() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }

   @After

   public void tearDown(){
       driver.close();
   }



    @Test

    public void test01() throws InterruptedException {

        // ilgili ayarları yapın
        // amazon sayfasına git
        // arama kutusu yanındaki dropdown menuden book secin
        // arama kutusuna java yazdirip arama yap
        // title'nin book ve java icerdigini test et

        driver.get("https://www.amazon.com");

        // dropDown menuden istedigimiz option'i secebilmek icin öncelikle select
        // classindan obje olustur.
        // ancak select objesi olusturmak icin Select class'inin constructor'i
        // handle edecegimiz WebElement i istediginden
        // 1- select objesi olusturmadan once dropdown elementini locate etmeliyiz.

        WebElement dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Select classindan obje olusturmak

        Select select=new Select(dropDownElementi);

        //3- select objesini kullanarak istedigimiz method/methodlari calistir

       // select.selectByValue("search-alias=stripbooks-intl-ship"); // istedigimiz menuyu secer

      //  select.selectByIndex(5); // bu da

        select.selectByVisibleText("Books"); // gorunen yazi demek // bu da en kolayı locate etmwene gerek yok




        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        System.out.println(driver.getTitle());




        String expectedKElime="Java";
        String actualTitle=driver.getTitle();


        Assert.assertTrue(actualTitle.contains(expectedKElime));



        // dropDownMenu'den book seceneginin secildigini test edin.
        /*
        Locate ettigimiz elementi bulamazsa NoSuchElementException verir.
        sayfa yenilendigi icin var olan bir elementi kullanamazsa
        StaleElementException verir. bu durumda locate ve secme islemini yeniden yaparsak kodumuz caliisr.
         */



        dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropDownElementi);
        select.selectByVisibleText("Books");



        String actualSecilenOption=select.getFirstSelectedOption().getText(); // secilen webelementin uzerindeki yaziyi string olarak almak.
        String expectedSecilecekOption="Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);


        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin.

       List<WebElement> optionsWebElementListesi=select.getOptions(); // butun optionları ver bana demek. bu list dondurur.

        int actualOptionSayisi=optionsWebElementListesi.size();// listenin size'ni bulma
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);


        Thread.sleep(2000);
    }
}
