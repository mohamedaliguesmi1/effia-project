/*package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout extends BasePage {
    private WebDriverWait wait;
    public class LogoutManager(){
 try {
        // Attendre et cliquer sur le menu déroulant
        WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")));
        dropdownMenu.click();

        // Localiser et cliquer sur le bouton de déconnexion
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo-customized-menu\"]/div[3]/ul/li[5]")));
        logoutButton.click();

        System.out.println("Utilisateur déconnecté avec succès.");
    } catch (Exception e) {
        System.err.println("Erreur lors de la tentative de déconnexion : " + e.getMessage());
    }
}
}

 */



package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutManager extends BasePage {
    private WebDriverWait wait;

    // Constructeur pour initialiser WebDriverWait
    public LogoutManager() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Méthode pour effectuer la déconnexion
    public void logout() {
        try {
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            // Attendre et cliquer sur le menu déroulant
            WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/nav[1]/div[1]/div[3]/div[2]/div/button")));
            dropdownMenu.click();

            // Localiser et cliquer sur le bouton de déconnexion
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo-customized-menu\"]/div[3]/ul/li[5]")));
            logoutButton.click();

            //System.out.println("Utilisateur déconnecté avec succès.");
        } catch (Exception e) {
            //System.err.println("Erreur lors de la tentative de déconnexion : " + e.getMessage());
        }
    }
}
