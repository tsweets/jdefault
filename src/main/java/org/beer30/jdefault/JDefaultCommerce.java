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
 * class used for describing e-commerce activity and products
 *
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 7:48 PM
 */
public class JDefaultCommerce extends JDefaultBase {
    /**
     * Generates a random color
     *
     * @return string name of color
     */
    public static String color() {
        return fetchString("commerce.color");
    }

    /**
     * Generates a random store department
     *
     * @return department string
     */
    public static String department() {
        return fetchString("commerce.department");
    }

    /**
     * Generates a random product name like "Small rubber shirt"
     *
     * @return product name string
     */
    public static String productName() {
        return fetchString("commerce.product_name.adjective") + ' ' + fetchString("commerce.product_name.material") + ' ' + fetchString("commerce.product_name.product");
    }
}
