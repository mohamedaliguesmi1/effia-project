/*package tests.Login;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_Gmail extends BasePage {
    public static void main(String[] args) {
        new BasePage();
        boolean testResult = false; // Définir le testResult par défaut
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // try {
            // Accéder à la page
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");
            //Thread.sleep(1000); // Pause courte pour s'assurer que la page charge

            // Cliquer sur le bouton de connexion
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();


          //  Thread.sleep(3000);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/svg")).click();
            // Cliquer sur l'icone se connecter avec gmail

            By motDePasseLienLocator = By.cssSelector("#container > div > div.nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb > div");
            WebElement motDePasseLien = wait.until(ExpectedConditions.elementToBeClickable(motDePasseLienLocator));
            motDePasseLien.click();



            // E
            By emailInputLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));

            // Cliquer sur le bouton "Envoyer"
            By inscriptionLocator = By.xpath("/html/body/div[3]/div[3]/div/h2/p");
            WebElement inscriptionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionLocator));
            String errorMessageText = inscriptionButton.getText();




            // Vérifier le contenu du message
            if (errorMessageText.equalsIgnoreCase("inscription")) {
                System.out.println(errorMessageText);
                testResult = true;
            }

        } catch (NoSuchElementException | TimeoutException e) {
            // Si aucun message d'erreur n'est trouvé, on suppose que l'opération a réussi
            testResult = false;

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Afficher le résultat du test
            System.out.println("TestResult: " + testResult);

            // Fermer le navigateur
            if (driver != null) {

                driver.quit();
            }




        }

    }


}


 */
package tests.Login;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Login_Gmail extends BasePage {
    public static void main(String[] args) {
        new BasePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Accéder à la page principale
            driver.get("https://ppms-sultan-dev.azurewebsites.net/");

            // Cliquer sur le bouton de connexion
            By loginButtonLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            loginButton.click();

            // Pause pour attendre l'apparition de l'icône Gmail
            Thread.sleep(3000);

            // Cliquer sur l'icône Gmail
            By gmailIconLocator = By.xpath("/html/body/div/div/div[2]/div/svg/g/path[4]"); // Remplacez par le bon sélecteur
            WebElement gmailIcon = wait.until(ExpectedConditions.elementToBeClickable(gmailIconLocator));
            gmailIcon.click();

            // Sauvegarder l'identifiant de la fenêtre actuelle
            String originalWindow = driver.getWindowHandle();
            System.out.println("Fenêtre principale : " + originalWindow);

            // Attendre qu'une nouvelle fenêtre s'ouvre
            wait.until(driver -> driver.getWindowHandles().size() > 1);

            // Basculer vers la nouvelle fenêtre Gmail
            Set<String> allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Nouvelle fenêtre détectée : " + windowHandle);
                    break;
                }
            }

            // Attendre que la page de connexion Gmail se charge
            wait.until(ExpectedConditions.titleContains("Gmail"));

            // Effectuer les actions sur la fenêtre Gmail (par exemple, entrer un email)
            By emailInputLocator = By.id("identifierId"); // Sélecteur pour le champ email
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
            emailInput.sendKeys("votre-email@gmail.com");

            // Cliquer sur le bouton "Suivant"
            By nextButtonLocator = By.xpath("//span[text()='Suivant']/parent::button");
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
            nextButton.click();

            // (Ajoutez ici les étapes supplémentaires pour saisir le mot de passe)

            // Revenir à la fenêtre d'origine
            driver.switchTo().window(originalWindow);
            System.out.println("Revenu à la fenêtre principale.");

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
        } finally {
            // Fermer le navigateur
            if (driver != null) {
                driver.quit();
            }
        }
    }
}


