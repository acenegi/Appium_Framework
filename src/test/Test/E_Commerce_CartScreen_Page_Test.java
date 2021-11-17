import BaseLibrary.BaseClass;
import Pages.E_Commerce_CartScreen_Page;
import org.testng.annotations.Test;

public class E_Commerce_CartScreen_Page_Test extends BaseClass {

    @Test(priority = 1)
    public void Verify_Added_Product(){
        E_Commerce_CartScreen_Page cp = new E_Commerce_CartScreen_Page();
        cp.VerifyAddProduct();
    }
    @Test(priority = 2)
    public void Verify_Product_Price(){
        E_Commerce_CartScreen_Page cp = new E_Commerce_CartScreen_Page();
        cp.VerifyProductPrice();
    }
}
