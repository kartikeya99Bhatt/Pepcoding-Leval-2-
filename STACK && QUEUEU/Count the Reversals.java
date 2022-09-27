class Sol
{
    int countRev (String s)
    {
        if(s.length()%2==1)
        {
            return -1;
        }
        // your code here  
        int cls_Count=0;
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='{')
            {
                st.push(ch);
            }
            else if(ch=='}') 
            {
                if(st.size()>0)
                {
                   st.pop(); 
                }
                else
                {
                    cls_Count++;
                }
            }
        }
       
        
    return ( (st.size()+1)/2+(cls_Count+1)/2);

    
        
    }
}
