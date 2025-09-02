import java.util.*;

public class Ninjas {

    public static int ninjaTraining(int n, int points[][]) {
        // dp[day][last] = max points achievable till 'day' if last activity was 'last'
        int dp[][] = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from last day (n-1), with "no previous activity" (3)
        return helper(points, n - 1, 3, dp);
    }

    private static int helper(int[][] points, int day, int last, int[][] dp) {
        // Base case: first day (day == 0)
        if (day == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        // Already computed → return from dp
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int maxi = Integer.MIN_VALUE;

        // Try all tasks for current day
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int score = points[day][task] + helper(points, day - 1, task, dp);
                maxi = Math.max(maxi, score);
            }
        }

        return dp[day][last] = maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[][] points = new int[n][3];
        System.out.println("Enter points for each day (3 activities per day):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        int result = ninjaTraining(n, points);
        System.out.println("Maximum points: " + result);

        sc.close();
    }
}

