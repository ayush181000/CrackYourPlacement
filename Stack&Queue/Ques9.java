import java.util.*;

public class Ques9 {

}

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }

        return answer;
    }
}

// stack solution
// using index number instead of actual values
class Solution2 {

    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        res[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            res[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

// iterative solution
// O(n2)
class Solution3 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int val = 0;
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
