
class Trash {

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }
}
