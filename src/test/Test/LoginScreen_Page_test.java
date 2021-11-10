import org.testng.annotations.Test;

import BaseLibrary.BaseClass;
import Pages.LoginScreen_Page;

public class LoginScreen_Page_test extends BaseClass{
	
	@Test
	public void Get_Started_Test() {
		
		LoginScreen_Page lp = new LoginScreen_Page();
		lp.ClickedOn_Get_Started_Button();
		lp.Verify();
		
		
	}

}
