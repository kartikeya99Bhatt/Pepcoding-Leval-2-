class Solution {
   class Pair
   {
        String str;
        int swapNo;
        Pair(String str,int swapNo){
            this.str=str;
            this.swapNo=swapNo;
        }
    }
    public int kSimilarity(String s1, String s2) {
        
        HashSet<String>set=new HashSet<>();
        Queue<Pair>q=new ArrayDeque<>();
        q.add(new Pair(s1,0));
        while(q.size()>0)
        {
            // remove
           Pair temp=q.remove();
           //mark*
            if(set.contains(temp.str)){
                continue;
            }
            set.add(temp.str);
            //work
            if(temp.str.equals(s2)){
                return temp.swapNo;
            }
            //addchildren*
            int idx=compare(temp.str,s2);
            char chNeed=s2.charAt(idx);
            for(int i=idx+1;i<temp.str.length();i++){
                char ch=temp.str.charAt(i);
                if(ch==chNeed){
                    String newStr=swap(temp.str,i,idx);
                    q.add(new Pair(newStr,temp.swapNo+1));
                }
            }
        }
        return 0;
    }
    public String swap(String s,int i,int j){
        StringBuilder sb=new StringBuilder(s);
        char  ch1=sb.charAt(i);
        char ch2=sb.charAt(j);
        sb.setCharAt(i,ch2);
        sb.setCharAt(j,ch1);
        return sb.toString();
    }
    public int compare(String x,String y){
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)!=y.charAt(i)){
                return i;
            }
        }
        return 0;
    }
}
