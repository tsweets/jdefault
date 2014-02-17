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
import org.apache.commons.lang.math.RandomUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 12:08 PM
 */
public class DefaultBase {

    private static Map<String, Object> fakeValuesMap;


    static {
        Yaml yaml = new Yaml();
        String languageCode = "en";


        URL dictionaryUrl = Address.class.getClassLoader().getResource("META-INF/en.yml");
        File dictionary = null;
        try {
            dictionary = new File(URLDecoder.decode(dictionaryUrl.getPath(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map valuesMap = (Map) yaml.load(findStream("META-INF/en.yml"));
        valuesMap = (Map) valuesMap.get(languageCode);
        fakeValuesMap = (Map<String, Object>) valuesMap.get("faker");
    }

    private static InputStream findStream(String filename) {
        InputStream streamOnClass = Address.class.getResourceAsStream(filename);
        if (streamOnClass != null) {
            return streamOnClass;
        }
        InputStream is = Address.class.getClassLoader().getResourceAsStream(filename);
        return is;
    }

    protected static Object fetch(String key) {
        List valuesArray = (List) fetchObject(key);
        return valuesArray.get(RandomUtils.nextInt(valuesArray.size()));
    }

    protected static String fetchList(String key) {
        List valuesArray = (List) fetchObject(key);

        List<String> stringList1 = (List<String>) valuesArray.get(0);
        List<String> stringList2 = (List<String>) valuesArray.get(1);
        List<String> stringList3 = (List<String>) valuesArray.get(2);

        return stringList1.get(RandomUtils.nextInt(stringList1.size())) + " " + stringList2.get(RandomUtils.nextInt(stringList2.size())) + " " + stringList3.get(RandomUtils.nextInt(stringList3.size()));

    }

    protected static String fetchString(String key) {
        List<String> stringList = (List<String>) fetchObject(key);
        return stringList.get(RandomUtils.nextInt(stringList.size()));


    }

    protected static Object fetchObject(String key) {
        String[] path = key.split("\\.");
        Object currentValue = fakeValuesMap;
        for (String pathSection : path) {
            currentValue = ((Map<String, Object>) currentValue).get(pathSection);
        }
        return currentValue;
    }

    protected static String numerify(String numberString) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '#') {
                sb.append(RandomUtils.nextInt(10));
            } else {
                sb.append(numberString.charAt(i));
            }
        }

        return sb.toString();
    }

    protected static String letterify(String letterString) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < letterString.length(); i++) {
            if (letterString.charAt(i) == '?') {
                sb.append((char) (97 + RandomUtils.nextInt(26))); // a-z
            } else {
                sb.append(letterString.charAt(i));
            }
        }

        return sb.toString();
    }

    protected static String bothify(String string) {
        return letterify(numerify(string));
    }

    protected static String parse(String key) {
        String value = (String) fetch(key);
        return parseFoundKey(value);
    }

    protected static String parseFoundKey(String value) {
        //   System.out.println("Start Value: " + value);

        String regex = "#\\{([A-Za-z]+\\.)?([^\\}]+)\\}";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(value);
        while (matcher.find()) {
            //         System.out.print("Start index: " + matcher.start());
            //         System.out.print(" End index: " + matcher.end() + " \n");
            String keyMatched = matcher.group().trim();
            //         System.out.println("Key: " + keyMatched);
            String trimmedKey = StringUtils.substring(keyMatched, 2, keyMatched.length() - 1);
            //         System.out.println("Trimmed Key: " + trimmedKey);
            String replacedValue = fetchString(trimmedKey);
            //         System.out.println("Replaced Value: " + replacedValue);
            if (StringUtils.contains(replacedValue, "#{")) {
                replacedValue = parseFoundKey(replacedValue);
            }
            value = StringUtils.replace(value, keyMatched, replacedValue);
            //         System.out.println("New Value: " + value);


        }
        return value;
    }
}
