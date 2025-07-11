/*package tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        // Example: Take a screenshot on failure
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
    public class CustomListener implements ITestListener {
        public CustomListener() {
            // Default constructor
        }

        @Override
        public void onTestStart(ITestResult result) {
            // Implementation
        }

        // Implement other methods as required
    }

}
 */



/*
package tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test Failed: " + result.getName());
        // Example: Add code for taking a screenshot here
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test Suite Finished: " + context.getName());
    }

}
 */



package tests;

import config.BasePage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener extends BasePage implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[INFO] Test démarré : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[SUCCESS] Test réussi : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[ERROR] Test échoué : " + result.getName());

        // Vérifie si WebDriver est initialisé avant de capturer l’écran
        if (driver != null) {
            String screenshotPath = captureScreenshot(result.getName());
            System.out.println("[INFO] Capture d’écran sauvegardée : " + screenshotPath);
        } else {
            System.out.println("[WARNING] Impossible de capturer l’écran : WebDriver est null.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[WARNING] Test ignoré : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[INFO] Début de la suite de tests : " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[INFO] Fin de la suite de tests : " + context.getName());
    }
}
