package Pages;

import java.util.List;
import Screen.ChooseTopicScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseLibrary.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseTopicScreen_Page extends BaseClass implements ChooseTopicScreen {
	
	public ChooseTopicScreen_Page(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}
	
	public void ChooseTopics(int count) {

		List<MobileElement> topics = driver.findElements(By.id(TopicList_Id));
		//int count = topics.size();

		for(int i=0; i<count;i++) {

			topics.get(i).click();

			
		}
		
		
	}
	
	public void ContinueButton() {
		
		try {
			timewait(driver,5,ContinueButton_Id);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ContinueButton_Id)));
			//Thread.sleep(2000);
			driver.findElement(By.id(ContinueButton_Id)).click();
			
		} catch (Exception e) {
			System.out.println("Issue in ContinueButton Method: "+e.getMessage());
		}
		
		
	}
	
	public void SkipButton() {
		try {
			timewait(driver,5,SkipButton_id);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(SkipButton_id)));
			//Thread.sleep(2000);
			driver.findElement(By.id(SkipButton_id)).click();
			
		} catch (Exception e) {
			System.out.println("Issue in SkipButton Method: "+e.getMessage());
		}
	}

	public void timewait(AndroidDriver driver,int time,String str){

		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(str)));

	}

}
