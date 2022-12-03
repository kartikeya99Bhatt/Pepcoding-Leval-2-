class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length())
        {
            return false;
        }
        
        int []arr1=new int[26];
        int []arr2=new int[26];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<word1.length();i++)
        {
            arr1[word1.charAt(i)-'a']++;
            arr2[word2.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if( (arr1[i]!=0 && arr2[i]==0) || (arr2[i]!=0 && arr1[i]==0) )
            {
                return false;
            }
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
            map.put(arr2[i],map.getOrDefault(arr2[i],0)-1); 
        }
        for(int v:map.values()){
            if(v>0)
            {
                return false;
            }
        }
        
       return true ;
    }
}
