import java.util.*;

class MergeSortAlgorithm 
{
    void mergeSort(int arr[], int l, int r) 
    {
        // code here
        if(l >= r)
        {
            return;
        }
        
        int mid = (l + r)/2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
        
        return;
    }
    
    void merge(int arr[], int l, int mid, int r)
    {
        int n = arr.length;
        int temp[] = new int[n];
        
        int left = l;
        int right = mid+1;
        int i = 0;
        
        while(left <= mid && right <= r)
        {
            if(arr[left] <= arr[right])
            {
                temp[i] = arr[left];
                left++;
                i++;
            }
            else
            {
                temp[i] = arr[right];
                right++;
                i++;
            }
        }
        
        while(left <= mid)
        {
            temp[i] = arr[left];
            left++;
            i++;
        }
        
        while(right <= r)
        {
            temp[i] = arr[right];
            right++;
            i++;
        }
        
        for(int j = l; j<=r ; j++)
        {
            arr[j] = temp[j-l];
        }
        
        return;
    }

    // Main function
    public static void main(String[] args) 
    {
        MergeSortAlgorithm obj = new MergeSortAlgorithm();
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        obj.mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

