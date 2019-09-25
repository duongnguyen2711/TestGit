package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp extends BasePage{

    private WebDriverWait wait;

    @FindBy(id = "firstName")
    public WebElement txtFirstName;

    @FindBy(id = "lastName")
    public WebElement txtLastName;

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(xpath = ".//div[@name='birthMonth']")
    public WebElement drpMonth;

    @FindBy(xpath = ".//div[@name='birthDay ']")
    public WebElement drpDay;

    @FindBy(xpath = ".//div[@name='birthYear']")
    public WebElement drpYear;

    @FindBy(id = "genderCode")
    public WebElement drpGender;

    @FindBy(xpath = ".//span[text()='Next: Location']")
    public WebElement btnNext;

    @FindBy(id = "emailError")
    public WebElement txtError;

    @FindBy(xpath = ".//h1[@class='step-title']/span[1]")
    public WebElement txtStepTitle;

    public void fillUpAllFields(String firstName, String lastName, String email, String day, String month, String year, String gender){

        wait.until(ExpectedConditions.invisibilityOf(txtFirstName));

        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);

        drpGender.click();
        wait.until(ExpectedConditions.elementToBeClickable(drpGender));
        drpGender.sendKeys(gender);

        drpDay.click();
        wait.until(ExpectedConditions.elementToBeClickable(drpDay));
        drpDay.sendKeys(day);

        drpMonth.click();
        wait.until(ExpectedConditions.elementToBeClickable(drpMonth));
        drpMonth.sendKeys(month);

        drpYear.click();
        wait.until(ExpectedConditions.elementToBeClickable(drpYear));
        drpYear.sendKeys(year);

        btnNext.click();
    }

    public boolean emailErrorDisplay(){
        String invalidEmailError = "Enter valid email";
        wait.until(ExpectedConditions.invisibilityOf(txtEmail));
        if (txtEmail.getText().equals(invalidEmailError)){
            return true;
        } else {
            return false;
        }
    }

    public void cleanUpTest(){
        driver.quit();
    }

}
