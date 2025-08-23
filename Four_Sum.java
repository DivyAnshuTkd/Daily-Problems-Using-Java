import java.util.*;
public class Four_Sum 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< n-1; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {
                continue;
            }
            
            for(int j = i+1; j<n-1; j++)
            {
                if(j > i+1 && nums[j] == nums[j-1])
                {
                continue;
                }
                
                int left = j+1;
                int right = n-1;
                while(left < right)
                {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target)
                    {
                        left++;
                    }

                    else if(sum > target)
                    {
                        right--;
                    }

                    else if(sum == target)
                    {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

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
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        Four_Sum solution = new Four_Sum();
        
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        
        List<List<Integer>> result = solution.fourSum(nums, target);
        
        System.out.println("Quadruplets that sum to " + target + ":");
        for(List<Integer> quad : result) 
        {
            System.out.println(quad);
        }
    }
}

