package com.qa.tests;


import base.DriverContext;
import org.testng.Assert;

import org.testng.annotations.*;
import page.LoginPage;
import page.SignUp;

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

    @Test
    public void SignUpSuccess(){
        LoginPage loginPage = new LoginPage();
        loginPage.lnkSignUp.click();

        SignUp signUp = new SignUp();
        int num = new Random().nextInt(5000);
        signUp.fillUpAllFields("Duong", "Nguyen", "duong.nguyen"+num+"@gmail.com",
                "27", "November", "1992", "Male");
        String step2 = signUp.txtStepTitle.getText();
        Assert.assertEquals(step2, "Step 2:");
    }

}
