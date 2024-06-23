import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int length = A.length;
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int index = -1;

        for (int i=0; i<length; i++) {
            for (int k = index + 1; k < length; k++) {
                if (B[i] > A[k]) {
                    index = k;
                    answer ++;
                    break;
                }
            }
        }

        return answer;
    }
}