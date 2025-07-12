import java.util.Stack;
import java.util.Objects;

class Solution {
    boolean solution(String s) {
        // ( = 0 , ) = 1
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        
        if (!st.isEmpty()) return false;
        return true;
    }
}