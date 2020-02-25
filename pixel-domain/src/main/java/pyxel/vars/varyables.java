package pyxel.vars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class varyables {
    public String DOMAIN_PRODUCT    = "EXP";

    public String URL_STS       = "https://travelinsurance.staysure.co.uk/quote/policy-details";
    public String URL_AVN       = "https://quote.avantitravelinsurance.co.uk/quote/policy-details";
    public String URL_EXP       = "https://expat.staysure.com/quote/policy-details";

    public String FROM_STS      = "UK3"; // UK1, UK3, UK4, UK5
    public String FROM_AVN      = ""; // UK1, UK3, UK4, UK5
    public String FROM_EXP      = "ES"; // FR, PT, ES

    public String COUNTRY_EUROPE_LR     = "Italy";
    public String COUNTRY_EUROPE_HR     = "Turkey";
    public String COUNTRY_WORLD_LR      = "Australia";
    public String COUNTRY_WORLD_HR      = "Canada";

    public String REGION_EUROPE_LR      = "EUROPE_LR";
    public String REGION_EUROPE_HR      = "EUROPE_HR";
    public String REGION_WORLD_LR       = "WORLD_LR";
    public String REGION_WORLD_HR       = "WORLD_HR";

    public String PARTY_TYPE_GLOBAL         = "SINGLE_PARENT_FAMILY";

    public int NUMBER_OF_TRAVELLERS      = 3;

    public int[] TRAVELLER_AGE = new int[] {30,0,18};

    public int START_YEAR_GLOBAL    = 2020;
    public int END_YEAR_GLOBAL      = 2020;

    public int START_MONTH_GLOBAL   = 2;
    public int END_MONTH_GLOBAL     = 3;

    public int START_DATE_GLOBAL    = 8;
    public int END_DATE_GLOBAL      = 20;

    public List<String> MARKETING_PREFERENCES_OPT = Arrays.asList(
           "TELEPHONE", "EMAIL", "POST", "SMS"
    );


}
