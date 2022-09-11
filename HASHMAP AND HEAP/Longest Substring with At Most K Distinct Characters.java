public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(k==0){
            return 0;
        }
          int ansSize=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int i=0;int j=0;int uc=0;
      
        while(true)
        {
            boolean flag1=false;
            boolean flag2=false;
          // Acquire Till The Answer Is A Valid
          while(i<s.length())
          {
                char ch=s.charAt(i);
                if(map.containsKey(ch)==false){
                        uc++;
                }
                if(uc>k)
                {
                    uc--;
                    break;
                }
                map.put(ch,map.getOrDefault(ch,0)+1);
                i++;
                flag1=true;
          }
        // possible to be the ans     
           int tempAns=i-j;
           ansSize=Math.max(ansSize,tempAns);
          // NOW START RELEASING 
          while(uc==k)
          {
              // START MAKING IT INVALID
              char ch=s.charAt(j);
              if(map.get(ch)>1){
                 map.put(ch,map.get(ch)-1);
              }
              else{
                  map.remove(ch);
                  uc--;
              }
              flag1=true;
              j++;
          }
           if(flag1==false && flag2==false){
               break;
           } 
            
        }
        return ansSize;
    }
}
