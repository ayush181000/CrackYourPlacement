
public class Ques10 {

}

class Solution {

    public String reverseWords(String s) {
        String str1 = "";
        String str[] = s.split(" ");
        for (int i = str.length - 1; i >= 1; i--) {
            String st = "";
            if (!str[i].equals(st))
                str1 = str1 + " " + str[i];
        }
        if (!str[0].equals(""))
            str1 = str1 + " " + str[0];
        return str1.substring(1, str1.length());
    }
}
