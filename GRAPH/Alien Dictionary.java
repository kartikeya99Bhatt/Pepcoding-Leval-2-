class Solution
{
    public String findOrder(String [] dict, int N, int k)
    {
        // Write your code here k
      ArrayList<Integer>[]graph=new ArrayList[k];
        for(int i=0;i<k;i++)
        {
            graph[i]=new ArrayList<>();
        }
      for(int i=0;i<N-1;i++)
      {
          String first=dict[i];
          String secound=dict[i+1];
          for(int j=0;j<Math.min(first.length(),secound.length());j++)
          {
              char f1=first.charAt(j);
              char f2=secound.charAt(j);
              if(f1!=f2)
              {
                  graph[f1-'a'].add(f2-'a');
                  break;
              }
          }
      }
      boolean []visited=new boolean [k];
      Stack<Character>st=new Stack<>();
      for(int i=0;i<k;i++)
        {
            if(visited[i]==false)
            {
                dfs(i,graph,visited,st);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()>0)
        {
            char ch=(char)(st.pop());

            sb.append(ch);
        }
        return sb.toString();
    }
    public static void dfs(int scr,ArrayList<Integer>[]graph,boolean []visited,Stack<Character>st)
    {
        visited[scr]=true;
        for(int nbr:graph[scr])
        {
            if(visited[nbr]==false)
            {
                dfs(nbr,graph,visited,st);
            }
        }
        st.push((char)(scr+'a'));
    }
}
