class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int [] answer = {};
        for (int i=0; i<nums.length; i++) {
            int minus = target - nums[i];
            if (hm.containsKey(minus)) {
                return new int[] {i, hm.get(minus)};
            } else hm.put(nums[i], i);
        }
        return answer; //출력값이 꼭 있기 때문에 null 처리
    }
}