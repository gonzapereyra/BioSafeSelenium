package Test;

import driver.DriverManager;
import org.example.ForgotPassword;
import org.example.HomePage;
import org.example.Login;
import org.example.Register;
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
    private HomePage homePage;
    private Register register;
    private Login login;
    private ForgotPassword forgotPassword;

    @BeforeMethod
    public void setUp(){
      //  driver = new ChromeDriver();
      //  driver.manage().window().maximize();
        DriverManager.getDriver().get("https://qa.biosafeapp.com/");
        homePage = new HomePage();
        register = new Register();
        login = new Login();
        forgotPassword = new ForgotPassword();
    }

    @Test
    public void testBioSafeAap() {
        homePage.register();

        register.registerUser();

        login = register.irLogin();

        login.dataUser();

        login.forgotPassword();

        forgotPassword.sendEmail();

        forgotPassword.backLogin();

        login.completeLogin();







    }
/*
    @Test
    public void homePage(){
        driver.get("https://qa.biosafeapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title,"BioSafeApp");

        //Utilizacion de localizadores para completar el registro de usuario


        //Localizarel boton de registro y realizar click:
        driver.findElement(By.xpath("(//a[@href='/signup'])[2]")).click();

        //Oprimir boton de registrarse para obtener error en los campos
        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //Localizar error en el input de nombre
        // Esperar que el mensaje de error aparezca en la página
        WebElement errorMessage = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText = errorMessage.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText.equals("El nombre es obligatorio");


        //Localizar los inputs necesarios para completar el formulario:
        driver.findElement(By.xpath("//input[@data-testid='nameInput']")).sendKeys("Gonzalo");//Nombre

        //Oprimir boton de registrarse para obtener error en los campos
        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //Localizar error en el input del correo
        // Esperar que el mensaje de error aparezca en la página
        WebElement errorMessage2 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText2 = errorMessage2.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText2);
        assert errorText2.equals("El correo electrónico es obligatorio");


        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).sendKeys("Gonzalo"); // Mail

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //Borrar mensaje anterior del input para agregar uno nuevo.
        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).clear(); // Mail
        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).sendKeys("Gonzalo@asdas"); // Mail

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //Localizar error en el input del Mail
        // Esperar que el mensaje de error aparezca en la página
        WebElement errorMessage5 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText5 = errorMessage5.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText5);
        assert errorText5.equals("El correo electrónico no es válido");

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //agregar correo sin error
        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).clear(); // Mail
        driver.findElement(By.xpath("//input[@data-testid='emailInput']")).sendKeys("gonzapereyra4@hotmail.com"); // Mail

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();


        //Localizar error en el input del Mail
        // Esperar que el mensaje de error aparezca en la página
        WebElement errorMessage3 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText3 = errorMessage3.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText3);
        assert errorText3.equals("La contraseña es obligatoria");

        driver.findElement(By.xpath("//input[@data-testid='passwordInput']")).sendKeys("Gonzalo"); //Contraseña

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        WebElement errorMessage6 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText6 = errorMessage6.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText6);
        assert errorText6.equals("La contraseña debe tener al menos 6 caracteres, incluyendo una letra, un número y un símbolo.");

        driver.findElement(By.xpath("//input[@data-testid='passwordInput']")).clear(); //Contraseña
        driver.findElement(By.xpath("//input[@data-testid='passwordInput']")).sendKeys("Gonzalo1$"); //Contraseña


        driver.findElement(By.xpath("(//img[@class='toggle-password'])[1]")).click(); //visor de contraseña


        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }

        driver.findElement(By.xpath("(//img[@class='toggle-password'])[1]")).click(); // visor contraseña

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();

        //Localizar error en el input del Confirmar contraseña
        // Esperar que el mensaje de error aparezca en la página
        WebElement errorMessage4 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText4 = errorMessage4.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText4);
        assert errorText4.equals("La confirmación de la contraseña es obligatoria");



        driver.findElement(By.xpath("//input[@data-testid='confirmPasswordInput']")).sendKeys("Gonzalo"); // confirmar contraseña

        driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();


        WebElement errorMessage7 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText7 = errorMessage7.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText7);
        assert errorText7.equals("Las contraseñas no coinciden");


       //Mostrar error de contraseña inforrecta
        driver.findElement(By.xpath("//input[@data-testid='confirmPasswordInput']")).clear(); // confirmar contraseña
        driver.findElement(By.xpath("//input[@data-testid='confirmPasswordInput']")).sendKeys("Gonzalo1$"); // confirmar contraseña




        driver.findElement(By.xpath("(//img[@class='toggle-password'])[2]")).click(); // visor confirmar contraseña

        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }

        driver.findElement(By.xpath("(//img[@class='toggle-password'])[2]")).click();//visor confirmar contraseña

       // driver.findElement(By.xpath("//button[@data-testid='botonRegistro']")).click();


    }

 */
/* Mejoramiento del codigo @Test utilizando chatGPT, para ver como se podia reducir codigo y mejorar para proximas pruebas.
    @Test
    public void homePage() {
        driver.get("https://qa.biosafeapp.com/");
        Assert.assertEquals(driver.getTitle(), "BioSafeApp");

        // Acceder al formulario de registro
        click(By.xpath("(//a[@href='/signup'])[2]"));

        // Validar errores en campos obligatorios paso a paso
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[1]", "El nombre es obligatorio");

        escribir("nameInput", "Gonzalo");
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[1]", "El correo electrónico es obligatorio");

        escribir("emailInput", "Gonzalo");
        click(By.xpath("//button[@data-testid='botonRegistro']"));

        limpiarYEscribir("emailInput", "Gonzalo@asdas");
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[1]", "El correo electrónico no es válido");

        limpiarYEscribir("emailInput", "Gonzalo@asdas.com");
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[1]", "La contraseña es obligatoria");

        escribir("passwordInput", "Gonzalo");
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[1]",
                "La contraseña debe tener al menos 6 caracteres, incluyendo una letra, un número y un símbolo.");

        limpiarYEscribir("passwordInput", "Gonza1.");

        alternarVisorPassword("(//img[@class='toggle-password'])[1]");
        click(By.xpath("//button[@data-testid='botonRegistro']"));

        validarMensajeDeError("(//p[@class='error'])[2]", "La confirmación de la contraseña es obligatoria");

        escribir("confirmPasswordInput", "Gonzalo");
        click(By.xpath("//button[@data-testid='botonRegistro']"));
        validarMensajeDeError("(//p[@class='error'])[2]", "Las contraseñas no coinciden");

        limpiarYEscribir("confirmPasswordInput", "Gonza1.");

        alternarVisorPassword("(//img[@class='toggle-password'])[2]");
    }

    private void escribir(String testId, String texto) {
        WebElement input = driver.findElement(By.xpath("//input[@data-testid='" + testId + "']"));
        input.sendKeys(texto);
    }

    private void limpiarYEscribir(String testId, String texto) {
        WebElement input = driver.findElement(By.xpath("//input[@data-testid='" + testId + "']"));
        input.clear();
        input.sendKeys(texto);
    }

    private void click(By selector) {
        driver.findElement(selector).click();
    }

    private void validarMensajeDeError(String xpath, String mensajeEsperado) {
        WebElement error = driver.findElement(By.xpath(xpath));
        String texto = error.getText();
        System.out.println("Mensaje de error: " + texto);
        Assert.assertEquals(texto, mensajeEsperado);
    }

    private void alternarVisorPassword(String xpathImg) {
        driver.findElement(By.xpath(xpathImg)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(xpathImg)).click();
    }
*/


    @AfterMethod
    public void tearDown(){
        if(driver != null){
          //  driver.quit();
        }
    }
}
