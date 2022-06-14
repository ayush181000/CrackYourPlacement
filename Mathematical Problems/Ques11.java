public class Ques11 {

}

class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }

    private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return (distance(p1, p2) > 0 &&
                distance(p1, p3) > 0 &&
                distance(p1, p2) == distance(p2, p3) &&
                distance(p2, p3) == distance(p3, p4) &&
                distance(p3, p4) == distance(p4, p1) &&
                // for diagonal elements
                distance(p1, p3) == distance(p2, p4));
    }

    private int distance(int[] x, int[] y) {
        int dx = (y[0] - x[0]) * (y[0] - x[0]);
        int dy = (y[1] - x[1]) * (y[1] - x[1]);
        int dist = dx + dy;
        return dist;
    }
}
