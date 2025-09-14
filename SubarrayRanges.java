import java.util.*;

public class SubarrayRanges
{
    public long subArrayRanges(int[] nums)
    {
        long min = minimum(nums);
        long max = maximum(nums);

        return (max - min);
    }

    public long minimum(int[] nums)
    {
        long sumOfSmall = 0;

        int n = nums.length;

        int previousSmall[] = previousSmaller(nums);
        int nextSmall[] = nextSmaller(nums);

        for (int i = 0; i < n; i++)
        {
            long pSmall = i - previousSmall[i];
            long nSmall = nextSmall[i] - i;

            long productSmall = pSmall * nSmall;
            sumOfSmall += productSmall * (long) nums[i];
        }

        return sumOfSmall;
    }

    public long maximum(int[] nums)
    {
        long sumOfLarge = 0;

        int n = nums.length;

        int previousLarge[] = previousLarger(nums);
        int nextLarge[] = nextLarger(nums);

        for (int i = 0; i < n; i++)
        {
            long pLarge = i - previousLarge[i];
            long nLarge = nextLarge[i] - i;

            long productLarge = pLarge * nLarge;
            sumOfLarge += productLarge * (long) nums[i];
        }

        return sumOfLarge;
    }

    public static int[] previousSmaller(int nums[])
    {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] nextSmaller(int nums[])
    {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                ans[i] = n;
            }
            else
            {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] previousLarger(int nums[])
    {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] nextLarger(int nums[])
    {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                ans[i] = n;
            }
            else
            {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args)
    {
        SubarrayRanges solution = new SubarrayRanges();

        int[] nums1 = {1, 2, 3};
        System.out.println("Result for [1,2,3]: " + solution.subArrayRanges(nums1)); // Expected 4

        int[] nums2 = {1, 3, 3};
        System.out.println("Result for [1,3,3]: " + solution.subArrayRanges(nums2)); // Expected 4

        int[] nums3 = {4, -2, -3, 4, 1};
        System.out.println("Result for [4,-2,-3,4,1]: " + solution.subArrayRanges(nums3)); // Expected 59
    }
}
