class Solution {
    public int maximumSwap(int num) {
        char []arr=(""+num).toCharArray();
        int []right=new int[arr.length];
        int max=0;
        int maxIdx=arr.length-1;
        for(int i=arr.length-1;i>=0;i--)
        {
            if((arr[i]-'0')>max)
            {
                maxIdx=i;
                max=arr[i]-'0';
            }
            right[i]=maxIdx;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(i!=right[i] && (arr[i]!=arr[right[i]]))
            {
                
                char temp=arr[i];
                arr[i]=arr[right[i]];
                arr[right[i]]=temp;
                break;
            }
        }
        return (Integer.parseInt(new String(arr)));
    }
}
