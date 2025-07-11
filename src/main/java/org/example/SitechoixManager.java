package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SitechoixManager extends BasePage {

    // Méthode pour sélectionner le site et effectuer une recherche
    public void selectSiteAndSearch(String visibleText) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Localiser le champ du menu déroulant et envoyer le texte visible
        //WebElement dropdownInput = driver.findElement(By.id("free-solo-demo"));
        WebElement dropdownInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("free-solo-demo")));

        dropdownInput.sendKeys(visibleText);


        // Cliquer sur le bouton de recherche ou autre élément
        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/div[2]/p")).click();



    }
}





/*package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SitechoixManager extends BasePage {
   //private String visibleTextdriver;
    //public SitechoixManager(WebDriver driver) {
       // this.driver = driver;

    public void SelectSiteAndSearch( String visibleText) {
       //this.visibleText = visibleText;
        WebElement dropdownInput = driver.findElement(By.id("free-solo-demo"));
        dropdownInput.sendKeys(visibleText);

        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/div[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     // Trouver le menu déroulant et sélectionner l'option par texte visible
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div/div/input")));
        dropdown.selectByVisibleText(visibleText);
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div/div[1]/div/button"));
        searchButton.click();
    }
}

*/