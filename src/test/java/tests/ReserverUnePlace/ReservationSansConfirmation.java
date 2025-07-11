/*package tests.ReserverUnePlace;
import config.BasePage;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class ReservationSansConfirmation extends BasePage {
    public static void main(String[] args) {
        // Initialiser WebDriver
        new BasePage(); // Pour initialiser le driver
        boolean testResult ;
        // Initialiser WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Login
        LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
        loginManager.login();
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

        // Remplir le formulaire avec les informations spécifiées
        InformationsSurCommandeManagerSansConfirmation manager = new InformationsSurCommandeManagerSansConfirmation();
        manager.fillForm("med ali 3", "247 TN 1000");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {

            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/button[2]")));

            String buttonText = reservPaimentbutton.getText();
            // Vérifier si le texte du bouton
            //if (buttonText.equalsIgnoreCase("test")) {
            if (buttonText.equalsIgnoreCase("Réservez une place")) {
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
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReservationSansConfirmation extends BasePage {

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
    public void testReservationSansConfirmation() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Login
        LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
        loginManager.login();

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

        // Remplir le formulaire avec les informations spécifiées
        InformationsSurCommandeManagerSansConfirmation manager = new InformationsSurCommandeManagerSansConfirmation();
        manager.fillForm("med ali 3", "247 TN 1000");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/button[2]")));

            String buttonText = reservPaimentbutton.getText();
            // Vérifier si le texte du bouton
            //if (buttonText.equalsIgnoreCase("test")) {
           if (buttonText.equalsIgnoreCase("Réservez une place")) {
                testResult = true;
            } else {
                testResult = false;
            }
        } catch (Exception e) {
            testResult = false;
        }
        System.out.println("Réservation sans confirmation :" + testResult);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
//
//        if (driver != null) {
//            driver.quit();
//        }
    }
}

 */



/*
package tests.ReserverUnePlace;

import config.BasePage;
import org.example.*;
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

public class ReservationSansConfirmation extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
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
    @Description("Vérifie la réservation sans confirmation")
    @Severity(SeverityLevel.NORMAL)
    public void testReservationSansConfirmation() {
        test = extent.createTest("Réservation sans confirmation"); // Crée un test ExtentReports

        try {
            TimeUnit.SECONDS.sleep(1);

            // Login
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            test.log(Status.INFO, "Connexion réussie");

            TimeUnit.SECONDS.sleep(1);

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            test.log(Status.INFO, "Site sélectionné : LOUVAIN-LA-NEUVE");

            TimeUnit.SECONDS.sleep(1);

            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            test.log(Status.INFO, "Premier bouton cliqué");

            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            test.log(Status.INFO, "Parking sélectionné : Parking Grand-Rue");

            TimeUnit.SECONDS.sleep(3);

            // Attendre que le troisième bouton soit cliquable et cliquer
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            test.log(Status.INFO, "Deuxième bouton cliqué");

            // Remplir le formulaire avec les informations spécifiées
            InformationsSurCommandeManagerSansConfirmation manager = new InformationsSurCommandeManagerSansConfirmation();
            manager.fillForm("med ali 3", "247 TN 1000");
            test.log(Status.INFO, "Formulaire rempli avec succès");

            TimeUnit.SECONDS.sleep(3);

            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/button[2]")));
            String buttonText = reservPaimentbutton.getText();

            // Vérifier si le texte correspond
            if (buttonText.equalsIgnoreCase("Réservez une place")) {
                testResult = true;
                test.log(Status.PASS, "Réservation sans confirmation réussie");
            } else {
                testResult = false;
                test.log(Status.FAIL, "Texte inattendu : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            test.log(Status.FAIL, "Erreur rencontrée : " + e.getMessage());
        }

        System.out.println("Réservation sans confirmation : " + testResult);
        Allure.step("Résultat du test : " + (testResult ? "Succès" : "Échec"));

        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
        test.log(Status.INFO, "Déconnexion réussie");
    }

    @AfterSuite
    public void tearDown() {
        // Générer le rapport ExtentReports
        extent.flush();

        // Fermer le navigateur
        super.tearDown();
    }
}

 */



package tests.ReserverUnePlace;

import config.BasePage;
import org.example.*;
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

public class ReservationSansConfirmation extends BasePage {

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

        // Log de démarrage
        System.out.println("[SETUP] Initialisation du test Réservation Sans Confirmation.");
    }

    @Test
    @Description("Vérifie la réservation sans confirmation")
    @Severity(SeverityLevel.CRITICAL)
    public void reservationSansConfirmationTest() {
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Connexion
            System.out.println("[INFO] Début de la connexion...");
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            System.out.println("[SUCCESS] Connexion réussie.");

            TimeUnit.SECONDS.sleep(1); // Pause après la connexion

            // Choix de site
            String site = "LOUVAIN-LA-NEUVE";
            System.out.println("[INFO] Sélection du site : " + site + "...");
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch(site);
            System.out.println("[SUCCESS] Site sélectionné : " + site + ".");

            /*
            System.out.println("[INFO] Sélection du site : LOUVAIN-LA-NEUVE...");
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            System.out.println("[SUCCESS] Site sélectionné : LOUVAIN-LA-NEUVE.");

             */

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

            /*
            System.out.println("[INFO] Sélection du parking : Parking Grand-Rue...");
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            System.out.println("[SUCCESS] Parking sélectionné : Parking Grand-Rue.");

             */

            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant

            // Cliquer sur le deuxième bouton
            System.out.println("[INFO] Clic sur le deuxième bouton...");
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[5]/div[4]/div/div[3]/button")));
            Button2.click();
            System.out.println("[SUCCESS] Deuxième bouton cliqué.");

            TimeUnit.SECONDS.sleep(3); // Pause avant de remplir le formulaire

            // Remplir le formulaire
            System.out.println("[INFO] Remplissage du formulaire avec les informations spécifiées...");
            InformationsSurCommandeManagerSansConfirmation manager = new InformationsSurCommandeManagerSansConfirmation();
            manager.fillForm("med ali 3", "247 TN 1000");
            System.out.println("[SUCCESS] Formulaire rempli.");

            TimeUnit.SECONDS.sleep(3); // Pause avant la vérification du bouton

            // Vérifier la présence et le texte du bouton "Réservez une place"
            System.out.println("[INFO] Vérification du bouton 'Réservez une place'...");
            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/button[2]")));
            String buttonText = reservPaimentbutton.getText();
            //if (buttonText.equalsIgnoreCase("test")) {
            if (buttonText.equalsIgnoreCase("Réservez une place")) {
                testResult = true;
                System.out.println("[SUCCESS] Vérification réussie : 'Réservez une place' trouvé.");
            } else {
                testResult = false;
                System.out.println("[ERROR] Texte inattendu trouvé : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            System.out.println("[ERROR] Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Test Réservation Sans Confirmation : " + testResult);
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        // Log de fin
        System.out.println("[TEARDOWN] Fin du test Réservation Sans Confirmation. Résultat : " + (testResult ? "Succès" : "Échec"));

        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}
