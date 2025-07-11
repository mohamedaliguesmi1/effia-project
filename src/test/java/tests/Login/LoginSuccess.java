/*package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSuccess extends BasePage {
    public static void main(String[] args) {

        boolean testResult;
            // Initialiser le driver via BasePage
            new BasePage(); // Cela initialise le `driver`


            // Initialiser WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Effectuer le login
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            // Localiser le bouton "se connecter"
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");

            // Attendre que le bouton soit visible
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));

            // Récupérer le texte du bouton
            String buttonText = loginButton.getText();
            System.out.println("Texte du bouton après login : " + buttonText);

            // Vérifier si le texte est différent de "se connecter"
            if (!buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                System.out.println("Login réussi !");
            } else {
                testResult = false;
                System.out.println("Échec du login ");
            }
        System.out.println(testResult);
            driver.quit();
        }
}

 */

/*
package tests.Login;

import config.BasePage;
import org.example.LoginManager;

import org.example.LogoutManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSuccess extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // Variable pour WebDriverWait

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage(); // Cela initialise le `driver`

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testLoginSuccess() {
        testResult = false; // Réinitialiser le résultat du test

        // Effectuer le login
        //LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "test");
        LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
        loginManager.login();

        try {
            TimeUnit.SECONDS.sleep(1); // Pause pour laisser le chargement se faire
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Localiser le bouton "se connecter"
        By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");

        try {
            // Attendre que le bouton soit visible
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));

            // Récupérer le texte du bouton
            String buttonText = loginButton.getText();
           // System.out.println("Texte du bouton après login : " + buttonText);

            // Vérifier si le texte est différent de "se connecter"

            if (!buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                //System.out.println("Login réussi !");
            } else {
               // System.out.println("Échec du login ");
            }
        } catch (Exception e) {
           // System.out.println("Erreur pendant le test : " + e.getMessage());
        }

        // Afficher le résultat
        System.out.println("LoginSuccess : "  + testResult);

        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

@AfterSuite

public void tearDown() {

   super.tearDown(); // Appelle la méthode centralisée pour fermer le navigateur
}
}
 */





/*
package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.example.LogoutManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Validation de la connexion réussie")
public class LoginSuccess extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("[SETUP] Initialisation du test LoginSuccess.");
    }

    @Test
    @Description("Vérifie qu'un utilisateur peut se connecter avec des informations valides.")
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginSuccess() {
        System.out.println("[INFO] Début du test de connexion réussie.");

        testResult = false; // Réinitialiser le résultat du test

        try {
            // Étape 1 : Connexion avec des informations valides
            System.out.println("[INFO] Tentative de connexion avec des informations valides.");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();

            // Pause pour laisser le chargement se faire
            TimeUnit.SECONDS.sleep(2);

            // Étape 2 : Vérification de la visibilité du bouton de connexion
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
            String buttonText = loginButton.getText();
            System.out.println("[INFO] Texte du bouton après connexion : " + buttonText);

            // Étape 3 : Vérification du texte du bouton
            if (!buttonText.equalsIgnoreCase("se connecter")) {
                System.out.println("[SUCCESS] Connexion réussie !");
                testResult = true;
            } else {
                System.out.println("[ERROR] Échec de la connexion !");
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur s'est produite pendant le test : " + e.getMessage());
            testResult = false;
        } finally {
            // Afficher le résultat du test
            System.out.println("[RESULT] Test LoginSuccess : " + (testResult ? "Succès" : "Échec"));
        }

        // Étape 4 : Déconnexion
        System.out.println("[INFO] Tentative de déconnexion.");
        try {
            LogoutManager logoutManager = new LogoutManager();
            logoutManager.logout();
            System.out.println("[SUCCESS] Déconnexion réussie !");
        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur s'est produite lors de la déconnexion : " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown(); // Appelle la méthode centralisée pour fermer le navigateur
        System.out.println("[TEARDOWN] Fin du test LoginSuccess.");
    }
}
 */


/*
package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.example.LogoutManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Validation de la connexion réussie")
public class LoginSuccess extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test LoginSuccess.");
    }

    @Test
    @Description("Vérifie qu'un utilisateur peut se connecter avec des informations valides.")
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginSuccess() {
        System.out.println("[INFO] Début du test de connexion réussie.");

        try {
            // Étape 1 : Connexion avec des informations valides
            System.out.println("[INFO] Tentative de connexion avec des informations valides...");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            System.out.println("[SUCCESS] Connexion initiée.");

            // Pause pour laisser le chargement se faire
            TimeUnit.SECONDS.sleep(2);

            // Étape 2 : Vérification de la visibilité du bouton après connexion
            System.out.println("[INFO] Vérification de l'affichage du bouton après connexion...");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
            String buttonText = loginButton.getText();
            System.out.println("[INFO] Texte du bouton après connexion : " + buttonText);

            // Étape 3 : Vérification du texte du bouton
            if (!buttonText.equalsIgnoreCase("MOHAMED ALI GUESMI")) {
            //if (!buttonText.equalsIgnoreCase("se connecter")) {
                System.out.println("[SUCCESS] Connexion réussie !");
                testResult = true;
            } else {
                System.out.println("[ERROR] Échec de la connexion !");
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur s'est produite pendant le test : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test LoginSuccess : " + (testResult ? "Succès" : "Échec"));
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterMethod
    public void logoutAfterTest() {
        // Étape 7 : Déconnexion après chaque test
        try {
            System.out.println("[INFO] Tentative de déconnexion...");
            LogoutManager logoutManager = new LogoutManager();
            logoutManager.logout();
            System.out.println("[SUCCESS] Déconnexion réussie !");
        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur s'est produite lors de la déconnexion : " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test LoginSuccess.");
    }
}
 */




package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.example.LogoutManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static tests.ExtentReportListener.*;

@Epic("Tests de connexion")
@Feature("Validation de la connexion réussie")
public class LoginSuccess extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test LoginSuccess.");
    }

    @Test
    @Description("Vérifie qu'un utilisateur peut se connecter avec des informations valides.")
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginSuccess() {
        logCustomMessage("[INFO] Début du test de connexion réussie.");

        try {
            // Étape 1 : Connexion avec des informations valides
            logCustomMessage("[INFO] Tentative de connexion avec des informations valides...");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            logCustomMessage("[SUCCESS] Connexion initiée.");

            // Pause pour laisser le chargement se faire
            TimeUnit.SECONDS.sleep(2);

            // Étape 2 : Vérification de la visibilité du bouton après connexion
            logCustomMessage("[INFO] Vérification de l'affichage du bouton après connexion...");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
            String buttonText = loginButton.getText();
            logCustomMessage("[INFO] Texte du bouton après connexion : " + buttonText);

            // Étape 3 : Vérification du texte du bouton
           // if (!buttonText.equalsIgnoreCase("MOHAMED ALI GUESMI")) {
                if (!buttonText.equalsIgnoreCase("se connecter")) {
                logCustomMessage("[SUCCESS] Connexion réussie !");
                testResult = true;
            } else {
                logCustomMessage("[ERROR] Échec de la connexion !");
                testResult = false;
            }

        } catch (Exception e) {
            logCustomMessage("[ERROR] Une erreur s'est produite pendant le test : " + e.getMessage());
            testResult = false;
        } finally {
            logCustomMessage("[RESULT] Test LoginSuccess : " + (testResult ? "Succès" : "Échec"));

            // Capture d’écran en cas d’échec
            String screenshotPath = captureScreenshot("testLoginSuccess");
            if (screenshotPath != null) {
                logScreenshot(screenshotPath);
            }

            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterMethod
    public void logoutAfterTest() {
        // Étape 7 : Déconnexion après chaque test
        try {
            logCustomMessage("[INFO] Tentative de déconnexion...");
            LogoutManager logoutManager = new LogoutManager();
            logoutManager.logout();
            logCustomMessage("[SUCCESS] Déconnexion réussie !");
        } catch (Exception e) {
            logCustomMessage("[ERROR] Une erreur s'est produite lors de la déconnexion : " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        logCustomMessage("[TEARDOWN] Fin du test LoginSuccess.");
    }
}
