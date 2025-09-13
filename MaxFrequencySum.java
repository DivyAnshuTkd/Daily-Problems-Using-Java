import java.util.Scanner;

public class MaxFrequencySum {
    public int maxFreqSum(String s) {
        int maximumVowels = 0;
        int maximumConsonants = 0;

        int n = s.length();
        int frequency[] = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                frequency[index] = frequency[index] + 1;
                maximumVowels = Math.max(maximumVowels, frequency[index]);
            } else {
                frequency[index] = frequency[index] + 1;
                maximumConsonants = Math.max(maximumConsonants, frequency[index]);
            }
        }

        return maximumVowels + maximumConsonants;
    }

    // Main method to test the code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        MaxFrequencySum solution = new MaxFrequencySum();
        int result = solution.maxFreqSum(s);

        System.out.println("Maximum frequency sum = " + result);
    }
}
