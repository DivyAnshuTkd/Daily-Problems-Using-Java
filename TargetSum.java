import java.util.*;

public class TargetSum 
{
    public static int findTargetSumWays(int[] nums, int target) 
    {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        // If not possible to partition
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0)
        {
            return 0;
        }

        int t = (totalSum + target) / 2;

        int dp[][] = new int[n][t + 1];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return helper(nums, dp, n - 1, t);
    }

    public static int helper(int[] nums, int[][] dp, int index, int target)
    {
        // Base case
        if (index == 0)
        {
            if (nums[0] == 0 && target == 0)
            {
                return 2;  // {} and {0}
            }
            else if (target == nums[0] || target == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if (dp[index][target] != -1)
        {
            return dp[index][target];
        }

        int notTake = helper(nums, dp, index - 1, target);

        int take = 0;
        if (nums[index] <= target)
        {
            take = helper(nums, dp, index - 1, target - nums[index]);
        }

        dp[index][target] = take + notTake;

        return dp[index][target];
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int result = findTargetSumWays(nums, target);
        System.out.println("Number of ways: " + result);

        sc.close();
    }
}
