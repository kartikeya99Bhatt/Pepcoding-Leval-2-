class Solution {
    HashMap<String,String>parent;
    HashMap<String,Integer>rank=new HashMap<>();
    public int numSimilarGroups(String[] strs) {
        parent=new HashMap<>();
        rank=new HashMap<>();
        for(String s:strs)
        {
            if(parent.containsKey(s)==false)
            {
                parent.put(s,s);
                rank.put(s,0);
            }
        }
        
        
        for(int i=0;i<strs.length;i++)
        {
            for(int j=(i+1);j<strs.length;j++)
            {
                boolean flag=compare(strs[i],strs[j]);
                if(flag){
                    unionHelper(strs[i],strs[j]);
                }
            }
        }
        int ccp=0;
       for(String key:parent.keySet()){
           if(key.equals(parent.get(key))){
               ccp++;
           }
       }
        return ccp;
    }
    public void unionHelper(String x,String y)
    {
        String pofx=find(x);
        String pofy=find(y);
        if(pofx!=pofy){
            union(pofx,pofy);
        }
    }
    public void union(String x,String y){
        if(rank.get(x)<rank.get(y)){
            parent.put(x,y);
        }
        else if(rank.get(y)<rank.get(x)){
             parent.put(y,x);
        }
        else{
             parent.put(x,y);
            rank.put(y,rank.get(y)+1);
        }
    }
    public String find(String x)
    {
        if(x.equals(parent.get(x)))
        {
            return x;
        }
        String cp=parent.get(x);
        String fp=find(cp);
        parent.put(x,fp);
        return fp;
    }
    public boolean compare(String x,String y){
        int cnt=0;
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)!=y.charAt(i)){
                cnt++;
            }
        }
        return(cnt<=2);
        
    }
    
}
