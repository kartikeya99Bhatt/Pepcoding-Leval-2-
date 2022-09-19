class Solution {
    static int numOfPairs(int[] x, int[] y, int N) {
        // code here
        HashMap<Integer,Integer>xmap=new HashMap<>();
        HashMap<Integer,Integer>ymap=new HashMap<>();
        HashMap<String,Integer>xymap=new HashMap<>();
        int ans=0;
        for(int i=0;i<x.length;i++)
        {
            int p1=x[i];
            int p2=y[i];
            String s=x[i]+"#"+y[i];
            if(xmap.containsKey(p1))
            {
                ans+=xmap.get(p1);
            }
            if(ymap.containsKey(p2))
            {
                ans+=ymap.get(p2);
            }
            if(xymap.containsKey(s))
            {
                ans=ans-(2*xymap.get(s));
            }
            xmap.put(p1,xmap.getOrDefault(p1,0)+1);
            ymap.put(p2,ymap.getOrDefault(p2,0)+1);
            xymap.put(s,xymap.getOrDefault(s,0)+1);
            
        }
        
        return ans;
    }
};
