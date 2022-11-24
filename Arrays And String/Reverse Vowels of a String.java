class Solution {
    public String reverseVowels(String s) 
    {
        char []arr=s.toCharArray();
       int i=0;int j=s.length()-1;
        while(i<j)
        {
            while(i<j && check(arr[i])==false){i++;}
            while(i<j && check(arr[j])==false){j--;}
            
            if(i<j && check(arr[i])==true && check(arr[j])==true)
            {
                char ch=arr[i];
                arr[i]=arr[j];
                arr[j]=ch;
                i++;j--;
            }
        }
        return (new String(arr));
    }
    public boolean check(char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u' || ch=='A'||ch=='E'||ch=='O'||ch=='I'||ch=='U')
        {
            return true;
        }
        return false;
    }
}
