package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void WebDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
