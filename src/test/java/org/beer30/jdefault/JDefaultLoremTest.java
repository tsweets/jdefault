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

import java.util.List;

/**
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 9:59 PM
 */
public class JDefaultLoremTest {
    @Test
    public void testCharacters() throws Exception {
        String s = JDefaultLorem.characters();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("characters: " + s);
    }

    @Test
    public void testCharacters1() throws Exception {
        String s = JDefaultLorem.characters(10);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("characters: " + s);
    }

    @Test
    public void testParagraph() throws Exception {
        String s = JDefaultLorem.paragraph();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("paragraph: " + s);
    }

    @Test
    public void testParagraph1() throws Exception {
        String s = JDefaultLorem.paragraph(3, true, 5);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("paragraph: " + s);
    }

    @Test
    public void testParagraphs() throws Exception {
        String s = JDefaultLorem.paragraphs();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("paragraphs: " + s);
    }

    @Test
    public void testParagraphs1() throws Exception {
        String s = JDefaultLorem.paragraphs(3, true);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("paragraphs: " + s);
    }

    @Test
    public void testSentence() throws Exception {
        String s = JDefaultLorem.sentence();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("sentence: " + s);
    }

    @Test
    public void testSentence1() throws Exception {
        String s = JDefaultLorem.sentence(10, true, 5);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("sentence: " + s);
    }

    @Test
    public void testSentences() throws Exception {
        String s = JDefaultLorem.sentences();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("sentences: " + s);
    }

    @Test
    public void testSentences1() throws Exception {
        String s = JDefaultLorem.sentences(3, true);
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("sentences: " + s);
    }

    @Test
    public void testWord() throws Exception {
        String s = JDefaultLorem.word();
        Assert.assertTrue(StringUtils.isNotEmpty(s));
        System.out.println("word: " + s);
    }

    @Test
    public void testWords1() throws Exception {
        List<String> s = JDefaultLorem.words(10, true);
        Assert.assertTrue(StringUtils.isNotEmpty(s.get(0)));
        System.out.println("words: " + s);
    }
}
