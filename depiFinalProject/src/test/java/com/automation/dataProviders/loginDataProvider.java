package com.automation.dataProviders;

import org.testng.annotations.DataProvider;

public class loginDataProvider {

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() {
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
                {"locked_out_user","secret_sauce"}

        };
    }
}
