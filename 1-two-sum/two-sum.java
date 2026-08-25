class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++)
       {
        int require = target - nums[i]; // as current + require = target
        if(map.containsKey(require))
        {
            return new int[]{map.get(require),i}; // returnig the indexes
        }
        map.put(nums[i],i);
       }
       return new int[]{};
    }
}
