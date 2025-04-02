package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    private WebDriver driver;

    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    }
