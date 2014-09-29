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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 12:00 PM
 */
public class JDefaultIdentityTest {
    @Test
    public void testSsn() throws Exception {
        String s1 = JDefaultIdentity.ssn();
        String s2 = JDefaultIdentity.ssn(false);
        String s3 = JDefaultIdentity.ssn(true);

        Assert.assertEquals(9, s1.length());
        Assert.assertEquals(9, s2.length());
        Assert.assertEquals(11, s3.length());

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void testDriversLicense() throws Exception {
        String s1 = JDefaultIdentity.driversLicense();
        Assert.assertEquals(11, s1.length());
        System.out.println(s1);
    }
}
