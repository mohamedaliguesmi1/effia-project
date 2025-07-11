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

public class AccesalaPagereservation extends BasePage {
    public static void main(String[] args) {
        // Initialiser WebDriver
        new BasePage(); // Pour initialiser le driver
        boolean testResult = false;
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
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            WebElement ReservationPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/p")));
            String buttonText = ReservationPage.getText();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Vérifier si le texte du bouton est "se connecter"
            //if (buttonText.equalsIgnoreCase("test")) {
            if (buttonText.equalsIgnoreCase("Réservation")) {
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

public class AccesalaPagereservation extends BasePage {

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
    public void accesALaPageReservation() {
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Connexion
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();

            TimeUnit.SECONDS.sleep(1); // Pause après la connexion

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");

            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();

            // Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");

            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant

            // Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte

            // Vérifier la présence de la page de réservation
            WebElement ReservationPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/p")));
            String buttonText = ReservationPage.getText();

            // Vérification du texte affiché
            testResult = buttonText.equalsIgnoreCase("Réservation");

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
        }
        System.out.println("Accés a la Page Réservation : " + testResult);
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

        super.tearDown(); // Méthode centralisée pour fermer le navigateur
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


public class AccesalaPagereservation extends BasePage {

    private boolean testResult; // Variable pour stocker le résultat du test
    private WebDriverWait wait; // Variable pour WebDriverWait
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
    @Description("Vérifie l'accès à la page de réservation")
    @Severity(SeverityLevel.NORMAL)
    public void accesALaPageReservation() {
        test = extent.createTest("Accès à la page réservation"); // Crée un test ExtentReports
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Connexion
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

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte

            // Vérifier la présence de la page de réservation
            WebElement ReservationPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/p")));
            String buttonText = ReservationPage.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("Réservation")) {
                testResult = true;
                test.log(Status.PASS, "Accès à la page réservation confirmé");
            } else {
                testResult = false;
                test.log(Status.FAIL, "Texte inattendu sur la page de réservation");
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            test.log(Status.FAIL, "Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Accès à la Page Réservation : " + testResult);

        // Allure - Ajouter un message basé sur le résultat
        Allure.step("Résultat du test : " + (testResult ? "Succès" : "Échec"));
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
import io.qameta.allure.*;

public class AccesalaPagereservation extends BasePage {

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
    @Description("Vérifie l'accès à la page de réservation")
    @Severity(SeverityLevel.NORMAL)
    public void accesALaPageReservation() {
        try {
            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Connexion
            LoginManager loginManager = new LoginManager("medaliguesmi111@gmail.com", "09245321Aa+");
            loginManager.login();

            TimeUnit.SECONDS.sleep(1); // Pause après la connexion

            // Choix de site
            SitechoixManager sitechoixManager = new SitechoixManager();
            sitechoixManager.selectSiteAndSearch("LOUVAIN-LA-NEUVE");

            TimeUnit.SECONDS.sleep(1); // Pause courte

            // Cliquer sur le premier bouton
            WebElement Button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/button[2]")));
            Button1.click();

            // Choix de parking
            ParkingchoixManager manager1 = new ParkingchoixManager();
            manager1.selectParkingAndSearch("Parking Grand-Rue");

            TimeUnit.SECONDS.sleep(3); // Pause avant de cliquer sur le bouton suivant

            // Cliquer sur le deuxième bouton
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
            Button2.click();

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte

            // Vérifier la présence de la page de réservation
            WebElement ReservationPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/p")));
            String buttonText = ReservationPage.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("Réservation")) {
                testResult = true;
            } else {
                testResult = false;
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
        }
        System.out.println("Accès à la Page Réservation : " + testResult);
    }

    @AfterSuite
    public void tearDown() {
        // Fermer le navigateur et effectuer un nettoyage
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

public class AccesalaPagereservation extends BasePage {

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
        System.out.println("[SETUP] Initialisation du test Accès à la Page Réservation.");
    }

    @Test
    @Description("Vérifie l'accès à la page de réservation")
    @Severity(SeverityLevel.NORMAL)
    public void accesALaPageReservation() {
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
            WebElement Button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[5]/div[4]/div/div[3]/button")));
            Button2.click();
            System.out.println("[SUCCESS] Deuxième bouton cliqué.");

            TimeUnit.SECONDS.sleep(3); // Pause avant de vérifier le texte

            // Vérifier la présence de la page de réservation
            System.out.println("[INFO] Vérification de la page de réservation...");
            WebElement ReservationPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/p")));
            String buttonText = ReservationPage.getText();

            // Vérification du texte affiché
            if (buttonText.equalsIgnoreCase("Réservation")) {
                testResult = true;
                System.out.println("[SUCCESS] Accès à la page réservation confirmé.");
            } else {
                testResult = false;
                System.out.println("[ERROR] Texte inattendu sur la page de réservation : " + buttonText);
            }

        } catch (Exception e) {
            testResult = false; // En cas d'erreur, le test échoue
            System.out.println("[ERROR] Erreur rencontrée : " + e.getMessage());
        }
        System.out.println("Accès à la Page Réservation : " + testResult);
        LogoutManager logoutManager = new LogoutManager();
        logoutManager.logout();
    }

    @AfterSuite
    public void tearDown() {
        // Log de fin
        System.out.println("[TEARDOWN] Fin du test Accès à la Page Réservation. Résultat : " + (testResult ? "Succès" : "Échec"));

        // Fermer le navigateur et effectuer un nettoyage
        super.tearDown();
    }
}


