class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{  //checking if there exists any cycle
            slow = findcycle(slow);     //it iterates by one element at once
            fast = findcycle(findcycle(fast)); //it iterates by two elememt at a time
        }
        while(slow!=fast);

        if(slow==1){   //checking if it's happy number or not
            return true;
        }
        return false;
    }
        private int findcycle(int num){
            int ans = 0;
            while(num > 0){
                int rem = num%10;
                ans += rem*rem;
                num/=10;
            }
            return ans;
        }
}