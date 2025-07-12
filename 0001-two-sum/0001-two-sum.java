class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int minus = target - nums[i];
            if (hm.containsKey(minus)) {
                // return i < index ? new int[] {i, index} : new int[] {index, i};
                return new int[] {i, hm.get(minus)};
            } else hm.put(nums[i], i);
        }
        return null;
    }
}