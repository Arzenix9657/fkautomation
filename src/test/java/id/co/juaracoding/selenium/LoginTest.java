package id.co.juaracoding.selenium;

import id.co.juaracoding.selenium.pages.LoginPage;
import id.co.juaracoding.util.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseSeleniumTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login_succeeds_with_valid_credentials() {
        loginPage.login(TestConfig.VALID_USERNAME, TestConfig.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard seharusnya ditampilkan setelah berhasil login.");
    }

    @Test
    public void login_fails_with_invalid_password() {
        loginPage.login(TestConfig.VALID_USERNAME, "wrong_password");
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Pengguna seharusnya tetap berada di halaman login jika login gagal.");
    }
}
