/*package tests.Login;
import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Deconnexion extends BasePage {
    public static void main(String[] args) {
        //public void runTest() {
        boolean testResult = false;

        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Effectuer le login
        LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
        loginManager.login();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Ouvrir le menu déroulant
        try {
            WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button")));
            dropdownMenu.click();

            // Localiser et cliquer sur le bouton de déconnexion
           WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo-customized-menu\"]/div[3]/ul/li[5]")));
            //WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo-customized-menu\"]/div[3]/ul/li[4]")));
            logoutButton.click();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            System.out.println(testResult);
            //driver.quit();
            return;
        }

        // Vérifier si le bouton "se connecter" est de nouveau visible
        try {
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button")));
            String buttonText = loginButton.getText();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Vérifier si le texte du bouton est "se connecter"
            if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                System.out.println("Déconnexion réussie !");
            } else {
                System.out.println("Échec de la déconnexion !");
            }
        } catch (Exception e) {
            testResult = false;
            System.out.println(testResult);
        }

        // Afficher le résultat du test
        System.out.println("TestResult: " + testResult);

        // Fermer le navigateur
        driver.quit();
    }
}
 */






/*

package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Deconnexion extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testDeconnexion() {
        testResult = false;

        // Effectuer le login
        LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
        loginManager.login();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Ouvrir le menu déroulant
        try {
            WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")));
            dropdownMenu.click();

            // Localiser et cliquer sur le bouton de déconnexion
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo-customized-menu\"]/div[3]/ul/li[5]")));
            logoutButton.click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            //System.out.println("Erreur : " + e.getMessage());
            driver.quit();
            return;
        }

        // Vérifier si le bouton "se connecter" est de nouveau visible
        try {
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")));
            String buttonText = loginButton.getText();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Vérifier si le texte du bouton est "se connecter"
            //if (buttonText.equalsIgnoreCase("test")) {
           if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
               // System.out.println("Déconnexion réussie !");
            } else {
                //System.out.println("Échec de la déconnexion !");
            }
        } catch (Exception e) {
            testResult = false;
           // System.out.println("Erreur lors de la vérification : " + e.getMessage());
        }

        // Afficher le résultat du test
        System.out.println("Deconnexion : " + testResult);
    }
@AfterSuite
public void tearDown() {
    super.tearDown(); // Appelle la méthode centralisée pour fermer le navigateur
}
}
 */




package tests.Login;
import config.BasePage;
import org.example.LoginManager;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Déconnexion")
public class Deconnexion extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("[SETUP] Initialisation du test Deconnexion.");
    }

    @Test
    @Description("Vérifie que l'utilisateur peut se déconnecter avec succès.")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeconnexion() {
        System.out.println("[INFO] Début du test Deconnexion.");
        testResult = false;

        try {
            // Étape 1 : Connexion avec LoginManager
            System.out.println("[INFO] Tentative de connexion avec des identifiants valides.");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            TimeUnit.SECONDS.sleep(3);
            // Étape 2 : Ouvrir le menu utilisateur
            System.out.println("[INFO] Ouverture du menu utilisateur.");
            By dropdownMenuLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(dropdownMenuLocator));
            dropdownMenu.click();

            // Étape 3 : Cliquer sur le bouton de déconnexion
            System.out.println("[INFO] Tentative de déconnexion.");
            By logoutButtonLocator = By.xpath("/html/body/div[3]/div[3]/ul/li[5]");
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
            logoutButton.click();
            TimeUnit.SECONDS.sleep(3);
            // Étape 4 : Vérifier que le bouton "Se connecter" est visible
            System.out.println("[INFO] Vérification de la réapparition du bouton 'Se connecter'.");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
            String buttonText = loginButton.getText();

            // Vérification du message affiché
            //if (buttonText.equalsIgnoreCase("test")) {
            if (buttonText.equalsIgnoreCase("Se connecter")) {
                System.out.println("[SUCCESS] Déconnexion réussie !");
                testResult = true;
            } else {
                System.out.println("[ERROR] Échec de la déconnexion. Bouton attendu non visible.");
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test Deconnexion : " + (testResult ? "Succès" : "Échec"));
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test Deconnexion.");
    }
}
