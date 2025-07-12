import java.util.Stack;
import java.util.Objects;

class Solution {
    boolean solution(String s) {
        int left = 0;
        int right = 0;
        for (int i=0; i<s.length(); i++) {
            if ((i==0 && s.charAt(i) == ')') ||
                    (i==s.length()-1 && s.charAt(i) == '(')) {
                return false;
            }
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