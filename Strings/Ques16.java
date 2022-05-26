package Strings;

import java.util.*;

public class Ques16 {

    public Map<Integer, String> mapToWord = new HashMap<>();

    Ques16() {
        mapToWord.put(0, "");
        mapToWord.put(1, "One");
        mapToWord.put(2, "Two");
        mapToWord.put(3, "Three");
        mapToWord.put(4, "Four");
        mapToWord.put(5, "Five");
        mapToWord.put(6, "Six");
        mapToWord.put(7, "Seven");
        mapToWord.put(8, "Eight");
        mapToWord.put(9, "Nine");
        mapToWord.put(10, "Ten");
        mapToWord.put(11, "Eleven");
        mapToWord.put(12, "Twelve");
        mapToWord.put(13, "Thirteen");
        mapToWord.put(14, "Fourteen");
        mapToWord.put(15, "Fifteen");
        mapToWord.put(16, "Sixteen");
        mapToWord.put(17, "Seventeen");
        mapToWord.put(18, "Eighteen");
        mapToWord.put(19, "Nineteen");
        mapToWord.put(20, "Twenty");
        mapToWord.put(30, "Thirty");
        mapToWord.put(40, "Forty");
        mapToWord.put(50, "Fifty");
        mapToWord.put(60, "Sixty");
        mapToWord.put(70, "Seventy");
        mapToWord.put(80, "Eighty");
        mapToWord.put(90, "Ninety");
    }

    // Time Complexity O(1) number of digits in the num is limited
    // Space Complexity O(1) the StringBuilder is for generating the output only
    public String numberToWords(int num) {
        // corner case
        if (num == 0) {
            return "Zero";
        }

        int units = num % 1000;

        int thousands = 0;
        int millions = 0;
        int billions = 0;

        num = num / 1000;
        if (num > 0) {
            thousands = num % 1000;
            num = num / 1000;
        }
        if (num > 0) {
            millions = num % 1000;
            num = num / 1000;
        }
        if (num > 0) {
            billions = num % 1000;
            num = num / 1000;
        }

        StringBuilder sb = new StringBuilder();

        if (billions > 0) {
            sb.append(toWord(billions) + " Billion ");
        }

        if (millions > 0) {
            sb.append(toWord(millions) + " Million ");
        }

        if (thousands > 0) {
            sb.append(toWord(thousands) + " Thousand ");
        }

        sb.append(toWord(units));

        // remove unnecessary spaces at the end
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public String toWord(int num) { // num will be < 1000
        int units = num % 100;
        int hundreds = num / 100;

        StringBuilder sb = new StringBuilder();
        if (hundreds > 0) {
            sb.append(mapToWord.get(hundreds) + " Hundred ");
        }

        if (units > 20) {
            int subunits = units % 10;
            units = units / 10 * 10;
            sb.append(mapToWord.get(units) + " " + mapToWord.get(subunits));
        } else {
            sb.append(mapToWord.get(units));
        }

        // remove unnecessary spaces at the end
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
