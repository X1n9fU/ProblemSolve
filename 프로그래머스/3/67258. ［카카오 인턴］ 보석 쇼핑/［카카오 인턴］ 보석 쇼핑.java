import java.util.*;

class Solution {
    public int SIZE = 100000;
    public int[] solution(String[] gems){
        int len = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> sequence = new HashMap<>();
        int [] answer = new int[2];
        int start = 0;
        for (int end=0; end<gems.length; end++){
            sequence.put(gems[end], sequence.getOrDefault(gems[end], 0) + 1);

            while (sequence.get(gems[start]) > 1){
                sequence.put(gems[start], sequence.get(gems[start]) -1);
                start ++;
            }
            if (sequence.size() == len && (end - start) < SIZE){
                SIZE = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }

        }
        return answer;
    }
}