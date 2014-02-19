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

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base Class for all default data classes
 *
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 12:08 PM
 */
public class DefaultBase {

    private static Map<String, Object> fakeValuesMap;


    static {
        Yaml yaml = new Yaml();
        String languageCode = "en";

        Map valuesMap = (Map) yaml.load(findStream("META-INF/en.yml"));
        valuesMap = (Map) valuesMap.get(languageCode);
        fakeValuesMap = (Map<String, Object>) valuesMap.get("faker");
    }

    /**
     * Finds the InputStream of a file in a Jar
     *
     * @param filename of the stream to return
     * @return the file's InputStream
     */
    private static InputStream findStream(String filename) {
        InputStream streamOnClass = Address.class.getResourceAsStream(filename);
        if (streamOnClass != null) {
            return streamOnClass;
        }
        InputStream is = Address.class.getClassLoader().getResourceAsStream(filename);
        return is;
    }

    /**
     * Fetches a random Object from the dictionary based on a key
     *
     * @param key of the object to find
     * @return the Object that represents the key
     */
    protected static Object fetch(String key) {
        List valuesArray = (List) fetchObject(key);
        return valuesArray.get(RandomUtils.nextInt(valuesArray.size()));
    }

    /**
     * Fetches a List of of Values
     *
     * @param key of the values to find
     * @return random value from each list
     */
    protected static String fetchList(String key) {
        List valuesArray = (List) fetchObject(key);

        //TODO: Make this dynamic - assumes 3 lists
        List<String> stringList1 = (List<String>) valuesArray.get(0);
        List<String> stringList2 = (List<String>) valuesArray.get(1);
        List<String> stringList3 = (List<String>) valuesArray.get(2);

        return stringList1.get(RandomUtils.nextInt(stringList1.size())) + " " + stringList2.get(RandomUtils.nextInt(stringList2.size())) + " " + stringList3.get(RandomUtils.nextInt(stringList3.size()));

    }

    /**
     * Fetches a value
     *
     * @param key of the value to find
     * @return the value converted to type String
     */
    protected static String fetchString(String key) {
        List<String> stringList = (List<String>) fetchObject(key);
        return stringList.get(RandomUtils.nextInt(stringList.size()));


    }

    /**
     * Finds map of values based on a key
     * @param key to lookup
     * @return map of key value pairs
     */
    protected static Object fetchObject(String key) {
        String[] path = key.split("\\.");
        Object currentValue = fakeValuesMap;
        for (String pathSection : path) {
            currentValue = ((Map<String, Object>) currentValue).get(pathSection);
        }
        return currentValue;
    }

    /**
     * Replace '#' in a string with random numbers
     * @param numberString to insert random numbers
     * @return a string with random numbers
     */
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

    /**
     * Replace '?' in a string with random letters
     * @param letterString to insert random letters
     * @return a string with random letters
     */
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

    /**
     * Run both numerify and letterfy on a string
     * @param string to run the replacement on
     * @return replaced string
     */
    protected static String bothify(String string) {
        return letterify(numerify(string));
    }

    /**
     * Resolve embedded key
     * for example  - "#{name.first_name} #{name.last_name}" is a value for the the key name.name
     * embedded in this value are 2 other keys that need to be resolved
     * @param key that links to an embedded key
     * @return fully resolved string
     */
    protected static String parse(String key) {
        String value = (String) fetch(key);
        return parseFoundKey(value);
    }

    /**
     * resolves an embedded key
     * @param value embedded key that has been already fetched
     * @return fully resolved string
     */
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
