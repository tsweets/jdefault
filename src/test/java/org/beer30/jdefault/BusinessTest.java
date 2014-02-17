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

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 12:26 PM
 */
public class BusinessTest {
    @Test
    public void testCreditCardExpiryDate() throws Exception {
        Date expDate = Business.creditCardExpiryDate();
        Assert.assertTrue(expDate.after(new Date()));
        System.out.println(expDate);

    }

    @Test
    public void testGenerateCreditCard() {
        String visa = Business.creditCardNumber(CreditCardType.VISA);
        System.out.println(visa);
        Assert.assertEquals(16,visa.length());
        Assert.assertEquals("4", StringUtils.left(visa,1));

        String masterCard = Business.creditCardNumber(CreditCardType.MASTERCARD);
        System.out.println(masterCard);
        Assert.assertEquals(16, masterCard.length());
        Assert.assertEquals("5", StringUtils.left(masterCard,1));

        String amex = Business.creditCardNumber(CreditCardType.AMEX);
        System.out.println(amex);
        Assert.assertEquals(15, amex.length());
        Assert.assertEquals("3", StringUtils.left(amex,1));

        String discover = Business.creditCardNumber(CreditCardType.DISCOVER);
        System.out.println(discover);
        Assert.assertEquals(16, discover.length());
        Assert.assertEquals("6011", StringUtils.left(discover,4));
    }

    @Test
    public void testCreditCardType() {
        CreditCardType ccType = Business.creditCardType();
        System.out.println(ccType);
        Assert.assertNotNull(ccType);
    }

    @Test
    public void testMoney() {
        Double money = Business.money(200);
        Assert.assertTrue(money >= 0.0);
        Assert.assertTrue(money <= 200.0);
        System.out.println("Money: " + money);

    }

}
