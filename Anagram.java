import java.util.*;
public class Anagram
{
    public static int search(String pat, String txt)
    {
        // code here
        int ans = 0;
        
        int k = pat.length();
        
        HashMap <Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i< pat.length(); i++)
        {
            char ch = pat.charAt(i);
            if(map.containsKey(ch) && !map.isEmpty())
            {
                map.put(ch, map.get(ch) + 1);
            }
            
            else
            {
                map.put(ch, 1);
            }
        }
        
        int count = map.size();
        
        int j = 0;
        int i = 0;
        
        while(j < txt.length())
        {
            char endChar = txt.charAt(j);
            if(map.containsKey(endChar))
            {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0)
                {
                    count--;
                }
            }
            
            if((j-i+1) < k)
            {
                j++;
            }
            
            else if((j-i+1) == k)
            {
                if(count == 0)
                {
                    ans = ans + 1;
                }
                
                char startChar = txt.charAt(i);
                if (map.containsKey(startChar))
                {
                    if (map.get(startChar) == 0)
                    {
                        count++;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }

                i++;
                j++;
            }
            
            
        }
        
        return ans;
    }

    public static void main(String[] args)
    {
        String pat = "abc";
        String txt = "cbabcacab";
        int result = search(pat, txt);
        System.out.println("Number of anagrams of '" + pat + "' in '" + txt + "': " + result);
    }
}