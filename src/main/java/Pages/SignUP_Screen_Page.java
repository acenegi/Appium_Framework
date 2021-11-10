package Pages;

import BaseLibrary.BaseClass;
import Screen.Sign_Up_Screen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUP_Screen_Page extends BaseClass implements Sign_Up_Screen {

    public SignUP_Screen_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = userAcc_xpath)
    private WebElement MyAccount;

    @AndroidFindBy(id = SignUp_Id)
    private WebElement SignUpButton;

    @AndroidFindBy(id = Email_id)
    private WebElement EmailBTN;




}
