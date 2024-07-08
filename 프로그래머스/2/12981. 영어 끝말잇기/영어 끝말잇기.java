import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int countOfWords = words.length;
        int fail = 0;
        Set<String> wordDic = new HashSet<>();
        wordDic.add(words[0]);
        for (int i = 0; i < countOfWords -1 ; i++) {
            int end = words[i].length();
            if (words[i].substring(end-1, end).equals(words[i+1].substring(0,1))){
                if (wordDic.contains(words[i+1])){
                    fail = i+1;
                    break;
                }
                else wordDic.add(words[i+1]);
            } else {
                fail = i+1;
                break;
            }
        }

        if (fail != 0){
            fail += 1;
            answer[1] = (int) Math.ceil((double) fail/n);
            if (fail % n == 0) answer[0] = n;
            else answer[0] = fail%n;

        }

        return answer;
    }
}