public class Ques6 {

}

class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String num = String.valueOf(x);

        return palindromeCheck(num);
    }

    public boolean palindromeCheck(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}