class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int [] answer = {};
        
        //HashMap에 넣는 과정
        for (int i=0; i<nums.length; i++) {
            hm.put(nums[i], i);
        }
		
        
        for (int i=0; i<nums.length; i++) {
            int minus = target - nums[i]; // x를 구하는 과정
            if (hm.containsKey(minus)) { //y를 찾는 과정
                int index = hm.get(minus);
                if (index == i) continue; // 동일한 인덱스는 포함하지 않는다.
                answer = i < index ? new int[] {i, index} : new int[] {index, i}; //인덱스를 올바르게 정렬
                break;
            }
        }
        return answer;
    }
}