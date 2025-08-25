public class PrintingStringInReverse {
    public String reverseWords(String s) {
        // Step 1: Remove leading/trailing spaces
        String str = s.trim();

        // Step 2: Split words by space
        String arr[] = str.split(" ");

        // Step 3: Use StringBuilder to build the reversed string
        StringBuilder sb = new StringBuilder("");

        // Step 4: Traverse from end to start
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) { // Ignore extra spaces
                if (sb.length() == 0) {
                    sb.append(arr[i]);
                } else {
                    sb.append(" ").append(arr[i]);
                }
            }
        }

        // Step 5: Convert back to string
        return sb.toString();
    }
        public static void main(String[] args) {
        PrintingStringInReverse sol = new PrintingStringInReverse();

        // Test cases
        String s1 = "  the sky is blue  ";
        String s2 = "hello world";
        String s3 = "   a   good   example   ";

        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s1) + "\"");
        System.out.println();

        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s2) + "\"");
        System.out.println();

        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s3) + "\"");
    }
}


