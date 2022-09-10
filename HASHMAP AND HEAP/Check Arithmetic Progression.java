class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
         HashSet<Integer>set=new HashSet<>();
            int min=arr[0];int secmin=arr[1];
            if(secmin<min){
                min=arr[1];
                secmin=arr[0];
            }
             set.add(min);
             set.add(secmin);
            for(int i=2;i<n;i++){
               int val=arr[i];
                if(val<min){
                    secmin=min;
                    min=val;
                }
                else if(val<secmin){
                    secmin=val;
                }
                set.add(val);
            }
            int diff=secmin-min;
            
            for(int i=1;i<n;i++){
                min+=diff;
                if(set.contains(min)==false){
                    return false;
                }
            }
            return true;
            
            
    
    }
}
