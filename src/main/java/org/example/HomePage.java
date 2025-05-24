package org.example;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    private WebDriver driver;

    //Localizar elementos
    //Boton registrarse
    private By bntRegister = By.xpath("(//a[@href='/signup'])[2]");


    public HomePage(){
        this.driver = DriverManager.getDriver();
    }

    public Register register(){
        driver.findElement(bntRegister).click();
        return new Register();
    }





}
