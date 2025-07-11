/*package tests.Login;

import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ChampsVides extends BasePage {
    public static void main(String[] args) {
        //public void runTest() {
        new BasePage(); // Initialiser le driver
        boolean testResult = false; // Initialiser à false par défaut

        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            LoginManager loginManager = new LoginManager("", "");
            loginManager.login();

            // Localiser le message d'erreur
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                // Attendre que le message d'erreur soit visible
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

                // Récupérer le texte du message d'erreur
                String errorMessageText = errorMessageElement.getText();

                // Vérifier si le texte correspond à celui attendu
                if (errorMessageText.equalsIgnoreCase("Veuillez fournir les informations nécessaires.")) {
                    testResult = true;
                    System.out.println(testResult);
                }else {
                    testResult = false;
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

public class ChampsVides extends BasePage {

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
    public void testChampsVides() {
        try {
            LoginManager loginManager = new LoginManager("", "");
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
                if (errorMessageText.equalsIgnoreCase("Veuillez fournir les informations nécessaires.")) {
                    testResult = true;
                } else {
                    testResult = false;
                }
               // System.out.println(testResult);

            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Si le message d'erreur n'apparaît pas
                testResult = false;
                //System.out.println(testResult);
            }

        } catch (Exception e) {
            //System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat du test
            System.out.println("ChampsVides : " + testResult);
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
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import java.time.Duration;

@Epic("Tests de connexion")
@Feature("Validation des champs de connexion")
public class ChampsVides extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test ChampsVides.");
    }

    @Test
    @Description("Vérifie si un message d'erreur apparaît lorsque les champs de connexion sont vides.")
    @Severity(SeverityLevel.CRITICAL)
    public void testChampsVides() {
        System.out.println("[INFO] Début du test ChampsVides.");

        try {
            System.out.println("[INFO] Tentative de connexion avec des champs vides...");
            LoginManager loginManager = new LoginManager("", "");
            loginManager.login();

            System.out.println("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                System.out.println("[INFO] Message d'erreur capturé : " + errorMessageText);
                if (errorMessageText.equalsIgnoreCase("test")) {
                    //if (errorMessageText.equalsIgnoreCase("Veuillez fournir les informations nécessaires.")) {
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
            System.out.println("[RESULT] Test ChampsVides : " + (testResult ? "Succès" : "Échec"));
            // Assertion pour forcer l'échec si testResult est false
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test ChampsVides.");
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
@Feature("Validation des champs de connexion")
public class ChampsVides extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test ChampsVides.");
    }

    @Test
    @Description("Vérifie si un message d'erreur apparaît lorsque les champs de connexion sont vides.")
    @Severity(SeverityLevel.CRITICAL)
    public void testChampsVides() {
        logCustomMessage("[INFO] Début du test ChampsVides.");

        try {
            logCustomMessage("[INFO] Tentative de connexion avec des champs vides...");
            LoginManager loginManager = new LoginManager("", "");
            loginManager.login();

            logCustomMessage("[INFO] Attente de l'affichage du message d'erreur.");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");

            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                logCustomMessage("[INFO] Message d'erreur capturé : " + errorMessageText);

                if (errorMessageText.equalsIgnoreCase("test")) {
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
            logCustomMessage("[RESULT] Test ChampsVides : " + (testResult ? "Succès" : "Échec"));

            // Capture d’écran
            String screenshotPath = captureScreenshot("testChampsVides");
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
        logCustomMessage("[TEARDOWN] Fin du test ChampsVides.");
    }
}
