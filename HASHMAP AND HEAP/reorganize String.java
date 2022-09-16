class Solution {
   public class pair implements Comparable<pair>
   {
       char ch;
       int fq;
       pair(){}
       pair(char ch,int fq)
       {
           this.ch=ch;
           this.fq=fq;
       }
       public int compareTo(pair o)
       {
           return(this.fq-o.fq);
       }
   }
    public String reorganizeString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(char key:map.keySet())
        {
            pair temp=new pair();
            temp.ch=key;
            temp.fq=map.get(key);
            pq.add(temp);
        }
        StringBuilder sb=new StringBuilder();
        
         pair p=pq.remove();
         sb.append(p.ch);
         pair temp=new pair(p.ch,p.fq-1);
        while(pq.size()>0)
        {
             p=pq.remove();
            sb.append(p.ch);
            if(temp.fq!=0)
            {
                pq.add(temp);
            }
            temp=new pair(p.ch,p.fq-1);
        }
        if(sb.length()==s.length())
        return sb.toString();
        else
        {
            return "";
        }
    }
}
