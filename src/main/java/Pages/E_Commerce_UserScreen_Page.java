package Pages;

import BaseLibrary.BaseClass;
import CommonMethod.applicationUtility;
import Screen.E_Commerce_UserScreen;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class E_Commerce_UserScreen_Page extends BaseClass implements E_Commerce_UserScreen {

    public E_Commerce_UserScreen_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(id = Country_Id)
    private WebElement Country;

    @FindBy(xpath = SelectCountry_xpath)
    private WebElement SelectCounty_Dropdown;

    @FindBy(id = YourName_Id)
    private WebElement YourName;

    @FindBy(id = MaleRadio_id)
    private WebElement MaleRadio_BTN;

    @FindBy(id = FemaleRadio_id)
    private WebElement FemaleRadio_BTN;

    @FindBy(id = LetsShop_Id)
    private WebElement LetsShop_BTN;

    @FindBy(xpath = ToastMSG_xpath)
    private WebElement ToastMSG;


    public void Select_Country(){
        try {

            Country.click();
            applicationUtility.scrollToAnElementByText(driver,"India");
           System.out.println("Country Name"+SelectCounty_Dropdown.getText());
            SelectCounty_Dropdown.click();

        }catch (Exception e){
            System.out.println("Issue in Select_Country Method: "+e.getMessage());
        }
    }

    public void YourName(String Name){
        try {
            YourName.click();
            YourName.sendKeys(Name);
            driver.hideKeyboard();

        }catch (Exception e){
            System.out.println("Issue in YourName Method: "+e.getMessage());
        }
    }

    public void MaleRadio_BTN(){
        try {

            MaleRadio_BTN.click();

        }catch (Exception e){
            System.out.println("Issue in MaleRadio_BTN Method: "+e.getMessage());

        }
    }

    public void FemaleRadio_BTN(){
        try {

            FemaleRadio_BTN.click();

        }catch (Exception e){
            System.out.println("Issue in FemaleRadio_BTN Method: "+e.getMessage());

        }
    }

    public void LetsShop_BTN(){
        try {

            LetsShop_BTN.click();
            Thread.sleep(2000);

        }catch (Exception e){
            System.out.println("Issue in LetsShop_BTN Method: "+e.getMessage());

        }
    }

    public void VerifyToast_MSG(){
        try{

            String toastMessage =ToastMSG.getAttribute("name");
            System.out.println(toastMessage);
            Assert.assertEquals("Please enter your name", toastMessage);

        }catch (Exception e){

            System.out.println("Issue in VerifyToast_MSG Method: "+e.getMessage());

        }
    }


}
