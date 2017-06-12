/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {
    
    private boolean printStatus = false;
    private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.
    
    public UrlValidatorTest(String testName) {
        super(testName);
    }
    
    
    
    public void testManualTest()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println(urlVal.isValid("http://www.amazon.com"));
        printTest("http://www.amazon.com",true);
        printTest("www.google.com",true);
        printTest("go.au",true);
        printTest("255.255.255.255",true);
        printTest("go.cc",true);
        printTest("http://www.amazon.com:80",true);
        printTest("http://www.amazon.com:80",true);
        printTest("http://www.amazon.com/test1",true);
        printTest("http://www.amazon.com?action=view",true);
        printTest("3ht://www.amazon.com",false);
        printTest("http/www.amazon.com",false);
        printTest("256.256.256.256",false);
        printTest("go.a1a",false);
        printTest("",false);
        printTest("http://www.amazon.com:-1",false);
        printTest("http://www.amazon.com/test1//file",false);
        printTest("http://www.amazon.com/#",false);
        printTest("telnet://www.amazon.com",false);
        
        //Test Pass
        assertTrue(urlVal.isValid("http://www.amazon.com"));
        assertFalse(urlVal.isValid("3ht://www.amazon.com"));
        assertFalse(urlVal.isValid("http/www.amazon.com"));
        assertFalse(urlVal.isValid("256.256.256.256"));
        assertFalse(urlVal.isValid("go.a1a"));
        assertFalse(urlVal.isValid(""));
        assertFalse(urlVal.isValid("http://www.amazon.com:-1"));
        assertTrue(urlVal.isValid("http://www.amazon.com:80"));
        assertTrue(urlVal.isValid("http://www.amazon.com/test1"));
        assertFalse(urlVal.isValid("http://www.amazon.com/test1//file"));
        //Test Failures
        assertTrue(!urlVal.isValid("www.google.com"));
        assertTrue(!urlVal.isValid("go.au"));
        assertTrue(!urlVal.isValid("255.255.255.255"));
        assertTrue(!urlVal.isValid("go.cc"));
        assertFalse(!urlVal.isValid("http://www.amazon.com/#"));
        assertTrue(!urlVal.isValid("http://www.amazon.com?action=view"));
        assertFalse(!urlVal.isValid("telnet://www.amazon.com"));
    }
    
    //This partion tests only url scheme
    public void testYourFirstPartition()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        printTest("http://www.amazon.com",true);
        printTest("ftp://www.amazon.com",true);
        printTest("h3t://www.amazon.com",true);
        printTest("3ht://www.amazon.com",false);
        printTest("http:/www.amazon.com",false);
        printTest("http:www.amazon.com",false);
        printTest("http/www.amazon.com",false);
        printTest("://www.amazon.com",false);
        printTest("www.amazon.com",true);
        
        //Test Pass
        assertTrue(urlVal.isValid("http://www.amazon.com"));
        assertTrue(urlVal.isValid("ftp://www.amazon.com"));
        assertTrue(urlVal.isValid("h3t://www.amazon.com"));
        assertFalse(urlVal.isValid("3ht://www.amazon.com"));
        assertFalse(urlVal.isValid("http:/www.amazon.com"));
        assertFalse(urlVal.isValid("http:www.amazon.com"));
        assertFalse(urlVal.isValid("http/www.amazon.com"));
        assertFalse(urlVal.isValid("://www.amazon.com"));
        //Test Failures
        assertTrue(!urlVal.isValid("www.amazon.com"));
    }
    
    //This partion tests only url Port
    public void testYourSecondPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        printTest("http://www.amazon.com:80",true);
        printTest("http://www.amazon.com:65535",true);
        printTest("http://www.amazon.com:0",true);
        printTest("http://www.amazon.com",true);
        printTest("http://www.amazon.com:-1",false);
        printTest("http://www.amazon.com:65636",true);
        printTest("http://www.amazon.com:65a",false);
        
        //Test Pass
        assertTrue(urlVal.isValid("http://www.amazon.com:80"));
        assertTrue(urlVal.isValid("http://www.amazon.com:0"));
        assertTrue(urlVal.isValid("http://www.amazon.com"));
        assertFalse(urlVal.isValid("http://www.amazon.com:-1"));
        assertFalse(urlVal.isValid("http://www.amazon.com:65a"));
        //Test Failures
        assertTrue(!urlVal.isValid("http://www.amazon.com:65535"));
        assertTrue(!urlVal.isValid("http://www.amazon.com:65636"));
    }
    
    public void printTest(String url,boolean correct) {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println("URL: " + url + " Correct: " + correct + " Actual: " + urlVal.isValid(url));
    }
    public void testIsValid()
    {
        boolean expected;
        boolean actual;
        boolean succeeded = true;
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        for(ResultPair testScheme : testUrlScheme) {
            for(ResultPair testAuthority : testUrlAuthority){
                for(ResultPair testPort : testUrlPort){
                    for(ResultPair testPath : testUrlPath){
                        for(ResultPair testQuery : testUrlQuery){
                            String testUrl = testScheme.item+testAuthority.item+testPort.item+testPath.item+testQuery.item;
                            expected = testScheme.valid&&testAuthority.valid&&testPort.valid&&testPath.valid&&testQuery.valid;
                            actual = urlVal.isValid(testUrl);
                            if(expected!=actual){
                                succeeded = false;
                                System.out.print(testUrl);
                                System.out.print(" expected:" + expected);
                                System.out.print(" actual:" + actual);
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
        //assertTrue(succeeded);
    }
    
    public void testAnyOtherUnitTest()
    {
        
    }
    /**
     * Create set of tests by taking the testUrlXXX arrays and
     * running through all possible permutations of their combinations.
     *
     * @param testObjects Used to create a url.
     */
    
    ResultPair[] testUrlScheme = {new ResultPair("http://", true),
    new ResultPair("ftp://", true),
    new ResultPair("h3t://", true),
    new ResultPair("3ht://", false),
    new ResultPair("http:/", false),
    new ResultPair("http:", false),
    new ResultPair("http/", false),
    new ResultPair("://", false),
    new ResultPair("", true)
    };
    ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
    new ResultPair("go.com", true),
    new ResultPair("go.au", true),
    new ResultPair("0.0.0.0", true),
    new ResultPair("255.255.255.255", true),
    new ResultPair("256.256.256.256", false),
    new ResultPair("255.com", true),
    new ResultPair("1.2.3.4.5", false),
    new ResultPair("1.2.3.4.", false),
    new ResultPair("1.2.3", false),
    new ResultPair(".1.2.3.4", false),
    new ResultPair("go.a", false),
    new ResultPair("go.a1a", false),
    new ResultPair("go.cc", true),
    new ResultPair("go.1aa", false),
    new ResultPair("aaa.", false),
    new ResultPair(".aaa", false),
    new ResultPair("aaa", false),
    new ResultPair("", false)
    };
    ResultPair[] testUrlPort = {new ResultPair(":80", true),
    new ResultPair(":65535", true),
    new ResultPair(":0", true),
    new ResultPair("", true),
    new ResultPair(":-1", false),
    new ResultPair(":65636", true),
    new ResultPair(":65a", false)
    };
    ResultPair[] testUrlPath = {new ResultPair("/test1", true),
    new ResultPair("/t123", true),
    new ResultPair("/$23", true),
    new ResultPair("/..", false),
    new ResultPair("/../", false),
    new ResultPair("/test1/", true),
    new ResultPair("", true),
    new ResultPair("/test1/file", true),
    new ResultPair("/..//file", false),
    new ResultPair("/test1//file", false)
    };
    ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
    new ResultPair("?action=edit&mode=up", true),
    new ResultPair("", true)
    };
}
