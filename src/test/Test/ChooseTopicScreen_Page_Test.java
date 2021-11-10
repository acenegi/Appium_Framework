import org.testng.annotations.Test;

import BaseLibrary.BaseClass;
import Pages.ChooseTopicScreen_Page;

public class ChooseTopicScreen_Page_Test extends BaseClass{
	
	@Test
	public void SelectTopic_Test() {
		
		ChooseTopicScreen_Page ts = new ChooseTopicScreen_Page(driver);
		
		ts.ChooseTopics(3);
		ts.ContinueButton();
		ts.SkipButton();
		
		
	}

}
