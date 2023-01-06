package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
    JUnit frameWork'u calistirilan testlerin passed veya failed olmasini raporlar
    ancak raporlamanın doğru sonuc vermesi icin testlerin asserton classındaki
    hazır methodlarla yapilmasi gerekir.
    eger assertion classı kullanilmazsa JUnit kodlarin sorunsuz olarak
    calisip bittigini raporlar
    C01'de testleri if else ile yaptigimiz icin
    testler failed olsa da kodlar sorunsuz calistigi icin testler yesil tik olarak isaretlendi.

     */

    int P1Yas1=60;
    int P2Yas2=66;
    int P3Yas3=70;


    @Test
    public void test01(){

        // emekli yasi 65 olduguna göre
        // P2'nin emekli olabilecegini tes edin.

        Assert.assertTrue(P2Yas2>65);
    }


    @Test
    public void test02(){

        // emekli yasi 65 olduguna göre
        // P1'nin emekli olamayacğini test edin.

        Assert.assertFalse(P1Yas1>65);
    }


    @Test
    public void test03(){
        // emekli yasi 65 olduguna gore
        // P3'nin emekli olamayacagini test edin
        Assert.assertFalse("Girilen yas 65'den kucuk olmadigindan emekli olabilir",P3Yas3>65); // failed olması durumu, doğru oldugunu gösterir.
    }



}
