package pyxel.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pyxel.core.BaseTest;
import pyxel.page.objects.StaysureHome;

public class WebTest extends BaseTest {

    @Test
    public void WebTestSTS() {
        StaysureHome stay = new StaysureHome(getDriver());

        url_web();
        policy_type_single_trip();
        going_on_cruise_yes();
        from_location_isle_of_man();
        to_location();
        multiple_destinations_yes();
        single_trip_start_date();
        //single_trip_end_date();
        party_type();
        traveller_ages();
        marketing_preferences();
        //travellerDetailsSubmit();
        //validation_req_fields();

    }

    //@Test
    public void AMTPolicy() {
        url_web();
        policy_type_annual_multi_trip();
        going_on_cruise_no();
        from_location_jersey();
        amt_area();
        single_trip_start_date();
        party_type();
        traveller_ages();
        travellerDetailsSubmit();
    }

    //@Test
    public void required_fields() {
        url_web();
        travellerDetailsSubmit();
        validation_req_fields();
    }



}
