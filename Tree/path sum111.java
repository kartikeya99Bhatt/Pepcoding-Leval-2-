// The Time Complexity is :- O(N^2)

class Solution {
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        count=0;
        ArrayList<TreeNode>list=new ArrayList<>();
        collectAllNode(root,list);
      
        for(TreeNode val:list)
        {
            System.out.println("The val is "+val.val);
            solve(val,targetSum,0);
            System.out.println("The count is "+count);
        }
        return count;
    }
    public void collectAllNode(TreeNode root,ArrayList<TreeNode>list)
    {
        if(root==null)
        {
            return ;
        }
        list.add(root);
        collectAllNode(root.left,list);
        collectAllNode(root.right,list);
    }
    public void solve(TreeNode root,int targetSum,long sum)
    {
        sum=sum+root.val;
       
        if(sum==targetSum)
        {
            count++;
          
        }   
            if(root.left!=null)
            solve(root.left,targetSum,sum);
            if(root.right!=null)
            solve(root.right,targetSum,sum);
      
        return ;
        
    }
}


  //TIME COMPLEXITY IS T(n)=O(n)

class Solution {
    int count =0;
     long currSum=0;
    public int pathSum(TreeNode root, int targetSum) {
     
        HashMap<Long,Integer>map=new HashMap<>();
        map.put(0l,1);
        count=0;
        solve(root,targetSum,map);
        return count;
    }
    public void solve(TreeNode root,int targetSum,HashMap<Long,Integer>map)
    {
        if(root==null)
        {
            return ;
        }
        currSum=currSum+root.val;
        if(map.containsKey(currSum-targetSum)){
            count+=map.get(currSum-targetSum);
            System.out.println("The count is "+ count);
        }
          map.put(currSum,map.getOrDefault(currSum,0)+1);
            solve(root.left,targetSum,map);
            solve(root.right,targetSum,map);
            map.put(currSum,map.get(currSum)-1);
            currSum=currSum-root.val;
       
    }
}


