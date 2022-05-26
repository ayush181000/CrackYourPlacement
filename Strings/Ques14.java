package Strings;

import java.util.Stack;

public class Ques14 {

}

class Solution {

    public int calculate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char lastOp = '+';
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + Character.getNumericValue(currChar);
            }

            if ((!Character.isDigit(currChar) && !Character.isWhitespace(currChar)) || i == length - 1) {
                switch (lastOp) {
                    case '+':
                        stack.push(currNum);
                        break;
                    case '-':
                        stack.push(-currNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * currNum);
                        break;
                    case '/':
                        stack.push(stack.pop() / currNum);
                        break;
                }
                lastOp = currChar;
                currNum = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
