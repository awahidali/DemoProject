package com.miro.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

;

/**
 * Created by Abdul Wahid.
 */
public class BaseTest extends TestListenerAdapter {
    public static String URL;
    public static String cpath;
    public static String env;
    public static SimpleDateFormat dtf = null;
    WebDriver driver;
    public static ExtentReports extent;
    public static String currentDateTime;
    public static ExtentXReporter extentXR = null;
    public static ExtentHtmlReporter htmlReporter;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
    ExtentTest parent = null;
    public static KlovReporter klov = null;
    // ExtentReports extent;
    ExtentTest logger;
    public static String username1;
    public static String username2;
    public static String password1;
    public static String password2;

    @BeforeSuite
    public void beforeSuite(ITestContext ctx) {
        File file = new File("./src/main/resources/config.properties");

        FileInputStream fileInput = null;
        FileInputStream fileInputCredential = null;
        try {
            fileInput = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cpath = prop.getProperty("chromeDriver");
        URL = prop.getProperty("URL");
        readJSONFile(System.getProperty("user.dir") + "\\src\\main\\resources\\credentials.json");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + cpath);

        dtf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date date = new Date();
        currentDateTime = dtf.format(date);

        startReport();
    }

    //@BeforeTest
    public static void startReport() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output/MiroReport_" + currentDateTime + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        htmlReporter.setAppendExisting(true);
        //extentXR =
        // System.out.println(extentXR.getProjectId()+": "+extentXR.getReportId());
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Host Name", inetAddress.getHostName());
        extent.setSystemInfo("Environment", env);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));

        htmlReporter.config().setDocumentTitle("Miro report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setCSS("css-string");

// add custom javascript
        htmlReporter.config().setJS("js-string");
        List statusHierarchy = Arrays.asList(
                Status.FATAL,
                Status.FAIL,
                Status.ERROR,
                Status.WARNING,
                Status.SKIP,
                Status.PASS,
                Status.DEBUG,
                Status.INFO
        );
        extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);
    }

    // @AfterTest
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            ExtentTestManager.getTest().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            ExtentTestManager.getTest().skip(result.getThrowable());
        }
    }


    @BeforeClass(enabled = false)
    public synchronized void beforeClass() {
        parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod(enabled = false)
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parent.createNode(method.getName());
        test.set(child);
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();

    }

    public static void readJSONFile(String jsonFile){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(jsonFile)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            JSONObject user1 = (JSONObject) ((JSONObject) userList.get(0)).get("user");
             username1 = (String)user1.get("username");
             password1 = (String)user1.get("password");
             JSONObject user2 = (JSONObject) ((JSONObject) userList.get(1)).get("user");
             username2 = (String)user1.get("username");
             password2 = (String)user1.get("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
