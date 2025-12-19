import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

    
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];

           
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> persons = new HashSet<>();

           
            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                persons.add(x);
                persons.add(y);
                i++;
            }

         
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

          
            for (int p : persons) {
                if (know[p]) {
                    queue.offer(p);
                    visited.add(p);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                know[curr] = true;

                if (!graph.containsKey(curr)) continue;

                for (int next : graph.get(curr)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (know[p]) result.add(p);
        }

        return result;
    }
}
