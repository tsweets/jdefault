/*
 * Copyright (c) 2014.  http://www.beer30.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.beer30.jdefault;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Default Data for generating fake addresses
 *
 * @author tsweets
 *         Date: 2/10/14
 *         Time: 6:11 PM
 */
public class JDefaultAddress extends JDefaultBase {

    /**
     * random 3-5 digit number for appending to a street
     *
     * @return number string
     */
    public static String buildingNumber() {
        return bothify((String) fetch("address.building_number"));
    }

    /**
     * Random City
     *
     * @return string to represent a city
     */
    public static String city() {
        return parse("address.city");

    }

    /**
     * random prefix for a city ie "North" "New"
     *
     * @return prefix string
     */
    public static String cityPrefix() {
        return fetchString("address.city_prefix");
    }

    /**
     * random city suffix ie "ton" "port"
     *
     * @return suffix string
     */
    public static String citySuffix() {
        return fetchString("address.city_suffix");
    }

    /**
     * random country - spelled out
     *
     * @return country string
     */
    public static String country() {
        return fetchString("address.country");
    }

    /**
     * Random latitude -90 to 90
     *
     * @return latitude string
     */
    public static String latitude() {
        return RandomUtils.nextInt(180) - 90 + "";
    }

    /**
     * Random longitude -180 to 180
     *
     * @return longitude string
     */
    public static String longitude() {
        return RandomUtils.nextInt(360) - 180 + "";

    }

    /**
     * Random secondary address ie "Apt 123"
     *
     * @return secondary address string
     */
    public static String secondaryAddress() {
        return numerify(fetchString("address.secondary_address"));
    }

    /**
     * random state - spelled out
     *
     * @return state string
     */
    public static String state() {
        return fetchString("address.state");
    }

    /**
     * random 2 letter state - fifty main US states (no territories)
     *
     * @return state code string
     */
    public static String stateAbbr() {
        return stateAbbr(false);
    }

    /**
     * random 2 letter state
     *
     * @param allStates include all states
     * @return state code string
     */
    public static String stateAbbr(boolean allStates) {
        String state = fetchString("address.state_abbr");
        if (allStates == true) {
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

    /**
     * random street address
     *
     * @return street address string
     */
    public static String streetAddress() {
        return streetAddress(false);
    }

    /**
     * random street address
     *
     * @param includeSecondary append secondary
     * @return street address string
     */
    public static String streetAddress(boolean includeSecondary) {
        return numerify(parse("address.street_address") + (includeSecondary ? " " + secondaryAddress() : ""));
    }

    /**
     * random street name
     *
     * @return street name string
     */
    public static String streetName() {
        return parse("address.street_name");
    }

    /**
     * random street suffix ie "Lane", "Ave"
     *
     * @return street suffix string
     */
    public static String streetSuffix() {
        return fetchString("address.street_suffix");
    }

    /**
     * random timezone in  Area/Location format ie America/Denver
     *
     * @return timezone string
     */
    public static String timeZone() {
        return bothify(fetchString("address.time_zone"));
    }

    /**
     * random 5 digit number to represent a zip code
     *
     * @return
     */
    public static String zipCode() {
        return zipCode(false);
    }

    /**
     * random formatted zip code ie ###### or #####-#### or just a normal ######
     *
     * @param randomFormat do a random format
     * @return zip code string
     */
    public static String zipCode(boolean randomFormat) {
        if (randomFormat) {
            return bothify(fetchString("address.postcode"));
        } else {
            return JDefaultNumber.randomNumberString(5);
        }
    }
}
