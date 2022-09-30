class Solution {
    public String removeDuplicateLetters(String s) {
       
        int []fq=new int[26];
        Stack<Character>st=new Stack<>();
        
        for(char ch:s.toCharArray())
        {
          fq[ch-'a']++;   
        }
        boolean []eis=new boolean[26];
       
        for(char ch:s.toCharArray())
        {
            fq[ch-'a']--;
            if(eis[ch-'a']==false)
            {
                while(st.size()>0 && st.peek()>ch && fq[st.peek()-'a']>0)
                {
                    eis[st.pop()-'a']=false;
                }
                st.push(ch);
                eis[ch-'a']=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()>0)
        {
            sb.append(st.pop());
        }
        return(sb.reverse().toString());
    }
}
