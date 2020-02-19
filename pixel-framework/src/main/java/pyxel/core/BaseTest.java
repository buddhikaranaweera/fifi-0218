package pyxel.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pyxel.vars.varyables;

public class BaseTest extends varyables {

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

    public void url_homepage() {
        this.driver.get ("https://www.staysure.co.uk");
    }

    public void url_sts() {
        this.driver.get ("https://travelinsurance.staysure.co.uk/quote/policy-details");
    }

    public void button_get_quote() {
        WebElement button_get_quote = this.driver.findElement(By.className("btn-get-quote"));
        button_get_quote.click();
    }

    public void policy_type_single_trip() {
        WebElement policy_type_single_trip = this.driver.findElement(By.xpath("//span[text()='Single Trip']"));
        policy_type_single_trip.click();
    }

    public void policy_type_annual_multi_trip() {
        WebElement policy_type_annual_multi_trip = this.driver.findElement(By.xpath("//span[text()='Annual Multi Trip']"));
        policy_type_annual_multi_trip.click();
    }

    public void going_on_cruise_yes() {
        WebElement going_on_cruise_yes = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(2) > label:nth-child(1) > svg:nth-child(2)"));
        going_on_cruise_yes.click();
    }

    public void going_on_cruise_no() {
        WebElement going_on_cruise_no = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        going_on_cruise_no.click();
    }

    public void to_location() {
        Select to_location = new Select(this.driver.findElement(By.id("destinationSingle")));
        to_location.selectByVisibleText(COUNTRY_EUROPE_LR);
    }

    public void amt_area() {
        Select amt_area = new Select(this.driver.findElement(By.id("destinationSingle")));
        amt_area.selectByVisibleText (REGION_EUROPE_LR); //TODO
    }

    public void multiple_destinations_yes() {
        //TODO
    }

    public void multiple_destinations_no () {
        WebElement multiple_destinations_no = this.driver.findElement(By.cssSelector("#multiple-destination > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        multiple_destinations_no.click();
    }


    public void single_trip_start_date() {
        WebElement single_trip_start_date = this.driver.findElement(By.id("datepicker-departure"));
        single_trip_start_date.click();

        Select setMonth = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        setMonth.selectByVisibleText("Oct");

        WebElement setDate = this.driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(2) > td:nth-child(1)"));
        setDate.click();
    }

    public void single_trip_policy_end_date() {
        WebElement single_trip_policy_end_date = this.driver.findElement(By.id("datepicker-return"));
        single_trip_policy_end_date.click();

        Select setMonth = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        setMonth.selectByVisibleText("Oct");

        WebElement setDate = this.driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7)"));
        setDate.click();
    }

    public void party_type() {
        WebElement party_type = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(2) > label > svg"));
        party_type.click();
    }

    public void traveller_ages() {
        WebElement traveller_ages = this.driver.findElement(By.id("traveler_age_1"));
        traveller_ages.sendKeys("30");
    }

    public void travellerDetailsSubmit() {
        WebElement submitButton = this.driver.findElement(By.id("btnSubmit"));
        submitButton.click();
    }

}
