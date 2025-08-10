import java.util.ArrayList;
import java.util.List;
public class FirstNegative
{
    static List<Integer> firstNegInt(int arr[], int k)
    {
        // write code here
        int n = arr.length;
        
        List<Integer> temp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        int i =0;
        int j =0;
        
        while(j < n)
        {
            if(arr[j] < 0)
            {
                temp.add(arr[j]);
            }
            
            if((j-i+1) < k)
            {
                j++;
            }
            
            else if((j-i+1) == k)
            {
                if(temp.size() == 0)
                {
                    ans.add(0);
                }
                else
                {
                    ans.add(temp.get(0));
                }
                
                if(!temp.isEmpty() && arr[i] == temp.get(0))
                {
                    temp.remove(0);
                }
                i++;
                j++;
            }
        }
        
        return ans;
        
    }

    public static void main(String[] args) 
    {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> result = firstNegInt(arr, k);
        System.out.println(result); // Output: [-1, -1, -15, -15]
    }
}
