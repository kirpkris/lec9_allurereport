package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    /**Constructor*/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**Variables*/
    String baseURL = "http://ca09476-bitrix.tw1.ru/";

    /**Web Elements*/
    By bitrixLogo= By.xpath("//a[@title='Bitrix24']");

    /**Page Methods*/
    //Go to Homepage
    @Step("Open My account...")
    public HomePage goToAuthPage() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public LoginPage goToLoginPage() {
        driver.navigate().to(baseURL + "/auth/");
        return new LoginPage(driver);
    }
}