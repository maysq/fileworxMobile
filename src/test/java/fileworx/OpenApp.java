package fileworx;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenApp {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait=null;

    @BeforeTest
    public void startUp() throws MalformedURLException {
        DesiredCapabilities cap= new DesiredCapabilities ();
        cap.setCapability ("deviceName", "Nexus_5X_API_28_2");
        cap.setCapability ("udid", "emulator-5554");
        cap.setCapability ("platformName", "Android");
        cap.setCapability ("platformVersion", "9.0");
        cap.setCapability ("appPackage", "co.sedco.petra.editorialdesk");
        cap.setCapability ("appActivity", "com.sedco.fileworx.view.SplashActivity");
        cap.setCapability ("noReset","false");
        driver= new AndroidDriver<MobileElement> (new URL ("http://localhost:4723/wd/hub"), cap);
        wait= new WebDriverWait (driver, 10);
    }

    @Test
    public void openApp(){
        System.out.println ("basic\n");
            wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("android:id/content" ))).click ();
            wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("com.android.packageinstaller:id/permission_allow_button"))).click ();
            wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("co.sedco.petra.editorialdesk:id/activity_login_edt_username"))).sendKeys ("root");
            //wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("com.android.packageinstaller:id/permission_allow_button"))).click ();
            wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("co.sedco.petra.editorialdesk:id/activity_login_edt_password"))).sendKeys ("root");
            wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("co.sedco.petra.editorialdesk:id/activity_login_btn_login"))).click ();
    }

    @AfterTest
    public void tearDown(){
        driver.quit ();
    }
}
