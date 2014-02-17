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
 *         Time: 6:49 PM
 */
public class PhoneNumber extends DefaultBase {

    public static String phoneNumber(){
        return "555" + Utils.randomNumberString(7);
    }

    public static String phoneNumberFormatted() {
        return numerify(fetchString("phone_number.formats"));
    }

}
