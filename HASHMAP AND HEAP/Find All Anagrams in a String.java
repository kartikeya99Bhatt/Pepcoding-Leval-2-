class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       
        if(p.length()>s.length()){
            return (new ArrayList<>());
        }
        HashMap<Character,Integer>pat=new HashMap<>();
        for(char ch:p.toCharArray()){
            pat.put(ch,pat.getOrDefault(ch,0)+1);
        }
        
         HashMap<Character,Integer>str=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch=s.charAt(i);
             str.put(ch,str.getOrDefault(ch,0)+1);
        }
        
        List<Integer>ans=new ArrayList<>();
        
      int j=0;int i=p.length();
        while(i<s.length()){
            
            //compare
            if(pat.equals(str)==true)
            {
                ans.add(j);
            }
            // remove
             char re=s.charAt(j);
             if(str.get(re)>1){
                  str.put(re,str.get(re)-1);
             }
            else
            {
                str.remove(re);
            }
            // add
             char ch=s.charAt(i);
              str.put(ch,str.getOrDefault(ch,0)+1);
            // update
            i++;
            j++;
        }
          if(pat.equals(str)==true)
            {
                ans.add(j);
            }
         return ans;   
    }
}
