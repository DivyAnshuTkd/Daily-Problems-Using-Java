import java.util.Arrays;

public class MedianOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 1.0;
        int m = nums1.length;
        int n = nums2.length;
        int length = (m + n);
        int arr[] = new int[length];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            arr[m + i] = nums2[i];
        }

        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            if (length % 2 != 0) {
                median = arr[(length) / 2];
            } else {
                int first = (length / 2);
                int second = (length / 2) - 1;
                median = (arr[first] + arr[second]) / 2.0;
            }
        }
        return median;
    }

    public static void main(String[] args) {
        MedianOfArray medianOfArray = new MedianOfArray();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = medianOfArray.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is: " + median);

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double median2 = medianOfArray.findMedianSortedArrays(nums3, nums4);
        System.out.println("Median is: " + median2);
    }
}
