/*package tests.Login;
import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MotDePasseOublier_EmailInexistant extends BasePage {
    public static void main(String[] args) {
        new BasePage();
        boolean testResult = false; // Définir le testResult par défaut
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Accéder à la page
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            Thread.sleep(1000); // Pause courte pour s'assurer que la page charge

            // Cliquer sur le bouton de connexion
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();

            // Pause pour attendre l'apparition du lien "Mot de passe oublié"
            Thread.sleep(3000);

            // Cliquer sur le lien "Mot de passe oublié"
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();

            // Entrer l'email dans le champ
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/input");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("kkjhk");

            // Cliquer sur le bouton "Envoyer"
            By sendButtonLocator = By.xpath("/html/body/div[3]/div[3]/div/div/button");
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();

            // Attendre l'apparition du message d'erreur ou de confirmation
            By messageErreurLocator = By.xpath("/html/body/div[1]/div/div[4]/div/div");
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErreurLocator));
            String errorMessageText = notification.getText();


            // Vérifier le contenu du message
            if (errorMessageText.equalsIgnoreCase("Utilisateur introuvable.")) {

                testResult = true;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            // Si aucun message d'erreur n'est trouvé, on suppose que l'opération a réussi
            testResult = false;

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat du test
            System.out.println("TestResult: " + testResult);

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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MotDePasseOublier_EmailInexistant extends BasePage {

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
    public void testMotDePasseOublierEmailInexistant() {
        try {
            // Accéder à la page
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            Thread.sleep(1000); // Pause courte pour s'assurer que la page charge

            // Cliquer sur le bouton de connexion
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();

            // Pause pour attendre l'apparition du lien "Mot de passe oublié"
            Thread.sleep(3000);

            // Cliquer sur le lien "Mot de passe oublié"
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();

            // Entrer l'email dans le champ
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/input");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("kkjhk");

            // Cliquer sur le bouton "Envoyer"
            By sendButtonLocator = By.xpath("/html/body/div[3]/div[3]/div/div/button");
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();

            // Attendre l'apparition du message d'erreur ou de confirmation
            By messageErreurLocator = By.xpath("/html/body/div[1]/div/div[4]/div/div");
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErreurLocator));
            String errorMessageText = notification.getText();

            // Vérifier le contenu du message
            //if (errorMessageText.equalsIgnoreCase("test")) {
            if (errorMessageText.equalsIgnoreCase("Utilisateur introuvable.")) {
                testResult = true;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            // Si aucun message d'erreur n'est trouvé, on suppose que l'opération a échoué
            testResult = false;

        } catch (Exception e) {
          //  System.err.println("Une erreur s'est produite : " + e.getMessage());
        }
        System.out.println("MotDePasseOublier_EmailInexistant : " + testResult);
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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Réinitialisation du mot de passe")
public class MotDePasseOublier_EmailInexistant extends BasePage {

    private boolean testResult; // Résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("[SETUP] Initialisation du test MotDePasseOublier_EmailInexistant.");
    }

    @Test
    @Description("Vérifie le comportement du lien de réinitialisation du mot de passe avec un email inexistant.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseOublierEmailInexistant() {
        System.out.println("[INFO] Début du test MotDePasseOublier_EmailInexistant.");

        testResult = false; // Réinitialiser le résultat du test

        try {
            // Étape 1 : Accéder à la page de connexion
            System.out.println("[INFO] Accès à la page de connexion.");
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            Thread.sleep(1000); // Attente courte pour le chargement de la page

            // Étape 2 : Cliquer sur le bouton "Se connecter"
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();

            // Étape 3 : Attendre et cliquer sur le lien "Mot de passe oublié"
            Thread.sleep(3000); // Attente pour s'assurer que le lien est visible
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();

            // Étape 4 : Entrer un email inexistant
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/input");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("kkjhk");

            // Étape 5 : Cliquer sur le bouton "Envoyer"
            By sendButtonLocator = By.xpath("/html/body/div[3]/div[3]/div/div/button");
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();

            // Étape 6 : Vérifier le message d'erreur
            By messageErreurLocator = By.xpath("/html/body/div[1]/div/div[4]/div/div");
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErreurLocator));
            String errorMessageText = notification.getText();

            // Vérifier que le message d'erreur correspond à "Utilisateur introuvable"
            if (errorMessageText.equalsIgnoreCase("Utilisateur introuvable.")) {
                System.out.println("[SUCCESS] Le message d'erreur a été correctement affiché.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Le message d'erreur n'a pas été trouvé ou ne correspond pas.");
                testResult = false;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("[ERROR] Une erreur est survenue lors du test : " + e.getMessage());
            testResult = false;

        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur imprévue est survenue : " + e.getMessage());
            testResult = false;
        } finally {
            // Affichage du résultat du test
            System.out.println("[RESULT] Test MotDePasseOublier_EmailInexistant : " + (testResult ? "Succès" : "Échec"));
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown(); // Appelle la méthode centralisée pour fermer le navigateur
        System.out.println("[TEARDOWN] Fin du test MotDePasseOublier_EmailInexistant.");
    }
}
 */


/*
package tests.Login;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;

@Epic("Tests de connexion")
@Feature("Réinitialisation du mot de passe")
public class MotDePasseOublier_EmailInexistant extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test MotDePasseOublier_EmailInexistant.");
    }

    @Test
    @Description("Vérifie le comportement du lien de réinitialisation du mot de passe avec un email inexistant.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseOublierEmailInexistant() {
        System.out.println("[INFO] Début du test MotDePasseOublier_EmailInexistant.");

        try {
            // Étape 1 : Accéder à la page de connexion
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            System.out.println("[INFO] Accès à la page de connexion.");

            Thread.sleep(1000);

            // Étape 2 : Cliquer sur le bouton "Se connecter"
            System.out.println("[INFO] Clic sur le bouton 'Se connecter'...");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();
            System.out.println("[SUCCESS] Bouton 'Se connecter' cliqué.");

            // Étape 3 : Cliquer sur le lien "Mot de passe oublié"
            System.out.println("[INFO] Clic sur le lien 'Mot de passe oublié'...");
            Thread.sleep(3000);
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();
            System.out.println("[SUCCESS] Lien 'Mot de passe oublié' cliqué.");

            // Étape 4 : Entrer un email inexistant
            System.out.println("[INFO] Saisie d'un email inexistant...");
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/input");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("kkjhk");
            System.out.println("[SUCCESS] Email inexistant saisi.");

            // Étape 5 : Cliquer sur le bouton "Envoyer"
            System.out.println("[INFO] Clic sur le bouton 'Envoyer'...");
            By sendButtonLocator = By.xpath("/html/body/div[3]/div[3]/div/div/button");
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();
            System.out.println("[SUCCESS] Bouton 'Envoyer' cliqué.");

            // Étape 6 : Vérifier le message d'erreur
            System.out.println("[INFO] Vérification du message d'erreur...");
            By messageErreurLocator = By.xpath("/html/body/div[1]/div/div[5]/div/div");
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErreurLocator));
            String errorMessageText = notification.getText();

            // Vérifier que le message d'erreur correspond à "Utilisateur introuvable."
            //if (errorMessageText.equalsIgnoreCase("test")) {
                if (errorMessageText.equalsIgnoreCase("Utilisateur introuvable.")) {
                System.out.println("[SUCCESS] Le message d'erreur a été correctement affiché.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Message d'erreur inattendu : " + errorMessageText);
                testResult = false;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("[ERROR] Élément non trouvé ou délai dépassé : " + e.getMessage());
            testResult = false;
        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test MotDePasseOublier_EmailInexistant : " + (testResult ? "Succès" : "Échec"));
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test MotDePasseOublier_EmailInexistant.");
    }
}
 */





package tests.Login;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.time.Duration;

import static tests.ExtentReportListener.*;

@Epic("Tests de connexion")
@Feature("Réinitialisation du mot de passe")
public class MotDePasseOublier_EmailInexistant extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test MotDePasseOublier_EmailInexistant.");
    }

    @Test
    @Description("Vérifie le comportement du lien de réinitialisation du mot de passe avec un email inexistant.")
    @Severity(SeverityLevel.NORMAL)
    public void testMotDePasseOublierEmailInexistant() {
        logCustomMessage("[INFO] Début du test MotDePasseOublier_EmailInexistant.");

        try {
            // Étape 1 : Accéder à la page de connexion
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            logCustomMessage("[INFO] Accès à la page de connexion.");

            Thread.sleep(1000);

            // Étape 2 : Cliquer sur le bouton "Se connecter"
            logCustomMessage("[INFO] Clic sur le bouton 'Se connecter'...");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();
            logCustomMessage("[SUCCESS] Bouton 'Se connecter' cliqué.");

            // Étape 3 : Cliquer sur le lien "Mot de passe oublié"
            logCustomMessage("[INFO] Clic sur le lien 'Mot de passe oublié'...");
            Thread.sleep(3000);
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/p");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();
            logCustomMessage("[SUCCESS] Lien 'Mot de passe oublié' cliqué.");

            // Étape 4 : Entrer un email inexistant
            logCustomMessage("[INFO] Saisie d'un email inexistant...");
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/input");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("kkjhk");
            logCustomMessage("[SUCCESS] Email inexistant saisi.");

            // Étape 5 : Cliquer sur le bouton "Envoyer"
            logCustomMessage("[INFO] Clic sur le bouton 'Envoyer'...");
            By sendButtonLocator = By.xpath("/html/body/div[3]/div[3]/div/div/button");
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();
            logCustomMessage("[SUCCESS] Bouton 'Envoyer' cliqué.");

            // Étape 6 : Vérifier le message d'erreur
            logCustomMessage("[INFO] Vérification du message d'erreur...");
            By messageErreurLocator = By.xpath("/html/body/div[1]/div/div[5]/div/div");
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErreurLocator));
            String errorMessageText = notification.getText();

            // Vérifier que le message d'erreur correspond à "Utilisateur introuvable."
            if (errorMessageText.equalsIgnoreCase("test")) {
            //if (errorMessageText.equalsIgnoreCase("Utilisateur introuvable.")) {
                logCustomMessage("[SUCCESS] Le message d'erreur a été correctement affiché.");
                testResult = true;
            } else {
                logCustomMessage("[ERROR] Message d'erreur inattendu : " + errorMessageText);
                testResult = false;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            logCustomMessage("[ERROR] Élément non trouvé ou délai dépassé : " + e.getMessage());
            testResult = false;
        } catch (Exception e) {
            logCustomMessage("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            logCustomMessage("[RESULT] Test MotDePasseOublier_EmailInexistant : " + (testResult ? "Succès" : "Échec"));

            // Capture d’écran
            String screenshotPath = captureScreenshot("testMotDePasseOublierEmailInexistant");
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
        logCustomMessage("[TEARDOWN] Fin du test MotDePasseOublier_EmailInexistant.");
    }
}

