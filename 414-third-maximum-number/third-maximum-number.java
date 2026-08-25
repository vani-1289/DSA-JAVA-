class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> hs = new TreeSet<>();  // ordered ascending

        int count = 0;
        int abhi = 0;   // will store 3rd max
        int vani = 0;   // will store max

        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        // iterate from largest to smallest
        Iterator<Integer> it = hs.descendingIterator();

        while (it.hasNext()) {
            int no = it.next();
            count++;

            if (count == 3) {
                abhi = no;   // 3rd max
            }

            if (count == 1) {
                vani = no;   // max
            }
        }

        if (hs.size() < 3) {
            return vani;   // return max if no 3rd max
        }

        return abhi;
    }
}
