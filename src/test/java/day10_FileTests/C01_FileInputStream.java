package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {



    @Test

    public void test01() throws FileNotFoundException {


        String dosyaYolu="C:\\Users\\SEVİL\\Desktop\\MerhabJava.docx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        /*

        File testlerinde genellikle dowloads'a indirilecek bir dosyanin
        indirildiğini test etmek
        veya masaüstündeki bir dosyanın web'e yuklenebildigini test etmek isteriz.
        ancak herkesin bilgisayarının ismi kullanici isimleri gibi farklılıklar olacagindan testler
        tek bir bilgisayarda calisacak gibi yazilmak zorunda kalinir.
        bu karisikligin onune gecebilmek icin java 2 basit kod blogu sunmustur.
         */

        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanın (C01_FileInputStream) yolunu verir.
        //C:\Users\SEVİL\Desktop\com.team105\com.Team105JUnit

        System.out.println(System.getProperty("user.home")); // C:\Users\SEVİL // bu da kullanicini temel path'ini verir
        // masa ustune gşitmek istersek
        // buna + /Desktop eklemeli

        // Dowloads'a gitmek icin
        // C:\Users\SEVİL\+\Downloads

        // Kodlarımızın dinamik olması icin yani kisinin bilgisayarındaki
        // kullanici adi gbi detaylara takılmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home temel path'ini calistigi bilgisayardan olacak sekilde olustururz.



        String dinamikDosyaYolu=System.getProperty("user.home") + "\\Desktop\\MerhabJava.docx";
    }




















}
