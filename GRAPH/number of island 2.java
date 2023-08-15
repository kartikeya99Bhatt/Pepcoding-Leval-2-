public class Solution {
    static int[] parent;
    static int[] rank;

    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        parent = new int[n * m];
        rank = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] arr = new int[n][m];
        int numberOfIsland = 0;
        int[] ans = new int[q.length];

        for (int i = 0; i < q.length; i++) {
            int r = q[i][0];
            int c = q[i][1];
            
            boolean flag = false;
            numberOfIsland++;
            for (int j = 0; j < 4; j++) {
                int row = r + dir[j][0];
                int col = c + dir[j][1];
                if (row >= 0 && col >= 0 && row < n && col < m && arr[row][col] == 1) {
                    int v1 = row * m + col;
                    int v2 = r * m + c;
                    int p1 = find(v1);
                    int p2 = find(v2);
                    if (p1 != p2) {
                        numberOfIsland--;
                        union(p1, p2);
                    }
                   
                }
            }
            arr[r][c]=1;

            
            ans[i] = numberOfIsland;
        }

        return ans;
    }

    public static int find(int v1) {
        if (parent[v1] == v1) {
            return v1;
        }
        parent[v1] = find(parent[v1]);
        return parent[v1];
    }

    public static void union(int x, int y) {
        if (rank[x] == rank[y]) {
            parent[y] = x;
            rank[x]++;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
