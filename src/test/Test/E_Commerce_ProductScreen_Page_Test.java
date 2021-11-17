import BaseLibrary.BaseClass;
import Pages.E_Commerce_ProductScreen_Page;
import org.testng.annotations.Test;

public class E_Commerce_ProductScreen_Page_Test extends BaseClass {

    @Test(priority = 1)
    public void Verification_Product_Page(){
        E_Commerce_ProductScreen_Page ps = new E_Commerce_ProductScreen_Page();
        ps.VerifyPage();
    }
    @Test(priority = 2)
    public void Add_To_Cart_Test(){
        E_Commerce_ProductScreen_Page ps = new E_Commerce_ProductScreen_Page();
        ps.Product_AddToCart();
        ps.Cart_BTN();
    }


}
