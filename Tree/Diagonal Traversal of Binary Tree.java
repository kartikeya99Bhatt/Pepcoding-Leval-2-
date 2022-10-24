class Tree
{
    int max=0;
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           HashMap<Integer,ArrayList>map=new HashMap<>();
           solve(root,map,0);
           ArrayList<Integer>ans=new ArrayList<>();
          
           for(int i=0;i<=max;i++)
           {
              ArrayList<Integer>list=map.get(i);
              for(int val:list)
              {
                ans.add(val);  
              }
           }
           return ans ;
      }
      public void solve(Node root,HashMap<Integer,ArrayList>map,int count )
      {
          if(root==null)
          {
              return ;
          }
          max=Math.max(max,count);
          if(map.containsKey(count))
          {
              map.get(count).add(root.data);
          }
          else
          {
             map.put(count,new ArrayList<>());
             map.get(count).add(root.data);
          }
          
         
              solve(root.left,map,count+1);
        
              solve(root.right,map,count);
          
      }
}
