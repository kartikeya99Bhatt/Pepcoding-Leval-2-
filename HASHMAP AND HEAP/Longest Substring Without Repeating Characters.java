class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;int max=0;int j=0; 
        HashMap<Character,Integer>fmap=new HashMap<>();
      
        while(i<s.length()){
          char ch=s.charAt(i);
          
            // ACQUIRE TILL THE POINT IT DOES NOT BECOME INVALID
            if(fmap.containsKey(ch)==false){
               fmap.put(ch,fmap.getOrDefault(ch,0)+1);
               i++;
           }
           else
           { 
                // START RELEASING TO MAKE IT VALID
                while(s.charAt(j)!=ch)
                {
                    if(fmap.get(s.charAt(j))>1)
                     fmap.put(s.charAt(j),fmap.getOrDefault(ch,0)+1);
                    else
                    fmap.remove(s.charAt(j));
                      j++;
                }
               if(fmap.get(s.charAt(j))>1)
                 fmap.put(s.charAt(j),fmap.getOrDefault(ch,0)+1);
                else
                fmap.remove(s.charAt(j));
                j++;
           }
            max=Math.max(max,(i-j));
        }
        
        return max;
    }
}
