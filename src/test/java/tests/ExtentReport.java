/*package tests;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReport {
    public static void main(String[] args) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("Demo Test", "Sample description");

        test.log(Status.INFO, "This is an info message");
        test.log(Status.PASS, "Test passed successfully");

        extent.flush(); // Writes the report
    }
}

 */
/*
package tests;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample {
    public static void main(String[] args) {
        // Configure the Spark reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        // Create ExtentReports and attach the reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Create a test in the report
        ExtentTest test = extent.createTest("Demo Test", "This is a sample test case");

        // Log steps
        test.log(Status.INFO, "This is an info message");
        test.log(Status.PASS, "Test passed successfully");

        // Save the report
        extent.flush();
    }

}
 */

package tests;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
    public static void main(String[] args) {
        // Configure the Spark reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        // Create ExtentReports and attach the reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Create a test in the report
        ExtentTest test = extent.createTest("Demo Test", "This is a sample test case");

        // Log steps
        test.log(Status.INFO, "This is an info message");
        test.log(Status.PASS, "Test passed successfully");

        // Save the report
        extent.flush();
    }
}



