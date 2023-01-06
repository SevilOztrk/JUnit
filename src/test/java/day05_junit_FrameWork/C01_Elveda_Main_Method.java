package day05_junit_FrameWork;

import org.junit.Ignore;
import org.junit.Test;

public class C01_Elveda_Main_Method {

    @Test
    public void test01(){
        System.out.println("test 01 çalisti");
        // @Test notasyonu sayesinde her bir test methodu bagımsız olarak calisablir.
        // eger testin icerisinde bir assertion yoksa
        // kod problem yasanmadan calisip bittiginde
        // JUnit test PASSED olarak raporlar.
    }


    @Test @Ignore
    public void test02(){
        System.out.println("test 02 çalisti");
        // @ Ignore notasyonu yazildigi test methodunun calistirilmamasini saglar.
    }


    @Test
    public void test03(){
        System.out.println("test 03 çalisti");
    }














}
