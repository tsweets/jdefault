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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author tsweets
 *         Date: 2/10/14
 *         Time: 6:26 PM
 */
public class JDefaultAddressTest {
    @Test
    public void testBuildingNumber() throws Exception {
        String value = JDefaultAddress.buildingNumber();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testBuildingNumber: " + value);
    }

    @Test
    public void testCity() throws Exception {
        String value = JDefaultAddress.city();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testCity: " + value);

    }

    @Test
    public void testCityPrefix() throws Exception {
        String value = JDefaultAddress.cityPrefix();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testCityPrefix: " + value);

    }

    @Test
    public void testCitySuffix() throws Exception {
        String value = JDefaultAddress.citySuffix();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testCitySuffix: " + value);

    }

    @Test
    public void testCountry() throws Exception {
        String value = JDefaultAddress.country();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testCountry: " + value);

    }

    @Test
    public void testLatitude() throws Exception {
        String value = JDefaultAddress.latitude();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testLatitude: " + value);
    }

    @Test
    public void testLongitude() throws Exception {
        String value = JDefaultAddress.longitude();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testLongitude: " + value);
    }

    @Test
    public void testSecondaryAddress() throws Exception {
        String value = JDefaultAddress.secondaryAddress();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testSecondary: " + value);

    }

    @Test
    public void testState() throws Exception {
        String value = JDefaultAddress.state();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testState: " + value);

    }

    @Test
    public void testStateAbbr() throws Exception {
        String value = JDefaultAddress.stateAbbr();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testStateAbbr: " + value);

    }

    @Test
    public void testStateAbbrAll() throws Exception {
        String value = JDefaultAddress.stateAbbr(false);
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        System.out.println("testStateAbbrAll: " + value);

    }


    @Test
    public void testStreetAddress() throws Exception {
        String value = JDefaultAddress.streetAddress();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testStreetAddress: " + value);

    }

    @Test
    public void testStreetAddressWithSecondary() throws Exception {
        String value = JDefaultAddress.streetAddress(true);
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testStreetAddressWSec: " + value);

    }

    @Test
    public void testStreetName() throws Exception {
        String value = JDefaultAddress.streetName();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testStreetName: " + value);

    }

    @Test
    public void testStreetSuffix() throws Exception {
        String value = JDefaultAddress.streetSuffix();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testStreetSuffix: " + value);
    }

    @Test
    public void testTimeZone() throws Exception {
        String value = JDefaultAddress.timeZone();
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testTimeZone: " + value);
    }

    @Test
    public void testZipCode() throws Exception {
        String value = JDefaultAddress.zipCode();
        assertNotNull(value);
        assertTrue(value.length() == 5);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testZipCode: " + value);
    }

    @Test
    public void testZipCodeRandom() throws Exception {
        String value = JDefaultAddress.zipCode(true);
        assertNotNull(value);
        assertTrue(value.length() >= 1);
        Assert.assertFalse(StringUtils.contains(value, "{"));
        Assert.assertFalse(StringUtils.contains(value, "#"));
        Assert.assertFalse(StringUtils.contains(value, "}"));
        System.out.println("testZipCodeRandom: " + value);
    }
}
