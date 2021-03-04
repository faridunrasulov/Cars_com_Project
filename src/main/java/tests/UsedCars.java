package tests;

import base.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class UsedCars extends Driver {


    @Test
    public void carsCom() throws Exception {

        homePages.setSelectDropDown(homePages.newAndUSedCarDropDown, "Used Cars");
        homePages.setSelectDropDown(homePages.allMakesDropDown, "Honda");
        homePages.setSelectDropDown(homePages.allModelsDropDown, "Pilot");
        homePages.setSelectDropDown(homePages.maximumPriceDropDown, "$50,000");
        homePages.setSelectDropDown(homePages.maimumDistanceDropDown, "100 Miles from");
        homePages.sendText(homePages.zipcodeTextBox, "6008");
        homePages.click(homePages.seacrBoxSubmitBTN);

        String actualPrice = searchResultPage.getActual(searchResultPage.maximumPrice);
        String expectedPrice = "Maximum Price: $50,000";
        Assert.assertEquals(actualPrice, expectedPrice);

        String actualMakeVehicle = searchResultPage.getActual((searchResultPage.vehicleMake));
        String expectedMakeVehicle = "Honda";
        Assert.assertEquals(actualMakeVehicle, expectedMakeVehicle);

        String actualModel = searchResultPage.getActual(searchResultPage.vehicleModel);
        String expectedModel = "Pilot";
        Assert.assertEquals(actualModel, expectedModel);

        String actualUsed = searchResultPage.getActual(searchResultPage.usedFilter);
        String expectedUsed = "Used";
        Assert.assertEquals(actualUsed, expectedUsed);

        homePages.click(searchResultPage.newButtonRadio);

        Assert.assertTrue(driver.findElement(searchResultPage.newFilter).isDisplayed());
        Assert.assertFalse(driver.findElement(searchResultPage.usedRadioButton).isSelected());


    }

}
