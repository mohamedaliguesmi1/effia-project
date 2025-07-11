package tests;

import config.BasePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Test extends BasePage {

        public void main  () {
            driver.get("https://ppms-sultan-test.azurewebsites.net/");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/nav[1]/div/div[3]/div[2]/div/button")).click();
            driver.findElement(By.xpath("//*[@id=\"idEmail\"]")).sendKeys("testteamvivianet1@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"standard-password-input\"]")).sendKeys("TE+2024teamtesting");
            driver.findElement(By.xpath("//*[@id=\":r7:\"]")).click();

        }
    }
