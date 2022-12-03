class Solution {
    int []res;
    public class Pair
    {
        int idx;
        int value;
        Pair(int idx,int value){
            this.idx=idx;
            this.value=value;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        res=new int[nums.length];
        Pair []arr=new Pair[nums.length];
        for(int i=0;i<nums.length;i++)
        {
          arr[i]=new Pair(i,nums[i]);  
        }
        mergeSort(arr,0,nums.length-1);
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<res.length;i++){
            ans.add(res[i]);
        }
        return ans;
    }
    public Pair [] mergeSort(Pair []arr,int lo,int hi)
    {
        if(lo==hi)
        {
            Pair []base=new Pair[1];
            base[0]=new Pair(lo,arr[lo].value);
            return base;
        }
        int mid=lo+(hi-lo)/2;
        Pair []a=mergeSort(arr,lo,mid);
        Pair []b=mergeSort(arr,mid+1,hi);
        Pair []c=mergeTwoSortedArray(arr,a,b);
        return c;
    }
    public Pair []mergeTwoSortedArray(Pair []arr,Pair []a, Pair []b)
    {
        Pair []c=new Pair[a.length+b.length];
        int i=0;int j=0;int k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i].value>b[j].value)
            {
                res[a[i].idx]+=b.length-j;
                c[k]=a[i];
                i++;
                k++;
            }
            else
            {
                c[k]=b[j];
                j++;
                k++;
            }
        }
        while(i<a.length)
        {
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length)
        {
            c[k]=b[j];
            j++;
            k++;
        }
        
        return c;
    }
}
