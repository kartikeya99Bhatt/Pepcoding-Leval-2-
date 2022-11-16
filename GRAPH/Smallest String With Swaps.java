class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n=s.length();
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<pairs.size();i++){
           int x=pairs.get(i).get(0);
           int y=pairs.get(i).get(1);
           int pofx=find(x);
           int pofy=find(y);
            if(pofx!=pofy){
                union(pofx,pofy);
            }
        }
        HashMap<Integer,PriorityQueue<Character>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(find(i)==i){
                map.put(i,new PriorityQueue<Character>());
            }
        }
      
        for(int i=0;i<n;i++)
        {
            int par=parent[i];

            map.get(par).add(s.charAt(i));
        }
      
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<parent.length;i++){
            char ch=map.get(parent[i]).remove();
            ans.append(ch);
        }
        return ans.toString();
    }
    int []parent;
    int []rank;
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }
        else if(rank[y]<rank[x]){
            parent[y]=x;
        }
        else{
            parent[x]=y;
            rank[y]++;
        }
    }
    
}
