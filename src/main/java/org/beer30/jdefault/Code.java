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
 *         Date: 2/15/14
 *         Time: 7:00 PM
 */
public class Code extends DefaultBase {

    /**
     * Generates an English Language Publisher Code in the range of
     * 0-900000-xx-x to	0-949999-xx-x
     * @return
     */
    public static String isbn() {
        StringBuffer stringBuffer = new StringBuffer("09");
        stringBuffer.append(String.format("%06d",Utils.randomIntBetweenTwoNumbers(0,49999)));
        stringBuffer.append(String.format("%02d",Utils.randomIntBetweenTwoNumbers(0,99)));
        String numberString  = stringBuffer.toString();



        int number = Integer.parseInt(numberString);
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            int digit = number % 10;                // rightmost digit
            sum = sum + i * digit;
            number = number / 10;
        }

        // Determine check digit, use X for 10
        String checkDigit = null;
        if (sum % 11 == 1) {
            checkDigit = "X";
        } else if (sum % 11 == 0) {
            checkDigit = "0";
        } else {
            checkDigit = (11 - (sum % 11)) + "";
        }

      //  System.out.println("The full ISBN number is " + numberString+checkDigit);
        String returnString = stringBuffer.toString();
        returnString = returnString.substring(0,1) + "-" + returnString.substring(1,7) + "-" + returnString.substring(7,9) + "-" + checkDigit;

        return returnString;
    }
}
