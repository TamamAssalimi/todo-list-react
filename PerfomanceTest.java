package com.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User  : tamam
 * Date  : 31/05/20
 * Time  : 15.22
 * Email : tamam.assalimi@gmail.com
 */

public class PerfomanceTest {

    public static void main(String[] args) {

        // Performance Test 1: Origami
        List<Map<String, Object>> list = new ArrayList<>();
        int n = 9;
        float height = 20;
        float weight = 20;
        origamiLipat(0, n, height, weight, list);
        System.out.println(list);

        // Performance Test 2: Optimus Prime
        getPrime(1000000);
    }

    private static void origamiLipat(int index, int n, float height, float weight, List<Map<String, Object>> list) {
        Map<String, Object> map = new HashMap<>();
        if (index < n) {
            index++;
            height = height / 2;
            map.put("n", index);
            map.put("height", height);
            map.put("weight", weight);
            list.add(map);
        }
        Map<String, Object> map1 = new HashMap<>();
        if (index < n) {
            index++;
            weight = weight / 2;
            map1.put("n", index);
            map1.put("height", height);
            map1.put("weight", weight);
            list.add(map1);
        }
        if (index != n)
            origamiLipat(index, n, height, weight, list);
    }

    private static void getPrime(int n) {
        if (n < 2 || n > 1000000)
            return;
        for (int i = 2; i < n; i++)
            if (isPrime(i))
                System.out.println(i);

    }

    public static boolean isPrime(int num){
        if ( num > 2 && num%2 == 0 ) return false;
        int top = (int)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2) if (num % i == 0) return false;
        return true;
    }

}
