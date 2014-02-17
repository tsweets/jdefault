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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 9:18 PM
 */
public class Lorem extends DefaultBase {

    public static String characters() {
        return characters(255);
    }

    public static String characters(int count) {
        return RandomStringUtils.randomAlphabetic(count).toLowerCase();

    }

    public static String paragraph(){
        return paragraph(3,false,3);
    }
    public static String paragraph(int sentenceCount, boolean supplemental, int randomSentencesToAdd) {
        String paragraphString = sentences(sentenceCount + RandomUtils.nextInt(randomSentencesToAdd),supplemental);

        return paragraphString;
    }

    public static String paragraphs() {
        return paragraphs(3, false);
    }
    public static String paragraphs(int paragraphCount, boolean supplemental) {
        List<String> paragraphList = new ArrayList<String>();
        for (int i = 0; i < paragraphCount; i++) {
            paragraphList.add(paragraph(3,supplemental,3));
        }

        String joined = StringUtils.join(paragraphList, "\n\n");
        return joined;

    }
    public static String sentence() {
        return sentence(4,false,6);
    }
    public static String sentence(int wordCount, boolean supplemental, int randomWordsToAdd) {
        List<String> wordList = words(wordCount + RandomUtils.nextInt(randomWordsToAdd), supplemental);
        String sentenceString = StringUtils.join(wordList, " ");

        return StringUtils.capitalize(sentenceString+".");
    }

    public static String sentences() {
        return sentences(3,false);
    }
    public static String sentences(int sentenceCount, boolean supplemental) {
        List<String> sentenceList = new ArrayList<String>();
        for (int i = 0; i< sentenceCount; i++) {
            sentenceList.add(sentence(3,supplemental,6));
        }

        String sentenceString = StringUtils.join(sentenceList," ");
        return sentenceString;

    }
    public static String word() {
        return fetchString("lorem.words");
    }

    public List<String> words() {
        return words(3, false);
    }

    public static List<String> words(int count, boolean supplemental) {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            String wordString = word();
            if (supplemental) {
                wordString = wordString + fetchString("lorem.supplemental");
            }
            words.add(wordString);
        }

        return words;
    }
}
