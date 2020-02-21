package pyxel.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pyxel.vars.varyables;

import javax.print.DocFlavor;

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

    public void url_sts() {
        this.driver.get ("https://travelinsurance.staysure.co.uk/quote/policy-details");
    }

    public void policy_type_single_trip() {
        WebElement policy_type_single_trip = this.driver.findElement(By.cssSelector("#cover > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
        policy_type_single_trip.click();
    }

    public void policy_type_annual_multi_trip() {
        WebElement policy_type_annual_multi_trip = this.driver.findElement(By.cssSelector("#cover > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        policy_type_annual_multi_trip.click();
    }

    public void going_on_cruise_yes() {
        WebElement going_on_cruise_yes = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
        going_on_cruise_yes.click();
    }

    public void going_on_cruise_no() {
        WebElement going_on_cruise_no = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        going_on_cruise_no.click();
    }

    public void from_location_uk() {
        WebElement from_location_uk = this.driver.findElement(By.cssSelector("div.box:nth-child(1) > label:nth-child(1)"));
        from_location_uk.click();
    }

    public void from_location_isle_of_man() {
        WebElement from_location_isle_of_man = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
        from_location_isle_of_man.click();
    }

    public void from_location_guernsey() {
        WebElement from_location_guernsey = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        from_location_guernsey.click();
    }

    public void from_location_jersey() {
        WebElement from_location_jersey = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > label:nth-child(1)"));
        from_location_jersey.click();
    }

    public void to_location() {
        Select to_location = new Select(this.driver.findElement(By.cssSelector("#destinationSingle")));
        to_location.selectByVisibleText(COUNTRY_EUROPE_LR);
    }

    public void amt_area() {
        Select amt_area = new Select(this.driver.findElement(By.cssSelector("#toLocationAnnual")));
        amt_area.selectByValue(REGION_EUROPE_LR);
    }

    public void multiple_destinations_yes() {
        WebElement multiple_destinations_yes = this.driver.findElement(By.cssSelector("#multiple-destination > div > div:nth-child(2) > label"));
        multiple_destinations_yes.click();

        add_destination();
    }

    public void add_destination() {
        WebElement add_another_destination = this.driver.findElement((By.cssSelector("#add-destination")));
        add_another_destination.click();

        Select to_location_multi = new Select(this.driver.findElement(By.cssSelector("#destinationSingle1")));
        to_location_multi.selectByVisibleText(COUNTRY_WORLD_LR);
    }

    public void multiple_destinations_no () {
        WebElement multiple_destinations_no = this.driver.findElement(By.cssSelector("#multiple-destination > div > div:nth-child(3) > label"));
        multiple_destinations_no.click();
    }


    public void single_trip_start_date() {
        WebElement single_trip_start_date = this.driver.findElement(By.cssSelector("#datepicker-departure"));
        single_trip_start_date.click();

        Select data_year = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
        data_year.selectByValue(String.valueOf(START_YEAR_GLOBAL));

        Select data_month = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        data_month.selectByValue(String.valueOf(START_MONTH_GLOBAL));

        WebElement data_date = this.driver.findElement(By.linkText(String.valueOf(START_DATE_GLOBAL)));
        data_date.click();
    }

    public void single_trip_end_date() {
        WebElement single_trip_start_date = this.driver.findElement(By.cssSelector("#datepicker-return"));
        single_trip_start_date.click();

        Select data_year = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
        data_year.selectByValue(String.valueOf(END_YEAR_GLOBAL));

        Select data_month = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        data_month.selectByValue(String.valueOf(END_MONTH_GLOBAL));

        WebElement data_date = this.driver.findElement(By.linkText(String.valueOf(END_DATE_GLOBAL)));
        data_date.click();
    }

    public void party_type() {
        switch (PARTY_TYPE_GLOBAL) {
            case "INDIVIDUAL":
                WebElement party_type_0 = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(2) > label"));
                party_type_0.click();
                break;
            case "COUPLE":
                WebElement party_type_2 = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(3) > label"));
                party_type_2.click();
                break;
            case "FAMILY":
                WebElement party_type_3 = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(4) > label"));
                party_type_3.click();
                WebElement single_parent_no = this.driver.findElement(By.cssSelector("#singleParentFamilySelect > div > div:nth-child(3) > label"));
                single_parent_no.click();
                number_of_travellers();
                break;
            case "SINGLE_PARENT_FAMILY":
                WebElement party_type_4 = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(4) > label"));
                party_type_4.click();
                WebElement single_parent_yes = this.driver.findElement(By.cssSelector("#singleParentFamilySelect > div > div:nth-child(2) > label"));
                single_parent_yes.click();
                number_of_travellers();
                break;
            case "OTHER":
                WebElement party_type_5 = this.driver.findElement(By.cssSelector("#cover-for > div > div:nth-child(5) > label"));
                party_type_5.click();
                number_of_travellers();
                break;
        }
    }

    public void number_of_travellers() {
        Select number_of_travellers =  new Select(this.driver.findElement(By.cssSelector("#numberOfTravellers")));
        number_of_travellers.selectByValue(String.valueOf(NUMBER_OF_TRAVELLERS));
    }

    public void traveller_ages() {
        for (int i = 0; i < NUMBER_OF_TRAVELLERS; i++) {
            WebElement traveller_ages = this.driver.findElement(By.cssSelector("#traveler_age_" + (i+1)));
            traveller_ages.sendKeys(String.valueOf(TRAVELLER_AGE[i]));

            if (this.driver.findElement(By.cssSelector("#yes_box_" + i + " > label:nth-child(1)")).isDisplayed()) {
                this.driver.findElement(By.cssSelector("#yes_box_" + i + " > label:nth-child(1)")).click();
            }

        }
    }

    public void full_time_education_yes() {
        WebElement full_time_education_yes = this.driver.findElement(By.cssSelector("#yes_box_0 > label:nth-child(1)"));
        full_time_education_yes.click();
    }

    public void full_time_education_no() {
        WebElement full_time_education_no = this.driver.findElement(By.cssSelector("#no_box_1 > label:nth-child(1)"));
        full_time_education_no.click();
    }

    public void marketing_preferences() {
        WebElement marketing_preferences = this.driver.findElement(By.cssSelector("#opt-out-marketing-pref"));

        if (marketing_preferences.isSelected()) {
            WebElement marketing_telephone = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(2) > label"));
            WebElement marketing_email = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(3) > label"));
            WebElement marketing_post = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(4) > label"));
            WebElement marketing_sms = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(5) > label"));

            switch (MARKETING_PREFERENCES) {
                case "t":
                    marketing_telephone.click();
                case "e":
                    marketing_email.click();
                case "p":
                    marketing_post.click();
                case "s":
                    marketing_sms.click();

            }
        }
    }

    public void travellerDetailsSubmit() {
        WebElement submitButton = this.driver.findElement(By.cssSelector("#btnSubmit"));
        submitButton.click();
    }

    public void validation_req_fields() {
        WebElement policyTypeError = this.driver.findElement(By.cssSelector("#policyTypeError"));
        WebElement goingCruiseError = this.driver.findElement(By.cssSelector("#going-cruiseError"));
        WebElement destinationLocationError = this.driver.findElement(By.cssSelector("#destinationLocationError"));
        WebElement departureDateError = this.driver.findElement(By.cssSelector("#departureDateError"));
        WebElement returnDateError = this.driver.findElement(By.cssSelector("#returnDateError"));
        WebElement noOfTravellersError = this.driver.findElement(By.cssSelector("#no-of-travellersError"));
        WebElement ageError = this.driver.findElement(By.cssSelector("#ageError"));
        WebElement marketingPrefError = this.driver.findElement(By.cssSelector("#marketing-pref-error"));

        if (policyTypeError.isDisplayed()) {
            System.out.println(policyTypeError.getText());
        }
        else if (goingCruiseError.isDisplayed()) {
            System.out.println(goingCruiseError.getText());
        }
        else if (destinationLocationError.isDisplayed()) {
            System.out.println(destinationLocationError.getText());
        }
        else if (departureDateError.isDisplayed()) {
            System.out.println(departureDateError.getText());
        }
        else if (returnDateError.isDisplayed()) {
            System.out.println(returnDateError.getText());
        }
        else if (noOfTravellersError.isDisplayed()) {
            System.out.println(noOfTravellersError.getText());
        }
        else if (ageError.isDisplayed()) {
            System.out.println(ageError.getText());
        }
        else if (marketingPrefError.isDisplayed()) {
            System.out.println(marketingPrefError.getText());
        }
        else {
            WebElement submitButton = this.driver.findElement(By.cssSelector("#btnSubmit"));
            submitButton.click();
        }

    }



}
