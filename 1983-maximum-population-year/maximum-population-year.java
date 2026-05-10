class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] year = new int[101];

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];

            year[birth - 1950]++;
            year[death - 1950]--;
        }

        int population = 0;
        int maxPopulation = 0;
        int answer = 1950;

        for (int i = 0; i < 101; i++) {
            population += year[i];

            if (population > maxPopulation) {
                maxPopulation = population;
                answer = 1950 + i;
            }
        }

        return answer;
    }
}