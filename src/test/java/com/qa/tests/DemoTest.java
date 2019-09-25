package com.qa.tests;


import org.testng.Assert;

import org.testng.annotations.Test;
import page.LoginPage;
import page.SignUp;

import java.util.Random;

public class DemoTest {

    @Test
    public void SignUpSuccess() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.waitPageLoad();
        loginPage.lnkSignUp.click();

        SignUp signUp = new SignUp();
        int num = new Random().nextInt(5000);
        signUp.fillUpAllFields("Duong", "Nguyen", "duong.nguyen",
                "27", "November", "1992", "Male");
        String emailError = signUp.txtError.getText();
        Assert.assertEquals(emailError, "Enter valid email");

        signUp.fillUpAllFields("Duong", "Nguyen", "duong.nguyen"+num+"@gmail.com",
                "27", "November", "1992", "Male");
        String step2 = signUp.txtStepTitle.getText();
        Assert.assertEquals(step2, "Step 2: ");

        signUp.cleanUpTest();
    }

}
