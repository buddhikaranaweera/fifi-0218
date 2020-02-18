package pyxel.test;

import org.testng.annotations.Test;
import pyxel.core.BaseTest;
import pyxel.page.objects.StaysureHome;

public class WebTest extends BaseTest {

    @Test
    public void WebTestSTS() {
        StaysureHome stay = new StaysureHome(getDriver());

        gotoURL();
        clickGetQuote();
        selectSingleTrip();
        selectCruise();
        toDestination();
        addDestinations ();
        multipleDestination();
        departureDate();
        returnDate();
        partyType();
        orgAge();
        travellerDetailsSubmit();
    }



}
