import java.util.*;

public class CherryPickupSolution 
{
    public static void main(String[] args) 
    {
        int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };

        CherryPickupSolution obj = new CherryPickupSolution();
        int result = obj.cherryPickup(grid);
        System.out.println("Maximum Cherries Collected: " + result);
    }

    public int cherryPickup(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][n];

        // Initialize all dp elements with -1
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Start from (0,0) and (0, n-1)
        return helper(grid, dp, 0, 0, n - 1);
    }

    public static int helper(int[][] grid, int[][][] dp, int i, int j1, int j2) 
    {
        int n = grid[0].length;

        // Out of bounds check
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) 
        {
            return Integer.MIN_VALUE;
        }

        // Base case (last row)
        if (i == grid.length - 1) 
        {
            if (j1 == j2) 
            {
                return grid[i][j1];
            } 
            else 
            {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // Memoization check
        if (dp[i][j1][j2] != -1) 
        {
            return dp[i][j1][j2];
        }

        int maximum = Integer.MIN_VALUE;

        // Try all 9 combinations for next move
        for (int k = -1; k <= 1; k++) 
        {
            for (int j = -1; j <= 1; j++) 
            {
                int value;

                if (j1 == j2) 
                {
                    value = grid[i][j1];
                } 
                else 
                {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += helper(grid, dp, i + 1, j1 + k, j2 + j);
                maximum = Math.max(maximum, value);
            }
        }

        dp[i][j1][j2] = maximum;
        return dp[i][j1][j2];
    }
}
