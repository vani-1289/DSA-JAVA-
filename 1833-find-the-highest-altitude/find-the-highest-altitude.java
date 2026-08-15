class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;    
        int[] alt = new int[n+1];  //prefix sum array 

        for (int i = 0; i < n ;i++){
            alt[i+1] = alt[i] + gain[i];
        }

        int max = alt[0];

        for(int i = 1;i<alt.length;i++){
            max = Math.max(max,alt[i]);
        }

      return max;
    }
}