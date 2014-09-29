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
 * class of generating default names
 *
 * @author tsweets
 *         Date: 2/16/14
 *         Time: 4:59 PM
 */
public class JDefaultName extends JDefaultBase {

    /**
     * generates a random first name
     *
     * @return first name string
     */
    public static String firstName() {
        return fetchString("name.first_name");
    }

    /**
     * generates a random middle name
     *
     * @return middle name string
     */
    public static String middleName() {
        return fetchString("name.first_name");
    }

    /**
     * generates a random last name
     *
     * @return last name string
     */
    public static String lastName() {
        return fetchString("name.last_name");
    }

    /**
     * generates a random full name in a random format
     * like "Mr Tom Jones" or "Howard Wright"
     *
     * @return full name string
     */
    public static String name() {
        return parse("name.name");
    }

    /**
     * generates random name prefix like "Mr" "Mrs"
     *
     * @return prefix string
     */
    public static String prefix() {
        return fetchString("name.prefix");
    }

    /**
     * generates random name suffix like "Jr." "Phd"
     *
     * @return suffix string
     */
    public static String suffix() {
        return fetchString("name.suffix");
    }

    /**
     * generates a random title
     * ie "Lead Research Engineer"
     *
     * @return title string
     */
    public static String title() {
        return fetchString("name.title.descriptor") + ' ' + fetchString("name.title.level") + ' ' + fetchString("name.title.job");
    }
}
