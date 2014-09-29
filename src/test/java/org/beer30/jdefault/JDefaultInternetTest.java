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
 *         Time: 7:06 PM
 */
public class JDefaultInternetTest {

    @Test
    public void testFixNonWord() throws Exception {
        String s = "~`!@#$%^&*()+=_-{}[]|\\:;\"'<>,.?/REALWORD";
        Assert.assertEquals("REALWORD", JDefaultInternet.fixNonWord(s));
    }

    @Test
    public void testDomainName() throws Exception {
        String s = JDefaultInternet.domainName();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("domainName: " + s);
    }

    @Test
    public void testDomainSuffix() throws Exception {
        String s = JDefaultInternet.domainSuffix();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("domainSuffix: " + s);
    }

    @Test
    public void testDomainWord() throws Exception {
        String s = JDefaultInternet.domainWord();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("domainWord: " + s);

    }

    @Test
    public void testEmail() throws Exception {
        String s = JDefaultInternet.email();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("email: " + s);

    }

    @Test
    public void testEmail1() throws Exception {
        String s = JDefaultInternet.email("tony");
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("email(tony): " + s);
    }

    @Test
    public void testFixUmlauts() throws Exception {
        String s = JDefaultInternet.fixUmlauts(JDefaultLorem.word());
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("fixUmlauts: " + s);
    }

    @Test
    public void testFreeEmail() throws Exception {
        String s = JDefaultInternet.freeEmail(JDefaultName.firstName());
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("freeEmail: " + s);
    }

    @Test
    public void testFreeEmail1() throws Exception {
        String s = JDefaultInternet.freeEmail();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("freeEmail: " + s);
    }

    @Test
    public void testIpV4Address() throws Exception {
        String s = JDefaultInternet.ipV4Address();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("ipv4: " + s);
    }

    @Test
    public void testIpV6Address() throws Exception {
        String s = JDefaultInternet.ipV6Address();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("ipv6: " + s);
    }

    @Test
    public void testPassword() throws Exception {
        String s = JDefaultInternet.password();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("password: " + s);
    }

    @Test
    public void testSafeEmail() throws Exception {
        String s = JDefaultInternet.safeEmail();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("safeEmail: " + s);
    }

    @Test
    public void testUrl() throws Exception {
        String s = JDefaultInternet.url();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        Assert.assertTrue(StringUtils.contains(s, "http://"));
        System.out.println("url: " + s);
    }

    @Test
    public void testUserName() throws Exception {
        String s = JDefaultInternet.userName();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("UserName: " + s);
    }
}
