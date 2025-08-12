import java.util.*;
class LongestSubstringWithoutRepeating
{
    public static int lengthOfLongestSubstring(String s)
    {

        int n = s.length();
        int maximum = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        
        while(j < n)
        {
            char ch = s.charAt(j);
            
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch) + 1);
            }
            
            else
            {
                map.put(ch, 1);
            }
            
            
            if(map.size() > (j-i+1))
            {
                j++;
            }
            
            if (map.size() == (j - i + 1)) { // No duplicate
            maximum = Math.max(maximum, j - i + 1);
            j++;
            } 
            else if (map.size() < (j - i + 1)) 
            { // Duplicate exists
                while (map.size() < (j - i + 1)) 
                {
                  char firstChar = s.charAt(i);
                  map.put(firstChar, map.get(firstChar) - 1);
                  if (map.get(firstChar) == 0) 
                  {
                    map.remove(firstChar);
                  }
                  i++;
                }
             j++;
            }
        }
        
        return maximum;
    }

    public static void main(String[] args)
    {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result); // Output: 3        
    }
}