public class QuickSort {

    // QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort left and right parts
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Partition function (Lomuto Partition Scheme)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;       // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return partition index
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("\nAfter Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
