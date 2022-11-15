class Solution {
    class Pair
    {
        String str;
        int swapNo;
        Pair(){}
        Pair(String str,int swapNo){
            this.str=str;
            this.swapNo=swapNo;
        }
    }
    public int slidingPuzzle(int[][] board) {
        HashSet<String>set=new HashSet();
        Queue<Pair>q=new ArrayDeque<>();
        String s=boxToString(board);
        q.add(new Pair(s,0));
        int [][]dir={{1,3},{0,4,2},{1,5},{0,4},{1,3,5},{2,4}};
        while(q.size()>0)
        {
            //r
            Pair temp=q.remove();
            //m*
            if(set.contains(temp.str))
            {
                continue;
            }
            set.add(temp.str);
            //w
            if(temp.str.equals("123450")){
                return temp.swapNo;
            }
            //ac*
            int idx=temp.str.indexOf("0");
            for(int val:dir[idx]){
                    String key=swap(temp.str,val,idx);
                    if(set.contains(key)==false){
                        q.add(new Pair(key,temp.swapNo+1));
                    }
            }
        }
            
      
            return -1;
    }
    public String swap(String sb,int i,int j){
        StringBuilder s=new StringBuilder(sb);
        char ch1=s.charAt(i);
        char ch2=s.charAt(j);
        s.setCharAt(i,ch2);
        s.setCharAt(j,ch1);
        return s.toString();
    }
    public String boxToString(int [][]box){
        StringBuilder sb=new StringBuilder();
        for(int []row:box){
            for(int val:row){
                sb.append(val);
            }
        }
        return (sb.toString());
    }
}
