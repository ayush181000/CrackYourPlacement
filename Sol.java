import java.util.Arrays;

public class Sol {
    public static void main(String[] args) {
        System.out.println(smallestWindow(new String("timetopractice"), new String("toc")));
    }

    public static String smallestWindow(String s, String p) {
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        int[] sArr = new int[26];
        int size = Integer.MAX_VALUE;
        String ans = "";

        while (j < s.length()) {
            sArr[s.charAt(j) - 'a']++;
            if (equals(sArr, pArr)) {
                System.out.println("in if");
                while (equals(sArr, pArr)) {
                    sArr[s.charAt(i) - 'a']--;
                    i++;
                }
                if (j - i < size) {
                    size = j - i;
                    ans = s.substring(i, j + 1);
                }
                i = j;
            }
            j++;
        }

        return ans;
    }

    public static boolean equals(int[] s, int[] p) {

        for (int i = 0; i < 26; i++) {
            if (p[i] != 0 && p[i] != s[i]) {
                return false;
            }
        }
        return true;
    }

}