/*package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MotDePasseInvalide extends BasePage {
    public static void main(String[] args) {
    boolean testResult = false;

        new BasePage(); // Initialiser le driver
        // Initialiser à false par défaut


        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "mot de passe invalide");
            loginManager.login();

            // Localiser le message d'erreur
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                // Attendre que le message d'erreur soit visible
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

                // Récupérer le texte du message d'erreur
                String errorMessageText = errorMessageElement.getText();

                // Vérifier si le texte correspond à celui attendu
                if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    testResult = true;
                    System.out.println(testResult);
                }
            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Si le message d'erreur n'apparaît pas, le login est réussi

                testResult = false; //
                System.out.println(testResult);
            }

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Fermer le navigateur
            if (driver != null) {

                driver.quit();
            }

        }

    }
}
 */






/*
package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MotDePasseInvalide extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // Variable pour WebDriverWait

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialiser le résultat du test
        testResult = false;
    }

    @Test
    public void testMotDePasseInvalide() {
        try {
            // Effectuer le login avec un mot de passe invalide
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "mot de passe invalide");
            loginManager.login();

            // Localiser le message d'erreur
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                // Attendre que le message d'erreur soit visible
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

                // Récupérer le texte du message d'erreur
                String errorMessageText = errorMessageElement.getText();

                // Vérifier si le texte correspond à celui attendu
                //if (errorMessageText.equalsIgnoreCase("test")) {
                if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    testResult = true;
                }
            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Si le message d'erreur n'apparaît pas, le login est réussi
                testResult = false;
            }

        } catch (Exception e) {
            //System.err.println("Une erreur s'est produite : " + e.getMessage());
        }

        // Afficher le résultat
        System.out.println("MotDePasseInvalide : " + testResult);
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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import java.time.Duration;

@Epic("Tests de connexion")
@Feature("Validation avec mot de passe invalide")
public class MotDePasseInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test MotDePasseInvalide.");
    }

    @Test
    @Description("Vérifie qu'un message d'erreur s'affiche lorsque le mot de passe est invalide.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseInvalide() {
        System.out.println("[INFO] Début du test MotDePasseInvalide.");

        try {
            System.out.println("[INFO] Tentative de connexion avec un mot de passe invalide.");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "mot de passe invalide");
            loginManager.login();

            System.out.println("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                System.out.println("[INFO] Message d'erreur capturé : " + errorMessageText);
                if (errorMessageText.equalsIgnoreCase("test")) {
                //if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    System.out.println("[SUCCESS] Le message d'erreur est correct.");
                    testResult = true;
                } else {
                    System.out.println("[ERROR] Le message d'erreur est incorrect.");
                    testResult = false;
                }

            } catch (NoSuchElementException | TimeoutException e) {
                System.out.println("[ERROR] Le message d'erreur attendu n'a pas été trouvé : " + e.getMessage());
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test MotDePasseInvalide : " + (testResult ? "Succès" : "Échec"));
            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test MotDePasseInvalide.");
    }
}
 */





/*
package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import java.time.Duration;

@Epic("Tests de connexion")
@Feature("Validation avec mot de passe invalide")
public class MotDePasseInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test MotDePasseInvalide.");
    }

    @Test
    @Description("Vérifie qu'un message d'erreur s'affiche lorsque le mot de passe est invalide.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseInvalide() {
        System.out.println("[INFO] Début du test MotDePasseInvalide.");

        try {
            System.out.println("[INFO] Tentative de connexion avec un mot de passe invalide.");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "mot de passe invalide");
            loginManager.login();

            System.out.println("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                System.out.println("[INFO] Message d'erreur capturé : " + errorMessageText);
                if (errorMessageText.equalsIgnoreCase("test")) {
                    //if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    System.out.println("[SUCCESS] Le message d'erreur est correct.");
                    testResult = true;
                } else {
                    System.out.println("[ERROR] Le message d'erreur est incorrect.");
                    testResult = false;
                }

            } catch (NoSuchElementException | TimeoutException e) {
                System.out.println("[ERROR] Le message d'erreur attendu n'a pas été trouvé : " + e.getMessage());
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test MotDePasseInvalide : " + (testResult ? "Succès" : "Échec"));
            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test MotDePasseInvalide.");
    }
}
 */



package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import java.time.Duration;

@Epic("Tests de connexion")
@Feature("Validation avec mot de passe invalide")
public class MotDePasseInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test MotDePasseInvalide.");
    }

    @Test
    @Description("Vérifie qu'un message d'erreur s'affiche lorsque le mot de passe est invalide.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseInvalide() {
        System.out.println("[INFO] Début du test MotDePasseInvalide.");

        try {
            System.out.println("[INFO] Tentative de connexion avec un mot de passe invalide.");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "mot de passe invalide");
            loginManager.login();

            System.out.println("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                System.out.println("[INFO] Message d'erreur capturé : " + errorMessageText);
                if (errorMessageText.equalsIgnoreCase("test")) {
                    //if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    System.out.println("[SUCCESS] Le message d'erreur est correct.");
                    testResult = true;
                } else {
                    System.out.println("[ERROR] Le message d'erreur est incorrect.");
                    testResult = false;
                }

            } catch (NoSuchElementException | TimeoutException e) {
                System.out.println("[ERROR] Le message d'erreur attendu n'a pas été trouvé : " + e.getMessage());
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test MotDePasseInvalide : " + (testResult ? "Succès" : "Échec"));
            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test MotDePasseInvalide.");
    }
}




