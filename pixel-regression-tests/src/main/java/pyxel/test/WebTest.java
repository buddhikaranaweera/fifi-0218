package pyxel.test;

import org.testng.annotations.Test;
import pyxel.core.BaseTest;
import pyxel.page.objects.StaysureHome;

public class WebTest extends BaseTest {

    public String PRODUCT_TYPE = "AMT"; // ST, AMT

    @Test
    public void WebTestSTS () {
        StaysureHome stay = new StaysureHome(getDriver());

        if (PRODUCT_TYPE == "ST") {
            get_price_quote();
            policy_type_single_trip();
            going_on_cruise_yes(); // going_on_cruise_yes, going_on_cruise_no
            from_location();
            to_location();
            multiple_destinations_yes(); // multiple_destinations_yes, multiple_destinations_no
            trip_start_date();
            trip_end_date();
            party_type();
            traveller_ages();
            marketing_preferences();
            traveller_details_submit();
        }
     else if (PRODUCT_TYPE == "AMT") {
            get_price_quote();
            policy_type_annual_multi_trip();
            going_on_cruise_no();; // going_on_cruise_yes, going_on_cruise_no
            from_location();
            to_location();
            trip_start_date();
            party_type();
            traveller_ages();
            marketing_preferences();
            traveller_details_submit();
        }
    }

    //@Test
    public void kitchen_sink() {
        get_price_quote();
        to_location();
        trip_start_date();
        traveller_details_submit();
        validation_req_fields();
    }



}
