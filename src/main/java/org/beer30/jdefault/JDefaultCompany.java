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
 * Class used for generated default data associated with a company
 *
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 7:54 PM
 */
public class JDefaultCompany extends JDefaultBase {

    /**
     * When a straight answer won't do, BS to the rescue!.
     * ie "implement vertical partnerships"
     *
     * @return bs string
     */
    public static String bs() {
        return fetchList("company.bs");
    }

    /**
     * Generate a buzzword-laden catch phrase.
     * ie "Advanced 3rd generation application"
     *
     * @return catch phrase string
     */
    public static String catchPhrase() {
        return fetchList("company.buzzwords");
    }

    /**
     * Generate a random company's DUNS number
     *
     * @return DUNS string
     */
    public static String dunsNumber() {
        return JDefaultNumber.randomIntBetweenTwoNumbers(1, 9) + JDefaultNumber.randomNumberString(8);
    }

    /**
     * Generate a random company name
     * ie Jones LLC
     *
     * @return company name string
     */
    public static String name() {
        return parse("company.name");
    }

    /**
     * Generate a random company suffix
     * ie "and Sons"
     *
     * @return
     */
    public static String suffix() {
        return fetchString("company.suffix");
    }


}
