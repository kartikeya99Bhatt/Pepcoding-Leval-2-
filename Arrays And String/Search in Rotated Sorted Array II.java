class Solution {
    public boolean search(int[] a, int target) {
        
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
          int mid=(lo+hi)/2;
          if(a[mid]==target)
          {
            return true;
          }
          else if(a[hi]>a[mid])
          {
             if(target>a[mid] &&target<=a[hi])
             {
               lo=mid+1;
             }
             else
             {
               hi=mid-1;
             }
          }
          else if(a[hi]<a[mid])
          {
             if(target>=a[lo] && target<a[mid])
             {
               hi=mid-1;
             }
             else
             {
               lo=mid+1;
             }
          }
          else
          {
            hi--;
          }
        }
        return false;
    }
}
