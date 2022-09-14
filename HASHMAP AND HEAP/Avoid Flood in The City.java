class Solution {
    public int[] avoidFlood(int[] rains) {
       HashMap<Integer,Integer>map=new HashMap<>();
        int []ans=new int[rains.length];
        TreeSet<Integer>set=new TreeSet<>();
        
        for(int i=0;i<rains.length;i++)
        {
            if(rains[i]==0)
            {
                set.add(i);
                ans[i]=1;
            }
            else
            {
                if(map.containsKey(rains[i]))
                {
                    int idx=map.get(rains[i]);
                    Integer cel=set.ceiling(idx);
                    if(cel!=null && idx<cel)
                    {
                        ans[cel]=rains[i];
                        set.remove(cel);
                    }
                    else
                    {
                        return(new int[0]);
                    }
                }
              
                ans[i]=-1;
                map.put(rains[i],i);
            }
        }
        return ans;
       
    }
}  
