import java.util.*;

public class Subsequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maximum = 0;

        for (int num : set) {
            // start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maximum = Math.max(maximum, length);
            }
        }

        return maximum;
    }

    // Main method for quick test
    public static void main(String[] args) {
        Subsequence sol = new Subsequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(nums)); // Output: 4 (sequence: 1,2,3,4)
    }
}
