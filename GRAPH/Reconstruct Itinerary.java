class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        map=new HashMap<>();
        
        for(int i=0;i<tickets.size();i++){
            String scr=tickets.get(i).get(0);
            String dest=tickets.get(i).get(1);
             if(map.containsKey(scr)){
                map.get(scr).add(dest);
            }
            else{
                map.put(scr,new PriorityQueue<>());
                 map.get(scr).add(dest);
            }
        }
        ArrayList<String>ans=new ArrayList<>();
        dfs("JFK",ans);
        return ans;
    }
     HashMap<String,PriorityQueue<String>>map;
    public void dfs(String scr,ArrayList<String>ans)
    {
        if(map.containsKey(scr)==false || map.get(scr).size()==0)
        {
            ans.add(0,scr);
            return ;
        }
        while(map.get(scr).size()>0)
        {
            String nbr=map.get(scr).remove();
            dfs(nbr,ans);
        }
        ans.add(0,scr);
    }
}
