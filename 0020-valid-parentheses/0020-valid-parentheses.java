import java.util.*;


class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') st.push(1);
            else if (c=='{') st.push(2);
            else if (c=='[') st.push(3);
            else {
                if (!st.isEmpty()) {
                    int close = st.pop();
                    if (c==')' && close != 1) return false;
                    else if (c == '}' && close != 2 ) return false;
                    else if (c==']' && close != 3) return false;
                } else return false;
            }
        }
        if (!st.isEmpty()) return false;

        return true;
    
    }

}