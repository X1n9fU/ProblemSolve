class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=1; i<nums.length; i++) { //배열 내 숫자들의 사이값
            for (int j=i; j<nums.length; j++) {
                if (nums[j] + nums[j-i] == target) {
                    return new int [] {j-i, j};
                }
            }
        }
        return null;
    }
}