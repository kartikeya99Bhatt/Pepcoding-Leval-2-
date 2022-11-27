public class Solution {
    public int solve(ArrayList<Integer> A) {
       int es=0;
       int os=0;
       for(int i=0;i<A.size();i++){
           if(i%2==0)
           {
               es+=A.get(i);
           }
           else
           {
               os+=A.get(i);
           }
       }
        
        int les=0;
        int los=0;
        int ans=0;
        for(int i=0;i<A.size();i++)
        {
            if(i%2==0)
            {
                int res=es-les-A.get(i);
                int ros=os-los;
                if(res+los==ros+les)
                {
                    ans++;
                }
                les+=A.get(i);
            }
            else
            {
                int res=es-les;
                int ros=os-los-A.get(i);
                if(res+los==ros+les)
                {
                    ans++;
                }
                los+=A.get(i);
            }

        }    
        return ans;   
    }
    
}
