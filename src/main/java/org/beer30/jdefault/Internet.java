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

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 8:44 PM
 */
public class Internet extends DefaultBase {
    public static String domainName() {
        List<String> words = new ArrayList<String>();
        words.add(fixUmlauts(domainWord()));
        words.add(domainSuffix());
        return StringUtils.join(words,".");

    }

    public static String domainSuffix() {
        return fetchString("internet.domain_suffix");

    }

    public static String domainWord() {
        return Name.lastName().toLowerCase();
    }

    public static String email(String name) {
        return name + "@" + domainName();
    }
    public static String email() {
        return userName() + "@" + domainName();
    }

    public static String fixUmlauts(String string) {
        String s1 = StringUtils.replace(string,"ä","ae");
        String s2 = StringUtils.replace(s1,"ö","oe");
        String s3 = StringUtils.replace(s2,"ü","ue");
        String s4 = StringUtils.replace(s3,"ß","ss");

        return s4;
    }

    public static String freeEmail() {
       return Name.firstName() + "@" + fetchString("internet.free_email");

    }

    public static String freeEmail(String name) {
        return name + "@" + fetchString("internet.free_email");

    }

    public static String ipV4Address() {
        StringBuffer sb = new StringBuffer();
        sb.append(Utils.randomIntBetweenTwoNumbers(2,254) + "");
        sb.append(".");
        sb.append(Utils.randomIntBetweenTwoNumbers(2,254) + "");
        sb.append(".");
        sb.append(Utils.randomIntBetweenTwoNumbers(2,254) + "");
        sb.append(".");
        sb.append(Utils.randomIntBetweenTwoNumbers(2,254) + "");

        return sb.toString();

    }

    public static String ipV6Address() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));
        sb.append(":");
        sb.append(String.format("%04X",Utils.randomIntBetweenTwoNumbers(1,65535)));

        return sb.toString();

    }

    public static String password() {
        return StringUtils.join(Lorem.words(2, false), "");

    }
    public static String safeEmail() {
        String[] tld = {"org","net","com"};
        return userName() + "@" + "example." + tld[Utils.randomIntBetweenTwoNumbers(0,2)];

    }
    public static String url() {
        return "http://" +domainName() +"/" + userName();

    }
    public static String userName() {
        return StringUtils.left(Name.firstName(),1).toLowerCase() + Name.lastName().toLowerCase() + Utils.randomNumberString(2);
    }
}
