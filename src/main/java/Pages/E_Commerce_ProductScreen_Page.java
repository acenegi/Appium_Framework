package Pages;

import BaseLibrary.BaseClass;
import CommonMethod.applicationUtility;
import Screen.E_Commerce_ProductScreen;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class E_Commerce_ProductScreen_Page extends BaseClass implements E_Commerce_ProductScreen {

   public E_Commerce_ProductScreen_Page(){

       PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @FindBy(id = ProductPageTitle_Id)
    private WebElement Title;

   @FindBy(id = ProductName_Id)
    private List<WebElement> ProductName;

   @FindBy(id = AddToCart_Id)
    private List<WebElement> AddToCart_BTN;

   @FindBy(id = Cart_Id)
    private WebElement Cart_BTN;

   public void VerifyPage(){
       try{
           SoftAssert softAssert = new SoftAssert();
           String actual = Title.getText();
           if("Products".equals(actual)){
               softAssert.assertTrue(true);
               softAssert.assertAll();
               System.out.println("You are in Product Page");
           }else {
               System.out.println("You are not in Product Page");
               softAssert.assertTrue(false);
               softAssert.assertAll();
           }

       }catch (Exception e){

           System.out.println("Issue in VerifyPage Method: "+e.getMessage());

       }
   }

   public void Product_AddToCart(){
       try{
            String Product="Air Jordan 9 Retro";
           applicationUtility.scrollToAnElementByText(driver,Product);
           int size = ProductName.size();
           for(int i = 0;i<size;i++){

               String data=ProductName.get(i).getText();

               if (data.equalsIgnoreCase(Product)){
                   AddToCart_BTN.get(i).click();
                   break;
               }

           }

       }catch (Exception e) {
           System.out.println("Issue in Product_AddToCart Method: " + e.getMessage());
       }
   }

   public void Cart_BTN(){
       try{
           Cart_BTN.click();
       }catch (Exception e){
           System.out.println("Issue in Cart_BTN Method: "+e.getMessage());
       }
   }


}
