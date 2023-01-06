package day11_seleniumWaits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // eski seleinum 4'e kadar 15 sn'yi belirtmek icin
        // timeout classından 15 sn tanimliyorduk
        // selenium 4 ile birlikte zaman belirleme classi Duration oldu.

    }
}
