package pyxel.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pyxel.vars.constantinople;

import java.util.Arrays;
import java.util.List;

public class BaseTest extends constantinople {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    /*
    *   Using https://github.com/bonigarcia/webdrivermanager to get around having to keep web browser EXE files
    *   https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    * */

    public void beforeSuite() {
        if (BROWSER == "CHROME") {
            ChromeDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        /*
        if(null != driver) {
            driver.close();
            driver.quit();
        }
        */
    }

    public void get_price_quote() {

        /*
        *   There are 3 websites representing 3 variations of the same insurance product.
        * */

        if (DOMAIN_PRODUCT == "STS") {
            this.driver.get (URL_STS);
        }
        else if (DOMAIN_PRODUCT == "AVN") {
            this.driver.get (URL_AVN);
        }
        if (DOMAIN_PRODUCT == "EXP") {
            this.driver.get (URL_EXP);
        }
    }

    // Select either Single Trip type or Annual Multi Trip type.
    public void policy_type_single_trip() {
        WebElement policy_type_single_trip = this.driver.findElement(By.cssSelector("#cover > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
        policy_type_single_trip.click();
    }
    public void policy_type_annual_multi_trip() {
        WebElement policy_type_annual_multi_trip = this.driver.findElement(By.cssSelector("#cover > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        policy_type_annual_multi_trip.click();
    }

    // Select whether user is going on a cruise or not.
    public void going_on_cruise_yes() {
        WebElement going_on_cruise_yes = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
        going_on_cruise_yes.click();
    }
    public void going_on_cruise_no() {
        WebElement going_on_cruise_no = this.driver.findElement(By.cssSelector("#going-cruise > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
        going_on_cruise_no.click();
    }

    public void from_location() {
        /*
        *   Staysure and Avanti products are originated from UK while EXPAT from elsewhere in Europe.
        * */

        if ((DOMAIN_PRODUCT == "STS") || (DOMAIN_PRODUCT == "AVN")) {
            WebElement from_location_uk = this.driver.findElement(By.cssSelector("div.box:nth-child(1) > label:nth-child(1)"));
            WebElement from_location_isle_of_man = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)"));
            WebElement from_location_guernsey = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > label:nth-child(1)"));
            WebElement from_location_jersey = this.driver.findElement(By.cssSelector("#travelling-from > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > label:nth-child(1)"));

            switch (FROM_UK) {
                case "UK1":
                    from_location_uk.click();
                    break;
                case "UK3":
                    from_location_isle_of_man.click();
                    break;
                case "UK4":
                    from_location_guernsey.click();
                    break;
                case "UK5":
                    from_location_jersey.click();
                    break;
            }

        }
        else if (DOMAIN_PRODUCT == "EXP") {
            Select expat_france = new Select(this.driver.findElement(By.cssSelector("#expatFromLocation")));
            Select expat_portugal = new Select(this.driver.findElement(By.cssSelector("#expatFromLocation")));
            Select expat_spain = new Select(this.driver.findElement(By.cssSelector("#expatFromLocation")));

            switch (FROM_EXP) {
                case "FR":
                    expat_france.selectByValue(FROM_EXP);
                    break;
                case "PT":
                    expat_portugal.selectByValue(FROM_EXP);
                    break;
                case "ES":
                    expat_spain.selectByValue(FROM_EXP);
                    break;
            }

        }
    }

    public void to_location() {
        /*
        *   For Single Trip types users can select countries while Annual Multi Trips let user select regions.
        * */

        WebElement st = this.driver.findElement(By.cssSelector("#fld-cover-singletrip"));
        WebElement amt = this.driver.findElement(By.cssSelector("#fld-cover-annualytrip"));

        if (st.isSelected()) {
            Select to_location = new Select(this.driver.findElement(By.cssSelector("#destinationSingle")));
            to_location.selectByVisibleText(MULTIPLE_DESTINATIONS.get(0));
        }
        else if (amt.isSelected()) {
            if (AMT_REGION == 0) {
                Select amt_area = new Select(this.driver.findElement(By.cssSelector("#toLocationAnnual")));
                amt_area.selectByValue(AMT_REGIONS.get(0));
            }
            else if (AMT_REGION == 1) {
                Select amt_area = new Select(this.driver.findElement(By.cssSelector("#toLocationAnnual")));
                amt_area.selectByValue(AMT_REGIONS.get(1));
            }
            else if (AMT_REGION == 2) {
                Select amt_area = new Select(this.driver.findElement(By.cssSelector("#toLocationAnnual")));
                amt_area.selectByValue(AMT_REGIONS.get(2));
            }
            else if (AMT_REGION == 3) {
                Select amt_area = new Select(this.driver.findElement(By.cssSelector("#toLocationAnnual")));
                amt_area.selectByValue(AMT_REGIONS.get(3));
            }
        }
    }

    // Select whether policy covers for multiple destinations or only single destination.
    public void multiple_destinations_no() {
        WebElement st = this.driver.findElement(By.cssSelector("#fld-cover-singletrip"));

        if (st.isSelected()) {
            WebElement multiple_destinations_no = this.driver.findElement(By.cssSelector("#multiple-destination > div > div:nth-child(3) > label"));
            multiple_destinations_no.click();
        }
    }
    public void multiple_destinations_yes() {
        WebElement st = this.driver.findElement(By.cssSelector("#fld-cover-singletrip"));

        if (st.isSelected()) {
            WebElement multiple_destinations_yes = this.driver.findElement(By.cssSelector("#multiple-destination > div > div:nth-child(2) > label"));
            multiple_destinations_yes.click();
            add_destination();
        }
    }
    public void add_destination() {
        for(int d = 1; d < MULTIPLE_DESTINATIONS.size(); d++) {
            WebElement add_another_destination = this.driver.findElement((By.cssSelector("#add-destination")));
            add_another_destination.click();

            Select to_location_multi = new Select(this.driver.findElement(By.cssSelector("#destinationSingle" +(d))));
            to_location_multi.selectByVisibleText(MULTIPLE_DESTINATIONS.get(d));
        }
    }

    public void trip_start_date() {
        WebElement single_trip_start_date = this.driver.findElement(By.cssSelector("#datepicker-departure"));
        single_trip_start_date.click();

        Select data_year = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
        data_year.selectByValue(String.valueOf(START_YEAR_GLOBAL));

        Select data_month = new Select(this.driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        data_month.selectByValue(String.valueOf(START_MONTH_GLOBAL));

        WebElement data_date = this.driver.findElement(By.linkText(String.valueOf(START_DATE_GLOBAL)));
        data_date.click();
    }

    public void trip_end_date() {
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
        marketing_preferences.click();
        marketing_preferences_opt_out();
    }

    public void marketing_preferences_opt_out() {
        WebElement marketing_telephone  = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(2) > label"));
        WebElement marketing_email      = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(3) > label"));
        WebElement marketing_post       = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(4) > label"));
        WebElement marketing_sms        = this.driver.findElement(By.cssSelector("#marketingConsentOptions > div:nth-child(5) > label"));

        for(int m = 0; m < MARKETING_PREFERENCES_OPT.size(); m++) {
            switch (MARKETING_PREFERENCES_OPT.get(m)) {
                case "EMAIL":
                    marketing_telephone.click();
                    break;
                case "TELEPHONE":
                    marketing_email.click();
                    break;
                case "POST":
                    marketing_post.click();
                    break;
                case "SMS":
                    marketing_sms.click();
                    break;
            }
        }

    }

    public void traveller_details_submit() {
        WebElement submitButton = this.driver.findElement(By.cssSelector("#btnSubmit"));
        submitButton.click();
    }

    public void validation_req_fields() {
        traveller_details_submit();

        List<String> elementArray = Arrays.asList(
                "#policyTypeError", "#going-cruiseError", "#destinationLocationError", "#departureDateError",
                "#returnDateError", "#returnDateError", "#no-of-travellersError", "#ageError", "#marketing-pref-error"
        );

        for(String element : elementArray) {
            if (this.driver.findElement(By.cssSelector(element)).isDisplayed()) {
                WebElement policyTypeError = this.driver.findElement(By.cssSelector(element));
                System.out.println(policyTypeError.getText());
            }
            else {
                traveller_details_submit();
            }
        }

    }



}
