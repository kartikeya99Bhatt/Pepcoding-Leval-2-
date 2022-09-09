class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int count0=0;int count1=0;int count2=0;long ans=0;
        HashMap<String,Integer>map=new HashMap<>();
        map.put("0#0",1);
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='0'){
                count0++;
            }
            else if(ch=='1'){
                count1++;
            }
            else if(ch=='2'){
               count2++;                
            }
            String s=(count0-count1)+"#"+(count0-count2);
            if(map.containsKey(s)){
                ans+=map.get(s);
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return ans;
    }
} 
