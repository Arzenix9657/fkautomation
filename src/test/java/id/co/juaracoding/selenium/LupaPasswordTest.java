package id.co.juaracoding.selenium;

import id.co.juaracoding.selenium.pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LupaPasswordTest extends BaseSeleniumTest {
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setupTest() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Test
    public void forgot_password_succeeds_with_registered_email() {
        forgotPasswordPage.submitForgotPassword("customer1@example.com");
        Assert.assertTrue(forgotPasswordPage.isSubmitSuccess(), "Link lupa password seharusnya berhasil dikirimkan ke email terdaftar.");
    }

    @Test
    public void forgot_password_fails_with_unregistered_email() {
        forgotPasswordPage.submitForgotPassword("unregistered@example.com");
        Assert.assertFalse(forgotPasswordPage.isSubmitSuccess(), "Link lupa password tidak boleh dikirimkan ke email yang tidak terdaftar.");
    }
}
