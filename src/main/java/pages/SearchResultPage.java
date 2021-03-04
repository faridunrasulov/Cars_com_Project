package pages;

import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends Driver {

    public By maximumPrice = By.xpath("(//label[text()='Maximum Price: $50,000'])[1]");
    public By vehicleMake = By.xpath("(//label[text()='Honda'])[1]");
    public By vehicleModel = By.xpath("(//label[text()='Pilot'])[1]");
    public By usedFilter = By.xpath("(//label[text()='Used'])[1]");
    public By listOfRadioButoons = By.xpath("//input[contains(@id,'stkTypId')]/following-sibling::label[contains(@for,'stkTypId-')]");
    public By listOfFilters = By.xpath("(//ul[@class='breadcrumbs'])[1]/li");
    public By newFilter = By.xpath("(//label[text()='New'])[1]");
    public By newButtonRadio = By.xpath("//input[@id='stkTypId-28880']/following-sibling::label");
    public By usedRadioButton = By.xpath("//label[@for='stkTypId-28881']");


    public String getActual(By element) {
        return driver.findElement(element).getText();
    }


    public void clickRadioButton(String value) {

        List<WebElement> lists = driver.findElements(listOfRadioButoons);
        for (WebElement list : lists) {
            if (list.isEnabled() && !list.isSelected()) {
                String listTxt = list.getText();
                if (listTxt.equals(value)) {
                    list.click();
                }
            }
        }

    }

    public void isDisplayed(By element) {
       if (driver.findElement(element).isDisplayed()){
           System.out.println("Element is Didplayed");
        }else {
           System.out.println("element is NOT Dispalyed");
       }
    }


}
