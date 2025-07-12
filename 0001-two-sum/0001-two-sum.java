class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] answer = {};
        for (int i=1; i<nums.length; i++) { // 현재 확인하는 인덱스에서 i만큼 전에 위치한 값
            for (int j=i; j<nums.length; j++) { // 현재 확인하는 인덱스
                if (nums[j] + nums[j-i] == target) {
                    answer = new int [] {j-i, j};
                    break;
                }
            }
        }
        return answer;
    }
}