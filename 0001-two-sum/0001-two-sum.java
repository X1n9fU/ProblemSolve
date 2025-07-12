class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int minus = target - nums[i];
            if (hm.containsKey(minus)) {
                // int index = hm.get(minus);
                // return i < index ? new int[] {i, index} : new int[] {index, i};
                return new int[] {hm.get(minus), i};
            } else hm.put(nums[i], i);
        }
        return null;
    }
}