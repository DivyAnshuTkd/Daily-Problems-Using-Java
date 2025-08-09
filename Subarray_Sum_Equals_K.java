import java.util.*;
public class Subarray_Sum_Equals_K
{
    public int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;

        for(int i =0; i< nums.length; i++)
        {
            sum = sum + nums[i];

            if(map.containsKey(sum - k))
            {
                ans = ans + map.get(sum-k);
            }

            if(map.containsKey(sum))
            {
                map.put(sum, map.get(sum) + 1);
            }
            else
            {
                map.put(sum, 1);
            }
        }
        return ans;      
    }

    public static void main(String[] args)
    {
        Subarray_Sum_Equals_K solution = new Subarray_Sum_Equals_K();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);        
    }
}

    


