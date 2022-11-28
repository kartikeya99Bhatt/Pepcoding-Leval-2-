class Solution {
    static String getSmallest(Long N) {
        // code here
        if(N<10)
        {
            return (N+"");
        }
        StringBuilder sb=new StringBuilder();
        for(int div=9;div>1;div--)
        {
            while(N%div==0)
            {
                N=N/div;
                sb.append(div);
            }
        }
        if(N>1)
        {
            return "-1";
        }
        return sb.reverse().toString();
    }
};
