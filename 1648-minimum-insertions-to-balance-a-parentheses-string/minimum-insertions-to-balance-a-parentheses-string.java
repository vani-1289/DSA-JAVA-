class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertion = 0;

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='('){     //case 1:opening brackets
                open++;
            }
            else{
                if(i+1<s.length() && s.charAt(i+1) == ')'){   //case 2: closing brackets
                    i++;         //we already have one ')'
                }
                else{            //if only one is present so insert another')'
                    insertion++;
                }

                if(open >0){  //this '))' must match an opening '('
                open--;
                }
                else{              //NO '(' available,so insert '('
                insertion++;
                }
            }

        }
        insertion += 2*open; //every remaining '(' needs two '))'
        return insertion;
        
    }
}