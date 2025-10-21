class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,0, new ArrayList<>() ,result);  
        return result;
    }
    public void helper(int[] nums, int idx, List<Integer> curr , List<List<Integer>> result){
        if(idx==nums.length){
            result.add(new ArrayList<>(curr));
            return ;
        }
        helper(nums,idx+1,curr,result);
        curr.add(nums[idx]);
        helper(nums,idx+1,curr,result);
        curr.remove(curr.size() - 1);
    }
}