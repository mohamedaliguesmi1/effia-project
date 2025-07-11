
package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginManager extends BasePage {

    private String username;
    private String password;

    // Constructeur pour initialiser LoginPage avec les informations d'identification
    public LoginManager(String username, String password) {
        super(); // Appelle le constructeur de BasePage pour initialiser WebDriver
        this.username = username;
        this.password = password;
    }

    // Méthode pour effectuer la connexion
    public void login() {
        driver.get("https://ppms-sultan-dev.azurewebsites.net/");


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Attendre que le bouton de connexion soit cliquable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginTriggerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button")));

        // Localiser et cliquer sur le bouton de connexion
        loginTriggerButton.click();

        // Attendre que les champs d'identifiant et de mot de passe soient visibles
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"standard-password-input\"]")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r7:\"]")));

        // Saisie des informations de connexion
        usernameField.sendKeys(this.username);
        passwordField.sendKeys(this.password);

        // Clic sur le bouton de connexion
        loginButton.click();

    }
}




/*package org.example;

import config.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;
import static org.openqa.selenium.By.cssSelector;

public class LoginManager extends BasePage {

    private String username;
    private String password;

    // Constructor to initialize LoginPage with credentials
    public LoginManager(String username, String password)  {
        super(); // Call the constructor of BasePage
        this.username = username;
        this.password = password;
    }

    // Method to perform login
    public void login() {
        //WebDriverManager.chromedriver().setup();
      //  WebDriver driver = getDriver();
       driver.get("https://ppms-sultan-test.azurewebsites.net/");
       // driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"idEmail\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"standard-password-input\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\":r7:\"]"));

        usernameField.sendKeys(this.username);
        passwordField.sendKeys(this.password);
        loginButton.click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
*/


/*
package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginManager extends BasePage {

    private String username;
    private String password;

    // Constructeur pour initialiser LoginPage avec les informations d'identification
    public LoginManager(String username, String password) {
        super(); // Appelle le constructeur de BasePage pour initialiser WebDriver
        this.username = username;
        this.password = password;
    }

    // Méthode pour effectuer la connexion
    public void login() {
        driver.get("https://ppms-sultan-dev.azurewebsites.net/");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Localiser et cliquer sur le bouton de connexion
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")).click();

        // Localiser les champs d'identifiant et de mot de passe
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"idEmail\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"standard-password-input\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\":r7:\"]"));

        // Saisie des informations de connexion
        usernameField.sendKeys(this.username);
        passwordField.sendKeys(this.password);

        // Clic sur le bouton de connexion
        loginButton.click();

        // Pause pour permettre le chargement, uniquement pour le débogage
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
