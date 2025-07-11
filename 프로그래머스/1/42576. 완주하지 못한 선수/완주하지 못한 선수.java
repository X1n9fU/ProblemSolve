import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> numOfCompletion = new HashMap<>();
        
        for (int i=0; i<completion.length; i++) {
            String name = completion[i];
            int num = 1;
            if (numOfCompletion.containsKey(name)){
                num = numOfCompletion.get(name) + 1;
            }
            numOfCompletion.put(name, num);
        }
        
        String result = "";
        for (int i=0; i<participant.length; i++) {
            String name = participant[i];
            if (numOfCompletion.containsKey(name)) {
                int num = numOfCompletion.get(name) - 1;
                if (num == 0) { //모든 참여자 확인 
                    numOfCompletion.remove(name);
                } else { //아직 동명이인 존재
                    numOfCompletion.put(name, num);
                }
            } else {
                result = name;
                break;
            }
        }
        
        return result;
    }
}