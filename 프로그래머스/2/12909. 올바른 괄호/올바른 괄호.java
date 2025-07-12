import java.util.Stack;
import java.util.Objects;

class Solution {
    boolean solution(String s) {
        int left = 0;
        int right = 0;
        if (s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right ++;
            }
            if (right > left) return false;
        }
        return left == right;
    }
}