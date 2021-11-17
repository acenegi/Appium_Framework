package Pages;

import BaseLibrary.BaseClass;
import Screen.E_Commerce_CartScreen;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class E_Commerce_CartScreen_Page extends BaseClass implements E_Commerce_CartScreen {

    public E_Commerce_CartScreen_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(id = ProductName_Id)
    private WebElement ProductNameText;

    @FindBy(id = Amount_Id)
    private WebElement AmountText;

    @FindBy(className = SendMeCheckBOX_Class)
    private WebElement SendMeCheckBOX;

    @FindBy(id = Term_Id)
    private WebElement TermandConditionBTN;

    @FindBy(id = visit_Id)
    private WebElement VisitBTN;

    public void VerifyAddProduct(){
        try{

            SoftAssert softAssert = new SoftAssert();
            String actual = ProductNameText.getText();
            if ("Air Jordan 9 Retro".equals(actual)){
                softAssert.assertTrue(true);
                softAssert.assertAll();
                System.out.println("Added Product is Matched");

            }else {
                System.out.println("Added Product is not Matched");
                softAssert.assertTrue(false);
                softAssert.assertAll();

            }
        }catch (Exception e){
            System.out.println("Issue in VerifyAddProduct Method: "+e.getMessage());
        }
    }

    public void VerifyProductPrice(){
        try{
            SoftAssert softAssert = new SoftAssert();
            String actual= AmountText.getText();
            System.out.println("Price is : "+actual);
            if ("$ 170.97".equals(actual)){
                softAssert.assertTrue(true);
                softAssert.assertAll();
                System.out.println("Added Product is Matched");

            }else {
                System.out.println("Added Product is not Matched");
                softAssert.assertTrue(false);
                softAssert.assertAll();

            }

        }catch (Exception e){
            System.out.println("issue in VerifyProductPrice Method: "+e.getMessage());
        }
    }

    public void VisitBTN(){
        try{

            VisitBTN.click();

        }catch (Exception e){
            System.out.println("Issue in VisitBTN Method: "+e.getMessage());
        }
    }
}
