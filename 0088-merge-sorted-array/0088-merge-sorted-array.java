class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i=0; i<nums2.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        //새로운 배열에 merge sort로 정렬

        int [] result = new int[m+n];
        int one = 0;
        int two = 0;
        int index=0;
        while (one < m && two < n) {
            if (nums1[one] <= nums2[two]){
                result[index] = nums1[one++];
            } else {
                result[index] = nums2[two++];
            }
            index++;
        }

        if (one == m) {
            int end = n-two;
            for (int i=0; i<end; i++) {
                result[index+i] = nums2[two+i];
            }
        }

        if (two == n) {
            int end = m-one;
            for (int i=0; i<end; i++) {
                result[index+i] = nums1[one+i];
            }
        }

        for (int i=0; i<m+n; i++){
            nums1[i] = result[i];
        }
    }
}