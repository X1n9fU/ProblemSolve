import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int index=0; index<commands.length; index++) {
            int [] temp = commands[index];
            int i=temp[0];
            int j=temp[1];
            int k=temp[2];
            int [] cut = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(cut);
            answer[index] = cut[k-1];                        
        }
        return answer;
    }
}