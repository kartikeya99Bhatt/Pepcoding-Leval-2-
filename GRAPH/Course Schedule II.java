class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      // constructing a graph
          ArrayList<Integer>[]graph=new  ArrayList[numCourses];
          HashMap<Integer,Integer>indegree=new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            graph[i]=new ArrayList<>();
            indegree.put(i,0);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
             int pre=prerequisites[i][1];
             int curr=prerequisites[i][0];
             graph[curr].add(pre);
             indegree.put(pre,indegree.getOrDefault(pre,0)+1);
        }
       // implementing khans algo
        Queue<Integer>q=new ArrayDeque<>();
        Stack<Integer>st=new Stack<>();
       for(int i=0;i<numCourses;i++)
       {
           if(indegree.containsKey(i) && indegree.get(i)==0)
           {
               q.add(i);
           }
          
       }
        int count=0;
        while(q.size()>0)
        {
            int temp=q.remove();
            st.add(temp);
            for(int nbr:graph[temp])
            {
                if(indegree.get(nbr)>0)
                {
                    if(indegree.get(nbr)==1)
                    {
                        q.add(nbr);
                        count++;
                    }
                    indegree.put(nbr,indegree.get(nbr)-1);
                }
            }
        }
        if(st.size()<numCourses)
        {
            return(new int[0]);
        }
        int []ans=new int[numCourses];
        int idx=0;
        while(st.size()>0)
        {
            ans[idx++]=st.pop();
        }
        return ans;
    }
}
