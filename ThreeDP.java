import java.util.*;

class ThreeDP 
{
    public int cherryPickup(int[][] grid) 
    {
        int n  = grid.length;
        int m = grid[0].length;

        int dp[][][] = new int[n][m][m];

        for(int i = 0; i< n; i++)
        {
            for(int j =0; j<m; j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(grid, dp, 0, 0, m-1);
    }

    public static int helper(int grid[][], int dp[][][], int i, int j1, int j2)
    {
        // Out of bounds
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
        {
            return Integer.MIN_VALUE;
        }

        // Last row
        if(i == grid.length-1)
        {
            if(j1 == j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != -1)
        {
            return dp[i][j1][j2];
        }

        int maximum = Integer.MIN_VALUE;

        // Explore all 9 possibilities
        for(int dj1 = -1; dj1 <= 1; dj1++)
        {
            for(int dj2 = -1; dj2 <= 1; dj2++)
            {
                int value = 0;

                if(j1 == j2)
                {
                    value = grid[i][j1];
                }
                else
                {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += helper(grid, dp, i+1, j1 + dj1, j2 + dj2);

                maximum = Math.max(maximum, value);
            }
        }

        dp[i][j1][j2] = maximum;

        return dp[i][j1][j2];
    }

    // Driver code
    public static void main(String[] args) 
    {
        ThreeDP sol = new ThreeDP();

        int grid[][] = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };

        int result = sol.cherryPickup(grid);

        System.out.println("Maximum cherries collected: " + result);
    }
}
