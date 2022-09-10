
class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<k;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ans.add(map.size());
        int j=0;
        int i=k;
        while(i<arr.length)
        {
            // remove
            if(map.get(arr[j])>1){
                map.put( arr[j],map.get(arr[j])-1 );
            }
            else{
                map.remove(arr[j]);
            }
            // add
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            // contribution to ans 
            ans.add(map.size());
            // updates
            i++;
            j++;
        }
        
        return ans;
    }
}

