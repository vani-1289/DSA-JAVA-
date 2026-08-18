class NumArray {
    int[] prefix;
    //prefix sum array is used to store the sum of element from begining of the array up to each position or index
    //so that later range sums can be calculated quickly.
    public NumArray(int[] nums) {
         prefix = new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return(prefix[right+1]-prefix[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */