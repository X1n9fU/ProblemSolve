import java.util.*;

class Solution {
    public int[] solution(String s) {
        String [] tuples = divide(s);
        Arrays.sort(tuples, Comparator.comparingInt(String::length));
        int [] answer = new int[tuples.length];
        ArrayList<String> number = new ArrayList<>();
        int index=0;
        for (String tuple : tuples) {
            String[] num = tuple.split(",");
            for (String n : num){
                if (!number.contains(n)) {
                    number.add(n);
                    answer[index++] = Integer.parseInt(n);
                }
            }
        }
        return answer;
    }

    private String[] divide(String s){
        s = s.substring(2, s.length()-2);
        return s.split("},\\{");
    }
}