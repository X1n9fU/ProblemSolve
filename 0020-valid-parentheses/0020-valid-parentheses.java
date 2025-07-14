import java.util.*;


class Solution {
    public boolean isValid(String s) {
        char [] stack = new char[s.length()];
        int index = -1;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack[++index] = ')';
                case '{' -> stack[++index] = '}';
                case '[' -> stack[++index] = ']';
                default -> {
                    if (index == -1 || stack[index] != c) return false;
                    index--;
                }
            }
        }
        if (index != -1) return false;
        return true;
    }

}