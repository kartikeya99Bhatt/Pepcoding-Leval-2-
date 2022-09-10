class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int val:deck){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        int min=Integer.MAX_VALUE;
     
        for(int val:map.keySet()){
            if(min==Integer.MAX_VALUE){
                min=map.get(val);
            }
            else
            min=Math.min(min,HCF(min,map.get(val)));
        } 
    
       if(min<2){
            return false;
        }
        
        return true;
    }
     public int HCF(int v1,int v2){
         
         while(v1>0){
             int rem=v2%v1;
             v2=v1;
             v1=rem;
         }
         return v2;
     }                    
}



