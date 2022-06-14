public class Ques9 {

}

class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        }

        while (n > 0) {
            n = n / 2;
            if (n % 2 != 0) {
                return false;
            }
            if (n == 2) {
                return true;
            }
        }
        return false;
    }
}
