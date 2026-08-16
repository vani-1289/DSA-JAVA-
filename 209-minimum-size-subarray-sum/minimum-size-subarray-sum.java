class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int minlength = Integer.MAX_VALUE;

        for(int right = 0; right<nums.length;right++){
       
        //expand the window
            total= total + nums[right];

        //shrink the window
        while(total >= target){

            minlength = Math.min(minlength,right-left+1);  //calculating the current length of the subarray

            total = total - nums[left];  //shrinking the window as possible 
            left++;   
        }
        }
        //if there is no such subarray
        if(minlength == Integer.MAX_VALUE){
            return 0;
        }
        return minlength;   
    }
}