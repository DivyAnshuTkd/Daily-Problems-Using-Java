class ColorSort
{
    public void sortColors(int[] nums)
    {
        int n = nums.length;

        int start = 0;
        int mid = 0;
        int end = n-1;

        while(mid <= end)
        {
                if(nums[mid] == 0)
                {
                    swap(nums, start, mid);
                    start++;
                    mid++;
                }

                else if(nums[mid] == 1)
                {
                    mid++;
                }

                else if(nums[mid] == 2)
                {
                    swap(nums, mid, end);
                    end--;
                }
        }
    }

    public static void swap(int nums[], int pos1, int pos2)
    {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        ColorSort cs = new ColorSort();
        int[] nums = {2, 0, 2, 1, 1, 0};
        cs.sortColors(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}