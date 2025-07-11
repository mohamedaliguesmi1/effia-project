/*package tests.Login;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AccesALaPageInscription extends BasePage{
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

            // Cliquer sur le lien s'inscrire

            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/span[2]");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();

            // E
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));

            // Cliquer sur le bouton "Envoyer"
            By inscriptionLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement inscriptionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionLocator));
            String errorMessageText = inscriptionButton.getText();




            // Vérifier le contenu du message
            if (errorMessageText.equalsIgnoreCase("inscription")) {
                System.out.println(errorMessageText);
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

public class AccesALaPageInscription extends BasePage {

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
    public void testAccesALaPageInscription() {
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

            // Cliquer sur le lien "s'inscrire"
            By motDePasseLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/span[2]");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();

            // Localiser l'élément contenant le message d'inscription
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));

            // Récupérer le texte et vérifier le contenu
            By inscriptionLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement inscriptionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionLocator));
            String errorMessageText = inscriptionButton.getText();

            // Vérifier si le message correspond à "inscription"
            //if (errorMessageText.equalsIgnoreCase("test")) {
           if (errorMessageText.equalsIgnoreCase("inscription")) {
                //System.out.println(errorMessageText);
                testResult = true;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            // Si aucun message d'erreur n'est trouvé, on suppose que l'opération a échoué
            testResult = false;

        } catch (Exception e) {
           // System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat du test
            System.out.println("AccesALaPageInscription  : " + testResult);
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
@Feature("Accès à la page d'inscription")
public class AccesALaPageInscription extends BasePage {

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

        System.out.println("[SETUP] Initialisation du test AccesALaPageInscription.");
    }

    @Test
    @Description("Vérifie l'accès à la page d'inscription.")
    @Severity(SeverityLevel.CRITICAL)
    public void testAccesALaPageInscription() {
        try {
            // Accéder à la page
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            System.out.println("[INFO] Accès à la page principale.");
            TimeUnit.SECONDS.sleep(1);

            // Cliquer sur le bouton de connexion
            System.out.println("[INFO] Clic sur le bouton 'Connexion'...");
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();
            System.out.println("[SUCCESS] Bouton 'Connexion' cliqué.");

            // Pause pour attendre l'apparition du lien "s'inscrire"
            TimeUnit.SECONDS.sleep(3);

            // Cliquer sur le lien "s'inscrire"
            System.out.println("[INFO] Clic sur le lien 'S'inscrire'...");
            By inscrireLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/span[2]");
            WebElement inscrireLien = wait.until(ExpectedConditions.elementToBeClickable(inscrireLienLocator));
            inscrireLien.click();
            System.out.println("[SUCCESS] Lien 'S'inscrire' cliqué.");

            // Vérification de la présence du message d'inscription
            System.out.println("[INFO] Vérification du message d'inscription...");
            By inscriptionMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement inscriptionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionMessageLocator));
            String messageText = inscriptionMessage.getText();

            // Vérifier si le message contient "inscription"
            if (messageText.equalsIgnoreCase("inscription")) {
                System.out.println("[SUCCESS] Message 'inscription' trouvé.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Message inattendu : " + messageText);
                testResult = false;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            // Si un élément n'est pas trouvé ou si le délai est dépassé
            System.out.println("[ERROR] Élément non trouvé ou délai dépassé : " + e.getMessage());
            testResult = false;
        } catch (Exception e) {
            // Pour toute autre exception
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            // Afficher le résultat du test
            System.out.println("[RESULT] Test AccesALaPageInscription : " + (testResult ? "Succès" : "Échec"));
        }
    }

    @AfterSuite
    public void tearDown() {
        // Nettoyer et fermer le navigateur
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test AccesALaPageInscription.");
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
import java.util.concurrent.TimeUnit;

@Epic("Tests de connexion")
@Feature("Accès à la page d'inscription")

public class AccesALaPageInscription extends BasePage {

    private WebDriverWait wait;
    private boolean testResult;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        System.out.println("[SETUP] Initialisation du test AccesALaPageInscription.");
    }

    @Test
    @Description("Vérifie l'accès à la page d'inscription.")
    @Severity(SeverityLevel.CRITICAL)
    public void testAccesALaPageInscription() {
        System.out.println("[INFO] Début du test AccesALaPageInscription.");

        try {
            // Étape 1 : Accéder à la page principale
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            System.out.println("[INFO] Accès à la page principale.");

            TimeUnit.SECONDS.sleep(1);

            // Étape 2 : Cliquer sur le bouton "Connexion"
            System.out.println("[INFO] Clic sur le bouton 'Connexion'...");
            By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();
            System.out.println("[SUCCESS] Bouton 'Connexion' cliqué.");

            TimeUnit.SECONDS.sleep(3);

            // Étape 3 : Cliquer sur le lien "S'inscrire"
            System.out.println("[INFO] Clic sur le lien 'S'inscrire'...");
            By inscrireLienLocator = By.xpath("/html/body/div[3]/div[3]/div/div/span[2]");
            WebElement inscrireLien = wait.until(ExpectedConditions.elementToBeClickable(inscrireLienLocator));
            inscrireLien.click();
            System.out.println("[SUCCESS] Lien 'S'inscrire' cliqué.");

            // Étape 4 : Vérification du message d'inscription
            System.out.println("[INFO] Vérification du message d'inscription...");
            By inscriptionMessageLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement inscriptionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionMessageLocator));
            String messageText = inscriptionMessage.getText();

            // Vérifier si le message contient "inscription"
            //if (messageText.equalsIgnoreCase("test")) {
            if (messageText.equalsIgnoreCase("inscription")) {
                System.out.println("[SUCCESS] Message 'inscription' trouvé.");
                testResult = true;
            } else {
                System.out.println("[ERROR] Message inattendu : " + messageText);
                testResult = false;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("[ERROR] Élément non trouvé ou délai dépassé : " + e.getMessage());
            testResult = false;
        } catch (Exception e) {
            System.out.println("[ERROR] Une erreur inattendue s'est produite : " + e.getMessage());
            testResult = false;
        } finally {
            System.out.println("[RESULT] Test AccesALaPageInscription : " + (testResult ? "Succès" : "Échec"));
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");
        }
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        System.out.println("[TEARDOWN] Fin du test AccesALaPageInscription.");
    }
}





