class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;    
        int[] alt = new int[n+1];  //prefix sum array 
        for (int i = 0; i < n ;i++){
            alt[i+1] = alt[i] + gain[i];
        }
        int maximum = alt[0];
        for(int i = 1;i<alt.length;i++){
            maximum = Math.max(maximum,alt[i]);
        }

return maximum;

     //     int alt = 0;                     //(Brute force) time complexity O(n^2)
    //     int max = 0;

    //     for (int i = 0; i < gain.length; i++) {
    //         alt += gain[i];
    //         max = Math.max(max, alt);
    //     }

    //     return max;
    
    }
}