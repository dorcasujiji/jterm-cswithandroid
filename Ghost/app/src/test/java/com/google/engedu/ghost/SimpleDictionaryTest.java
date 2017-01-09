/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.engedu.ghost;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SimpleDictionaryTest {

    String[] wordsArray = {"a", "a", "ant", "cattle", "hello", "zoo"};
    ArrayList<String> words = new ArrayList<>(Arrays.asList(wordsArray));
    SimpleDictionary dict = new SimpleDictionary(words,0);

    @Test
    public void testIsWord() {
        assertEquals("l", "apple".substring("app".length(), "app".length()+1));

    }

    @Test
    public void testGetAnyWordStartingWith() {
        assertEquals("cattle", dict.getAnyWordStartingWith("ca"));
    }

    @Test
    public void testGetGoodWordStartingWith1(){
        assertEquals("apple", dict.getGoodWordStartingWith("app"));
    }

    @Test
    public void testGetGoodWordStartingWith2(){
        assertEquals("applicatio", dict.getGoodWordStartingWith("app"));
    }


}
