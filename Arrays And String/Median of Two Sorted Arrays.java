class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int m1=(m+n+1)/2;
        int m2=(m+n+2)/2;
        
        int me1=getMedianElement(nums1,nums2,m1,0,0);
        int me2=getMedianElement(nums1,nums2,m2,0,0);
        
        return (me1+me2)/2.0;
    }
    public int getMedianElement(int []nums1,int []nums2,int k,int s1,int s2)
    {
     
      if(s1==nums1.length){
         return(nums2[s2+k-1]);
      }
      else if(s2==nums2.length)
      {
        return(nums1[s1+k-1]);
      }
      else if(k==1)
      {
        return Math.min(nums1[s1],nums2[s2]);
      }
      else
      {
          int e1=Integer.MAX_VALUE;
          if(s1+k/2-1<nums1.length)
          {
          e1=nums1[s1+k/2-1];
          }
          int e2=Integer.MAX_VALUE;
          if(s2+k/2-1<nums2.length)
          {
            e2=nums2[s2+k/2-1];
          }
          if(e1<e2)
          {
            return( getMedianElement(nums1,nums2,k-k/2,s1+k/2,s2));
          }
          else
          {
            return( getMedianElement(nums1,nums2,k-k/2,s1,s2+k/2));
          }
     }
    }
}
