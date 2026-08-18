class Solution {
     int compareTeams(int[] teamA, int[] teamB) {
        int positions = teamA.length - 1;
        for (int i = 0; i < positions; i++) {
            if (teamA[i] != teamB[i]) {
                return teamB[i] - teamA[i];
            }
        }
        return teamA[positions] - teamB[positions];
    }

    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return "";
        }
        
        int positions = votes[0].length();
        int[][] voteCounts = new int[26][positions + 1];
        boolean[] isPresent = new boolean[26];

        for (String vote : votes) {
            for (int i = 0; i < positions; i++) {
                int teamIndex = vote.charAt(i) - 'A';
                voteCounts[teamIndex][i]++;
                isPresent[teamIndex] = true;
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> compareTeams(a, b));

        for (int i = 0; i < 26; i++) {
            if (isPresent[i]) {
                voteCounts[i][positions] = i;
                maxHeap.add(voteCounts[i]);
            }
        }

        StringBuilder rankedResult = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int teamIndex = maxHeap.poll()[positions];
            rankedResult.append((char) ('A' + teamIndex));
        }

        return rankedResult.toString();
    }
}