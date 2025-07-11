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

        for (int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }


    //     int indexOfNums1 = 0;
    //     int indexOfNums2 = 0;
    //     /*
    //     num1과 num2를 차례대로 비교
    //     만약 num2가 더 작다면 비교한 것에 넣고,
    //     넣을 곳 뒤에 숫자들(m - 확인한 인덱스)은 그만큼 밀림
    //     만약 num1를 다 확인했는데 num2가 남았다면 그대로 순차대로 num1에 덮어쓰기
    //     */

    //     while (indexOfNums1 < m+n) {
    //         if (nums1[indexOfNums1] == 0 && indexOfNums > m) {
    //             break;
    //         }
    //         if (nums1[indexOfNums1] > nums2[indexOfNums2]) { 
    //             for (int i=0; i<m-indexOfNums1; i++){
    //                 nums1[indexOfNums1+1] = temp;
    //                 temp = nums1[indexOfNums1+1];
    //                 nums1[indexOfNums1+1] = nums1[indexOfNums1];
    //             }
    //             nums1[indexOfNums1] = nums2[indexOfNums2];
    //             indexOfNums2++;
    //         }
    //         indexOfNums1++;
    //     }


    //     int temp = 0;
    //     boolean pass = false;
    //     while (indexOfNums1 < m+n) {
    //         if (nums1[indexOfNums1] == 0 && indexOfNums1 >= m || indexOfNums2 >= n) {
    //             break;
    //         }
    //         if (nums1[indexOfNums1] <= nums2[indexOfNums2]) {
    //             indexOfNums1 ++;
    //         } else {
    //             for (int i=0; i<m+n-indexOfNums1-1; i++){
    //                 temp = nums1[indexOfNums1+1+i];
    //                 nums1[indexOfNums1+1+i] = nums1[indexOfNums1+i];
    //             }
    //             nums1[indexOfNums1] = nums2[indexOfNums2];                
    //             indexOfNums1++;
    //             indexOfNums2++;
    //         }
    //     }

    //     if (indexOfNums2 < n){
    //         for (int i=0; i<n-indexOfNums2; i++) {
    //             System.out.println(indexOfNums1);
    //             System.out.println(indexOfNums2);
    //             nums1[indexOfNums1+i] = nums2[indexOfNums2+i];
    //         }
    //     }
    // }
}