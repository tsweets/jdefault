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
 * generates everyone's favorite placeholder text
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 9:18 PM
 */
public class Lorem extends DefaultBase {

    /**
     * generates random characters 255 long
     *
     * @return random character string
     */
    public static String characters() {
        return characters(255);
    }

    /**
     * generates random characters
     * @param count of characters to generate
     * @return random character string
     */
    public static String characters(int count) {
        return RandomStringUtils.randomAlphabetic(count).toLowerCase();

    }

    /**
     * random lorem paragraph with 3 to 6 sentences
     * @return paragraph string
     */
    public static String paragraph(){
        return paragraph(3,false,3);
    }

    /**
     * random lorem paragraph
     * @param sentenceCount  min number of sentences
     * @param supplemental if true add additional words
     * @param randomSentencesToAdd max random number of sentences to add
     * @return paragraph string
     */
    public static String paragraph(int sentenceCount, boolean supplemental, int randomSentencesToAdd) {
        String paragraphString = sentences(sentenceCount + RandomUtils.nextInt(randomSentencesToAdd),supplemental);

        return paragraphString;
    }

    /**
     * generate 3 paragraphs
     * @return paragraphs string
     */
    public static String paragraphs() {
        return paragraphs(3, false);
    }

    /**
     * generate paragraphs
     * @param paragraphCount number of paragraphs to generate
     * @param supplemental if true add additional words
     * @return paragraphs string
     */
    public static String paragraphs(int paragraphCount, boolean supplemental) {
        List<String> paragraphList = new ArrayList<String>();
        for (int i = 0; i < paragraphCount; i++) {
            paragraphList.add(paragraph(3,supplemental,3));
        }

        String joined = StringUtils.join(paragraphList, "\n\n");
        return joined;

    }

    /**
     * generate sentence with at least 4 words and up to 6 random words added
     * @return sentence string
     */
    public static String sentence() {
        return sentence(4,false,6);
    }

    /**
     * generate sentence
     * @param wordCount min number of words
     * @param supplemental if true add additional word to each word
     * @param randomWordsToAdd number of random words added
     * @return sentence string
     */
    public static String sentence(int wordCount, boolean supplemental, int randomWordsToAdd) {
        List<String> wordList = words(wordCount + RandomUtils.nextInt(randomWordsToAdd), supplemental);
        String sentenceString = StringUtils.join(wordList, " ");

        return StringUtils.capitalize(sentenceString+".");
    }

    /**
     * generate 3 sentences
     * @return sentence string
     */
    public static String sentences() {
        return sentences(3,false);
    }

    /**
     * generate sentences
     * @param sentenceCount number of sentences
     * @param supplemental  if true add additional word to each word
     * @return sentence string
     */
    public static String sentences(int sentenceCount, boolean supplemental) {
        List<String> sentenceList = new ArrayList<String>();
        for (int i = 0; i< sentenceCount; i++) {
            sentenceList.add(sentence(3,supplemental,6));
        }

        String sentenceString = StringUtils.join(sentenceList," ");
        return sentenceString;

    }

    /**
     * generate a random word
     * @return word string
     */
    public static String word() {
        return fetchString("lorem.words");
    }

    /**
     * generate a list of 3 random words
     * @return word list
     */
    public List<String> words() {
        return words(3, false);
    }

    /**
     * generate a list of random words
     * @param count of words to add to the list
     * @param supplemental if true add additional word to each word
     * @return word list
     */
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
