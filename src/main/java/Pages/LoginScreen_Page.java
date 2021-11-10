package Pages;

import Screen.LoginScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;

import BaseLibrary.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginScreen_Page extends BaseClass implements LoginScreenObject {
	
	public LoginScreen_Page() {

		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	//this.driver=driver;
		
	}

	@AndroidFindBy(id = getStarted_ID)
	private WebElement started;

	public void ClickedOn_Get_Started_Button() {
		
		try {
			started.click();
			//driver.findElement(By.id(getStarted_ID)).click();
			Thread.sleep(10000);
			
			
		} catch (Exception e) {
			System.out.println("Issue in Get Started Button: "+e.getMessage());
		}
	}

	public void Verify(){
		String actual ="Manish";
		String Expected= "Manish Negi";
		SoftAssert softAssert = new SoftAssert();
		if (actual.equals(Expected)){
			softAssert.assertTrue(true);
			softAssert.assertAll();
			System.out.println("Test is Passed");
		}else {
			System.out.println("Test is Failed");
			softAssert.assertTrue(false);
			softAssert.assertAll();
		}
	}

}
