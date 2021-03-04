package pages;

import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class HomePages extends Driver{

    private Select select;

    public By newAndUSedCarDropDown = By.xpath("//select[@aria-label='Select a stock type']");
    public By allMakesDropDown = By.xpath("//select[@aria-label='Make']");
    public By allModelsDropDown = By.xpath("//select[@aria-label='Model']");
    public By maximumPriceDropDown = By.xpath("//select[@aria-label='Select a maximum price']");
    public By maimumDistanceDropDown = By.xpath("//select[@aria-label='Select a maximum distance']");
    public By zipcodeTextBox = By.xpath("//input[@aria-label='Enter a Zip Code']");
    public By seacrBoxSubmitBTN = By.xpath("//input[@type='submit']");
    public By reloadButton  = By.xpath("//body[@id='t']");


    public void setSelectDropDown(By element, String text) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public void sendText(By element, String text) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void brokenLinks() throws IOException {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            String linkURL = links.get(i).getAttribute("href");
            if (linkURL != null) {
                URL obj = new URL(linkURL);
                HttpURLConnection conn = ((HttpURLConnection) obj.openConnection());

                int rCode = conn.getResponseCode();
                if (rCode == 200) {
                    System.out.println(i + " Link is valid------ " + linkURL);
                } else {
                    System.out.println(i + " Link is broken------ " + linkURL);
                }
            } else {

                System.out.println(links.get(i).getText());
                System.out.println(i + " Link is broken ******** " + linkURL);
            }
        }

    }

    public void click(By element) throws Exception{
        driver.manage().deleteAllCookies();
        Thread.sleep(7000);
        driver.findElement(element).click();
    }


}
