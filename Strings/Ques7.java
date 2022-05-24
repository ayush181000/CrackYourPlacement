package Strings;

import java.util.ArrayList;
import java.util.List;

public class Ques7 {

    public static void main(String[] args) {
        print(generateParenthesis(3), 0);
    }

    public static void print(List<String> a, int index) {
        if ((a != null) && (index < a.size())) {
            System.out.println(a.get(index));
            print(a, ++index);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        helper("", 0, n, n, out);
        return out;
    }

    public static void helper(String asf, int balance, int open, int close, List<String> out) {
        if (open == 0 && close == 0) { // check to see that there is no left open or close brackets
            if (balance == 0) { // check if all the brackets are balances
                out.add(asf);
            }
            return;
        }

        if (balance == 0) {
            // if a string is balance, i.e balance == 0, then adding ')' will not add value
            // as it will not make the string balanced. but adding '(' will add a
            // possibility of getting balanced in future
            helper(asf + "(", balance + 1, open - 1, close, out);
        }

        else if (open == 0) {

            // if open == 0, means that we used all the open bracked like, for n = 2, the
            // string will look like '(('. so, after this can only consider the closing
            // brackets.
            helper(asf + ")", balance - 1, open, close - 1, out);
        }

        else {

            // exploring different possibilities
            helper(asf + "(", balance + 1, open - 1, close, out);
            helper(asf + ")", balance - 1, open, close - 1, out);
        }
    }
}