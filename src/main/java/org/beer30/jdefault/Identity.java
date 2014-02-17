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
 * @author tsweets
 *         Date: 2/11/14
 *         Time: 9:55 PM
 */
public class Identity {

    public static String ssn() {
        return ssn(false);
    }

    public static String ssn(boolean formatted) {
        if (!formatted) {
            return Utils.randomNumberString(9);
        } else {
            StringBuffer ssnString = new StringBuffer(Utils.randomNumberString(3));
            ssnString.append("-");
            ssnString.append(Utils.randomNumberString(2));
            ssnString.append("-");
            ssnString.append(Utils.randomNumberString(4));
            return ssnString.toString();
        }

    }

    /**
     * Creates a Driver's license in the format of 2 Letter State Code, Dash, 8 Digit Random Number
     * ie CO-12345678
     * @return
     */
    public static String driversLicense() {
        StringBuffer dl = new StringBuffer(Address.stateAbbr());
        dl.append("-");
        dl.append(Utils.randomNumberString(8));

        return dl.toString();
    }
}
