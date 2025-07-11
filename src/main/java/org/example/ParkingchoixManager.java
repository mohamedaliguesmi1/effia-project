/*package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParkingchoixManager extends BasePage {
    public void selectParkingAndSearch(String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdownInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("free-solo-demo")));

        dropdownInput.sendKeys(visibleText);


        // Cliquer sur le bouton de recherche ou autre élément
        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/div[2]")).click();

    }
}



/*


package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParkingchoixManager extends BasePage {
    /*
        public void selectParkingAndSearch(String visibleText) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Attendre que les éléments de la liste des parkings soient visibles
            List<WebElement> parkingElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-c84f31-MuiTypography-root")));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            boolean parkingFound = false;

            // Parcourir les éléments et sélectionner celui qui correspond au texte visible
            for (WebElement parkingElement : parkingElements) {
                if (parkingElement.getText().equalsIgnoreCase(visibleText)) {
                    parkingElement.click(); // Cliquer sur l'élément correspondant
                    parkingFound = true;
                   // break;
                }
            }

            if (!parkingFound) {
                throw new RuntimeException("Parking avec le texte visible \"" + visibleText + "\" introuvable !");
            }

            // Cliquer sur le bouton de recherche ou continuer avec le reste de la logique
           // WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/div[2]")));
            //searchButton.click();
        }
    }



    public void selectParkingAndSearch(String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Attendre que les éléments de la liste des parkings soient visibles
        List<WebElement> parkingElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-c84f31-MuiTypography-root")));
        //System.out.println("Liste des parkings récupérée.");

        //boolean parkingFound = false;

        // Parcourir les éléments et sélectionner celui qui correspond au texte visible
        for (WebElement parkingElement : parkingElements) {
           // System.out.println("Vérification du parking : " + parkingElement.getText());
            if (parkingElement.getText().equalsIgnoreCase(visibleText)) {
               // System.out.println("Parking trouvé : " + visibleText);
                parkingElement.click(); // Cliquer sur l'élément correspondant
               // parkingFound = true;

                // Attendre la mise à jour après le clic
               // System.out.println("Attente après le clic sur le parking...");
              //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/button[2]")));
               // break;
            }
        }

       // if (!parkingFound) {
          //  System.out.println("Parking non trouvé !");
            //throw new RuntimeException("Parking avec le texte visible \"" + visibleText + "\" introuvable !");
        }
       // System.out.println("Fin de la méthode selectParkingAndSearch");
    }
//}

 */

package org.example;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ParkingchoixManager extends BasePage {

    public void selectParkingAndSearch(String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Attendre que les éléments de la liste des parkings soient visibles
        List<WebElement> parkingElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-c84f31-MuiTypography-root")));

        boolean parkingFound = false;

        // Parcourir les éléments et sélectionner celui qui correspond au texte visible
        for (WebElement parkingElement : parkingElements) {
            if (parkingElement.getText().equalsIgnoreCase(visibleText)) {
                parkingElement.click(); // Cliquer sur l'élément correspondant
                parkingFound = true;

                // Attendre que l'action post-clic soit visible ou que la page soit mise à jour
                wait.until(ExpectedConditions.stalenessOf(parkingElement));
                break; // Arrêter la boucle après avoir trouvé le parking
            }
        }

        // Si le parking n'est pas trouvé, lever une exception
        if (!parkingFound) {
            throw new RuntimeException("Parking avec le texte visible \"" + visibleText + "\" introuvable !");
        }
    }
}
