class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        ArrayList<TreeNode>path=NodeToRootPath(root,target.val);
        ArrayList<Integer>ans=new ArrayList<>();
        TreeNode block=null;
        for(int i=0;i<path.size();i++)
        {
            addNode(path.get(i),k,ans,block);
            k--;
            block=path.get(i);
            if(k<0)
                break;
        }
        
            return ans;
    }
    public void addNode(TreeNode  root,int k,ArrayList<Integer>ans,TreeNode block)
    {
        if(root==null || root==block)
        {
            return;
        }
        else if(k==0)
        {
            ans.add(root.val);
        }
        addNode(root.left,k-1,ans,block);
        addNode(root.right,k-1,ans,block);
    }
    public  ArrayList<TreeNode> NodeToRootPath(TreeNode root,int target){
            if(root==null)
            {
                return (new ArrayList<>());
            }
            else if(root.val==target)
            {
                ArrayList<TreeNode>base=new ArrayList<>();
                base.add(root);
                return base;
            }
            ArrayList<TreeNode>lt=NodeToRootPath(root.left,target);
            if(lt.size()>0)
            {
                lt.add(root);
                return lt;
            }
            ArrayList<TreeNode>rt=NodeToRootPath(root.right,target);
            if(rt.size()>0)
            {
                rt.add(root);
                return rt;
            }
            return (new ArrayList<>()); 
    }
}
