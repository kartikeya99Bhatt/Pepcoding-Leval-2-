class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        int ans=0;int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(sum,1);
       for(int val:arr){
           if(val==0){
               sum-=1;
           }
           else{
               sum+=1;
           }
           if(map.containsKey(sum)){
               ans+=map.get(sum);
           }
           map.put(sum, map.getOrDefault(sum,0)+1);
       }
       return ans;
    }
    
}


