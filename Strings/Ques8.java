
import java.util.ArrayDeque;
import java.util.Deque;

public class Ques8 {

}

class Solution {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

        if (stack.size() == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        while (stack.size() > 0) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}