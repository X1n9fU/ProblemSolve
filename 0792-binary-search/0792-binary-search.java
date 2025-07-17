class Solution {
    static int answer = -1;
    public int search(int[] nums, int target) {
        int middle = nums.length/2;
        System.out.println("middle : " + middle + "length :" + nums.length);
        if (nums.length == 0) {
            answer = -1;
            return answer;
        }
        if (nums.length == 1) {
            if (nums[0] == target) return middle;
            else answer = -1;
            return answer;
        }
        if (nums[middle] == target) return middle;
        else if (nums[middle] < target) {
            int temp = search(Arrays.copyOfRange(nums, middle, nums.length), target);
            if (temp != -1) answer = temp + middle;
        }
        else if (nums[middle] > target) answer = search(Arrays.copyOfRange(nums, 0, middle), target);
        System.out.println(answer);
        return answer;
    }
}