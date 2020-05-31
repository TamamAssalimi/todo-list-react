package com.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User  : tamam
 * Date  : 30/05/20
 * Time  : 21.45
 * Email : tamam.assalimi@gmail.com
 */

public class BackendTest {

    public static void main(String[] args) {
        //Perfect Two
        int[] array = {2, 7, 11, 15};
        int input = 13;
        System.out.println("perfect two : " + perfectTwo(array, input));

        //Hot Dog
        String[] strArray = {"hot", "dot", "dog", "lot", "log"};
        String inputHotDog = "hit dog";
        System.out.println("hot dog : " + hotDog(strArray, inputHotDog));

        //Programmer IT
        String[] strArrayProgram = {"pro", "gram", "merit", "program", "it", "programmer"};
        String inputProgram = "programit";
        System.out.print("programmer IT : \n" + programmerIt(strArrayProgram, inputProgram));

        //Hasil Palindrome Terbesar
        //Dengan berbekal input integer n sebagai jumlah digit (asumsikan n ≤ 4),Jika N> 4 maka return value 0
        int n = 4;
        System.out.println("highest palindrome result : " + palindromeHighestResult(n));

        //Jual-beli Saham
        int[] profitArray = {100, 90, 80, 75, 65};
        System.out.println("Highest profit : " + resultProfit(profitArray));

        //Angka ajaib, random number hanya terdiri dari 4 digit dengan angka ajaib adalah 6174
        int randomNumber = 9087;
        System.out.println("Angka ajaib : " + angkaAjaib(randomNumber));


    }

    private static String perfectTwo(int[] array, int input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++)
                if (input == array[i] + array[j]) {
                    result.add(i);
                    result.add(j);
                    break;
                }
            if (result.size() > 0)
                break;
        }
        if (result.size() > 0)
            return result.toString();
        return "<no way>";
    }

    private static String hotDog(String[] array, String input) {
        String[] strSplit = input.toLowerCase().split(" ");
        List<String> strList = Arrays.asList(array);
        List<String> result = new ArrayList<>();
        if (strSplit.length != 2 || array.length != 5)
            return "<no way>";
        boolean isValidOne = false;
        boolean isValidTwo = false;
        for (int i = 0; i < strList.size(); i++) {
            if (!strList.contains(strSplit[0])) {
                for (int j = 0; j < strSplit[0].length(); j++) {
                    String temp = strSplit[0];
                    if (temp.replace(strSplit[0].charAt(j), strList.get(i).charAt(j)).equals(strList.get(i))) {
                        result.add(strSplit[0]);
                        strSplit[0] = strList.get(i);
                        result.add(strSplit[0]);
                        isValidOne = true;
                        break;
                    }
                }
            } else {
                if (isValidOne && !isValidTwo)
                    result.add(strList.get(i));
                if (strSplit[0].equals(strList.get(i)) && !isValidOne) {
                    result.add(strList.get(i));
                    isValidOne = true;
                }
            }
            if (!strList.contains(strSplit[1])) for (int j = 0; j < strSplit[1].length(); j++) {
                String temp = strSplit[1];
                if (temp.replace(strSplit[1].charAt(j), strList.get(i).charAt(j)).equals(strList.get(i))) {
                    result.add(strSplit[1]);
                    strSplit[1] = strList.get(i);
                    isValidTwo = true;
                    break;
                }
            }
            else if (strList.get(i).equals(strSplit[1]) && !isValidTwo) isValidTwo = true;
        }
        if (result.size() > 0 && isValidOne && isValidTwo)
            return result.toString();
        return "<no way>";
    }

    private static String programmerIt(String[] array, String input) {
        StringBuilder result = new StringBuilder();
        boolean isValid = false;
        for (String value : array) {
            if (input.length() > value.length()) {
                if (input.toLowerCase().substring(0, value.length()).equals(value)) {
                    result.append(value);
                    int k = value.length();
                    for (String s : array) {
                        if (k + s.length() <= input.length()) {
                            isValid = false;
                            if (input.substring(k, k + s.length()).equals(s)) {
                                result.append(",").append(s);
                                k = k + s.length();
                                isValid = true;
                            }
                        }
                    }
                    result.append("\n");
                }
            } else if (input.length() == value.length()) {
                result.append(value);
                result.append("\n");
                isValid = true;
            }
        }
        if (isValid)
            return result.toString();
        return "<no way>";
    }

    static int palindromeHighestResult(int n) {
        if (n > 4)
            return 0;
        int maximumValue = 0;
        for (int i = 1; i <= n; i++) {
            maximumValue *= 10;
            maximumValue += 9;
        }
        int minimumValue = 1 + maximumValue / 10;
        int palindromeResult = 0;
        for (int i = maximumValue; i >= minimumValue; i--)
            for (int j = i; j >= minimumValue; j--) {
                int item = i * j;
                if (item < palindromeResult)
                    break;
                int number = item;
                int reverse = 0;
                while (number != 0) {
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }
                if (item == reverse && item > palindromeResult)
                    palindromeResult = item;
            }
        return palindromeResult;
    }

    private static String resultProfit(int[] arrayPrice) {
        int result = highestProfit(arrayPrice, arrayPrice.length - 1);
        if (result > 0)
            return String.valueOf(result);
        return "Harga selalu turun";
    }

    private static int highestProfit(int[] arrayPrice, int end) {
        int profit = 0;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arrayPrice[j] > arrayPrice[i]) {
                    int profitCount = arrayPrice[j] - arrayPrice[i];
                    profit = Math.max(profit, profitCount);
                }
            }
        }
        return profit;
    }

    private static int angkaAjaib(int input) {
        if (String.valueOf(input).length() != 4)
            return 0;
        return findKaperkasConstant(input, 0);
    }

    private static int findKaperkasConstant(int input, int kaprekars) {
        String strInput = String.valueOf(input);
        char[] array = strInput.toCharArray();
        Arrays.sort(array);
        StringBuilder asc = new StringBuilder();
        StringBuilder desc = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            asc.append(array[i]);
            desc.append(array[array.length - 1 - i]);
        }
        int result = Integer.parseInt(desc.toString()) - Integer.parseInt(asc.toString());
        System.out.println(desc + "-" + asc + "=" + result);
        kaprekars++;
        if (result == 6174)
            return kaprekars;
        return findKaperkasConstant(result, kaprekars);
    }

}
