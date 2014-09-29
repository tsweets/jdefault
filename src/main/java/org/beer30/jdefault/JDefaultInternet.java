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
 * generates data around Internet concepts
 *
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 8:44 PM
 */
public class JDefaultInternet extends JDefaultBase {

    /**
     * generates a random domain name (no host)
     * ie bartell.net
     *
     * @return domain name string
     */
    public static String domainName() {
        List<String> words = new ArrayList<String>();
        words.add(fixUmlauts(domainWord()));
        words.add(domainSuffix());
        return StringUtils.join(words, ".");

    }

    /**
     * generate random domain suffix
     * ie "com" "net" "org"
     *
     * @return
     */
    public static String domainSuffix() {
        return fetchString("internet.domain_suffix");

    }

    /**
     * return a domain word (all lower case) that is usually prepended to the front of a suffix
     *
     * @return domain word string
     */
    public static String domainWord() {
        return fixNonWord(JDefaultName.lastName().toLowerCase());
    }

    /**
     * generates a email address based off of a name given
     * the name is appended to a domain name
     * ie name@somedomain.net
     *
     * @param name to use for the email address
     * @return email string
     */
    public static String email(String name) {
        return name + "@" + domainName();
    }

    /**
     * random email address
     *
     * @return email string
     */
    public static String email() {
        return userName() + "@" + domainName();
    }

    /**
     * replace umlauts to be in compliance with  RFC 3986 URLs
     *
     * @param string that may contain umlauts
     * @return clean string
     */
    public static String fixUmlauts(String string) {
        String s1 = StringUtils.replace(string, "ä", "ae");
        String s2 = StringUtils.replace(s1, "ö", "oe");
        String s3 = StringUtils.replace(s2, "ü", "ue");
        String s4 = StringUtils.replace(s3, "ß", "ss");

        return s4;
    }

    /**
     * replace all special (as well as Unicode) characters leaving A-Z Chars and Digits
     * @param string
     * @return
     */
    public static String fixNonWord(String string) {
        String resultString = string.replaceAll("[^\\p{L}\\p{Nd}]", "");

        return resultString;
    }

    /**
     * generate a random free email address like name@gmail.com or name@yahoo.com
     *
     * @return email string
     */
    public static String freeEmail() {
        return fixNonWord(JDefaultName.firstName()) + "@" + fetchString("internet.free_email");

    }

    /**
     * generate a random free email address based off of a given name
     *
     * @param name to use with free email domain
     * @return email string
     */
    public static String freeEmail(String name) {
        return name + "@" + fetchString("internet.free_email");

    }

    /**
     * generates a random IPv4 ip address like 192.168.2.100
     *
     * @return ip address string
     */
    public static String ipV4Address() {
        StringBuffer sb = new StringBuffer();
        sb.append(JDefaultNumber.randomIntBetweenTwoNumbers(2, 254) + "");
        sb.append(".");
        sb.append(JDefaultNumber.randomIntBetweenTwoNumbers(2, 254) + "");
        sb.append(".");
        sb.append(JDefaultNumber.randomIntBetweenTwoNumbers(2, 254) + "");
        sb.append(".");
        sb.append(JDefaultNumber.randomIntBetweenTwoNumbers(2, 254) + "");

        return sb.toString();

    }

    /**
     * generates a random IPv6 ip address like 2607:f0d0:1002:0051:0000:0000:0000:0004
     *
     * @return ip address string
     */
    public static String ipV6Address() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));
        sb.append(":");
        sb.append(String.format("%04X", JDefaultNumber.randomIntBetweenTwoNumbers(1, 65535)));

        return sb.toString();

    }

    /**
     * generates a random password
     *
     * @return password string
     */
    public static String password() {
        return StringUtils.join(JDefaultLorem.words(2, false), "");

    }

    /**
     * generate a random safe email that can't go anywhere since they are used with reserved TLD domains like
     * example.com example.net and example.org
     * ie name@example.net
     *
     * @return safe email string
     */
    public static String safeEmail() {
        String[] tld = {"org", "net", "com"};
        return userName() + "@" + "example." + tld[JDefaultNumber.randomIntBetweenTwoNumbers(0, 2)];

    }

    /**
     * generates a random web url in the form of
     * http://domain.com/somedir
     *
     * @return
     */
    public static String url() {
        return "http://" + domainName() + "/" + userName();

    }

    /**
     * generates a random username in the format of Firstname intial + lastname + random 2 digit
     * ie tjones67
     *
     * @return
     */
    public static String userName() {
        return fixNonWord(StringUtils.left(JDefaultName.firstName(), 1).toLowerCase() + JDefaultName.lastName().toLowerCase() + JDefaultNumber.randomNumberString(2));
    }
}
