class Solution {
    String ans="";
    public String crackSafe(int n, int k) {
        ans="";
        visited=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(0);
        }
        visited.add(sb.toString());
        int limit=(int)Math.pow(k,n);
        dfs(sb,limit,k,n);
        return ans;
    }
    HashSet<String>visited;
    public boolean dfs(StringBuilder sb,int limit,int k,int n)
    {
        if(visited.size()==limit)
        {
            ans=sb.toString();
            return true;
        }
       
        String str=sb.substring(sb.length()-(n-1));
        for(int i=0;i<k;i++)
        {
           String nstr=str+i;
           if(visited.contains(nstr)==false){
               visited.add(nstr);
                sb.append(i);
                boolean res=dfs(sb,cnt+1,limit,k,n);
               if(res==true)
               {
                   return true;
               }
                sb.deleteCharAt(sb.length()-1);
                 visited.remove(nstr);
           } 
        }
      
        return false;
    }
}
/*"0001001001"*/
