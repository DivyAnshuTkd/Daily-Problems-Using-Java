import java.util.*;

public class TrappingRainWater 
{
    public static void main(String[] args) 
    {
        // Example input
        int[] height = {4,2,0,3,2,5};

        TrappingRainWater obj = new TrappingRainWater();
        int result = obj.trap(height);

        System.out.println("Total trapped water: " + result);
    }

    public int trap(int[] height) 
    {
        int n = height.length;
        int leftArray[] = prefix(height);
        int rightArray[] = suffix(height);

        int total = 0;

        for(int i = 0; i<n; i++)
        {
            int left = leftArray[i];
            int right = rightArray[i];

            if(height[i] < left && height[i] < right)
            {
                total += Math.min(left, right) - height[i];
            }
        }
        return total;
    }

    public static int[] prefix(int[] height)
    {
        int prefixSum[] = new int[height.length];
        prefixSum[0] = height[0];

        for(int i = 1; i<height.length; i++)
        {
            prefixSum[i] = Math.max(prefixSum[i-1], height[i]);
        }
        return prefixSum;
    }

    public static int[] suffix(int[] height)
    {
        int n = height.length;
        int suffixSum[] = new int[height.length];
        suffixSum[n-1] = height[n-1];

        for(int i = n-2; i>= 0; i--)
        {
            suffixSum[i] = Math.max(suffixSum[i+1], height[i]);
        }
        return suffixSum;
    }
}
