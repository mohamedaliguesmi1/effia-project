/*package tests.ReserverUnePlace;

import config.BasePage;
import org.example.InformationsSurCommandeManager;
import org.example.LoginManager;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReserverSansConnexions extends BasePage {
    public static void main(String[] args) {
        // Initialiser WebDriver
        new BasePage(); // Pour initialiser le driver
        boolean testResult = false;
        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://ppms-sultan-dev.azurewebsites.net/");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Choix de site
        SitechoixManager sitechoixManager = new SitechoixManager();
        sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
        Button1.click();
        ParkingchoixManager manager1 = new ParkingchoixManager();
        manager1.selectParkingAndSearch("Parking Grand-Rue");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Attendre que le troisième bouton soit cliquable et cliquer

        WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
        Button2.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
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

            } else {
                testResult = false;
            }
        } catch (Exception e) {
            testResult = false;
            // System.out.println("Erreur lors de la vérification : " + e.getMessage());
        }
        System.out.println(testResult);

        if (driver != null) {

            driver.quit();
        }
    }
}

 */




/*

package tests.ReserverUnePlace;

import config.BasePage;
import org.example.LogoutManager;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

        import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReserverSansConnexions extends BasePage {

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
    public void reserverSansConnexion() {
        try {
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");

            // Pause courte pour s'assurer que la page charge
            TimeUnit.SECONDS.sleep(1);

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");

            // Pause courte
            TimeUnit.SECONDS.sleep(1);

            // Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();

            // Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");

            // Pause avant de cliquer sur le bouton suivant
            TimeUnit.SECONDS.sleep(3);

            // Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();

            // Pause avant de vérifier le texte
            TimeUnit.SECONDS.sleep(3);

            // Vérifier la présence de la boîte de dialogue "se connecter"
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String buttonText = loginButton.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
            } else {
                testResult = false;
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
        }
        System.out.println("Réservation sans connexion : " + testResult);
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        // Afficher le résultat final du test
        System.out.println("Résultat du test ReserverSansConnexions : " + testResult);

        // Fermer le navigateur si nécessaire
        if (driver != null) {
            driver.quit();
        }
    }
}

 */






/*

package tests.ReserverUnePlace;

import config.BasePage;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

        import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReserverSansConnexions extends BasePage {

    private boolean testResult; // Stocke le résultat du test
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
    public void reserverSansConnexion() {
        try {
            // Naviguer vers l'URL cible
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            TimeUnit.SECONDS.sleep(1); // Pause pour laisser la page charger

            // Étape 1 : Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            TimeUnit.SECONDS.sleep(1);

            // Étape 2 : Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();

            // Étape 3 : Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            TimeUnit.SECONDS.sleep(3);

            // Étape 4 : Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            TimeUnit.SECONDS.sleep(3);

            // Étape 5 : Vérifier la boîte de dialogue "se connecter"
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String buttonText = loginButton.getText();

            // Vérification du texte affiché
            testResult = buttonText.equalsIgnoreCase("se connecter");
        } catch (Exception e) {
            testResult = false; // Si une erreur survient, le test est considéré comme échoué
            //System.err.println("Erreur lors de l'exécution du test : " + e.getMessage());
        }
        System.out.println("Reserver Sans Connexions : " + testResult);
    }

    @AfterSuite
    public void tearDown() {
        // Afficher le résultat final


        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}

 */





/*

package tests.ReserverUnePlace;

import config.BasePage;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReserverSansConnexions extends BasePage {

    private boolean testResult; // Stocke le résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites
    private ExtentReports extent; // Instance pour ExtentReports
    private ExtentTest test; // Instance de test pour ExtentReports

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Configurer ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setDocumentTitle("Reservation Test Execution");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);



        // Initialiser le résultat du test
        testResult = false;
    }

    @Test
    @Description("Vérifie la réservation sans connexion")
    @Severity(SeverityLevel.CRITICAL)
    public void reserverSansConnexion() {
        test = extent.createTest("Réserver Sans Connexion"); // Créer un test ExtentReports

        try {
            // Naviguer vers l'URL cible
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            test.log(Status.INFO, "Navigué vers l'URL cible");
            TimeUnit.SECONDS.sleep(1); // Pause pour laisser la page charger

            // Étape 1 : Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            test.log(Status.INFO, "Site sélectionné : LOUVAIN-LA-NEUVE");
            TimeUnit.SECONDS.sleep(1);

            // Étape 2 : Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            test.log(Status.INFO, "Premier bouton cliqué");

            // Étape 3 : Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            test.log(Status.INFO, "Parking sélectionné : Parking Grand-Rue");
            TimeUnit.SECONDS.sleep(3);

            // Étape 4 : Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            test.log(Status.INFO, "Deuxième bouton cliqué");
            TimeUnit.SECONDS.sleep(3);

            // Étape 5 : Vérifier la boîte de dialogue "se connecter"
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String buttonText = loginButton.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                test.log(Status.PASS, "Réservation sans connexion validée");
            } else {
                testResult = false;
                test.log(Status.FAIL, "Texte inattendu : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // Si une erreur survient, le test est considéré comme échoué
            test.log(Status.FAIL, "Erreur rencontrée : " + e.getMessage());
        }

        System.out.println("Réserver Sans Connexions : " + testResult);
        Allure.step("Résultat du test : " + (testResult ? "Succès" : "Échec"));
    }

    @AfterSuite
    public void tearDown() {
        // Générer le rapport ExtentReports
        extent.flush();

        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}



package tests.ReserverUnePlace;

import config.BasePage;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners({tests.ExtentReportListener.class}) // Ajouter ExtentReportListener pour capturer les logs
public class ReserverSansConnexions extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // Variable pour WebDriverWait
    private ExtentTest extentTest; // Objet pour enregistrer les logs du test

    @BeforeSuite
    public void setUp() {
        // Initialiser le driver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialiser le résultat du test
        testResult = false;
    }

    @BeforeMethod
    public void startTest(Method method) {
        // Initialiser un test dans ExtentReports
        extentTest = ExtentReportListener.getExtent().createTest(method.getName(), "Vérifie la réservation sans connexion.");
        extentTest.log(Status.INFO, "Début du test: " + method.getName());
    }

    @Test
    public void reserverSansConnexion() {
        try {
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            extentTest.log(Status.INFO, "Navigué à l'URL : https://ppms-sultan-dev.azurewebsites.net/");

            TimeUnit.SECONDS.sleep(1); // Pause courte pour s'assurer que la page charge
            extentTest.log(Status.INFO, "Pause de 1 seconde pour charger la page.");

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            extentTest.log(Status.INFO, "Sélectionné le site : LOUVAIN-LA-NEUVE.");

            TimeUnit.SECONDS.sleep(1); // Pause courte
            extentTest.log(Status.INFO, "Pause de 1 seconde après la sélection du site.");

            // Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            extentTest.log(Status.INFO, "Cliqué sur le premier bouton pour continuer.");

            // Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            extentTest.log(Status.INFO, "Sélectionné le parking : Parking Grand-Rue.");

            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant
            extentTest.log(Status.INFO, "Pause de 3 secondes avant de cliquer sur le deuxième bouton.");

            // Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            extentTest.log(Status.INFO, "Cliqué sur le deuxième bouton pour accéder à l'étape suivante.");

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte
            extentTest.log(Status.INFO, "Pause de 3 secondes avant de vérifier le texte du bouton.");

            // Vérifier la présence de la boîte de dialogue "se connecter"
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String buttonText = loginButton.getText();
            extentTest.log(Status.INFO, "Texte trouvé dans la boîte de dialogue : " + buttonText);

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                extentTest.log(Status.PASS, "La boîte de dialogue contient le texte attendu : 'se connecter'.");
            } else {
                testResult = false;
                extentTest.log(Status.FAIL, "Le texte trouvé est incorrect. Texte attendu : 'se connecter'. Texte trouvé : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            extentTest.log(Status.FAIL, "Une exception s'est produite : " + e.getMessage());
        }

        // Vérification finale pour le test
        Assert.assertTrue(testResult, "Le test 'reserverSansConnexion' a échoué.");
    }

    @AfterMethod
    public void logTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test terminé avec succès.");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test échoué : " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test ignoré.");
        }
    }

    @AfterSuite
    public void tearDown() {
        // Afficher le résultat final du test
        System.out.println("Résultat du test ReserverSansConnexions : " + testResult);

        // Fermer le navigateur si nécessaire
        if (driver != null) {
            driver.quit();
        }

        // Enregistrer les logs dans le rapport
        ExtentReportListener.getExtent().flush();
    }
}

 */


/*
package tests.ReserverUnePlace;

import config.BasePage;
import org.example.LogoutManager;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReserverSansConnexions extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // Instance de WebDriverWait

    @BeforeSuite
    public void setUp() {
        // Initialiser WebDriver via BasePage
        new BasePage();

        // Initialiser WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialiser le résultat du test
        testResult = false;

        // Charger l'URL
        driver.get("https://ppms-sultan-dev.azurewebsites.net/");
        System.out.println("[SETUP] Initialisation du test ReserverSansConnexions.");
    }

    @Test
    @Description("Vérifie le comportement lorsqu'une réservation est faite sans connexion.")
    @Severity(SeverityLevel.CRITICAL)
    public void reserverSansConnexionTest() {
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Choix de site
            String site = "LOUVAIN-LA-NEUVE";
            System.out.println("[INFO] Sélection du site : " + site + "...");
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch(site);
            System.out.println("[SUCCESS] Site sélectionné : " + site + ".");



            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Cliquer sur le premier bouton
            System.out.println("[INFO] Clic sur le premier bouton...");
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            System.out.println("[SUCCESS] Premier bouton cliqué.");
            // Choix de parking


            String parking = "Parking Grand-Rue";
            System.out.println("[INFO] Sélection du parking : " + parking + "...");
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch(parking);
            System.out.println("[SUCCESS] Parking sélectionné : " + parking + ".");




            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant

            // Cliquer sur le deuxième bouton
            System.out.println("[INFO] Clic sur le deuxième bouton...");
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            System.out.println("[SUCCESS] Deuxième bouton cliqué.");

            TimeUnit.SECONDS.sleep(3); // Pause avant la vérification

            // Vérification de la fenêtre de connexion
            System.out.println("[INFO] Vérification de la présence de la fenêtre de connexion...");
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String buttonText = loginButton.getText();

            if (buttonText.equalsIgnoreCase("se connecter")) {
                testResult = true;
                System.out.println("[SUCCESS] Vérification réussie : Fenêtre 'Se connecter' trouvée.");
            } else {
                testResult = false;
                System.out.println("[ERROR] Texte inattendu trouvé : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            System.out.println("[ERROR] Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Test ReserverSansConnexions : " + testResult);
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        // Log de fin
        System.out.println("[TEARDOWN] Fin du test ReserverSansConnexions. Résultat : " + (testResult ? "Succès" : "Échec"));

        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}
 */



package tests.ReserverUnePlace;

import config.BasePage;
import org.example.LogoutManager;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
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

@Epic("Tests de réservation")
@Feature("Réservation sans connexion")
public class ReserverSansConnexions extends BasePage {

    private boolean testResult;
    private WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        new BasePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testResult = false;
        logCustomMessage("[SETUP] Initialisation du test ReserverSansConnexions.");
        driver.get("https://ppms-sultan-dev.azurewebsites.net/");
    }

    @Test
    @Description("Vérifie qu'une tentative de réservation sans être connecté redirige vers la page de connexion.")
    @Severity(SeverityLevel.CRITICAL)
    public void reserverSansConnexionTest() {
        logCustomMessage("[INFO] Début du test ReserverSansConnexions.");

        try {
            TimeUnit.SECONDS.sleep(1);
            // Étape 1 : Sélection du site
            String site = "LOUVAIN-LA-NEUVE";
            logCustomMessage("[INFO] Sélection du site : " + site);
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch(site);
            logCustomMessage("[SUCCESS] Site sélectionné.");

            TimeUnit.SECONDS.sleep(1);

            // Étape 2 : Cliquer sur le premier bouton
            logCustomMessage("[INFO] Clic sur le premier bouton...");
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            logCustomMessage("[SUCCESS] Premier bouton cliqué.");

            TimeUnit.SECONDS.sleep(1);

            // Étape 3 : Sélection du parking
            String parking = "Parking Grand-Rue";
            logCustomMessage("[INFO] Sélection du parking : " + parking);
            ParkingchoixManager parkingchoixManager = new ParkingchoixManager();
            parkingchoixManager.selectParkingAndSearch(parking);
            logCustomMessage("[SUCCESS] Parking sélectionné.");

            TimeUnit.SECONDS.sleep(3);

            // Étape 4 : Cliquer sur le deuxième bouton
            logCustomMessage("[INFO] Clic sur le deuxième bouton...");
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[5]/div[4]/div/div[3]/button")));
            Button2.click();
            logCustomMessage("[SUCCESS] Deuxième bouton cliqué.");

            TimeUnit.SECONDS.sleep(3);

            // Étape 5 : Vérification de la fenêtre de connexion
            logCustomMessage("[INFO] Vérification de l'affichage de la fenêtre de connexion...");
            WebElement loginPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/h3")));
            String popupText = loginPopup.getText();

           String expectedText = "Se connecter";
           // String expectedText = "test";
            if (popupText.equalsIgnoreCase(expectedText)) {
                logCustomMessage("[SUCCESS] Fenêtre de connexion affichée correctement.");
                testResult = true;
            } else {
                logCustomMessage("[ERROR] Texte inattendu affiché : " + popupText);
                testResult = false;
            }

        } catch (Exception e) {
            logCustomMessage("[ERROR] Erreur inattendue : " + e.getMessage());
            testResult = false;
        }
       /* finally {
            logCustomMessage("[RESULT] Test ReserverSansConnexions : " + (testResult ? "Succès" : "Échec"));

            // Capture d'écran en cas d'échec
            String screenshotPath = captureScreenshot("reserverSansConnexionTest");
            if (screenshotPath != null) {
                logScreenshot(screenshotPath);
            }

            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");

            // Déconnexion
            try {
                LogoutManager logoutManager = new LogoutManager();
                logoutManager.logout();
            } catch (Exception e) {
                logCustomMessage("[WARN] Impossible de se déconnecter proprement : " + e.getMessage());
            }
        }
       */
        finally {
            logCustomMessage("[RESULT] Test ReserverSansConnexions : " + (testResult ? "Succès" : "Échec"));

            // Capture d'écran uniquement en cas d'échec
            if (!testResult) {
                String screenshotPath = captureScreenshot("reserverSansConnexionTest");
                if (screenshotPath != null) {
                    logScreenshot(screenshotPath);
                }
            }

            // Assertion finale
            Assert.assertTrue(testResult, "Le test a échoué car testResult est false.");

            // Déconnexion
            try {
                LogoutManager logoutManager = new LogoutManager();
                logoutManager.logout();
            } catch (Exception e) {
                logCustomMessage("[WARN] Impossible de se déconnecter proprement : " + e.getMessage());
            }
        }

    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        logCustomMessage("[TEARDOWN] Fin du test ReserverSansConnexions.");
    }
}
