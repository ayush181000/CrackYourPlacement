public class Ques2 {

    public boolean backspaceCompare(String s, String t) {
        int s_pointer = s.length() - 1;
        int t_pointer = t.length() - 1;
        int s_skips = 0;
        int t_skips = 0;
        while (s_pointer >= 0 || t_pointer >= 0) {
            while (s_pointer >= 0) {
                if (s.charAt(s_pointer) == '#') { // found backspace
                    s_skips++;
                    s_pointer--;
                } else if (s_skips > 0) { // found non backspace char
                    s_skips--;
                    s_pointer--;
                } else
                    break;
            }
            while (t_pointer >= 0) {
                if (t.charAt(t_pointer) == '#') { // found backspace
                    t_skips++;
                    t_pointer--;
                } else if (t_skips > 0) { // found non backspace char
                    t_skips--;
                    t_pointer--;
                } else
                    break;
            }
            if (s_pointer >= 0 && t_pointer >= 0 && s.charAt(s_pointer) != t.charAt(t_pointer))
                return false;
            if (s_pointer >= 0 != t_pointer >= 0)
                return false;
            s_pointer--;
            t_pointer--;
        }
        return true;
    }
}
