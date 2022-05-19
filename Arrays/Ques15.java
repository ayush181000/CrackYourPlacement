package Arrays;

public class Ques15 {

}

class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftScore = 0, rightScore = 0;

        // take 1st k points
        for (int i = 0; i < k; i++)
            leftScore += cardPoints[i];

        // assign it to maxScore
        int maxScore = leftScore;

        // if k is same as points array length, return here
        if (n == k)
            return maxScore;

        // now we are going to drop one point on the left and take one point on the
        // right
        for (int i = 0; i < k; i++) {
            leftScore = leftScore - cardPoints[k - 1 - i];
            rightScore = rightScore + cardPoints[n - 1 - i];

            // find the max for every combination on this loop
            maxScore = Math.max(maxScore, leftScore + rightScore);
        }

        // return the max score we found on this combination
        return maxScore;
    }
}
