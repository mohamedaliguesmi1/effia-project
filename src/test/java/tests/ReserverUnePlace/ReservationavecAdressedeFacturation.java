/*package tests.ReserverUnePlace;
import config.BasePage;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReservationavecAdressedeFacturation extends BasePage {
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

    InformationsSurCommandeAdresseDifferenteManager manager = new InformationsSurCommandeAdresseDifferenteManager();
      manager.fillForm("med ali 3", "247 TN 1000", "Belgique", "Aouina", "1455", "Nabeul");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {

            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[2]")));

            String buttonText = reservPaimentbutton.getText();
            // Vérifier si le texte du bouton
            //if (buttonText.equalsIgnoreCase("test")) {
            if (buttonText.equalsIgnoreCase("Données de paiement")) {
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
import static org.testng.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReservationavecAdressedeFacturation extends BasePage {

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
    public void testReservationAvecAdresseDeFacturation() {
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

        // Cliquer sur le premier bouton
        WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
        Button1.click();

        ParkingchoixManager manager1 = new ParkingchoixManager();
        manager1.selectParkingAndSearch("Parking Grand-Rue");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Cliquer sur le deuxième bouton
        WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
        Button2.click();

        // Remplir le formulaire avec les informations spécifiées
        InformationsSurCommandeAdresseDifferenteManager manager = new InformationsSurCommandeAdresseDifferenteManager();
        manager.fillForm("med ali 3", "247 TN 1000", "Belgique", "Aouina", "1455", "Nabeul");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[2]")));
            String buttonText = reservPaimentbutton.getText();

            // Vérifier si le texte correspond
            if (buttonText.equalsIgnoreCase("Données de paiement")) {
                testResult = true;
            } else {
                testResult = false;
            }
        } catch (Exception e) {
            testResult = false;
        }
        System.out.println(" Réservation avec une adresse de facturation differente : " +testResult);
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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.*;

public class ReservationavecAdressedeFacturation extends BasePage {

    private boolean testResult; // Stocke le résultat du test
    private WebDriverWait wait; // WebDriverWait pour les attentes explicites
    private ExtentReports extent; // ExtentReports instance
    private ExtentTest test; // Test instance for ExtentReports

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
    @Description("Vérifie la réservation avec une adresse de facturation différente")
    @Severity(SeverityLevel.CRITICAL)
    public void testReservationAvecAdresseDeFacturation() {
        test = extent.createTest("Réservation avec une adresse de facturation différente"); // Crée un test ExtentReports
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Login
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();
            test.log(Status.INFO, "Connexion réussie");

            TimeUnit.SECONDS.sleep(1); // Pause après la connexion

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");
            test.log(Status.INFO, "Site sélectionné : LOUVAIN-LA-NEUVE");

            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();
            test.log(Status.INFO, "Premier bouton cliqué");

            // Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");
            test.log(Status.INFO, "Parking sélectionné : Parking Grand-Rue");

            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant

            // Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();
            test.log(Status.INFO, "Deuxième bouton cliqué");

            // Remplir le formulaire avec les informations spécifiées
            InformationsSurCommandeAdresseDifferenteManager manager = new InformationsSurCommandeAdresseDifferenteManager();
            manager.fillForm("med ali 3", "247 TN 1000", "Belgique", "Aouina", "1455", "Nabeul");
            test.log(Status.INFO, "Formulaire rempli avec l'adresse de facturation");

            TimeUnit.SECONDS.sleep(3); // Pause après remplissage

            // Vérifier la présence du texte "Données de paiement"
            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[2]")));
            String buttonText = reservPaimentbutton.getText();

            if (buttonText.equalsIgnoreCase("Données de paiement")) {
                testResult = true;
                test.log(Status.PASS, "Texte correct affiché : Données de paiement");
            } else {
                testResult = false;
                test.log(Status.FAIL, "Texte incorrect affiché : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            test.log(Status.FAIL, "Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Réservation avec une adresse de facturation différente : " + testResult);

        // Allure - Ajouter un message basé sur le résultat
        Allure.step("Résultat du test : " + (testResult ? "Succès" : "Échec"));

        // Déconnexion
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        // Écrire les résultats du rapport ExtentReports
        extent.flush();

        // Fermer le navigateur
        super.tearDown();
    }
}

 */

package tests.ReserverUnePlace;

import config.BasePage;
import org.example.LoginManager;
import org.example.LogoutManager;
import org.example.ParkingchoixManager;
import org.example.SitechoixManager;
import org.example.InformationsSurCommandeAdresseDifferenteManager;
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

public class ReservationavecAdressedeFacturation extends BasePage {

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
        System.out.println("[SETUP] Initialisation du test Réservation avec Adresse de Facturation.");
    }

    @Test
    @Description("Vérifie l'accès à la page de paiement après une réservation avec une adresse différente de facturation")
    @Severity(SeverityLevel.CRITICAL)
    public void reservationAvecAdresseDeFacturation() {
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

            // Remplir le formulaire avec les informations spécifiées
            System.out.println("[INFO] Remplissage du formulaire avec l'adresse de facturation...");
            InformationsSurCommandeAdresseDifferenteManager manager = new InformationsSurCommandeAdresseDifferenteManager();
            manager.fillForm("med ali 3", "247 TN 1000", "Belgique", "Aouina", "1455", "Nabeul");
            System.out.println("[SUCCESS] Formulaire rempli avec succès.");

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte

            // Vérifier la présence du bouton de paiement
            System.out.println("[INFO] Vérification de la page de paiement...");
            WebElement reservPaimentbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div/div[2]")));
            String buttonText = reservPaimentbutton.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("Données de paiement")) {
                testResult = true;
                System.out.println("[SUCCESS] Accès à la page de paiement confirmé.");
            } else {
                testResult = false;
                System.out.println("[ERROR] Texte inattendu sur la page de paiement : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            System.out.println("[ERROR] Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Réservation avec Adresse de Facturation : " + testResult);
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();

    }

    @AfterSuite
    public void tearDown() {
        // Log de fin
        System.out.println("[TEARDOWN] Fin du test Réservation avec Adresse de Facturation. Résultat : " + (testResult ? "Succès" : "Échec"));

        // Déconnexion et nettoyage

        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}



