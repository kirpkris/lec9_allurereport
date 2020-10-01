package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;


@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    //Test Data
    String wrongUsername = "testButrix@incore.sdfj";
    String wrongPassword = "11122233444";
    String expectedErrorMessageText = "Incorrect login or password";
    String invalidErrorMessageText = "Incorrect erro mesaage!!!!!";

    @Test (priority = 1, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {
        homePage
            .goToAuthPage()
            .goToLoginPage()
            .loginToApp(wrongUsername, wrongPassword)
            .verifyLoginPassword(expectedErrorMessageText);
    }

    @Test (priority = 2, description="Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        homePage
            .goToAuthPage()
            .goToLoginPage()
            .loginToApp("", "")
            .verifyLoginUserName(expectedErrorMessageText);
    }

}