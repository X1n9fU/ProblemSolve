import java.util.*;

public class Solution {
    public String solution(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
        }
}