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
import org.apache.commons.lang.math.RandomUtils;

/**
 * random number generator
 *
 * @author tsweets
 *         Date: 2/16/14
 *         Time: 5:08 PM
 */
public class JDefaultNumber {

    /**
     * random number 0 to 9
     *
     * @return digit string
     */
    public static String digit() {
        return randomIntBetweenTwoNumbers(0, 9) + "";
    }

    /**
     * random number string without 0 being possible as the first digit
     *
     * @param numberOfDigits length of string
     * @return number string
     */
    public static String number(int numberOfDigits) {
        if (numberOfDigits < 1) {
            return "";
        }


        StringBuffer sb = new StringBuffer(randomIntBetweenTwoNumbers(1, 9) + "");

        if (numberOfDigits == 1) {
            return sb.toString();
        }


        char[] chars = "123456789".toCharArray();
        String secondHalf = RandomStringUtils.random(numberOfDigits - 1, 0, 8, false, false, chars);
        return sb.append(secondHalf).toString();
    }


    /**
     * random number string with zero possible in any position
     *
     * @param length of number string
     * @return number string
     */
    public static String randomNumberString(int length) {
        char[] chars = "0123456789".toCharArray();
        return RandomStringUtils.random(length, 0, 9, false, false, chars);
    }

    /**
     * generate a random number between 2 numbers - inclusive
     *
     * @param min lowest number to generate
     * @param max max number to generate
     * @return random number string
     */
    public static int randomIntBetweenTwoNumbers(int min, int max) {
        int number = RandomUtils.nextInt(max - min);
        return number + min;
    }
}
