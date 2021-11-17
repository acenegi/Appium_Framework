package BaseLibrary;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static AndroidDriver<MobileElement> driver;
	
	AppiumDriverLocalService server;
	
	static File src = new File("./Configuration/Android.properties");


	
	String DeviceName = ConfigUtility.readConfig.Config(src, "DeviceName");
	String PlatformName = ConfigUtility.readConfig.Config(src, "PlatformName");
	String PlatformVersion = ConfigUtility.readConfig.Config(src, "PlatformVersion");
	String AutomationName = ConfigUtility.readConfig.Config(src, "AutomationName");
	String AppPackage = ConfigUtility.readConfig.Config(src, "AppPackage");
	String AppActivity = ConfigUtility.readConfig.Config(src, "AppActivity");
	String ServerPort = ConfigUtility.readConfig.Config(src, "ServerPort");
	String appPath = ConfigUtility.readConfig.Config(src, "appPath");
	String appName = ConfigUtility.readConfig.Config(src, "appName");
	
	//static int Timewait = Integer.parseInt(ConfigUtility.readConfig.Config(src, "wait"));
	
	//public static WebDriverWait wait =new WebDriverWait(driver, 10);
	
	@BeforeSuite
	public void SetUP() {
		
		AppiumServer();
		setCapabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		
		
		driver.quit();
		server.stop();
		
	}

	public void setCapabilities() {
		
		try {
			File app = new File(appPath,appName);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
			caps.setCapability(CapabilityType.PLATFORM_NAME, PlatformName);
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PlatformVersion);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
			caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		
			//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppPackage);
			//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppActivity);
			
			URL url = new URL("http://127.0.0.1:"+ServerPort+"/wd/hub");
			driver =new AndroidDriver<MobileElement>(url, caps);
			
		} catch (Exception e) {
			System.out.println("Issue in this method: "+e.getMessage());
		}
	}
	
	public void AppiumServer() {
		
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder().usingPort(4723);
		server = AppiumDriverLocalService.buildService(serviceBuilder);
		server.start();
		
		
	}

}
