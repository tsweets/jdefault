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

/**
 * @author tsweets
 *         Date: 2/16/14
 *         Time: 6:34 PM
 */
public class JDefaultNumberTest {
    @Test
    public void testDigit() throws Exception {
        String s = JDefaultNumber.digit();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("digit: " + s);
    }

    @Test
    public void testNumber() throws Exception {
        String s = JDefaultNumber.number(10);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        Assert.assertEquals(10, s.length());
        System.out.println("number (10): " + s);
    }
}
