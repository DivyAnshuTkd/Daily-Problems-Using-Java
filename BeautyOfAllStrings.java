public class BeautyOfAllStrings {

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Consider all substrings
        for (int i = 0; i < n; i++) {
            int frequency[] = new int[26]; // reset for each starting index

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                int index = ch - 'a';
                frequency[index]++;

                int maximum = Integer.MIN_VALUE;
                int minimum = Integer.MAX_VALUE;

                // Find max and min frequency in current substring
                for (int f : frequency) {
                    if (f > 0) {
                        maximum = Math.max(maximum, f);
                        minimum = Math.min(minimum, f);
                    }
                }

                sum += (maximum - minimum);
            }
        }
        return sum;
    }

    // Main function to test
    public static void main(String[] args) {
        BeautyOfAllStrings sol = new BeautyOfAllStrings();

        String s1 = "aabcb";
        System.out.println("Beauty Sum of " + s1 + " = " + sol.beautySum(s1));
        // Expected output: 5

        String s2 = "aabcbaa";
        System.out.println("Beauty Sum of " + s2 + " = " + sol.beautySum(s2));
    }
}
