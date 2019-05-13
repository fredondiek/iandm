/*
 * The MIT License
 *
 * Copyright 2019 FMarube.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iandm.app;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author FMarube
 */
public class Memoization {
    
    private static  Map<Integer, Boolean> memoizeTable = new HashMap<>(); // O(1)
    
    static boolean isPrime(int n, int i) {

        // Base cases 
        if (n <= 2) {
            return (n == 2) ? true : false;
        }
        if (n % i == 0) {
            return false;
        }        
        
        if (i * i > n) {
            return true;
        }
      
        // Check for next divisor 
        return isPrime(n, i + 1);
    }
    
    // Fibonacci with Memoization
    public static boolean isPrimeMemoize(int n,int i) {

        // Base cases 
        if (n <= 2) {
            return (n == 2) ? true : false;
        }
        if (n % i == 0) {
            return false;
        }        
        
        if (i * i > n) {
            return true;
        }
        
        if (memoizeTable.containsKey(n)) {
            System.out.println("Getting value from computed result for " + n);
            return memoizeTable.get(n);
        }
        // Check for next divisor 

        boolean result = isPrime(n, i + 1);

        System.out.println("Putting result in cache for " + n);
        memoizeTable.put(n, result);

        return result;
    }
    
    
    public static void main(String... args){
        System.out.println(isPrimeMemoize(10,2));
    }
    
    

     
    
}
