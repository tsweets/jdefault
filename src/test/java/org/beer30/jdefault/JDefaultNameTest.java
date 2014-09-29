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
 *         Time: 5:03 PM
 */
public class JDefaultNameTest {
    @Test
    public void testFirstName() throws Exception {
        String s = JDefaultName.firstName();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("firstName: " + s);
    }

    @Test
    public void testMiddleName() throws Exception {
        String s = JDefaultName.middleName();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("middleName: " + s);
    }

    @Test
    public void testLastName() throws Exception {
        String s = JDefaultName.lastName();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("lastName: " + s);
    }

    @Test
    public void testName() throws Exception {
        String s = JDefaultName.name();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("name: " + s);
    }

    @Test
    public void testPrefix() throws Exception {
        String s = JDefaultName.prefix();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("prefix: " + s);
    }

    @Test
    public void testSuffix() throws Exception {
        String s = JDefaultName.suffix();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("suffix: " + s);
    }

    @Test
    public void testTitle() throws Exception {
        String s = JDefaultName.title();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("title: " + s);
    }
}
