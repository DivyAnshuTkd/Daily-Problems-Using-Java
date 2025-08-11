import java.util.ArrayDeque;
import java.util.Deque;
class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        int ans[] = new int[n-k+1];

        Deque<Integer> deq = new ArrayDeque<>();

        int i = 0;
        int j = 0;

        while(j < n)
        {
            while(!deq.isEmpty() && nums[j] > deq.peekLast())
            {
                deq.pollLast();
            }
            
            deq.offerLast(nums[j]);

            if((j-i+1) < k)
            {
                j++;
            }

            else if((j-i+1) == k)
            {
                ans[i] = deq.peekFirst();

                if(deq.peekFirst() == nums[i])
                {
                    deq.pollFirst();
                }

                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " "); // Output: [3, 3, 5, 5, 6, 7]
        }
    }
}
