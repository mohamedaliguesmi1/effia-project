/*package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;

import static config.BasePage.driver;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialiser ExtentReports une seule fois au début de la suite
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Créer un nouveau test pour chaque méthode de test
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

@Override
public void onTestFailure(ITestResult result) {
    test.log(Status.FAIL, "Test Failed");
    test.log(Status.FAIL, "Cause: " + result.getThrowable());

    // Capture d'écran (si WebDriver est utilisé)
    String screenshotPath = "path_to_screenshot";
    test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
}

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Enregistrer le rapport une fois tous les tests exécutés
        if (extent != null) {
            extent.flush();
        }
    }
    public static void logToReportAndConsole(String message) {
        System.out.println(message); // Log dans la console
        if (test != null) { // Vérifie si l'objet ExtentTest est initialisé
            test.log(Status.INFO, message); // Log dans le rapport HTML
        } else {
            System.err.println("ExtentTest object is null, unable to log to ExtentReports.");
        }
    }

    public static String captureScreenshot(String testName){
        try {
            // Utilisez WebDriver pour capturer une capture d'écran
            Object driver;
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "./screenshots/" + testName + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotPath));

            // Retournez le chemin pour l'ajouter au rapport
            return screenshotPath;
        } catch (Exception e) {
            logToReportAndConsole("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    public static void logScreenshot(String screenshotPath) {
        if (test != null && screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath, "Screenshot of failure");
        }
    }

}
 */







/*
package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }





    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }






    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, "Cause: " + result.getThrowable());

        // Capture d'écran (si WebDriver est utilisé)
        String screenshotPath = "path_to_screenshot";
        test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

}
 */





/*
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test = extent.createTest(testName); // Initialisation de l'objet ExtentTest
        test.log(Status.INFO, "Test Started: " + testName);
    }

     */







/*

package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

import static config.BasePage.getDriver;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialiser ExtentReports une seule fois au début de la suite
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, "Cause: " + result.getThrowable());

        // Capture d'écran sur échec
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
        if (screenshotPath != null) {
            logScreenshot(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    // Méthode pour capturer une capture d'écran
    public static String captureScreenshot(String testName) {
        try {
            WebDriver driver = getDriver(); // Récupère le driver actuel
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "./screenshots/" + testName + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            logToReportAndConsole("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    public static void logScreenshot(String screenshotPath) {
        if (test != null && screenshotPath != null) {
            try {
                test.addScreenCaptureFromPath(screenshotPath, "Screenshot of failure");
            } catch (IOException e) {
                logToReportAndConsole("Failed to log screenshot: " + e.getMessage());
            }
        }
    }

    public static void logToReportAndConsole(String message) {
        System.out.println(message); // Log dans la console
        if (test != null) {
            test.log(Status.INFO, message); // Log dans le rapport Extent
        }
    }
}

 */










package tests;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

            import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static config.BasePage.driver;

    public class ExtentReportListener implements ITestListener {

        private static ExtentReports extent;
        private static ExtentTest test;
        private static StringBuilder testLogs = new StringBuilder(); // Stockage des logs du test courant

        @Override
        public void onStart(ITestContext context) {
            if (extent == null) {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
                sparkReporter.config().setReportName("Automation Report");
                sparkReporter.config().setDocumentTitle("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }
        }

        @Override
        public void onTestStart(ITestResult result) {
            testLogs.setLength(0); // Réinitialise les logs pour un nouveau test
            test = extent.createTest(result.getMethod().getMethodName());
            logToReportAndConsole("[INFO] Début du test : " + result.getMethod().getMethodName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            logToReportAndConsole("[SUCCESS] Test réussi : " + result.getMethod().getMethodName());
            test.log(Status.PASS, testLogs.toString()); // Ajoute tous les logs du test au rapport
        }

        @Override
        public void onTestFailure(ITestResult result) {
            logToReportAndConsole("[ERROR] Test échoué : " + result.getMethod().getMethodName());
            logToReportAndConsole("Cause: " + result.getThrowable());

            // Capture d’écran et ajout au rapport
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            if (screenshotPath != null) {
                logScreenshot(screenshotPath);
            }

            test.log(Status.FAIL, testLogs.toString()); // Ajoute tous les logs du test au rapport
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            logToReportAndConsole("[WARNING] Test ignoré : " + result.getMethod().getMethodName());
            test.log(Status.SKIP, testLogs.toString());
        }

        @Override
        public void onFinish(ITestContext context) {
            if (extent != null) {
                extent.flush();
            }
        }

        /**
         * 📌 Capture une capture d’écran et retourne son chemin.
         */
        public static String captureScreenshot(String testName) {
            if (driver == null) {
                logToReportAndConsole("[WARNING] WebDriver non initialisé, impossible de capturer une capture d'écran.");
                return null;
            }

            try {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String screenshotPath = "./screenshots/" + testName + "_" + timestamp + ".png";

                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotPath));

                logToReportAndConsole("[INFO] Capture d’écran sauvegardée : " + screenshotPath);
                return screenshotPath;

            } catch (IOException e) {
                logToReportAndConsole("[ERROR] Erreur lors de la capture d'écran : " + e.getMessage());
                return null;
            }
        }

        /**
         * 📌 Ajoute une capture d’écran au rapport Extent.
         */
        public static void logScreenshot(String screenshotPath) {
            if (test != null && screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath, "Capture d’écran");
            }
        }

        /**
         * 📌 Ajoute un message personnalisé aux logs et au rapport Extent.
         */
        public static void logCustomMessage(String message) {
            testLogs.append(message).append("\n"); // Ajoute aux logs du test
            logToReportAndConsole(message);
        }

        /**
         * 📌 Affiche un message dans la console et l’ajoute aux logs du test.
         */
        public static void logToReportAndConsole(String message) {
            System.out.println(message);
            if (test != null) {
                test.log(Status.INFO, message);
            }
        }
    }

