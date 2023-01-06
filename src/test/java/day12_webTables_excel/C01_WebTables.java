package day12_webTables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {


    @Test
    public void test01(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin

        WebElement headerelementi= driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println(headerelementi.getText());

        //3. 3.sutunun basligini yazdirin

        List<WebElement> basliklar=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("3. sütunun basligi:" + basliklar.get(2).getText());

        //4. Tablodaki tum datalari yazdirin

        WebElement tumDatalar=driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("tum datalar : " +tumDatalar.getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        List<WebElement> datalarListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));

        int siraNo=1;
        for (WebElement eachElement: datalarListesi
             ) {
            if (!eachElement.getText().equals("") || eachElement.getText().equals(" ")){
                System.out.println(siraNo+". - "+eachElement.getText());
                siraNo++;
            }
        }

        //6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElemntleriListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println(satirElemntleriListesi.size());


        //7. Tablodaki sutun sayisini yazdirin

        // basta basliklar listesi olusturmustuk onun size'ni alalim.

        System.out.println("sutun sayisi:" + basliklar.size());

        //8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunDatalarListesi=driver.findElements(By.xpath("((//div[@class=‘rt-tr-group’]))//div[1]/div[3]"));
        for (WebElement eachElement: ucuncuSutunDatalarListesi
        ) {
            if (!eachElement.getText().equals("") || eachElement.getText().equals(" ")){
                System.out.println(eachElement.getText());

        }


        //9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin

           // index'i saydiralim kierrayı bulunca indexin 4 fazlasini yazdiralim.



            for (int i = 0; i <datalarListesi.size() ; i++) {

                if (datalarListesi.get(i).getText().equals("Kierra")){
                    System.out.println("Istenen kisinin maasi:" + datalarListesi.get(i+4).getText());
                }
            }

            }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}
