class Solution {
    public List<Integer> partitionLabels(String s) {
        // first iteration
        int []map=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map[ch-'a']=i;
        }
        // secound iteration
        ArrayList<Integer>ans=new ArrayList<Integer>();
        int st=0;int end=0;
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            end=Math.max(end,map[ch-'a']);
           
            if(i==end)
            {
                ans.add(end-st+1);
                st=end=end+1;;
            }
        }
        
        return ans;
            
    }
}
