class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap< HashMap<Character,Integer>,ArrayList<String>>base=new HashMap<>();
        
        for(String s:strs){
           
            HashMap<Character,Integer>fmap=new HashMap<>();
            for(char ch:s.toCharArray()){
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            
            if(base.containsKey(fmap)==false){
                base.put(fmap,new ArrayList<String>());
                base.get(fmap).add(s);
            }
            else{
                 base.get(fmap).add(s);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(List<String>list:base.values())
        {
            ans.add(list);
        }
        return ans;
    }
}
