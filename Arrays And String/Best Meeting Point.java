   public static int minTotalDistance(int[][] grid) {
        // Write your code here
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer>column=new ArrayList<Integer>();
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(grid[i][j]==1)
                {
                    column.add(j);
                }
            }
        }
        
        ArrayList<Integer>row=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    row.add(i);
                }
            }
        }
        int rowMediun=row.get(row.size()/2);
        int colunmMedium=column.get(column.size()/2);
        
        int distance=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    distance+=Math.abs(i-rowMediun)+Math.abs(j-colunmMedium);
                }
            }
        }
        return distance;
    }
