/*package config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver; // WebDriver partagé pour toutes les classes

    // Constructeur pour initialiser WebDriver
    public BasePage() {
        initializeDriver();
    }

    private void initializeDriver() {
        if (driver == null) { // Initialisation unique de WebDriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
    }

    // Getter pour WebDriver
    public WebDriver getDriver() {
        return driver;
    }

//    // Méthode pour fermer le navigateur (à appeler en fin de test)
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

    public  void tearDown() {
        if (driver != null) {
            driver.quit(); // Ferme complètement le navigateur
            driver = null; // Réinitialise le driver
            //driver.manage().deleteAllCookies();
        }
    }

    // Méthode pour rechercher un élément
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // Autres méthodes pour l'interaction avec les éléments
    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void typeText(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isElementVisible(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = find(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void waitForElementPresent(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    private WebDriverWait wait;


    // Ajoutez d'autres méthodes selon vos besoins


}
 */



package config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class BasePage {

    public static WebDriver driver;

    // Constructeur pour initialiser le WebDriver
    public BasePage() {
        initializeDriver();
    }

    /**
     * Initialise WebDriver si ce n'est pas encore fait.
     */
    private void initializeDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Ferme le navigateur et réinitialise WebDriver.
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // 📌 ✅ Fonctions génériques pour interagir avec les éléments de la page

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void typeText(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isElementVisible(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Sélectionne une valeur par texte visible dans une liste déroulante.
     */
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = find(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    /**
     * Attend jusqu'à ce qu'un élément soit présent dans le DOM.
     */
    public void waitForElementPresent(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Capture une capture d'écran et l'enregistre dans le dossier "screenshots/".
     * @param testName Nom du fichier de capture.
     * @return Chemin du fichier de la capture d'écran.
     */
    public String captureScreenshot(String testName) {
        if (!(driver instanceof TakesScreenshot)) {
            System.out.println("[WARNING] La capture d'écran n'est pas supportée par WebDriver.");
            return null;
        }

        // Création automatique du dossier screenshots/
        try {
            Files.createDirectories(Paths.get("screenshots/"));
        } catch (IOException e) {
            System.err.println("[ERROR] Impossible de créer le dossier screenshots : " + e.getMessage());
            return null;
        }

        // Génération du nom de fichier unique avec timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

        // Capture d'écran et sauvegarde du fichier
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("[INFO] Capture d'écran enregistrée : " + screenshotPath);
        } catch (IOException e) {
            System.err.println("[ERROR] Erreur lors de l'enregistrement de la capture d'écran : " + e.getMessage());
        }

        return screenshotPath;
    }
}
