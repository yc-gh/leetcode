// https://leetcode.com/problems/number-of-islands/

//DFS
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0)
            return 0;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(char[][] grid, int i, int j, int r, int c) {

        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i, j - 1, r, c);
        dfs(grid, i - 1, j, r, c);
        dfs(grid, i, j + 1, r, c);
        dfs(grid, i + 1, j, r, c);
    }
}


// BFS - TLE
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0)
            return 0;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(grid, i, j, rows, cols, vis);
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isSafe(char[][] grid, boolean[][] vis, int r, int c, int i, int j) {
        return (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == '1' && !vis[i][j]);
    }

    static void bfs(char[][] grid, int i, int j, int r, int c, boolean[][] vis) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { i, j });

        int[] adjRows = { 0, -1, 0, 1 };
        int[] adjCols = { -1, 0, 1, 0 };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            vis[curr[0]][curr[1]] = true;
            for (int index = 0; index < 4; index++) {
                int nextRow = curr[0] + adjRows[index];
                int nextCol = curr[1] + adjCols[index];

                if (isSafe(grid, vis, r, c, nextRow, nextCol)) {
                    queue.offer(new int[] { nextRow, nextCol });
                }
            }
        }
    }
}