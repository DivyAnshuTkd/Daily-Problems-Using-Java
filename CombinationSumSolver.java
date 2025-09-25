import java.util.*;

public class CombinationSumSolver {

    // Main function to test the solution
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSumSolver solver = new CombinationSumSolver();
        List<List<Integer>> result = solver.combinationSum2(candidates, target);

        System.out.println("Unique combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    // Main method to generate combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates and pruning
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(candidates, target, answer, list, 0);
        return answer;
    }

    // Helper method (backtracking)
    public static void helper(int[] candidates, int target, List<List<Integer>> answer,
                              List<Integer> list, int index) {
        if (target == 0) {
            answer.add(new ArrayList<>(list)); // Found valid combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates at the same recursive level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Pruning: stop if current candidate exceeds remaining target
            if (candidates[i] > target) {
                break;
            }

            // Choose the current candidate
            list.add(candidates[i]);

            // Recurse with next index (i+1 because each number can be used once)
            helper(candidates, target - candidates[i], answer, list, i + 1);

            // Backtrack: remove last element and try next candidate
            list.remove(list.size() - 1);
        }
    }
}

