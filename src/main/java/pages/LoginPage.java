package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class LoginPage extends BasePage {

    /**Constructor*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By userNameId = By.name("USER_LOGIN");
    By passwordId = By.name("USER_PASSWORD");
    By loginButtonId = By.xpath("//input[@class='login-btn']");
    By errorMessage = By.xpath("//div[@class='errortext']");

    /**Page Methods*/
    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public LoginPage loginToApp(String username, String password) {
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Username Condition
    @Step("Verify username: {0} step...")
    public LoginPage verifyLoginUserName(String expectedText) {
        waitVisibility(errorMessage);
        Assert.assertEquals(readText(errorMessage), expectedText);
        return this;
    }

    //Verify Password Condition
    @Step("Verify verifyLoginPassword: {0} step...")
    public LoginPage verifyLoginPassword(String expectedText) {
        waitVisibility(errorMessage);
        Assert.assertEquals(readText(errorMessage), trim(expectedText));
        return this;
    }
}