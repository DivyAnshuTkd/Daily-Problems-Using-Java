import java.util.Stack;

public class Largest_Rectangle_in_Histogram
{
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] prevSmaller = prevSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int [] prevSmaller(int heights[])
    {
        int n = heights.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< n; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            if(stack.isEmpty())
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

    public int [] nextSmaller(int heights[])
    {
        int n = heights.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            if(stack.isEmpty())
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

    public static void main(String[] args) 
    {
        Largest_Rectangle_in_Histogram obj = new Largest_Rectangle_in_Histogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = obj.largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + result); // Output: 10
    }
}
