class Solution {
    public String pushDominoes(String dominoes) 
    {
        dominoes="L"+dominoes+"R";
        char []arr=dominoes.toCharArray();
        int pi=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]=='R')
            {
                if(arr[pi]=='R')
                {
                    for(int j=pi+1;j<i;j++)
                    {
                        arr[j]='R';
                    }
                }
                else if(arr[pi]=='L')
                {
                }
                pi=i;
            }
            else if(arr[i]=='L')
            {
                if(arr[pi]=='R')
                {
                    int lo=pi+1;
                    int hi=i-1;
                    while(lo<hi)
                    {
                        arr[lo]='R';
                        arr[hi]='L';
                        lo++;
                        hi--;
                    }
                }
                else if(arr[pi]=='L')
                {
                     for(int j=pi+1;j<i;j++)
                    {
                        arr[j]='L';
                    }  
                }
                pi=i;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=1;i<arr.length-1;i++){
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}
