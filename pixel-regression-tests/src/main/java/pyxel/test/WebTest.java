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

        url_sts();
        policy_type_annual_multi_trip();
        policy_type_single_trip();
        going_on_cruise_yes();
        from_location_isle_of_man();
        going_on_cruise_no();
        to_location();
        multiple_destinations_yes();
        single_trip_start_date();
        single_trip_end_date();
        party_type();
        //number_of_travellers();
        traveller_ages();
        travellerDetailsSubmit();

    }



}
