import java.util.*;
public class Three_Sum 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i< n; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {
                continue;
            }
            int left = i+1;
            int right = n-1;

            while(left < right)
            {
                long sum = (long) nums[i] + nums[left] + nums[right];

                if(sum > 0)
                {
                    right--;
                }
                else if(sum < 0)
                {
                    left++;
                }

                else if(sum == 0)
                {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1])
                    {
                        left++;
                    }

                    while(left < right && nums[right] == nums[right+1])
                    {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        Three_Sum obj = new Three_Sum();
        
        int[] nums = {1, 0, -1, 0, -2, 2};
        
        List<List<Integer>> result = obj.threeSum(nums);
        
        System.out.println("triplet that sum to " + 0 + ":");
        for(List<Integer> triple : result) 
        {
            System.out.println(triple);
        }
    }
}
