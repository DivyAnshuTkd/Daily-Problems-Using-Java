import java.util.*;

public class FrogJump1{
    int minCost(int[] height) {
        int n = height.length;

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n - 1, height, dp);
    }

    public static int helper(int index, int height[], int dp[]) {
        // Base case
        if (index == 0) {
            return 0;
        }

        // If already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        // Take 1 step
        int left = helper(index - 1, height, dp) + Math.abs(height[index] - height[index - 1]);

        // Take 2 steps
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = helper(index - 2, height, dp) + Math.abs(height[index] - height[index - 2]);
        }

        // Store in dp before returning
        dp[index] = Math.min(left, right);

        return dp[index];
    }

    // Main function
    public static void main(String[] args) {
        FrogJump1 sol = new FrogJump1();

        int[] height = {30, 10, 60, 10, 60, 50};
        int result = sol.minCost(height);

        System.out.println("Minimum cost: " + result);
    }
}
