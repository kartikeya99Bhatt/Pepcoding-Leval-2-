public static long minimumCost(int [] arr)
	{
	    Arrays.sort(arr);
	    int n=arr.length;
	    long ans=0;
	    for(int i=n-1;i>=1;i-=2)
	    {
	        if(i==1) // only two element are left
	        {
	          ans+=arr[1]; 
	        }
	        else if(i==2)
	        {
	            ans+=arr[0]+arr[1]+arr[2];
	        }
	        else
	        {
	           int f1=arr[i]+arr[0]+arr[i-1]+arr[0];
	           int f2=arr[i]+arr[0]+arr[1]+arr[1];
	           ans+=Math.min(f1,f2);
	        }
	    }
	    return ans;
	}
