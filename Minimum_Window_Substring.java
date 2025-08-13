import java.util.HashMap;
class Minimum_Window_Substring
{
    public String minWindow(String s, String t)
    {
        if (s.length() < t.length())
        {
            return "";
        }

        // Frequency map for t
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = map.size();  // unique characters needed
        int formed = 0;             // how many characters have matched required frequency
        HashMap<Character, Integer> windowCount = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && windowCount.get(c).intValue() == map.get(c).intValue())    // brilliant
            {
                formed++;
            }

            while (formed == required)
            {
                if (right - left + 1 < minLen)
                {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (map.containsKey(leftChar) && windowCount.get(leftChar) < map.get(leftChar)) 
                // If the current left character is part of the pattern and its count in the current window
                // is now less than the required count (after moving the left pointer),
                // it means we have one less matching character for the pattern.
                {
                    formed--;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE)
        {
            return "";
        }

        return (s.substring(minLeft, minLeft + minLen));
    }

    public static void main(String[] args) {
        Minimum_Window_Substring solution = new Minimum_Window_Substring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Output: "BANC"
    }
}

