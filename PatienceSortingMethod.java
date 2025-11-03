import java.util.*;  // for ArrayList and Collections

public class PatienceSortingMethod 
{
    // 🔹 Function to calculate the length of LIS using Binary Search
    static int lis(int arr[]) 
    {
        // ✅ Get the size of the array
        int n = arr.length;
        
        // ✅ Create a dynamic list to store the potential LIS elements
        // (this will not be the actual LIS but helps find its length efficiently)
        ArrayList<Integer> list = new ArrayList<>();
        
        // ✅ Start the list with the first element of the array
        list.add(arr[0]);
        
        // ✅ Traverse through the array elements from index 1 to n-1
        for (int i = 1; i < n; i++)
        {
            // 🟢 CASE 1: If current element is greater than the last element in 'list'
            // It means we can extend our increasing subsequence
            if (arr[i] > list.get(list.size() - 1))
            {
                list.add(arr[i]);   // ➕ Append arr[i] to 'list'
            }
            
            // 🔴 CASE 2: If arr[i] is smaller or equal to the last element
            // We need to find its correct position in 'list' using binary search
            else
            {
                // 🔍 Perform binary search to find index of arr[i] (or where it should go)
                int index = Collections.binarySearch(list, arr[i]);
                
                // ⚙️ If element not found, binarySearch returns a negative value
                // To get correct insertion position: index = -(index + 1)
                if (index < 0)
                {
                    index = -(index + 1);
                }
                
                // ✏️ Replace the element at 'index' with arr[i]
                // This keeps the list elements as small as possible for future extensions
                list.set(index, arr[i]);
            }
        }
        
        // ✅ Length of the 'list' represents the length of LIS
        return list.size();
    }

    // 🔹 Main function to test the code
    public static void main(String[] args) 
    {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        
        int result = lis(arr);
        
        System.out.println("Length of Longest Increasing Subsequence is: " + result);
    }
}

