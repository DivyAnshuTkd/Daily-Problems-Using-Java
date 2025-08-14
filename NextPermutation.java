class NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int pivot = -1;
        int nextGreater = 0;
        for(int i = n-2; i>= 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                pivot = i;
                break;
            }
        }

        if(pivot == -1)
        {
            reverse(nums, pivot);
        }

        else
        {
            for(int j = n-1; j> pivot; j--)
            {
              if(nums[j] > nums[pivot])
              {
                nextGreater = j;
                break;
              }
            }

            swap(nums, pivot, nextGreater);
            reverse(nums, pivot);

        }
    }

    public static void swap(int nums[], int pivot, int nextGreater)
    {
        int temp = nums[pivot];
        nums[pivot] = nums[nextGreater];
        nums[nextGreater] = temp;
    }

    public static void reverse(int nums[],int pivot)
    {
        int n = nums.length;
        int i = pivot+1;
        int j = n-1;

        while(i<j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] nums = {1, 2, 3};
        obj.nextPermutation(nums);
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}