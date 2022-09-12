class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer>ans=new ArrayList<>();
       
        // case1
        if(x==1 && y==1)
        {
            if(bound>=2){
                ans.add(2);
                return ans;
            }
        }
        // case2
         if(x==1)
         {
            for(int i=0;1+Math.pow(y,i)<=bound;i++){
                    ans.add(1+(int)Math.pow(y,i));
            } 
         }
        
        // case3
        if(y==1)
        {
            
            for(int i=0;1+Math.pow(x,i)<=bound;i++){
                    ans.add(1+(int)Math.pow(x,i));
            } 
        }
        
        // case 4
        if (x>1 && y>1)
        {
            HashSet<Integer>set=new HashSet<>();
            for(int px=1;px<bound;px=px*x){
                for(int py=1;py<bound;py=py*y){
                    int val=px+py;
                    if(val<=bound && set.contains(val)==false){
                        ans.add(val);
                        set.add(val);
                    }

                }
            }
        }
        return ans;
    }
}
