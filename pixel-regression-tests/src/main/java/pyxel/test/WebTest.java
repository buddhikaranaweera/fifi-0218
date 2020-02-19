package pyxel.test;

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
        going_on_cruise_no();
        to_location();
        multiple_destinations_no();
        single_trip_start_date();
        single_trip_policy_end_date();

    }



}
