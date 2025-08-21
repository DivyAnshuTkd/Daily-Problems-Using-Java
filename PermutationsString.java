import java.util.*;

class PermutationsString
{
    public ArrayList<String> findPermutation(String s)
    {
        // Code here
        ArrayList<String> ans = new ArrayList<>();
        ans = permutations("", s);
        
        HashSet<String> set = new HashSet<>(ans);
        
        ArrayList<String> finalAns = new ArrayList<>(set);
        
        return finalAns;
    }
    
    public ArrayList<String> permutations(String p, String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        
        
        
        for(int i = 0; i<=p.length(); i++)
        {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations(f+ch+s, up.substring(1)));
        }
        
        return ans;
    }

    public static void main(String[] args) {
        PermutationsString ps = new PermutationsString();
        String s = "abc";
        ArrayList<String> result = ps.findPermutation(s);
        System.out.println("Permutations of " + s + ": " + result);
        
        String s2 = "aab";
        ArrayList<String> result2 = ps.findPermutation(s2);
        System.out.println("Permutations of " + s2 + ": " + result2);
    }
}