package ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    public static final String SITE_LINK = "https://app.viralitycontent.com/login";

    private void setValueToField(WebElement field , String value){
        field.sendKeys(value);
    }

    public void setValueToEmail(String value){
        setValueToField(emailField, value);
    }

    public void setValueToPassword(String value){
        setValueToField(passwordField, value);
    }

    public void confirmForm(){
        submitButton.submit();
    }
}
