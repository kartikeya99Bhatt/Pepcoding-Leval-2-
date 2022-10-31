 static int max=0;
    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        max=0;
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        solve(root,map,0);
        for(int i=0;i<=max;i++)
        {
            list.add(map.get(i));
        }
        return list;
    }
    public static void solve(TreeNode root,HashMap<Integer,ArrayList<Integer>>map,int idx)
    {
        if(root==null)
        {
            return ;
        }
        if(map.containsKey(idx))
        {
            map.get(idx).add(root.val);
        }
        else
        {
            map.put(idx,new ArrayList<Integer>());
            map.get(idx).add(root.val);
            max=Math.max(idx,max);
        }
         solve(root.right,map,idx+1);
        solve(root.left,map,idx);
       
    }
