package com.automation.dataProviders;

import org.testng.annotations.DataProvider;

public class users {
    @DataProvider
    public Object[][] getLoginCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"Login22", "secret_sauce"},//invalid username
                {"standard_user", "Ahmed222"},//invalid password
                {"standard_user", ""},//blank password
                {"standard_user  ", "secret_sauce"},//space at the end of the username
                {"standard_user", "secret_Sauce"}, //case sensitivity in password

        };

    }

    @DataProvider
    public Object[][] defaultUser() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
        };
    }
}