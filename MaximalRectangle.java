import java.util.Stack;
public class MaximalRectangle
{
    public int maximalRectangle(char[][] matrix)
    {
        //if there are no rows then return
        if(matrix.length == 0)
        {
            return 0;
        }

        // find the number columns in a row
        int heights[] = new int[matrix[0].length];
        int largest = Integer.MIN_VALUE;

        for(int i= 0; i<matrix.length; i++)
        {
            for(int j =0; j<matrix[i].length; j++)    // matrix[i].length, this means the length of ith row 
            {
               int val = matrix[i][j] - '0';   //char to int
               if(val == 0)
               {
                heights[j] = 0;
               }

               else
               {
                heights[j] = heights[j] + val;
               }
            }
            int maxArea = largestRectangleArea(heights);
            if(largest < maxArea)
            {
                largest = maxArea;
            }
        }
        return largest;
    }

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

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal Rectangle Area: " + mr.maximalRectangle(matrix));
    }
}
