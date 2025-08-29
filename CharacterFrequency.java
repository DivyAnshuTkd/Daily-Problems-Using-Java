import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int fr;

    Pair(char ch, int fr) {
        this.ch = ch;
        this.fr = fr;
    }
}

class CharacterFrequency {
    public String frequencySort(String s) {
        // Step 1: Count frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max-Heap based on frequency
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((a, b) -> b.fr - a.fr);

        for (char key : map.keySet()) {
            pQueue.add(new Pair(key, map.get(key)));
        }

        // Step 3: Build result string
        StringBuilder sb = new StringBuilder();
        while (!pQueue.isEmpty()) {
            Pair p = pQueue.poll();
            char c = p.ch;
            int f = p.fr;

            while (f != 0) {
                sb.append(c);
                f--;
            }
        }
        return sb.toString();
    }

    // Just for testing
    public static void main(String[] args) {
        CharacterFrequency sol = new CharacterFrequency();
        String s = "tree";
        System.out.println(sol.frequencySort(s)); 
        // Possible output: "eert" or "eetr" (both are valid)
    }
}
