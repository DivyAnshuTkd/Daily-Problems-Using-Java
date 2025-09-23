import java.util.Scanner;

public class VersionComparator {

    // Method to compare two version strings
    public static int compareVersion(String version1, String version2) {
        // Split version strings by dot
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // Maximum number of segments
        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int num1, num2;

            // Handle missing segments for version1
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            } else {
                num1 = 0;
            }

            // Handle missing segments for version2
            if (i < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            } else {
                num2 = 0;
            }

            // Compare the numbers
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0; // All segments are equal
    }

    // Main method to test the compareVersion method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first version: ");
        String version1 = sc.nextLine();

        System.out.print("Enter second version: ");
        String version2 = sc.nextLine();

        int result = compareVersion(version1, version2);

        if (result == 0) {
            System.out.println("Versions are equal.");
        } else if (result < 0) {
            System.out.println(version1 + " is smaller than " + version2);
        } else {
            System.out.println(version1 + " is greater than " + version2);
        }

        sc.close();
    }
}
