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
 *         Date: 2/16/14
 *         Time: 4:59 PM
 */
public class Name extends DefaultBase {
    public static String firstName() {
        return fetchString("name.first_name");
    }

    public static String middleName() {
        return fetchString("name.first_name");
    }

    public static String lastName() {
        return fetchString("name.last_name");
    }

    public static String name() {
        return parse("name.name");
    }

    public static String prefix() {
        return fetchString("name.prefix");
    }

    public static String suffix() {
        return fetchString("name.suffix");
    }

    public static String title() {
        return fetchString("name.title.descriptor") + ' ' + fetchString("name.title.level") + ' ' + fetchString("name.title.job");
    }
}
