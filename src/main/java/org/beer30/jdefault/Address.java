package org.beer30.jdefault;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @author tsweets
 *         Date: 2/10/14
 *         Time: 6:11 PM
 */
public class Address extends DefaultBase {


    public static String buildingNumber() {
        return bothify((String) fetch("address.building_number"));
    }

    public static String city() {
        // Start String #{Name.last_name}#{city_suffix}
        return parse("address.city");

    }

    public static String cityPrefix() {
        return fetchString("address.city_prefix");
    }

    public static String citySuffix() {
        return fetchString("address.city_suffix");
    }

    public static String country() {
        return fetchString("address.country");
    }

    public static String latitude() {
        return RandomUtils.nextInt(180) - 90 + "";
    }

    public static String longitude() {
        return RandomUtils.nextInt(360) - 180 + "";

    }

    public static String secondaryAddress() {
        return numerify(fetchString("address.secondary_address"));
    }

    public static String state() {
        return fetchString("address.state");
    }

    public static String stateAbbr() {
        return stateAbbr(true);
    }

    public static String stateAbbr(boolean lowerFifty) {
        String state = fetchString("address.state_abbr");
        if (lowerFifty == false) {
            return state;
        } else {
            while (state.equalsIgnoreCase("FM") || state.equalsIgnoreCase("FL") || state.equalsIgnoreCase("GU")
                    || state.equalsIgnoreCase("PW") || state.equalsIgnoreCase("PA") || state.equalsIgnoreCase("PR")
                    || state.equalsIgnoreCase("AE") || state.equalsIgnoreCase("AA") || state.equalsIgnoreCase("AP")
                    || state.equalsIgnoreCase("MP") || state.equalsIgnoreCase("VI") || state.equalsIgnoreCase("AS")
                    || state.equalsIgnoreCase("MH")) {
                state = stateAbbr(true);
            }

        }
        return state;
    }

    public static String streetAddress() {
        return streetAddress(false);
    }

    public static String streetAddress(boolean includeSecondary) {
        return numerify(parse("address.street_address") + (includeSecondary ? " " + secondaryAddress() : ""));
    }

    public static String streetName() {
        return parse("address.street_name");
    }

    public static String streetSuffix() {
        return fetchString("address.street_suffix");
    }

    public static String timeZone() {
        return bothify(fetchString("address.time_zone"));
    }

    public static String zipCode() {
        return zipCode(false);
    }
    public static String zipCode(boolean randomFormat) {
        if (randomFormat) {
            return bothify(fetchString("address.postcode"));
        } else {
            return Utils.randomNumberString(5);
        }
    }
}
