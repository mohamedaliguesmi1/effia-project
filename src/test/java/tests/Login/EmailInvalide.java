/*package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EmailInvalide extends BasePage {
    public static void main(String[] args) {
   //public void runTest() {
        boolean testResult = false;
        new BasePage(); // Initialiser le driver
      // Initialiser à false par défaut

        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Effectuer le login avec un email invalide
            LoginManager loginManager = new LoginManager("Email invalide", "09245321Aa+");
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
                    System.out.println(testResult);// Le test réussit car l'email est invalide
                }
            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Si le message d'erreur n'apparaît pas, le login est réussi

                testResult = false; // Le test échoue car l'email est valide
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

public class EmailInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

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
    public void testEmailInvalide() {
        try {
            // Effectuer le login avec un email invalide

            LoginManager loginManager = new LoginManager("Email invalide", "09245321Aa+");
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
                    testResult = true; // Le test réussit car l'email est invalide
                    //System.out.println(testResult);
                }
            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Si le message d'erreur n'apparaît pas
                testResult = false; // Le test échoue car l'email est valide
                //System.out.println(testResult);
            }

        } catch (Exception e) {
           // System.err.println("Une erreur s'est produite : " + e.getMessage());
        }
        finally {
            // Afficher le résultat du test
            System.out.println("EmailInvalide : " + testResult);
        }
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
@Feature("Validation des emails")
public class EmailInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test EmailInvalide.");
    }

    @Test
    @Description("Vérifie que le système renvoie un message d'erreur pour un email invalide.")
    @Severity(SeverityLevel.CRITICAL)
    public void testEmailInvalide() {
        System.out.println("[INFO] Début du test pour un email invalide.");

        try {
            System.out.println("[INFO] Tentative de connexion avec un email invalide.");
            LoginManager loginManager = new LoginManager("Email invalide", "09245321Aa+");
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
            System.out.println("[RESULT] Test EmailInvalide : " + (testResult ? "Succès" : "Échec"));
            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }

    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test EmailInvalide.");
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

import static tests.ExtentReportListener.*;

@Epic("Tests de connexion")
@Feature("Validation des emails")
public class EmailInvalide extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test EmailInvalide.");
    }

    @Test
    @Description("Vérifie que le système renvoie un message d'erreur pour un email invalide.")
    @Severity(SeverityLevel.CRITICAL)
    public void testEmailInvalide() {
        logCustomMessage("[INFO] Début du test pour un email invalide.");

        try {
            logCustomMessage("[INFO] Tentative de connexion avec un email invalide.");
            LoginManager loginManager = new LoginManager("Email invalide", "09245321Aa+");
            loginManager.login();

            logCustomMessage("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                logCustomMessage("[INFO] Message d'erreur capturé : " + errorMessageText);

                //if (errorMessageText.equalsIgnoreCase("test")) {
                    if (errorMessageText.equalsIgnoreCase("Veuillez vérifier votre courriel ou votre mot de passe.")) {
                    logCustomMessage("[SUCCESS] Le message d'erreur est correct.");
                    testResult = true;
                } else {
                    logCustomMessage("[ERROR] Le message d'erreur est incorrect.");
                    testResult = false;
                }

            } catch (NoSuchElementException | TimeoutException e) {
                logCustomMessage("[ERROR] Le message d'erreur attendu n'a pas été trouvé : " + e.getMessage());
                testResult = false;
            }

        } catch (Exception e) {
            logCustomMessage("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            logCustomMessage("[RESULT] Test EmailInvalide : " + (testResult ? "Succès" : "Échec"));

            // Capture d’écran en cas d’échec
            String screenshotPath = captureScreenshot("testEmailInvalide");
            if (screenshotPath != null) {
                logScreenshot(screenshotPath);
            }

            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        logCustomMessage("[TEARDOWN] Fin du test EmailInvalide.");
    }
}
