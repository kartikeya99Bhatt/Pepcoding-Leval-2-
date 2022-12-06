class Solution {
    public String shortestPalindrome(String s) {
        
        // creating a string 
        StringBuilder sb=new StringBuilder(s);
        StringBuilder str=new StringBuilder();
        str.append(sb+"$");
        str.append(sb.reverse());
       
        // lps
        int []lps=getLps(str.toString());
        int need=lps[str.length()-1];
        sb=new StringBuilder(s.substring(need));
        return (sb.reverse()+s);

    }
    public int[] getLps(String s)
    {
      int []lps=new int[s.length()];
      int len=0;int i=1;
      while(i<s.length())
      {
          if(s.charAt(i)==s.charAt(len))
          {
             lps[i]=len+1;
             len++;i++;
          }
          else if(len==0)
          {
            i++;
          }
          else
          {
             len=lps[len-1];
          }
      }

      return lps;
    }

}
