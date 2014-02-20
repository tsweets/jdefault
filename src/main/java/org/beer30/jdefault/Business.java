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
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Business class containing useful default data associated with doing business.
 *
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 12:10 PM
 */
public class Business {

    /**
     * Typically Cards are good for 3 years. Will create a random date between 24 and 48 months
     *
     * @return date
     */
    public static Date creditCardExpiryDate() {
        DateTime dateTime = new DateTime();
        DateTime addedMonths = dateTime.plusMonths(Number.randomIntBetweenTwoNumbers(24, 48));
        return addedMonths.dayOfMonth().withMaximumValue().toDate();
    }

    /**
     * Create a Credit Card number for different types of cards. The number that is generated can pass through a
     * Luhn verification process, since the proper check digit is calculated.
     *
     * @param type of credit card number to create
     * @return credit card number string
     */
    public static String creditCardNumber(CreditCardType type) {
        String ccNumber = null;
        switch (type) {
            case VISA: {
                StringBuffer tempCC = new StringBuffer("4");
                tempCC.append(Number.randomNumberString(14));
                ccNumber = tempCC.append(+generateCheckDigit(tempCC.toString())).toString();
                break;
            }
            case MASTERCARD: {
                StringBuffer tempCC = new StringBuffer("5");
                tempCC.append(Number.randomIntBetweenTwoNumbers(1, 5));
                tempCC.append(Number.randomNumberString(13));
                ccNumber = tempCC.append(+generateCheckDigit(tempCC.toString())).toString();
                break;
            }
            case AMEX: {
                StringBuffer tempCC = new StringBuffer("3");
                tempCC.append(Number.randomIntBetweenTwoNumbers(4, 7));
                tempCC.append(Number.randomNumberString(12));
                ccNumber = tempCC.append(+generateCheckDigit(tempCC.toString())).toString();
                break;
            }
            case DISCOVER: {
                StringBuffer tempCC = new StringBuffer("6011");
                tempCC.append(Number.randomNumberString(11));
                ccNumber = tempCC.append(+generateCheckDigit(tempCC.toString())).toString();
                break;
            }
        }
        return ccNumber;
    }

    /**
     * Return a Random Credit Card Type
     *
     * @return random CreditCardType
     */
    public static CreditCardType creditCardType() {
        return Utils.randomEnum(CreditCardType.class);
    }

    private static int generateCheckDigit(String ccNumber) {
        int[] ints = new int[ccNumber.length()];
        for (int i = 0; i < ccNumber.length(); i++) {
            ints[i] = Integer.parseInt(ccNumber.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 == 0) {
            return 0;
        } else return 10 - (sum % 10);
    }

    /**
     * Random dollar amount starting at zero
     *
     * @param maxDollars to return
     * @return double value of random money
     */
    public static Double money(int maxDollars) {
        int dollars = RandomUtils.nextInt(maxDollars + 1);
        int cents = RandomUtils.nextInt(100);
        Double d = new Double(dollars + "." + cents);
        return d;
    }


}
