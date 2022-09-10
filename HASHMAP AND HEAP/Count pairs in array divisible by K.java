class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        int []newArr=new int[k];
        long count=0;
        for(int val:arr){
            int rem=val%k;
            if(rem==0){
             count+=newArr[0];   
            }
            else{
                count+=newArr[k-rem];
            }
            newArr[rem]++;
        }
        return count;
    }
}
