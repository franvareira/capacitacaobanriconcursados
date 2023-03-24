package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import Validations.LoginValidation;

public class LoginTask {
    
private WebDriver driver;
private LoginPage loginPage;
private LoginValidation loginValidation;
    
    public LoginTask(WebDriver driver) {
        
        this.driver= driver;
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
    }
    
    public void efetuarLogin() {
        
        loginValidation.validationLoginPage();
        loginPage.getUserNameInput().sendKeys("standard_user");
        loginPage.getPasswordInput().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
    }

}
