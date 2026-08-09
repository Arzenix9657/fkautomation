package id.co.juaracoding.selenium;

import id.co.juaracoding.selenium.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrasiTest extends BaseSeleniumTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void setupTest() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registration_succeeds_with_valid_details() {
        registerPage.register("newuser", "newuser@example.com", "Password@123");
        Assert.assertTrue(registerPage.isRegisterSuccess(), "Registrasi seharusnya berhasil dengan detail data yang valid.");
    }

    @Test
    public void registration_fails_with_empty_or_invalid_fields() {
        registerPage.register("", "invalidemail", "123");
        Assert.assertFalse(registerPage.isRegisterSuccess(), "Registrasi seharusnya gagal jika field wajib dikosongkan atau berformat salah.");
    }
}
