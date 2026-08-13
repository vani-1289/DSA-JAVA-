class Solution {

    static void sol(int index,String digits,StringBuilder temp,List<String> ans,Map <Integer,String> mp){
        int size = digits.length();
        if(index >= size){
            ans.add(temp.toString());
            return;
        }
        String z = mp.get(digits.charAt(index)-'0');
        for(int i = 0; i < z.length(); i++){
            temp.append(z.charAt(i));
            sol(index + 1,digits,temp,ans,mp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map <Integer,String> mp = new HashMap<>();
        mp.put  (2,"abc");
        mp.put  (3,"def");
        mp.put  (4,"ghi");
        mp.put  (5,"jkl");
        mp.put  (6,"mno");
        mp.put  (7,"pqrs");
        mp.put  (8,"tuv");
        mp.put  (9,"wxyz");
          

        List<String> ans = new ArrayList<>();
        StringBuilder temp= new StringBuilder();
        sol(0,digits,temp,ans,mp);
        return ans;
        
        
    }


}