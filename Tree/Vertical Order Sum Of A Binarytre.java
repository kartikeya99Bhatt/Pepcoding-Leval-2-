static int max=0; static int min=0;
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        
        max=0;
        min=0;
       HashMap<Integer,Integer>map=new HashMap<>();
       solve(root,map,0);
       
       ArrayList<Integer>ans=new ArrayList<>();
       for(int i=min;i<=max;i++){
          ans.add(map.get(i));
       }
       return ans;
        
    }
    
public static void solve(TreeNode root,HashMap<Integer,Integer>map,int idx)
    {
        if(root==null)
        {
            return ;
        }
        map.put(idx,map.getOrDefault(idx,0)+root.val);
        max=Math.max(idx,max);
        min=Math.min(idx,min);
        solve(root.left,map,idx-1);
        solve(root.right,map,idx+1);
    }
