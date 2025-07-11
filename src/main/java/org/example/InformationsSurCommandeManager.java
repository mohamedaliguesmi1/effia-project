
package org.example;

import config.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InformationsSurCommandeManager extends BasePage {

    private WebDriverWait wait;

    public InformationsSurCommandeManager() {
        super(); // Appelle le constructeur de BasePage
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20)); // Utilise le WebDriver partagé
        disableAnimations();
    }

    private void disableAnimations() {
        ((JavascriptExecutor) getDriver()).executeScript(
                "document.body.style.transition = 'none'; " +
                        "Array.from(document.querySelectorAll('*')).forEach(el => el.style.transition = 'none');"
        );
    }

    private void waitForPageLoad() {
        wait.until(webDriver -> ((String) ((JavascriptExecutor) webDriver).executeScript("return document.readyState")).equals("complete"));
    }

    private WebElement waitForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("L'élément " + locator + " n'est pas visible après l'attente.", e);
        }
    }

    private void selectFromCustomDropdown(By dropdownLocator, By itemLocator, String visibleText) {
        WebElement dropdown = waitForElement(dropdownLocator);
        dropdown.click();
        WebElement item = waitForElement(itemLocator);
        if (item.getText().equals(visibleText)) {
            item.click();
        }
    }

    private void selectRadioButton(By radioLocator) {
        WebElement radioButton = waitForElement(radioLocator);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void fillForm(String conducteur, String matricule) {
        waitForPageLoad();
        By conducteurDropdown = By.xpath("//*[@id=\"mui-component-select-driverID\"]");
        By conducteurOption = By.xpath("//*[@id='menu-driverID']/div[3]/ul/li[text()='" + conducteur + "']");
        selectFromCustomDropdown(conducteurDropdown, conducteurOption, conducteur);


        By matriculeDropdown = By.xpath("//*[@id=\"demo-customized-select-native\"]");
        By matriculeOption = By.xpath("//*[@id='menu-vehicleID']/div[3]/ul/li[text()='" + matricule + "']");
        selectFromCustomDropdown(matriculeDropdown, matriculeOption, matricule);

        driver.findElement(By.cssSelector("#root > div > div:nth-child(2) > div > div > div > div > div.MuiBox-root.css-nw8yla > div > div.MuiBox-root.css-h7xgo7 > div > div:nth-child(1) > span.MuiButtonBase-root.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.PrivateSwitchBase-root.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.css-gsgs5o-MuiButtonBase-root-MuiCheckbox-root > input")).click();
        driver.findElement(By.cssSelector("#root > div > div:nth-child(2) > div > div > div > div > div.MuiBox-root.css-nw8yla > div > div.MuiBox-root.css-h7xgo7 > div > div:nth-child(2) > span.MuiButtonBase-root.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.PrivateSwitchBase-root.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.MuiCheckbox-root.MuiCheckbox-colorSecondary.MuiCheckbox-sizeSmall.css-gsgs5o-MuiButtonBase-root-MuiCheckbox-root > input")).click();

        // Cliquer sur le bouton de soumission

     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[5]/button[2]"))).click();

}
}




/*package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InformationsurcommandeManager {




        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath(" /html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dropdownElement = driver.findElement(By.cssSelector("#mui-component-select-driverID"));
        dropdownElement.click();


        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText(conducteur);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dropdownElement2 = driver.findElement(By.cssSelector("#demo-customized-select-native"));
        dropdownElement2.click();


        Select dropdown1 = new Select(dropdownElement2);

        dropdown.selectByVisibleText(matricule);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id=\"demo-customized-select-native\"]"));
        Select dropdown2 = new Select(dropdownElement1);

        dropdown.selectByVisibleText(pays)

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input"));
        submitButton.click();
        WebElement submitButton1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input"));
        submitButton1.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\":r18:\"]")).click();
}

*/


/*
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationsurcommandeManager {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructeur pour initialiser WebDriver et WebDriverWait
    public InformationsurcommandeManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Méthode pour sélectionner un élément dans une liste déroulante par texte visible
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Méthode pour sélectionner un élément dans une liste déroulante par valeur
    public void selectByValue(By locator, String value) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Méthode principale pour sélectionner des informations de commande
    public void selectInformation(String conducteur, String matricule) {
        // Ouvrir les premières listes déroulantes et sélectionner des éléments
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div")).click();

        WebElement driverButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
        driverButton.click();

        // Sélection du conducteur
        selectByVisibleText(By.cssSelector("#mui-component-select-driverID"), conducteur);

        // Sélection du matricule
        selectByVisibleText(By.cssSelector("#demo-customized-select-native"), matricule);

        // Cliquer sur les boutons radio pour sélectionner les options de soumission
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input")).click();

        // Cliquer sur le bouton de soumission
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r18:\"]"))).click();
    }
}
*/

/*
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationsurcommandeManager {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public InformationsurcommandeManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to select an item in a dropdown by visible text
    private void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Method to select an item in a dropdown by value
    private void selectByValue(By locator, String value) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Main method to select order information
    public void selectInformation(String conducteur, String matricule) {
        // Open dropdown menus and select elements

        // Click on first dropdown element
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div"))).click();

        // Click on the driver button to expand list
        WebElement driverButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div/div[3]/button")));
        driverButton.click();

        // Select "conducteur" in the dropdown
        selectByVisibleText(By.cssSelector("#mui-component-select-driverID"), conducteur);

        // Select "matricule" in the second dropdown
        selectByVisibleText(By.cssSelector("#demo-customized-select-native"), matricule);

        // Click on radio buttons to select options
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input")).click();
                // Cliquer sur le bouton de soumission
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r18:\"]"))).click();
    }
}
*/



/*package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InformationsurcommandeManager {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver with Selenium Manager
    public InformationsurcommandeManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    // Method to select an item in a dropdown by visible text
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Main method to fill in the information fields
    public void selectInformation(String conducteur, String matricule) {
        // Select the first dropdown and choose "conducteur"
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/div[1]/div/div")).click();
        selectByVisibleText(By.cssSelector("#menu-driverID > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiMenu-paper.MuiPopover-paper.MuiMenu-paper.css-3dzjca-MuiPaper-root-MuiPopover-paper-MuiMenu-paper > ul"), conducteur);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/div[2]/label")).click();
        // Select the second dropdown and choose "matricule"
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectByVisibleText(By.cssSelector("#menu-vehicleID > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiMenu-paper.MuiPopover-paper.MuiMenu-paper.css-3dzjca-MuiPaper-root-MuiPopover-paper-MuiMenu-paper > ul > li.MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.css-186kac4-MuiButtonBase-root-MuiMenuItem-root"), matricule);

        // Example of selecting radio buttons
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input")).click();

        // Submit
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r18:\"]"))).click();
    }
}
*/





/*
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationsSurCommandeManager {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public InformationsSurCommandeManager() {
        // Initialize WebDriver with Selenium Manager
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to open the application
   // public void openApplication(String url) {
        //driver.get(url);
        //driver.manage().window().maximize();
    //}

    // Method to select an item from a custom dropdown by visible text
    private void selectFromCustomDropdown(By dropdownLocator, By itemLocator, String visibleText) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click(); // Open the dropdown

        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        if (item.getText().equals(visibleText)) {
            item.click(); // Select the desired item
        }
    }

    // Method to select a radio button
    private void selectRadioButton(By radioLocator) {
        WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(radioLocator));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    // Main method to interact with the form
    public void fillForm(String conducteur, String matricule) {
        // Open and select from the first dropdown (Conducteur)
        By conducteurDropdown = By.xpath("#menu-driverID > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiMenu-paper.MuiPopover-paper.MuiMenu-paper.css-3dzjca-MuiPaper-root-MuiPopover-paper-MuiMenu-paper > ul");
        By conducteurOption = By.xpath("//ul[@id='menu-driverID']//li[text()='" + conducteur + "']");
        selectFromCustomDropdown(conducteurDropdown, conducteurOption, conducteur);

        // Open and select from the second dropdown (Matricule)
        By matriculeDropdown = By.xpath("#menu-vehicleID > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiMenu-paper.MuiPopover-paper.MuiMenu-paper.css-3dzjca-MuiPaper-root-MuiPopover-paper-MuiMenu-paper > ul']");
        By matriculeOption = By.xpath("//ul[@id='menu-vehicleID']//li[text()='" + matricule + "']");
        selectFromCustomDropdown(matriculeDropdown, matriculeOption, matricule);

        // Select the first radio button
        By firstRadioButton = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input");
        selectRadioButton(firstRadioButton);

        // Select the second radio button
        By secondRadioButton = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input");
        selectRadioButton(secondRadioButton);

        // Click the submit button
        By submitButton = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[5]/button[2]");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
*/


/*
package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationsSurCommandeManager {

    private WebDriver driver;
    private WebDriverWait wait;

    public InformationsSurCommandeManager() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Temps d'attente plus long
        disableAnimations();
    }

    private void disableAnimations() {
        ((JavascriptExecutor) driver).executeScript(
                "document.body.style.transition = 'none'; " +
                        "Array.from(document.querySelectorAll('*')).forEach(el => el.style.transition = 'none');"
        );
    }

    private void waitForPageLoad() {
        wait.until(webDriver -> ((String) ((JavascriptExecutor) webDriver).executeScript("return document.readyState")).equals("complete"));
    }

    private void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("L'élément " + locator + " n'est pas visible après l'attente.", e);
        }
    }

    private void selectFromCustomDropdown(By dropdownLocator, By itemLocator, String visibleText) {
        WebElement dropdown = waitForElement(dropdownLocator);
        dropdown.click();
        WebElement item = waitForElement(itemLocator);
        if (item.getText().equals(visibleText)) {
            item.click();
        }
    }

    private void selectRadioButton(By radioLocator) {
        WebElement radioButton = waitForElement(radioLocator);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void fillForm(String conducteur, String matricule) {
        waitForPageLoad();

        By conducteurDropdown = By.xpath("//ul[@id='menu-driverID']");
        By conducteurOption = By.xpath("//ul[@id='menu-driverID']//li[text()='" + conducteur + "']");
        selectFromCustomDropdown(conducteurDropdown, conducteurOption, conducteur);

        By matriculeDropdown = By.xpath("//ul[@id='menu-vehicleID']");
        By matriculeOption = By.xpath("//ul[@id='menu-vehicleID']//li[text()='" + matricule + "']");
        selectFromCustomDropdown(matriculeDropdown, matriculeOption, matricule);

        By firstRadioButton = By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[1]/span/input");
        selectRadioButton(firstRadioButton);

        By secondRadioButton = By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[2]/div[4]/div/label[2]/span/input");
        selectRadioButton(secondRadioButton);

        By submitButton = By.xpath("//button[text()='Submit']");
        WebElement button = waitForElement(submitButton);
        button.click();
    }
}
*/



// By conducteurDropdown = By.xpath("//div[contains(@class, 'MuiMenu-paper')]//ul");   /html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]
//By conducteurOption = By.xpath("//li[contains(@class, 'MuiMenuItem-root') and text()='med ali 1']");
// selectFromCustomDropdown(conducteurDropdown, conducteurOption, "med ali 1");
        /*
        By conducteurDropdown = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/div[1]/div/div");

        By conducteurOption = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/div[1]/div/div//li[text()='" + conducteur + "']");
        selectFromCustomDropdown(conducteurDropdown, conducteurOption, conducteur);
*/

// By conducteurDropdown = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/div[1]/div/div");
//By conducteurOption = By.xpath("//ul[@id='menu-driverID']//li[text()='" + conducteur + "']");
// selectFromCustomDropdown(conducteurDropdown, conducteurOption, conducteur);