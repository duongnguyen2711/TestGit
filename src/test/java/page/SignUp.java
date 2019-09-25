package page;

import base.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp extends BasePage{

    private WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), 5);

    @FindBy(id = "firstName")
    public WebElement txtFirstName;

    @FindBy(id = "lastName")
    public WebElement txtLastName;

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(xpath = ".//div[@name='birthMonth']")
    public WebElement drpMonth;

    @FindBy(xpath = ".//div[@name='birthDay']")
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

    @FindBy(id = "ui-select-choices-1")
    public WebElement listDay;

    @FindBy(id = "ui-select-choices-2")
    public WebElement listYear;

    @FindBy(id = "ui-select-choices-0")
    public WebElement listMonth;

    @FindBy(id = "ui-select-choices-3")
    public WebElement listGender;

    private void selectYear(String year){
        WebElement newYearList = listYear.findElement(By.xpath("//div[text()='"+year+"']"));
        wait.until(ExpectedConditions.visibilityOf(newYearList));
        newYearList.click();
    }

    private void selectDay(String day){
        WebElement newDayList = listDay.findElement(By.xpath("//div[text()='"+day+"']"));
        wait.until(ExpectedConditions.visibilityOf(newDayList));
        newDayList.click();
    }

    private void selectMonth(String month){
        WebElement newMonthList = listMonth.findElement(By.xpath("//div[text()='"+month+"']"));
        wait.until(ExpectedConditions.visibilityOf(newMonthList));
        newMonthList.click();
    }


    private void selectGender(String gender){
        WebElement newGenderList = listGender.findElement(By.xpath("//div[text()='"+gender+"']"));
        wait.until(ExpectedConditions.visibilityOf(newGenderList));
        newGenderList.click();

    }

    public void fillUpAllFields(String firstName, String lastName, String email, String day, String month, String year, String gender){

        wait.until(ExpectedConditions.visibilityOf(txtFirstName));

        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);

        drpGender.click();
        selectGender(gender);

        drpDay.click();
        selectDay(day);

        drpMonth.click();
        selectMonth(month);

        drpYear.click();
        selectYear(year);

        btnNext.click();
    }

    public boolean emailErrorDisplay(){
        String invalidEmailError = "Enter valid email";
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        if (txtEmail.getText().equals(invalidEmailError)){
            return true;
        } else {
            return false;
        }
    }

}
