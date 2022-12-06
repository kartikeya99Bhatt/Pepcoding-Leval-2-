class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int []lps=getLps(pat);
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<txt.length())
        {
            if(txt.charAt(i)==pat.charAt(j))
            {
                i++;j++;
                if(j==pat.length())
                {
                    ans.add(i-j+1);
                    j=lps[j-1];
                }
            }
            else if(j==0)
            {
                i++;
            }
            else
            {
                j=lps[j-1];
            }
        }
        
        return ans;
    }
    
    public int[] getLps(String str)
    {
         int i=1;int len=0;int []lps=new int[str.length()];
        while(i<str.length())
        {
            if(str.charAt(len)==str.charAt(i))
            {
                lps[i]=len+1;
                i++;len++;
            }
            else if(len==0)
            {
                i++;
            }
            else // length value is grater than 0
            {
                len=lps[len-1];
            }
            
        }
        return lps;
    }
}
