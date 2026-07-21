class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int originalOnes = 0;
        List<Integer> zeroBlockLengths = new ArrayList<>();
        
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                while (i < n && s.charAt(i) == '1') {
                    originalOnes++;
                    i++;
                }
            } else {
                int len = 0;
                while (i < n && s.charAt(i) == '0') {
                    len++;
                    i++;
                }
                zeroBlockLengths.add(len);
            }
        }

        if (zeroBlockLengths.size() < 2) {
            return originalOnes;
        }

        int maxGain = 0;
        for (int j = 0; j < zeroBlockLengths.size() - 1; j++) {
            maxGain = Math.max(maxGain, zeroBlockLengths.get(j) + zeroBlockLengths.get(j + 1));
        }

        return originalOnes + maxGain;
    }
}