package org.example;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    private WebDriver driver;

    //Seleccionar localizadores del formulario de registro

    private By btnConfirmarRegistro = By.xpath("//button[@data-testid='botonRegistro']");
    private By mjeError1 = By.xpath("(//p[@class='error'])[1]");
    private By inputName = By.xpath("//input[@data-testid='nameInput']");
    private By inputEmail = By.xpath("//input[@data-testid='emailInput']");
    private By inputPassword = By.xpath("//input[@data-testid='passwordInput']");
    private By inputConfirmPassword = By.xpath("//input[@data-testid='confirmPasswordInput']");
    private By imgPassword = By.xpath("(//img[@class='toggle-password'])[1]");
    private By imgConfirPassword = By.xpath("(//img[@class='toggle-password'])[2]");


    //Constructor
    public Register(){
        this.driver = DriverManager.getDriver();
    }

    public void registerUser(){
        //Click en confirmar registro para ver errores de TODOS los inputs
        driver.findElement(btnConfirmarRegistro).click();

        //Localizar error input nombre
        WebElement errorMessage = driver.findElement(mjeError1);
        String errorText = errorMessage.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText.equals("El nombre es obligatorio");

        //Completar input nombre
        driver.findElement(inputName).sendKeys("Gonzalo");

        //oprimir boton confirmar registro para mostrar errores en demas inputs menos el del NOMBRE
        driver.findElement(btnConfirmarRegistro).click();

        //Localizar error input que no sea nombre
        WebElement errorMessage2 = driver.findElement(mjeError1);
        String errorText2 = errorMessage2.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText2.equals("El correo electrónico es obligatorio");

        //Completar datos del input de EMAIL
        driver.findElement(inputEmail).sendKeys("gonzapereyra34@654");

        driver.findElement(btnConfirmarRegistro).click();

       //Corroborar el SEGUNDO mensaje de error del EMAIL

        //Localizar error input que no sea nombre
        WebElement errorMessage3 = driver.findElement(mjeError1);
        String errorText3 = errorMessage3.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText3.equals("El correo electrónico no es válido");

        //Limpiamos el input de EMAIL y cargamos un EMAIL VALIDO y observamos errores en los inputs que no sean NOMBRE y EMAIL
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("gonzapereyra34@hotmail.com");
        driver.findElement(btnConfirmarRegistro).click();

        //Corroboramos mensaje de error de la Password
        //Localizar error input que no sea nombre
        WebElement errorMessage4 = driver.findElement(mjeError1);
        String errorText4 = errorMessage4.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText4.equals("La contraseña es obligatoria");

        //Completamos datos de la una PASSWORD INVALIDA y verificamos el siguiente error
        driver.findElement(inputPassword).sendKeys("Gonzalo");

        driver.findElement(btnConfirmarRegistro).click();

        //Localizamos mensaje de error de contraseña invalida
        WebElement errorMessage5 = driver.findElement(mjeError1);
        String errorText5 = errorMessage5.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText5.equals("La contraseña debe tener al menos 6 caracteres, incluyendo una letra, un número y un símbolo.");

        //Limpiasmos la PASSWORD y agregamos una contraseña valida,la visualizamos y repasamos los errores que no sean NOMBRE EMAIL y PASSWORD
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys("Gonzalo1$");
        driver.findElement(imgPassword).click();
        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }
        //Hacemos nuevo click en el visor de PASSWORD y confirmamos registro para ver errores de CONFIRMAR PASSWORD
        driver.findElement(imgPassword).click();
        driver.findElement(btnConfirmarRegistro).click();

        //Localizamos nuevo mensaje de error de CONFIRMAR PASSWORD
        //Localizamos mensaje de error de contraseña invalida
        WebElement errorMessage6 = driver.findElement(mjeError1);
        String errorText6 = errorMessage6.getText();  // Obtener el texto del mensaje de error
        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText);
        assert errorText6.equals("La confirmación de la contraseña es obligatoria");

        //Cargamos una PASSWORD INCORRECTA para verificar nuevo mensjae de error
        driver.findElement(inputConfirmPassword).sendKeys("Gonzalo");
        driver.findElement(btnConfirmarRegistro).click();

        //Corroboramos que el error sea el correcto
        WebElement errorMessage7 = driver.findElement(By.xpath("(//p[@class='error'])[1]"));
        String errorText7 = errorMessage7.getText();  // Obtener el texto del mensaje de error

        // Verificar que el mensaje de error sea el esperado
        System.out.println("Mensaje de error: " + errorText7);
        assert errorText7.equals("Las contraseñas no coinciden");

        //Limpiamos, agregamos la CONFIRMACION PASSWORD correcta, la VUSUALIZAMOS y verificamos que este correcta.
        driver.findElement(inputConfirmPassword).clear();
        driver.findElement(inputConfirmPassword).sendKeys("Gonzalo1$");
        driver.findElement(inputConfirmPassword).click();
        driver.findElement(imgConfirPassword).click();

        //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
        try {
            Thread.sleep(1000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
        }
        //Hacemos nuevo click en el visor de PASSWORD y confirmamos registro para ver errores de CONFIRMAR PASSWORD
        driver.findElement(imgConfirPassword).click();



    }

    public Login irLogin(){
        driver.findElement(btnConfirmarRegistro).click();
        return new Login();
    }



}
