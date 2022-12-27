class Solution {
    public String largestNumber(int[] nums) {
        String []arr=new String[nums.length];
       for(int i=0;i<nums.length;i++){
         arr[i]=""+nums[i];
       }
      Arrays.sort(arr,(a,b)->{
       String c1=a+b;
       String c2=b+a;
       return(c2.compareTo(c1));
      });
      if(arr[0].equals("0")){return "0";}
      StringBuilder sb=new StringBuilder("");
      for(int i=0;i<arr.length;i++){
        sb.append(arr[i]);
      } 
      return sb.toString();
    }
}
