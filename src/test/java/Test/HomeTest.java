package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.Duration;

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

        //Utilizacion de localizadores para completar el registro de usuario


        //Localizarel boton de registro y realizar click:
        driver.findElement(By.xpath("(//a[@href='/signup'])[2]")).click();

        //Localizar los inputs necesarios para completar el formulario:
        driver.findElement(By.xpath("//input[@data-testid='nameInput']")).sendKeys("Gonzalo");//Nombre
        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).sendKeys("Gonzalo"); // Mail
        driver.findElement(By.xpath("//input[@data-testid='passwordInput']")).sendKeys("Gonzalo"); //Contraseña
        driver.findElement(By.xpath("(//img[@class='toggle-password'])[1]")).click(); //visor de contraseña

        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }

        driver.findElement(By.xpath("(//img[@class='toggle-password'])[1]")).click(); // visor contraseña
        driver.findElement(By.xpath("//input[@data-testid='confirmPasswordInput']")).sendKeys("Gonzalo"); // confirmar contraseña
        driver.findElement(By.xpath("(//img[@class='toggle-password'])[2]")).click(); // visor confirmar contraseña

        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }

        driver.findElement(By.xpath("(//img[@class='toggle-password'])[2]")).click();//visor confirmar contraseña


    }


    @AfterMethod
    public void tearDown(){
        if(driver != null){
          //  driver.quit();
        }
    }
}
