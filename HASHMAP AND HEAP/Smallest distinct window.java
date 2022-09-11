class Solution {
   public static int findSubString( String str) {
        // Your code goes here
        int ans=Integer.MAX_VALUE;
        HashSet<Character>set=new HashSet<>();
        for(char ch:str.toCharArray()){
            set.add(ch);
        }
       
        int i=0;int j=0;int mc=0;int dc=set.size();
        HashMap<Character,Integer>map=new HashMap<>();
        while(true)
        {
            boolean flag1=true;
            boolean flag2=true;
            // ACQUIRE TILL IT DO NOT BECOME VALID 
            while(i<str.length() && mc<dc){
                char ch=str.charAt(i);
                if(set.contains(ch) && map.containsKey(ch)==false )
                {
                    mc++;
                }
                map.put(ch,map.getOrDefault(ch,0)+1);
                flag1=false;
                i++;
            }
            
            // RELEASE IT DO NOT BECOME VALID
            while(mc==dc)
            {
                
                int tempAns=i-j;
                 ans=Math.min(ans,tempAns);
                 char ch=str.charAt(j);
                 if(set.contains(ch) && map.get(ch)==1)
                 {
                     mc--;
                 }
                 
                 if(map.get(ch)>1)
                 map.put(ch,map.get(ch)-1);
                 else if(map.get(ch)==1)
                 map.remove(ch);
             
                 j++;   
                 flag2=false;
            }
            if(flag1==true && flag2==true)
            {
                break;
            }
            
        }
        return ans;
    }
}
