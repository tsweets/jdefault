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
 *         Time: 7:14 PM
 */
public class JDefaultCodeTest {
    @Test
    public void testIsbn() throws Exception {

        String code = JDefaultCode.isbn();
        Assert.assertEquals(13, code.length());
        System.out.println(code);
    }
}
