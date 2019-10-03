package com.qa.tests;

import base.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SignUp;
import utility.JsonReader;

import java.io.FileNotFoundException;
import java.util.Random;

public class DemoTest1 {
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

    @DataProvider(name = "dataProvider")
    public Object[][] passData() throws FileNotFoundException {
        return JsonReader.getData("user.dir" + "/data/SignUp.json", "Sign Up Successful", 2, 7);
    }

    @Test
    public void SignUpUnsuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.lnkSignUp.click();

        SignUp signUp = new SignUp();
        int num = new Random().nextInt(5000);
        signUp.fillUpAllFields("Duong", "Nguyen", "duong.nguyen",
                "27", "November", "1992", "Male");
        String emailError = signUp.txtError.getText();
        Assert.assertEquals(emailError, "Enter valid email");
    }

}
