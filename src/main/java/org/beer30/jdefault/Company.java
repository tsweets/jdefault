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
 * @author tsweets
 *         Date: 2/15/14
 *         Time: 7:54 PM
 */
public class Company extends DefaultBase {

    /**
     *  When a straight answer won't do, BS to the rescue!.
     * @return
     */
    public static String bs() {
       return fetchList("company.bs");
    }

    /**
     *  Generate a buzzword-laden catch phrase.
     * @return
     */
    public static String catchPhrase() {
        return fetchList("company.buzzwords");
    }

    public static String dunsNumber() {
        return Utils.randomIntBetweenTwoNumbers(1,9) + Utils.randomNumberString(8);
    }

    public static String name() {
        return parse("company.name");
    }

    public static String suffix() {
        return fetchString("company.suffix");
    }

   /* def translate(*args)
    opts = args.last.is_a?(Hash) ? args.pop : {}
    opts[:locale] ||= Faker::Config.locale
    opts[:raise] = true
            I18n.translate(*(args.push(opts)))
    rescue I18n::MissingTranslationData
    # Super-simple fallback -- fallback to en if the
    # translation was missing.  If the translation isn't
            # in en either, then it will raise again.
            I18n.translate(*(args.push(opts.merge(:locale => :en))))
    end*/
}
