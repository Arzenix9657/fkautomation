package id.co.juaracoding.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    // TODO: Update locator berikut dengan selector asli dari halaman lupa password
    private final By emailField = By.id("forgot-email");
    private final By submitButton = By.id("btn-forgot-submit");
    private final By successMessage = By.id("forgot-success");
    private final By errorMessage = By.id("forgot-error");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void submitForgotPassword(String email) {
        enterEmail(email);
        clickSubmitButton();
    }

    public boolean isSubmitSuccess() {
        try {
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
