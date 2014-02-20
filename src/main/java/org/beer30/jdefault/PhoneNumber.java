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

/**
 * random phone number generator
 * @author tsweets
 *         Date: 2/16/14
 *         Time: 6:49 PM
 */
public class PhoneNumber extends DefaultBase {

    /**
     * generate random phone number with 555 prefix - just like the movies
     *
     * @return phone number string
     */
    public static String phoneNumber() {
        return Number.number(3) + "555" + Number.randomNumberString(4);
    }

    /**
     * random phone number with random format
     * ie 303-555-1212 2221231234
     * @return number string
     */
    public static String phoneNumberFormatted() {
        return numerify(fetchString("phone_number.formats"));
    }

}
