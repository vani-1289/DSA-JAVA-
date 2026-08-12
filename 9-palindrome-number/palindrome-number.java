class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        //to remove the num<0
        if(x<0){
            return false;
        }
        //finding the reverse
        while(temp!=0){
            int rem=temp%10;
            rev=(rev*10)+rem;
            temp=temp/10;
        }
        //test whether its pallindrome or not
        if(rev==x){
            return true;
        }
        else{
            return false;
        }
        
    }
}