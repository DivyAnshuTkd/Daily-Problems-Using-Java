import java.util.*;

class Knapsacks 
{
    static int t[][];
    
    static int knapsack(int W, int val[], int wt[]) 
    {
        int n = val.length;  
        t = new int[n+1][W+1];  // dp table
        
        // initialize dp with -1
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= W; j++)
            {
                t[i][j] = -1;
            }
        }
        return helper(W, val, wt, n);
    }
    
    public static int helper(int W, int val[], int wt[], int n)
    {
        // base condition
        if(n == 0 || W == 0)
        {
            return 0;
        }
        
        if(t[n][W] != -1)
        {
            return t[n][W];
        }
        
        // choice diagram
        if(wt[n-1] <= W)
        {
            return t[n][W] = Math.max(
                val[n-1] + helper(W-wt[n-1], val, wt, n-1),
                helper(W, val, wt, n-1)
            );
        }
        else
        {
            return t[n][W] = helper(W, val, wt, n-1);
        }
    }

    // Main function to test
    public static void main(String[] args)
    {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        
        int result = knapsack(W, val, wt);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}
