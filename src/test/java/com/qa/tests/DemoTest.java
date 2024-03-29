package com.qa.tests;


import base.DriverContext;
import org.testng.Assert;

import org.testng.annotations.*;
import page.LoginPage;
import page.SignUp;
import utility.JsonReader;

import java.io.FileNotFoundException;
import java.util.Random;

public class DemoTest {

    @BeforeMethod
    public void openBrowser(){
        DriverContext.setUpDriver();
        DriverContext.getDriver().get("https://www.utest.com");
        DriverContext.getDriver().manage().window().maximize();
    }

    @AfterMethod()
    public void closeBrowser(){
        DriverContext.getDriver().quit();
    }

    @DataProvider(name = "testData")
    public Object[][] passData() throws FileNotFoundException {
        return JsonReader.getData(System.getProperty("user.dir") + "/data/SignUp.json", "SignUp Successful", 2, 7);
    }

    @Test (dataProvider = "testData")
    public void SignUpSuccess(String firstName, String lastName, String email, String dobDay, String dobMonth, String dobYear, String gender){
        LoginPage loginPage = new LoginPage();
        loginPage.lnkSignUp.click();

        SignUp signUp = new SignUp();
        //int num = new Random().nextInt(5000);
        signUp.fillUpAllFields(firstName, lastName, email, dobDay, dobMonth, dobYear, gender);
        String step2 = signUp.txtStepTitle.getText();
        Assert.assertEquals(step2, "Step 2:");
    }

}
