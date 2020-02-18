package pyxel.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
     /*   System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        //ChromeDriverManager.chromedriver();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
      */

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void afterSuite() {
     /*   if(null != driver) {
            driver.close();
            driver.quit();
        }

      */
    }

    public void gotoURL() {
        this.driver.get ("https://www.staysure.co.uk");
    }

    public void clickGetQuote() {
        WebElement getQuoteButton = this.driver.findElement(By.className("btn-get-quote"));
        getQuoteButton.click();
    }

    public void selectSingleTrip() {

        // ST
        WebElement typeOfCover = this.driver.findElement(By.cssSelector("#cover > div > div:nth-child(2) > label > svg"));
        typeOfCover.click();

        /* AMT
        WebElement typeOfCover = this.driver.findElement(By.cssSelector("#cover > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        typeOfCover.click();
        */
    }

    public void selectCruise() {
        /* YES
        WebElement cruiseCover = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(2) > label:nth-child(1) > svg:nth-child(2)"));
        cruiseCover.click();
        */

        // NO
        WebElement cruiseCover = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        cruiseCover.click();
    }

    public void toDestination() {
        //TODO
        Select travellingTo = new Select(this.driver.findElement(By.id("destinationSingle")));
        travellingTo.selectByVisibleText("Italy");
    }

    public void addDestinations () {
        //TODO
    }

    public void multipleDestination() {
        WebElement multipleDestinations = this.driver.findElement(By.cssSelector("#multiple-destination > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        multipleDestinations.click();
    }

    public void departureDate() {
        //TODO: find another way
        WebElement departureDate = this.driver.findElement(By.id("datepicker-departure"));
        departureDate.click();
        Select selectStartMonth = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        selectStartMonth.selectByVisibleText("Oct");
        WebElement startDate = this.driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(2) > td:nth-child(1)"));
        startDate.click();
    }

    public void returnDate() {
        //TODO: find another way
        WebElement returnDate = this.driver.findElement(By.id("datepicker-return"));
        returnDate.click();
        Select selectEndMonth = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        selectEndMonth.selectByVisibleText("Oct");
        WebElement endDate = this.driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7)"));
        endDate.click();
    }

    public void partyType() {
        WebElement coverFor = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(2) > label > svg"));
        coverFor.click();
    }

    public void orgAge() {
        WebElement orgAge = this.driver.findElement(By.id("traveler_age_1"));
        orgAge.sendKeys("30");
    }

    public void travellerDetailsSubmit() {
        WebElement submitButton = this.driver.findElement(By.id("btnSubmit"));
        submitButton.click();
    }

}
