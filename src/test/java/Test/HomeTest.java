package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void homePage(){
        driver.get("https://qa.biosafeapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title,"BioSafeApp");
    }


    @AfterMethod
    public void tearDown(){
        if(driver != null){
          //  driver.quit();
        }
    }
}
