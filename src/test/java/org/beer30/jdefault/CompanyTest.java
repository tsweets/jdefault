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
 *         Date: 2/15/14
 *         Time: 8:14 PM
 */
public class CompanyTest {
    @Test
    public void testBs() throws Exception {
        String s = Company.bs();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("BS: " + s);

    }

    @Test
    public void testCatchPhrase() throws Exception {
        String s = Company.catchPhrase();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("CP: " + s);

    }

    @Test
    public void testDunsNumber() throws Exception {
        String s = Company.dunsNumber();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println(s);

    }

    @Test
    public void testName() throws Exception {
        String s = Company.name();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println(s);

    }

    @Test
    public void testSuffix() throws Exception {
        String s = Company.suffix();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println(s);

    }
}
