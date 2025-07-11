package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationsSurCommandeManagerSansConfirmation extends BasePage {

    private WebDriverWait wait;

    public InformationsSurCommandeManagerSansConfirmation() {
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[3]/div/div[5]/button[1]"))).click();

    }
}
