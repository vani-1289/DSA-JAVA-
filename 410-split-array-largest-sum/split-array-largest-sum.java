class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]);
            //in the end of the loop this will contain the max item from the arr
            end += nums[i];
        }
        
            //binary search
            while(start<end){
                int mid = start + (end-start)/2;

            //calculate the number of piecesyou can divide this in with the max sum(mid)
            int sum = 0;
            int pieces = 1;  //pieces should initally be 1 

            for(int num : nums){
                if(sum+num > mid){
            //in this case u cant add in this subarr,make a new one since the sum+num exceeds max & mid
            //if u add this num in new subarr the sum == num
                  sum = num;
                  pieces++;   //hence the new subarr is formed
                  }   
                  else{
                    sum += num;
                  }
            }
            if(pieces > k){    //we need to take the sum a little high,(search in the right part)
                  start = mid+1;   // need bigger sum
            }
            else{
                end = mid;   //try smaller sum
                //here the pieces <= m so individual values are greater,(search in the left part)
                //needs to take a little more num of pieces
            }

        }
        return end; //since start==end==mid
    }
}
        
