  public static class Pair
    {
        TreeNode node;
        int leftRange;
        int rightRange;
        Pair(TreeNode node,int leftRange,int rightRange)
        {
            this.node=node;
            this.leftRange=leftRange;
            this.rightRange=rightRange;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        
        Queue<Pair>pq=new ArrayDeque<>();
        TreeNode root=null;
        int i=0;
        while(i<LevelOrder.length)
        {
            if(i==0)
            {
                 root=new TreeNode(LevelOrder[i++]);
                pq.add(new Pair(root,Integer.MIN_VALUE,root.val));
                pq.add(new Pair(root,root.val,Integer.MAX_VALUE));
            }
            else
            {
                Pair temp=pq.remove();
                if(LevelOrder[i]>temp.leftRange && LevelOrder[i]<temp.rightRange)
                {
                    TreeNode newNode=new TreeNode(LevelOrder[i++]);
                    pq.add(new Pair(newNode,temp.leftRange,newNode.val));
                    pq.add(new Pair(newNode,newNode.val,temp.rightRange));
                    if(temp.node.val > newNode.val)
                    {
                        temp.node.left=newNode;
                    }
                    else
                    {
                        temp.node.right=newNode;
                    }
                }
                
            }
        }
        
        return root;
        
    }
