public class Ques2 {

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        int i = 0;

        int al = a.length();
        int bl = b.length();

        while (i < al || i < bl || carry != 0) {
            int x = 0;
            if (i < al && a.charAt(al - i - 1) == '1') {
                x = 1;
            }
            int y = 0;
            if (i < bl && b.charAt(bl - i - 1) == '1') {
                y = 1;
            }

            ans.append((x + y + carry) % 2);
            carry = (x + y + carry) / 2;
            i++;
        }

        return ans.reverse().toString();
    }
}
