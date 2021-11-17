import BaseLibrary.BaseClass;
import Pages.E_Commerce_UserScreen_Page;
import org.testng.annotations.Test;

public class E_Commerce_UserScreen_Page_Test extends BaseClass {


    @Test(enabled = true)
    public void E_Commerce_User_Test(){
        E_Commerce_UserScreen_Page up = new E_Commerce_UserScreen_Page();
        up.Select_Country();
        up.YourName("Manish");
        up.FemaleRadio_BTN();
        up.MaleRadio_BTN();
        up.LetsShop_BTN();

    }

    @Test(enabled = false)
    public void Verify_ToastMSG(){
        E_Commerce_UserScreen_Page up = new E_Commerce_UserScreen_Page();
        up.Select_Country();
        up.YourName("");
        up.FemaleRadio_BTN();
        up.MaleRadio_BTN();
        up.LetsShop_BTN();
        up.VerifyToast_MSG();

    }

}
