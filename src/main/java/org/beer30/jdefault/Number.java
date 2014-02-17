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

import org.apache.commons.lang.RandomStringUtils;

/**
 * @author tsweets
 *         Date: 2/16/14
 *         Time: 5:08 PM
 */
public class Number {

    public static String digit() {
        return Utils.randomIntBetweenTwoNumbers(0,9) + "";
    }

    public static String number(int numberOfDigits) {
        if (numberOfDigits < 1) {
            return "";
        }


        StringBuffer sb = new StringBuffer(Utils.randomIntBetweenTwoNumbers(1,9) + "");

        if (numberOfDigits == 1) {
            return sb.toString();
        }


        char[] chars = "123456789".toCharArray();
        String secondHalf = RandomStringUtils.random(numberOfDigits-1, 0, 8, false, false, chars);
        return sb.append(secondHalf).toString();
    }


}
