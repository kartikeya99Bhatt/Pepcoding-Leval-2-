class Solution {
    public int nextGreaterElement(int n) {
        char []arr=(""+n).toCharArray();
        int i=arr.length-1;

        while(i-1>=0)
        {
            if(arr[i-1]>=arr[i]){
                i--;
            }
            else{
                break;
            }
        }
        if(i==0)
        {
            return -1;
        }
        else
        {
            i--;
            int j=arr.length-1;
            while(arr[j]<=arr[i])
            {
                j--;
            }
            // swap
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            
            // reverse
            i=i+1;
            j=arr.length-1;
            while(i<j)
            {
               temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
                i++;
                j--;
            }
            
        }
        String res=new String(arr);
        long ans=Long.parseLong(res);
           if(ans>Integer.MAX_VALUE){
             return -1;   
           }
       
            return (int)ans;
        
    }
}
