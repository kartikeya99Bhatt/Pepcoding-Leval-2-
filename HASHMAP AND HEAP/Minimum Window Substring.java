class Solution {
    public String minWindow(String s, String t) {
        
       String ans=null;
        int i=0;int j=0;
        int dc=t.length();int mc=0;
        HashMap<Character,Integer>tmap=new HashMap<>();
        for(char ch:t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer>smap=new HashMap<>();
        while(true)
        {
            // ACQUIRE TILL IT DOES NOT GET VALID 
            boolean flag1=true;
            boolean flag2=true;
            while(i<s.length() && mc<dc)
            {
                char ch=s.charAt(i);
                if(smap.getOrDefault(ch,0)<tmap.getOrDefault(ch,0))
                {
                   mc++; 
                }
                i++;
                smap.put(ch,smap.getOrDefault(ch,0)+1);
                flag1=false;
            }
            
            // RELEASE TILL IT DOES NOT BECOME VALID 
            while(mc==dc){
                // ONE OF THE OPTION OF BEING THE ANS
                String tempAns=s.substring(j,i);
                if(ans==null)
                    ans=tempAns;
                else if(tempAns.length()<ans.length())
                {
                    ans=tempAns;
                }
                
                // start releasing
                char ch=s.charAt(j);
                if(smap.get(ch)<=tmap.getOrDefault(ch,0)){
                  mc--;   
                }
               
               if(smap.get(ch)==1){
                   smap.remove(ch);
                    
                }
                else{
                    smap.put(ch,smap.get(ch)-1);
                }
                j++;
                 flag2=false;
            }
            
            if(flag1==true && flag2==true){
                break;
            }
                   
            
        }
        return ( (ans==null)?"":ans);
    }
}
/*
1.Accquire til it do not become valid ans
2.Relese tii the ans do not become invalid 
*/
