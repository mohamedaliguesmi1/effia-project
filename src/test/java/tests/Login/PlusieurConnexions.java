/*package tests.Login;
import config.BasePage;
import org.example.LoginManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlusieurConnexions extends BasePage {
    public static void main(String[] args) {
        new BasePage(); // Initialiser le driver
        boolean testResult = false; // Initialiser à false par défaut
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginManager loginManager = new LoginManager("invalid_user@example.com", "invalid_password");
        loginManager.login();

        // Localiser le bouton de connexion
        By loginButtonLocator = By.cssSelector("#\\:r7\\:"); // Remplacez par le sélecteur exact
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

        try {
            // Cliquer 5 fois sur le bouton de connexion
            for (int attemptCount = 0; attemptCount < 5; attemptCount++) {
                loginButton.click();
                Thread.sleep(2000); // Pause de 2 secondes entre les clics
            }

            // Vérifier si le message attendu apparaît après 5 tentatives
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");
            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();

                if (errorMessageText.equalsIgnoreCase("Trop de tentatives de connexion, veuillez réessayer plus tard.")) {
                    testResult = true; // Le message attendu a été détecté
                }
            } catch (Exception e) {
                // Aucune exception à traiter ici, testResult reste false
            }

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat global du test
            if (testResult) {
                System.out.println(testResult);
            } else {
                System.out.println(testResult);
            }

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PlusieurConnexions extends BasePage {

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
    public void testPlusieurConnexions() {
        try {
            // Initialiser le gestionnaire de connexion avec des informations invalides
            LoginManager loginManager = new LoginManager("invalid_user@example.com", "invalid_password");
            loginManager.login();

            // Localiser le bouton de connexion
            By loginButtonLocator = By.cssSelector("#\\:r7\\:"); // Remplacez par le sélecteur exact
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

            try {
                // Cliquer 5 fois sur le bouton de connexion
                for (int attemptCount = 0; attemptCount < 5; attemptCount++) {
                    loginButton.click();
                    Thread.sleep(2000); // Pause de 2 secondes entre les clics
                }

                // Vérifier si le message attendu apparaît après 5 tentatives
                By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();
                //if (errorMessageText.equalsIgnoreCase("test")) {
                if (errorMessageText.equalsIgnoreCase("Trop de tentatives de connexion, veuillez réessayer plus tard.")) {
                    testResult = true; // Le message attendu a été détecté
                }
            } catch (Exception e) {
                // Si le message d'erreur n'apparaît pas, testResult reste false
            }

        } catch (Exception e) {
            //System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat global du test
            System.out.println("PlusieurConnexions : " + testResult);
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Tentatives de connexion multiples")
public class PlusieurConnexions extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("[SETUP] Initialisation du test PlusieurConnexions.");
    }

    @Test
    @Description("Vérifie le comportement après plusieurs tentatives de connexion échouées.")
    @Severity(SeverityLevel.CRITICAL)
    public void testPlusieurConnexions() {
        System.out.println("[INFO] Début du test PlusieurConnexions.");

        testResult = false; // Réinitialiser le résultat du test

        try {
            // Étape 1 : Initialiser le gestionnaire de connexion avec des informations invalides
            LoginManager loginManager = new LoginManager("invalid_user@example.com", "invalid_password");
            loginManager.login();

            // Étape 2 : Localiser le bouton de connexion
            By loginButtonLocator = By.cssSelector("#\\:r7\\:"); // Remplacez par le sélecteur exact
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

            // Étape 3 : Cliquer plusieurs fois sur le bouton de connexion (5 tentatives)
            for (int attemptCount = 0; attemptCount < 5; attemptCount++) {
                loginButton.click();
                System.out.println("[INFO] Tentative de connexion #" + (attemptCount + 1));
                Thread.sleep(2000); // Pause de 2 secondes entre les clics
            }

            // Étape 4 : Vérifier le message d'erreur après 5 tentatives
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            String errorMessageText = errorMessageElement.getText();

            // Étape 5 : Validation du message d'erreur
            if (errorMessageText.equalsIgnoreCase("Trop de tentatives de connexion, veuillez réessayer plus tard.")) {
                System.out.println("[SUCCESS] Le message d'erreur a été correctement affiché.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Le message d'erreur n'a pas été trouvé ou ne correspond pas.");
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur est survenue lors du test : " + e.getMessage());
            testResult = false;

        } finally {
            // Affichage du résultat du test
            System.out.println("[RESULT] Test PlusieurConnexions : " + (testResult ? "Succès" : "Échec"));
        }

        // Attendre 30 secondes après le test
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown(); // Appelle la méthode centralisée pour fermer le navigateur
        System.out.println("[TEARDOWN] Fin du test PlusieurConnexions.");
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
@Feature("Tentatives de connexion multiples")
public class PlusieurConnexions extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test PlusieurConnexions.");
    }

    @Test
    @Description("Vérifie le comportement après plusieurs tentatives de connexion échouées.")
    @Severity(SeverityLevel.CRITICAL)
    public void testPlusieurConnexions() {
        System.out.println("[INFO] Début du test PlusieurConnexions.");

        try {
            // Étape 1 : Initialiser le gestionnaire de connexion avec des informations invalides
            System.out.println("[INFO] Initialisation du LoginManager avec des identifiants invalides...");
            LoginManager loginManager = new LoginManager("invalid_user@example.com", "invalid_password");
            loginManager.login();
            System.out.println("[SUCCESS] Gestionnaire de connexion initialisé.");

            // Étape 2 : Localiser le bouton de connexion
            System.out.println("[INFO] Localisation du bouton de connexion...");
            By loginButtonLocator = By.cssSelector("#\\:r7\\:"); // À remplacer si nécessaire
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            System.out.println("[SUCCESS] Bouton de connexion trouvé.");

            // Étape 3 : Effectuer 5 tentatives de connexion
            System.out.println("[INFO] Début des tentatives de connexion...");
            for (int attemptCount = 0; attemptCount < 5; attemptCount++) {
                loginButton.click();
                System.out.println("[INFO] Tentative de connexion #" + (attemptCount + 1));
                Thread.sleep(2000); // Attente de 2 secondes entre les tentatives
            }

            // Étape 4 : Vérifier le message d'erreur après 5 tentatives
            System.out.println("[INFO] Vérification du message d'erreur...");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            String errorMessageText = errorMessageElement.getText();

            // Étape 5 : Validation du message d'erreur
           String expectedErrorMessage = "test";
            //String expectedErrorMessage = "Trop de tentatives de connexion, veuillez réessayer plus tard.";
            if (errorMessageText.equalsIgnoreCase(expectedErrorMessage)) {
                System.out.println("[SUCCESS] Message d'erreur correct affiché.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Message inattendu : " + errorMessageText);
                testResult = false;
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Erreur inattendue : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test PlusieurConnexions : " + (testResult ? "Succès" : "Échec"));
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
 // Étape 6 : Attente de 30 secondes avant de poursuivre les tests
        try {
            System.out.println("[INFO] Attente de 30 secondes avant le test suivant...");
            TimeUnit.SECONDS.sleep(30);
            System.out.println("[INFO] 30 secondes écoulées, reprise des tests.");
        } catch (InterruptedException e) {
            System.out.println("[ERROR] Interruption de l'attente : " + e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

    @AfterSuite
    public void tearDown() {

        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test PlusieurConnexions.");
    }
}
 */


package tests.Login;

import config.BasePage;
import org.example.LoginManager;
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
@Feature("Tentatives de connexion multiples")
public class PlusieurConnexions extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test PlusieurConnexions.");
    }

    @Test
    @Description("Vérifie le comportement après plusieurs tentatives de connexion échouées.")
    @Severity(SeverityLevel.CRITICAL)
    public void testPlusieurConnexions() {
        logCustomMessage("[INFO] Début du test PlusieurConnexions.");

        try {
            // Étape 1 : Initialiser le gestionnaire de connexion avec des informations invalides
            logCustomMessage("[INFO] Initialisation du LoginManager avec des identifiants invalides...");
            LoginManager loginManager = new LoginManager("invalid_user@example.com", "invalid_password");
            loginManager.login();
            logCustomMessage("[SUCCESS] Gestionnaire de connexion initialisé.");

            // Étape 2 : Localiser le bouton de connexion
            logCustomMessage("[INFO] Localisation du bouton de connexion...");
            By loginButtonLocator = By.cssSelector("#\\:r7\\:"); // À remplacer si nécessaire
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            logCustomMessage("[SUCCESS] Bouton de connexion trouvé.");

            // Étape 3 : Effectuer 5 tentatives de connexion
            logCustomMessage("[INFO] Début des tentatives de connexion...");
            for (int attemptCount = 0; attemptCount < 5; attemptCount++) {
                loginButton.click();
                logCustomMessage("[INFO] Tentative de connexion #" + (attemptCount + 1));
                Thread.sleep(2000); // Attente de 2 secondes entre les tentatives
            }

            // Étape 4 : Vérifier le message d'erreur après 5 tentatives
            logCustomMessage("[INFO] Vérification du message d'erreur...");
            By errorMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p[1]/p");
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            String errorMessageText = errorMessageElement.getText();

            // Étape 5 : Validation du message d'erreur
            //String expectedErrorMessage = "test";
            String expectedErrorMessage = "Trop de tentatives de connexion, veuillez réessayer plus tard.";
            if (errorMessageText.equalsIgnoreCase(expectedErrorMessage)) {
                logCustomMessage("[SUCCESS] Message d'erreur correct affiché.");
                testResult = true;
            } else {
                logCustomMessage("[ERROR] Message inattendu : " + errorMessageText);
                testResult = false;
            }

        } catch (Exception e) {
            logCustomMessage("[ERROR] Erreur inattendue : " + e.getMessage());
            testResult = false;
        } finally {
            logCustomMessage("[RESULT] Test PlusieurConnexions : " + (testResult ? "Succès" : "Échec"));

            // Capture d’écran en cas d’échec
            String screenshotPath = captureScreenshot("testPlusieurConnexions");
            if (screenshotPath != null) {
                logScreenshot(screenshotPath);
            }

            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }

        // Étape 6 : Attente de 30 secondes avant de poursuivre les tests
        try {
            logCustomMessage("[INFO] Attente de 30 secondes avant le test suivant...");
            TimeUnit.SECONDS.sleep(30);
            logCustomMessage("[INFO] 30 secondes écoulées, reprise des tests.");
        } catch (InterruptedException e) {
            logCustomMessage("[ERROR] Interruption de l'attente : " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        logCustomMessage("[TEARDOWN] Fin du test PlusieurConnexions.");
    }
}



