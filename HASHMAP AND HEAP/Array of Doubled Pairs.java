class Solution {
    public boolean canReorderDoubled(int[] arr) {
    
        Arrays.sort(arr);
        
        HashMap<Integer,Integer>fmap=new HashMap<>();
        for(int val:arr){
            if(val!=0)
          fmap.put(val,fmap.getOrDefault(val,0)+1);
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                continue;
            }
            else if(fmap.containsKey(arr[i]) && fmap.containsKey(2*arr[i]) && fmap.get(arr[i])>0 && fmap.get(2*arr[i])>0)
            {
                fmap.put(arr[i],fmap.get(arr[i])-1);
                fmap.put(2*arr[i],fmap.get(2*arr[i])-1);
            }
           
        }
       
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){continue;}
            if(fmap.get(arr[i])!=0)
            {
                return false;
            }
        }
        
        return true;
    }
}
