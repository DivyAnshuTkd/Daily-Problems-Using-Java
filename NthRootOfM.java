public class NthRootOfM {

    public int nthRoot(int n, int m) {
        int left = 1;
        int right = m;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long multiplication = 1;
            for (int i = 0; i < n; i++) {
                multiplication = multiplication * mid;
                if (multiplication > m) break; // prevent overflow & unnecessary work
            }

            if (multiplication == m) {
                return mid; // found the exact nth root
            } else if (multiplication > m) {
                right = mid - 1; // go left
            } else {
                left = mid + 1; // go right
            }
        }

        return -1; // if no integer nth root exists
    }

    // main method to test the function
    public static void main(String[] args) {
        NthRootOfM obj = new NthRootOfM();

        System.out.println(obj.nthRoot(2, 16));   // Output: 4
        System.out.println(obj.nthRoot(3, 27));   // Output: 3
        System.out.println(obj.nthRoot(3, 28));   // Output: -1
        System.out.println(obj.nthRoot(4, 2401)); // Output: 7
        System.out.println(obj.nthRoot(5, 243));  // Output: 3
    }
}
