package com.automation.pages;

import java.util.Arrays;
import java.util.List;

public class ExpectedList {
    public static List<String> sortedNamesAZ() {
        return Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)"
        );
    }

    public static List<String> sortedNamesZA() {
        return Arrays.asList(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Bike Light",
            "Sauce Labs Backpack"
        );
    }

    public static List<String> sortedPricesLH() {
        return Arrays.asList(
            "$7.99",
            "$9.99",
            "$15.99",
            "$15.99",
            "$29.99",
            "$49.99"
        );
    }
    
    public static List<String> sortedPricesHL() {
        return Arrays.asList(
            "$49.99",
            "$29.99",
            "$15.99",
            "$15.99",
            "$9.99",
            "$7.99"
        );
    }
}
