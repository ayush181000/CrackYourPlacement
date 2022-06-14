public class Ques5 {

}

// optimized version
class Solution {

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = getNext(n);
        }
        return n == 1;
    }
}
// my solution

// class Solution {
// public boolean isHappy(int n) {
// ArrayList<Integer> list = new ArrayList<>();
// while (true) {
// int y = operation(n);
// if (y == 1) {
// return true;
// } else {
// if (list.contains(y)) {
// return false;
// } else {
// list.add(y);
// }
// }
// n = y;
// }
// }
// public int operation(int n) {
// int sum = 0;
// while (n > 0) {
// sum += (int) Math.pow(n % 10, 2);
// n = n / 10;
// }
// return sum;
// }
// }
