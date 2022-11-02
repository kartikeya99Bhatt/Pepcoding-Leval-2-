class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int twoNumber=0;
        for(int i=0;i<n;i++)
        {
            twoNumber=twoNumber^arr[i]^(i+1);
        }
        int rsb=twoNumber&(-twoNumber);
        int first=0;
        int second=0;
        
        for(int i=0;i<n;i++)
        {
            if((arr[i]&rsb)==0)
            first^=arr[i];
            else
            second^=arr[i];
            
            if(((i+1)&rsb)==0)
             first^=(i+1);
             else
             second^=(i+1);
        }
        
        int []ans=new int[2];
       HashSet<Integer>set=new HashSet<>();
       for(int val:arr)
       {
           set.add(val);
       }
       if(set.contains(first))
       {
        ans[0]=first;
        ans[1]=second;
       }
       else
       {
         ans[1]=first;
        ans[0]=second;
       }
        
        return ans;
    }
}
