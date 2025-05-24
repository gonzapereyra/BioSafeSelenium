package org.example;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;

    //Localizadores Forgot Password
    private By inputEmail = By.xpath("//input[@type='email']");
    private By btnSendmje = By.xpath("//button[@type='submit']");
    private By btnLogin = By.xpath("//a[@href='/login']");


    //Constructor

    public ForgotPassword(){
        this.driver = DriverManager.getDriver();
    }

    public void sendEmail(){
        driver.findElement(btnSendmje).click();
        driver.findElement(inputEmail).sendKeys("asdasdasd");
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("asdasd@asda.com");
        driver.findElement(inputEmail).clear();

    }

    public Login backLogin(){
        driver.findElement(btnLogin).click();
        return new Login();
    }

}
