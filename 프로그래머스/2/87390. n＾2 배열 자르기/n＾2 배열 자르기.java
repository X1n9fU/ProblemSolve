import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        if (n==1) return new int[]{1};

        int [] array = new int[(int) (right-left+1)];

        int index = 0;
        for (long i = left; i<=right; i++){
            int num = (int) ((i / n) + 1);
            if (i % n < num){
                array[index] = num;
            } else {
                array[index] = (int) (i % n) + 1;
            }
            index ++;
        }
        return array;
    }
}