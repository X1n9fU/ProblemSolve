import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s<n) return new int[]{-1};
        int index=0;
        while (n>0){
            int amount = s/n;
            answer[index++] = amount;
            s-=amount;
            n--;
        }
        return answer;
    }
}