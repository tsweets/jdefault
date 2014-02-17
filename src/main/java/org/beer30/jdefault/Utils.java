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

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

/**
 * @author tsweets
 *         Date: 2/13/14
 *         Time: 6:05 PM
 */
public class Utils {
    public static String randomNumberString(int length) {
        char[] chars = "123456789".toCharArray();
        return RandomStringUtils.random(length, 0, 8, false, false, chars);
    }

    public static int randomIntBetweenTwoNumbers(int min, int max){
        int number = RandomUtils.nextInt(max - min);
        return number + min;
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = RandomUtils.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
