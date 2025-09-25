import java.util.*;

public class CombinationSum3Demo 
{
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        helper(arr, list, answer, k, n, 0);

        return answer;
    }

    public static void helper(int arr[], List<Integer> list, List<List<Integer>> answer, int k, int n, int index)
    {
        if (n == 0)
        {
            if (list.size() == k)
            {
                answer.add(new ArrayList<>(list));
                return;
            }
            else
            {
                return;
            }
        }

        for (int i = index; i < 9; i++)
        {
            // Skip duplicates check (not really needed since arr has unique values)
            if (index < i && arr[i] == arr[index]) 
            {
                continue;
            }

            if (arr[i] > n)
            {
                break; // pruning
            }

            list.add(arr[i]);
            helper(arr, list, answer, k, n - arr[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) 
    {
        CombinationSum3Demo obj = new CombinationSum3Demo();

        int k = 3;   // number of elements in each combination
        int n = 7;   // target sum

        List<List<Integer>> result = obj.combinationSum3(k, n);

        System.out.println("Combinations of " + k + " numbers that sum to " + n + ":");
        for (List<Integer> combination : result) 
        {
            System.out.println(combination);
        }
    }
}
