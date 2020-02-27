package pyxel.test;

import org.testng.annotations.Test;
import pyxel.core.BaseTest;
import pyxel.page.objects.StaysureHome;

public class WebTest extends BaseTest {

    @Test
    public void WebTestSTS() {
        StaysureHome stay = new StaysureHome(getDriver());

        get_price_quote();
        policy_type_single_trip();
        going_on_cruise_yes();
        from_location();
        to_location();
        multiple_destinations_yes();
        trip_start_date();
        trip_end_date();
        party_type();
        traveller_ages();
        marketing_preferences();
        //travellerDetailsSubmit();
        //validation_req_fields();

    }

    //@Test
    public void AMTPolicy() {
        get_price_quote();
        policy_type_annual_multi_trip();
        going_on_cruise_no();
        from_location();
        to_location();
        trip_start_date();
        party_type();
        traveller_ages();
        traveller_details_submit();
    }

    //@Test
    public void required_fields() {
        get_price_quote();
        to_location();
        trip_start_date();
        traveller_details_submit();
        validation_req_fields();
    }



}
