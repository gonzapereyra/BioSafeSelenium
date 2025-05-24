package org.example;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;

        //Localizadores del registro.
        private By inputEmail = By.xpath("//input[@data-testid='email-input']");
        private By inputContra =  By.xpath("//input[@data-testid='password-input']");
        private By imgVisor = By.xpath("//img[@class='password-icon']");
        private By forgotPassword = By.xpath("//a[@data-testid='forgot-password-link']");
        private By irARegistro = By.xpath("//a[@data-testid='signup-link']");
        private By btnLogin = By.xpath("//button[@data-testid='login-button']");



    //Constructor

    public Login(){
            this.driver = DriverManager.getDriver();

        }


        public void dataUser(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
            driver.findElement(inputEmail).sendKeys("gonzaaa");
            driver.findElement(btnLogin).click();

            driver.findElement(inputEmail).clear();
            driver.findElement(inputEmail).sendKeys("gonzapereyra34@asd.com");
            driver.findElement(inputContra).sendKeys("asds");
            driver.findElement(imgVisor).click();
            //Generar un tiempo de espera o pausa, este tiempo es solo para demorar la carga de datos y que se puedan ver las acciones
            try {
                Thread.sleep(1000); // 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace(); // Podés loguearlo o manejarlo de otra forma si querés
            }
            driver.findElement(inputEmail).clear();
            driver.findElement(inputContra).clear();
            driver.findElement(inputEmail).sendKeys("gonzapereyra34@gmail.com");
            driver.findElement(inputContra).sendKeys("ertert");

            driver.findElement(btnLogin).click();

        }


        public ForgotPassword forgotPassword(){
        driver.findElement(forgotPassword).click();
        return new ForgotPassword();
        }


        public void completeLogin(){
            driver.findElement(inputEmail).sendKeys("gonzapereyra34@hotmail.com");
            driver.findElement(inputContra).sendKeys("Gonzalo1$");
            driver.findElement(btnLogin).click();
        }

}
